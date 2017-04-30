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
import com.machinepublishers.jbrowserdriver.UserAgent;

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
	
	public static JBrowserDriver getBrowserDriver(LinkedHashMap<String, String> requestHeaders) {
		JBrowserDriver driver = null;
		Settings.Builder builder = Settings.builder().processes(100)// 设置当前运行的JBrowserDriver实例数量
		        .blockAds(true)// 阻止对广告/垃圾邮件服务器的请求
		        .quickRender(true)// 从渲染中排除网页图像和二进制数据，加快渲染速度
		        .loggerLevel(null)// 关闭所有日志输出，提高性能
		        .hostnameVerification(false)// 关于域名验证，提高性能
		        .cache(true)// 开启缓存，类似真实浏览器的缓存功能
		        .cacheEntries(10 * 10000)// 设置缓存数量
		        .cacheEntrySize(20 * 1024 * 1024)// 设置缓存大小 20M
		        .maxRouteConnections(20)// 最大并发连接（number of per process）to a specific主机+代理的组合
		        .maxConnections(20)// 并发连接的最大数目（每个进程）
		// .userAgent(UserAgent.CHROME)
		;
		
		if (requestHeaders != null) {
			builder = builder.requestHeaders(new RequestHeaders(requestHeaders));
		}
		
		driver = new JBrowserDriver(builder.build());
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
