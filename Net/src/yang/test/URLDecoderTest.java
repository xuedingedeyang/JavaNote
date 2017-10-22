package yang.test;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class URLDecoderTest {

	public static void main(String[] args) throws UnsupportedEncodingException {
		String keyword = URLDecoder.decode("%E7%96%AF%E7%8B%82Java%E8%AE%B2%E4%B9%89","utf-8");
		System.out.println(keyword);
		String urlstr = URLEncoder.encode("·è¿ñJava½²Òå","utf-8");
		System.out.println(urlstr);

	}

}
