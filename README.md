# java-staticizer

基于无界面浏览器jbrowserdriver实现的静态化组件，支持将AJAX页面静态化，并支持AngularJS及Vue.js等主流JS实现的页面静态化。API简洁，使用方便。

## 使用示例：

> StaticizerTest.java代码引用

```
long startTime = System.currentTimeMillis();
String url = "http://guangzhou.jianzhimao.com";// 待静态化的目标地址
String baseSavePath = "/Users/cptahck/workspace/jianzhimao/java-staticizer/src/test/resources/static-file/";// 静态化文件保存地址
	
StaticizerClient client = StaticizerClientFactory.getClient();
logger.info("获取StaticizerClient操作对象>>>" + client);
	
HtmlPage htmlPage = null;
for (int i = 1; i < 2; i++) {
	
	logger.debug("准备静态化第[" + i + "]个文件.");
	for (int j = 0; j < 100; j++) {
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
requestHeaders.put("User-Agent", "Mozilla/5.0 (Linux; Android 6.0; Nexus 5 Build/MRA58N) AppleWebKit/537.36 (KHTML, like Gecko) 
Chrome/58.0.3029.81 Mobile Safari/537.36");
requestHeaders.put("Cookie", "ipcity=guangzhou; isw=1; isp=1; ism=1; UM_distinctid=15b991d8b504-0d54f3feabfe08-143d655c-13c680-15b991d8b51109; 
gr_user_id=759e16e4-e3f9-41c2-a693-e2ee6773bf6f; m_location_info=%2C%E5%B9%BF%E5%B7%9E%2C; CNZZDATA1254075128=1655583782-1492924156-%7C1492950101; 
Hm_lvt_c48dcbb8f7a6cb176845ad3439189ed0=1492924831; JSESSIONID=00C3088AC63C798A72FA9C6FF2C21FB0-n2.www; 1=189ADF1D3B328F58FD5BBABAEFA022F9; 
user_account=18826410953; user_pwd=UVAxQTVYN2oxc1k9; user_type=2; user_autologin=1; jobView_showType=2; jobView_p=1; 
Hm_lvt_447f87add4dbd73deca17a45d8536dbd=1492922502,1493304116; Hm_lpvt_447f87add4dbd73deca17a45d8536dbd=1493304191");
	
htmlPage = client.getPageSource(url, requestHeaders);
//logger.info("请求到的内容：" + htmlPage.getPageSource());
		
```

## 具体参考：

- 简单测试类参考：[StaticizerTest.java](https://github.com/cpthack/java-staticizer/blob/master/src/test/java/com/github/cpthack/commons/staticizer/StaticizerTest.java)
- spring实现参考：[spring boot实现](https://github.com/cpthack/spring-staticizer-service)
