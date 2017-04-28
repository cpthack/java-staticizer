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

import java.util.LinkedHashMap;

import com.github.cptahck.commons.staticizer.constants.StaticizerConstants;
import com.github.cptahck.commons.staticizer.exception.AssertHelper;
import com.machinepublishers.jbrowserdriver.JBrowserDriver;
import com.machinepublishers.jbrowserdriver.RequestHeaders;
import com.machinepublishers.jbrowserdriver.Settings;
import com.machinepublishers.jbrowserdriver.Timezone;

/**
 * <b>JbrowserdriverHelper.java</b></br>
 * 
 * <pre>
 * 基于Jbrowserdriver封装的操作工具
 * </pre>
 *
 * @author cpthack cpt@jianzhimao.com
 * @date Apr 28, 2017 11:29:39 AM
 * @since JDK 1.8
 */
public class JbrowserdriverHelper {
	
	public static JBrowserDriver getMobileBrowserDriver() {
		return getBrowserDriver(StaticizerConstants.MOBILE_REQUEST_HEADERS);
	}
	
	@SuppressWarnings("static-access")
	public static JBrowserDriver getBrowserDriver(LinkedHashMap<String, String> requestHeaders) {
		JBrowserDriver driver = null;
		Settings settings = Settings.builder().blockAds(true).connectionReqTimeout(10).javascript(false).ajaxResourceTimeout(10).logWarnings(false).timezone(Timezone.AMERICA_NEWYORK).build();
		if (requestHeaders != null) {
			settings = settings.builder().requestHeaders(new RequestHeaders(requestHeaders)).build();
		}
		driver = new JBrowserDriver(settings);
		AssertHelper.notNull(driver, "初始化JBrowserDriver失败.");
		return driver;
	}
	
	public static JBrowserDriver getMobileUrl(String url) {
		JBrowserDriver driver = getMobileBrowserDriver();
		return getUrl(driver, url);
	}
	
	public static JBrowserDriver getUrl(String url, LinkedHashMap<String, String> requestHeaders) {
		JBrowserDriver driver = getBrowserDriver(requestHeaders);
		return getUrl(driver, url);
	}
	
	private static JBrowserDriver getUrl(JBrowserDriver driver, String url) {
		driver.get(url);
		return driver;
	}
}
