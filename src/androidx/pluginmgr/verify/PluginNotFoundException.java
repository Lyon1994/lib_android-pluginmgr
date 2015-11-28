package androidx.pluginmgr.verify;

import android.util.AndroidException;

/**
 * 插件为找到的异常
 * 
 * @author Lody
 * @version 1.0
 */
@SuppressWarnings("serial")
public class PluginNotFoundException extends AndroidException {
	public PluginNotFoundException(String name) {
		super(name);
	}
}
