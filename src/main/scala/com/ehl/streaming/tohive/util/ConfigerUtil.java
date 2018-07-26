package com.ehl.streaming.tohive.util;

import java.io.File;

import org.apache.log4j.Logger;

public class ConfigerUtil {
	static Logger logger = Logger.getLogger(ConfigerUtil.class);

	public static String getResource(String fileName) {
		String input = "";
		File file = new File(
				new File(ConfigerUtil.class.getProtectionDomain().getCodeSource().getLocation().getFile()).getParent()
						+ "/" + fileName);
		if (file.exists()) {
			input = file.getAbsolutePath();
			logger.info("conf文件目录为:" + file.getAbsolutePath());
		} else {
			input = System.getProperty("user.dir") + "/conf/"+fileName;
			logger.info("conf文件目录为:" + input);
		}
		return input;
	}
}
