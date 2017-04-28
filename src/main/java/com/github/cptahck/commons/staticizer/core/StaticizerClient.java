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

/**
 * <b>StaticizerClient.java</b></br>
 * 
 * <pre>
 * 静态化客户端操作接口类，定义了静态化操作的一系列接口
 * </pre>
 *
 * @author cpthack cpt@jianzhimao.com
 * @date Apr 27, 2017 10:37:55 PM
 * @since JDK 1.7
 */
public interface StaticizerClient {
	
	/**
	 * 
	 * <b>getMobilePageSource</b> <br/>
	 * <br/>
	 * 
	 * 获取当前URL的静态页面内容，缺省请求头信息<br/>
	 * 用于一些仅移动端访问的站点，你也可以通过调用getPageSource(String url, LinkedHashMap<String, String>
	 * requestHeaders)自定义请求头来实现
	 * 
	 * @author cpthack cpt@jianzhimao.com
	 * @param url
	 * @return HtmlPage
	 *
	 */
	HtmlPage getMobilePageSource(String url);
	
	/**
	 * 
	 * <b>getPageSource</b> <br/>
	 * <br/>
	 * 
	 * 获取当前URL的静态页面内容，缺省请求头信息<br/>
	 * 
	 * @author cpthack cpt@jianzhimao.com
	 * @param url
	 *            目标URL
	 * @return HtmlPage
	 *
	 */
	HtmlPage getPageSource(String url);
	
	/**
	 * 
	 * <b>getPageSource</b> <br/>
	 * <br/>
	 * 
	 * 获取当前URL的静态页面内容，自定义请求头信息<br/>
	 * 
	 * @author cpthack cpt@jianzhimao.com
	 * @param url
	 *            目标URL
	 * @param requestHeaders
	 *            请求头信息
	 * @return HtmlPage
	 *
	 */
	HtmlPage getPageSource(String url, LinkedHashMap<String, String> requestHeaders);
	
}
