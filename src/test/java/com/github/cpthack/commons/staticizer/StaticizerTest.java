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

import java.util.LinkedHashMap;

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
		String url = "https://www.jianzhimao.com/ctrlindex/enterprise.html";// 待静态化的目标地址
		String baseSavePath = "/Users/cptahck/workspace/jianzhimao/java-staticizer/src/test/resources/static-file/";// 静态化文件保存地址
		
		StaticizerClient client = StaticizerClientFactory.getClient();
		logger.info("获取StaticizerClient操作对象>>>" + client);
		
		HtmlPage htmlPage = null;
		for (int i = 1; i < 2; i++) {
			
			logger.debug("准备静态化第[" + i + "]个文件.");
			for (int j = 0; j < 1; j++) {
				htmlPage = client.getPageSource(url);
				logger.info("请求目标地址并获取HtmlPage对象：" + j);
				logger.info("请求[" + url + "]后返回的状态，statusCode = [" + htmlPage.getStatusCode() + "]");
				logger.info("请求[" + url + "]后返回的内容大小，size = [" + htmlPage.getPageSource().length() + "]");
			}
			
			// logger.info("请求[" + url + "]后返回的内容,如下：\n" + htmlPage.getPageSource());
			
			logger.info("成功设置本次静态文件保存地址及文件名");
			htmlPage.setBaseSavePath(baseSavePath).asHtml("test".concat(i + ".html"));
		}
		logger.debug("请求耗时：" + (System.currentTimeMillis() - startTime) + " ms");
		
		LinkedHashMap<String, String> requestHeaders = new LinkedHashMap<String, String>();
		requestHeaders.put("User-Agent", "Mozilla/5.0 (Linux; Android 6.0; Nexus 5 Build/MRA58N) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.81 Mobile Safari/537.36");
		requestHeaders.put("Cookie", "ipcity=guangzhou; isw=1; isp=1; ism=1; UM_distinctid=15b991d8b504-0d54f3feabfe08-143d655c-13c680-15b991d8b51109; gr_user_id=759e16e4-e3f9-41c2-a693-e2ee6773bf6f; m_location_info=%2C%E5%B9%BF%E5%B7%9E%2C; CNZZDATA1254075128=1655583782-1492924156-%7C1492950101; Hm_lvt_c48dcbb8f7a6cb176845ad3439189ed0=1492924831; JSESSIONID=00C3088AC63C798A72FA9C6FF2C21FB0-n2.www; 1=189ADF1D3B328F58FD5BBABAEFA022F9; user_account=18826410953; user_pwd=UVAxQTVYN2oxc1k9; user_type=2; user_autologin=1; jobView_showType=2; jobView_p=1; Hm_lvt_447f87add4dbd73deca17a45d8536dbd=1492922502,1493304116; Hm_lpvt_447f87add4dbd73deca17a45d8536dbd=1493304191");
		htmlPage = client.getPageSource(url, requestHeaders);
		//logger.info("请求到的内容：" + htmlPage.getPageSource());
	}
	
}
