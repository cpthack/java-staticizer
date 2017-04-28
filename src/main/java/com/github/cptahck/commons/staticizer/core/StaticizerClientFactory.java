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

/**
 * <b>StaticizerClientFactory.java</b></br>
 * 
 * <pre>
 * StaticizerClient对象工厂类
 * </pre>
 *
 * @author cpthack cpt@jianzhimao.com
 * @date Apr 28, 2017 2:59:49 PM
 * @since JDK 1.7
 */
public class StaticizerClientFactory {
	
	private final static StaticizerClient client = new JBrowserDriverStaticizer();
	
	public static StaticizerClient getClient() {
		return client;
	}
}
