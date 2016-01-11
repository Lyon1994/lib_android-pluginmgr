package org.lyon_yan.app.android.lib_android_pluginmgr;

import android.content.Context;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import androidx.pluginmgr.PluginManager;
import androidx.pluginmgr.environment.PlugInfo;

/**
 * 插件加载器
 * Created by yanni on 2016/1/11.
 */
public class PluginLoader {

    private List<PlugInfo> plugInfos = new ArrayList<>();
    /**
     * 插件所在目录
     */
    public static final String DEFAULT_PLUGIN_FOLDER = "plugin";
    public File plugin_folder = null;

    public File getPlugin_folder() {
        if (plugin_folder == null) {

        }
        return plugin_folder;
    }

    /**
     * 初始化epay插件
     *
     * @param PLUGIN_FOLDER
     */
    public static PluginLoader create(String PLUGIN_FOLDER) {
        return new PluginLoader(PLUGIN_FOLDER);
    }

    /**
     * 初始化epay插件
     */
    public static PluginLoader create() {
        return new PluginLoader(DEFAULT_PLUGIN_FOLDER);
    }

    private PluginLoader(String PLUGIN_FOLDER) {
        if (PluginManager.getSingleton() != null) {
            androidx.pluginmgr.PluginManager pluginMgr = androidx.pluginmgr.PluginManager.getSingleton();
            File plugin_folder = pluginMgr.getContext().getDir(PLUGIN_FOLDER, Context.MODE_PRIVATE);
            try {
                plugInfos.clear();
                plugInfos.addAll(pluginMgr.loadPlugin(plugin_folder));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public List<PlugInfo> getPlugInfos() {
        return plugInfos;
    }

    /**
     * 加载插件
     *
     * @param context
     * @param plugInfo
     * @return
     */
    public static synchronized boolean loadPlugin(Context context, PlugInfo plugInfo) {
        if (androidx.pluginmgr.PluginManager.getSingleton() == null) {
            return false;
        }
        androidx.pluginmgr.PluginManager.getSingleton().startMainActivity(context, plugInfo);
        return true;
    }
}
