package net.wincn.app;

import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

public class App {
	static Logger logger = Logger.getLogger(App.class);

	public static void main(String[] args) throws FileNotFoundException, IOException {
		RestTemplate template = new RestTemplate();
		MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
		map.add("log", "admin3");
		map.add("pwd", "aibing0420");
		String result = template.postForObject("http://wincn.net/wp-login.php", map, String.class);
		try {
			result = filter(result);
			parseResult(result);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		IOUtils.write(result, new FileOutputStream("success.html"));
	}
	public static String filter(String result){
		String[] filters = {"&rsaquo;","&larr;","&_wpnonce","&redirect_to"};
		for(String str:filters)
			result = result.replace(str, "");
		return result;
	}
	// 解析result
	public static void parseResult(String result) throws DocumentException {
		SAXReader reader = new SAXReader();
		Document document = reader.read(new ByteArrayInputStream(result.getBytes()));
		Element element = document.getRootElement();
		logger.debug(element.getXPathResult(1));

	}

}
