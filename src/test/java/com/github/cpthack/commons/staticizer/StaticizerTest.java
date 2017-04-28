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
package com.github.cpthack.commons.staticizer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.cptahck.commons.staticizer.core.HtmlPage;
import com.github.cptahck.commons.staticizer.core.StaticizerClient;
import com.github.cptahck.commons.staticizer.core.StaticizerClientFactory;

/**
 * <b>StaticizerTest.java</b></br>
 * 
 * <pre>
 * StaticizerClient测试类
 * </pre>
 *
 * @author cpthack cpt@jianzhimao.com
 * @date Apr 28, 2017 3:09:57 PM
 * @since JDK 1.8
 */
public class StaticizerTest {
	private static Logger logger = LoggerFactory.getLogger(StaticizerTest.class);
	
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		String url = "http://guangzhou.jianzhimao.com";// 待静态化的目标地址
		String baseSavePath = "/Users/cptahck/workspace/jianzhimao/java-staticizer/src/test/resources/static-file/";// 静态化文件保存地址
		
		StaticizerClient client = StaticizerClientFactory.getClient();
		logger.info("获取StaticizerClient操作对象>>>" + client);
		
		HtmlPage htmlPage = null;
		for (int i = 1; i < 1000; i++) {
			
			logger.debug("准备静态化第[" + i + "]个文件.");
			
			htmlPage = client.getMobilePageSource(url);
			logger.info("请求目标地址并获取HtmlPage对象");
			
			logger.info("请求[" + url + "]后返回的状态，statusCode = [" + htmlPage.getStatusCode() + "]");
			
			// logger.info("请求[" + url + "]后返回的内容,如下：\n" + htmlPage.getPageSource());
			
			logger.info("成功设置本次静态文件保存地址及文件名");
			htmlPage.setBaseSavePath(baseSavePath).asHtml("test".concat(i + ".html"));
		}
		
		logger.debug("请求耗时：" + (System.currentTimeMillis() - startTime) + " ms");
		
	}
	
}
