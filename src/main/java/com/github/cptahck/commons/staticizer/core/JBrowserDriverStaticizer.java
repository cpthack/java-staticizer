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

import java.util.LinkedHashMap;

import com.github.cptahck.commons.staticizer.utils.JbrowserdriverHelper;
import com.machinepublishers.jbrowserdriver.JBrowserDriver;

/**
 * <b>JBrowserDriverStaticizer.java</b></br>
 * 
 * <pre>
 * 基于JBrowserDriver实现StaticizerClient
 * </pre>
 *
 * @author cpthack cpt@jianzhimao.com
 * @date Apr 28, 2017 10:55:01 AM
 * @since JDK 1.8
 */
public class JBrowserDriverStaticizer implements StaticizerClient {
	
	@Override
	public HtmlPage getMobilePageSource(String url) {
		JBrowserDriver driver = JbrowserdriverHelper.getMobileUrl(url);
		return toHtmlPage(driver);
	}
	
	@Override
	public HtmlPage getPageSource(String url) {
		return getPageSource(url);
	}
	
	@Override
	public HtmlPage getPageSource(String url, LinkedHashMap<String, String> requestHeaders) {
		JBrowserDriver driver = JbrowserdriverHelper.getUrl(url, requestHeaders);
		return toHtmlPage(driver);
	}
	
	private HtmlPage toHtmlPage(JBrowserDriver driver) {
		HtmlPage htmlPage = new HtmlPage();
		htmlPage.setStatusCode(driver.getStatusCode());
		htmlPage.setPageSource(driver.getPageSource());
		// Close the browser. Allows this thread to terminate.
		driver.quit();
		return htmlPage;
	}
}
