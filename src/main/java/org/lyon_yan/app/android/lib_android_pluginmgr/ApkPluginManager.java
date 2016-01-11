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
        if (androidx.pluginmgr.PluginManager.getSingleton() == null) {
            androidx.pluginmgr.PluginManager.init(context);
            for (String folder : plugin_folder) {
                insertPluginFolder(folder, PluginLoader.create());
            }
        }
    }

    /**
     * 插入插件目录进入扫描
     * @param folder
     * @param pluginLoader
     */
    public static void insertPluginFolder(String folder, PluginLoader pluginLoader) {
        if (folder == null) {
            folder = PluginLoader.DEFAULT_PLUGIN_FOLDER;
        }
        if (pluginLoaders.containsKey(folder)) {
            return;
        }
        pluginLoaders.put(folder, PluginLoader.create(folder));
    }
}
