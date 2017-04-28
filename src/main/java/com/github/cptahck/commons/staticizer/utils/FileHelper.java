/**
 * Copyright (c) 2013-2020, cpthack 成佩涛 (cpt@jianzhimao.com).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.cptahck.commons.staticizer.utils;

import java.io.File;
import java.io.IOException;

import org.slf4j.Logger;

import com.github.cptahck.commons.staticizer.constants.StaticizerConstants;
import com.github.cptahck.commons.staticizer.exception.AssertHelper;
import com.google.common.io.Files;

/**
 * <b>FileHelper.java</b></br>
 * 
 * <pre>
 * 文件操作辅助工具类
 * </pre>
 *
 * @author cpthack cpt@jianzhimao.com
 * @date Apr 28, 2017 12:22:50 AM
 * @since JDK 1.7
 */
public class FileHelper {
	
	private static Logger logger = org.slf4j.LoggerFactory.getLogger(FileHelper.class);
	
	/**
	 * 
	 * <b>newFile</b> <br/>
	 * <br/>
	 * 
	 * 创建文件<br/>
	 * 
	 * @author cpthack cpt@jianzhimao.com
	 * @param fileSavePath
	 * @param fileName
	 * @return File
	 *
	 */
	public static File newFile(String fileSavePath, String fileName) {
		File file = new File(fileSavePath);
		if (!file.exists()) {
			file.mkdirs();
			logger.warn("检测到静态文件目录不存在，初始化目录.filePath = [" + fileSavePath + "]");
		}
		file = new File(fileSavePath + fileName);
		if (file.exists()) {
			logger.debug("文件已经存在，直接返回.fileName = [" + fileName + "]");
			return file;
		}
		try {
			file.createNewFile();
			logger.debug("创建静态文件成功.FileName = [" + fileSavePath + fileName + "]");
		}
		catch (Exception e) {
			logger.error("创建静态文件失败,file = [" + fileSavePath + fileName + "]", e);
		}
		return file;
	}
	
	/**
	 * 
	 * <b>toHtml</b> <br/>
	 * <br/>
	 * 
	 * 根据内容生成html文件 <br/>
	 * 
	 * @author cpthack cpt@jianzhimao.com
	 * @param file
	 * @param content
	 * @return File
	 *
	 */
	public static File toHtml(File writeFile, String content) {
		AssertHelper.isTrue(writeFile != null && writeFile.exists(), "生成HTML文件失败，写入的文件writeFile对象不能为空");
		try {
			Files.write(content, writeFile, StaticizerConstants.DEFAULT_CHARTSETS);
			logger.info("生成静态文件成功.FilePath = " + writeFile.getAbsolutePath() + "]");
			return writeFile;
		}
		catch (Exception e) {
			logger.error("生成HTML文件失败", e);
		}
		return null;
	}
	
}
