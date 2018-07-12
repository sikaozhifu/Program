package com.utils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.domain.Book;

public class BookMain {

	public static void main(String[] args) {
		String URL = "https://www.amazon.cn/%E5%9B%BE%E4%B9%A6/b/ref=sa_menu_top_books_l1?ie=UTF8&node=658390051";
		String userAgent="Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/67.0.3396.99 Safari/537.36";
		try {
			Document doc1 = Jsoup.connect(URL)
				.userAgent(userAgent)
				.post();
			Elements elements = doc1.getElementById("nav-subnav").select("a[class=nav-a]");
			for (Element element : elements) {
				String url = element.attr("abs:href");
				//System.out.println(url);
				//获取category
				url = URLDecoderString(url);
				String[] split2 = url.split("[\\/,?]");
				//category为split[3]
				//System.out.println(split2[3]);
				
				Document doc2 = Jsoup.connect(url)
					.userAgent(userAgent)
					.get();
				Elements elementsByClass = doc2.getElementsByClass("ch-tabwidget-pc-contentAsin");
				for (Element element2 : elementsByClass) {
					Book book = new Book();
					//category
					book.setCategory(split2[3]);
					Elements img = element2.getElementsByClass("ch-tabwidget-pc-contentAsinImg");
					//img
					book.setImg(img.select("img").first().attr("abs:src"));
					//获取详情的链接
					String attr = img.select("a").first().attr("abs:href");
					
					String[] split = attr.split("\\/");
					//商品id为split[4]
					//id
					book.setId(split[4]);
					Elements name = element2.getElementsByClass("ch-tabwidget-asintitle");
					//name
					book.setName(name.text());
					Elements price = element2.getElementsByClass("ch-tabwidget-price");
					//price
					book.setPrice(price.text());
					System.out.println(book.toString());
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static String getCategory(String url){
		String regex = "([\u4e00-\u9fa5]+)";
        Matcher matcher = Pattern.compile(regex).matcher(url);
        String result = null;
        if(matcher.find()){
            result = matcher.group(1);
        }
        return result;
    }
	
	////url解码获取图书类别
	public static String URLDecoderString(String str) {//url解码
		String result = "";
		if (null == str) {
			return "";
		}
		try {
			result = URLDecoder.decode(str, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return result;
	}
}
