package org.lyon_yan.app.android.lib_android_pluginmgr;

import android.content.Context;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import androidx.pluginmgr.PluginManager;
import androidx.pluginmgr.environment.PlugInfo;

/**
 * 插件管理器
 * Created by yanni on 2016/1/11.
 */
public class ApkPluginManager {
    private static HashMap<String, PluginLoader> pluginLoaders = new HashMap<>();

    /**
     * 初始化epay插件
     *
     * @param context
     */
    public static void init(Context context, String... plugin_folder) {
            androidx.pluginmgr.PluginManager.init(context);
            pluginLoaders.clear();
            for (String folder : plugin_folder) {
                insertPluginFolder(folder, PluginLoader.create());
            }
    }

    /**
     * 插入插件目录进入扫描
     *
     * @param folder
     * @param pluginLoader
     */
    protected static void insertPluginFolder(String folder, PluginLoader pluginLoader) {
        if (folder == null) {
            folder = PluginLoader.DEFAULT_PLUGIN_FOLDER;
        }
        if (pluginLoaders.containsKey(folder)) {
            return;
        }
        pluginLoaders.put(folder, PluginLoader.create(folder));
    }

    /**
     * 插入插件目录
     *
     * @param folder
     */
    public static void insertPluginFolder(String... folder) {
        for (String s : folder) {
            pluginLoaders.put(s, PluginLoader.create(s));
        }
    }


    /**
     * 获取指定的插件加载器
     *
     * @param folder 插件的内部文件存储位置
     * @return
     */
    public static PluginLoader getPluginLoader(String folder) {
        if (pluginLoaders.containsKey(folder)) {
            return pluginLoaders.get(folder);
        }
        return null;
    }

    /**
     * 获取默认的插件加载器
     *
     * @return
     */
    public static PluginLoader getDefaultPluginLoader() {
        return getPluginLoader(PluginLoader.DEFAULT_PLUGIN_FOLDER);
    }
}
