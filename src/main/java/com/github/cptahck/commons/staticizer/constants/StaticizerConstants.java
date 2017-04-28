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
package com.github.cptahck.commons.staticizer.constants;

import java.nio.charset.Charset;
import java.util.LinkedHashMap;

import com.google.common.base.Charsets;

/**
 * <b>StaticizerConstants.java</b></br>
 * 
 * <pre>
 * 静态化常量配置类
 * </pre>
 *
 * @author cpthack cpt@jianzhimao.com
 * @date Apr 28, 2017 9:06:37 AM
 * @since JDK 1.7
 */
public class StaticizerConstants {
	/**
	 * 静态化文件默认存放目录
	 */
	public final static String						  BASE_SAVE_PATH		 = "/cpthack/staticizer/file/";
	
	/**
	 * 读写文件默认编码
	 */
	public final static Charset						  DEFAULT_CHARTSETS		 = Charsets.UTF_8;
	
	/**
	 * 移动端默认请求头
	 */
	public final static LinkedHashMap<String, String> MOBILE_REQUEST_HEADERS = new LinkedHashMap<String, String>();
	static {
		MOBILE_REQUEST_HEADERS.put("User-Agent", "Mozilla/5.0 (Linux; Android 6.0; Nexus 5 Build/MRA58N) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.81 Mobile Safari/537.36");
	}
	
}
