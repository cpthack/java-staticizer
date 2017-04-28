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
package com.github.cptahck.commons.staticizer.core;

import java.io.File;

import com.github.cptahck.commons.staticizer.constants.StaticizerConstants;
import com.github.cptahck.commons.staticizer.exception.AssertHelper;
import com.github.cptahck.commons.staticizer.utils.FileHelper;

/**
 * <b>HtmlPage.java</b></br>
 * 
 * <pre>
 * 网页静态后内容转化类
 * </pre>
 *
 * @author cpthack cpt@jianzhimao.com
 * @date Apr 27, 2017 11:47:47 PM
 * @since JDK 1.7
 */
public class HtmlPage {
	
	/**
	 * 请求网页状态
	 */
	private int	   statusCode;
	
	/**
	 * 静态化后的网页内容
	 */
	private String pageSource;
	
	/**
	 * 静态化后网页保存的基础路径，示例："/cpthack/temp/file/"
	 */
	private String baseSavePath;
	
	/**
	 * 设置静态化后网页保存的基础路径
	 */
	public HtmlPage setBaseSavePath(String baseSavePath) {
		this.baseSavePath = baseSavePath;
		return this;
	}
	
	public File asHtml(String fileName) {
		AssertHelper.notBlank(pageSource, "The pageSource is Not Allow Null.");
		if (null == baseSavePath) {
			baseSavePath = StaticizerConstants.BASE_SAVE_PATH;
		}
		File htmlFile = FileHelper.newFile(baseSavePath, fileName);
		htmlFile = FileHelper.toHtml(htmlFile, pageSource);
		return htmlFile;
	}
	
	public int getStatusCode() {
		return statusCode;
	}
	
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	
	public String getPageSource() {
		return pageSource;
	}
	
	public void setPageSource(String pageSource) {
		this.pageSource = pageSource;
	}
	
}
