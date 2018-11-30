package edu.dlnu;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

import java.io.IOException;

public class MainClass {
    //在类的{ }下
    //属性
    //方法
    //主方法
    public static void main(String[] args) {
        System.out.println("咕咕咕");
    }
    //测试方法
    @Test
    public void test1(){
        //创建一段HTML字符串
        String html = "<html> <head></head> <body>测试</body> </html>";
        Document document = Jsoup.parse(html);
        System.out.println(document);
    }
    @Test
    public void test2() throws IOException {
        Document document = Jsoup.connect("http://www.zimuzu.tv/html/top/week.html").get();
//        System.out.println(document);
        Elements a0 = document.getElementsByClass("a0");
        String text0 = a0.text();
        System.out.println(text0);
        Elements a1 = document.getElementsByClass("a1");
        String text1 = a1.text();
        System.out.println(text1);
    }
    @Test
    public void test3() throws IOException {
        Document document = Jsoup.connect("http://www.zimuzu.tv/html/top/week.html").get();
        Elements select = document.select(".a0");
        String text = select.text();
        System.out.println(text);
    }
    @Test
    public void test4() throws IOException {
        //获取所有的链接地址
        Document document = Jsoup.connect("https://www.dy2018.com/").get();
        Elements elements = document.select("li");
        System.out.println(elements);
        for (int i = 0; i < elements.size(); i++) {
            //按顺序取出数组中的每一个标签
            Element element = elements.get(i);
            //获取标签的属性值
            String href = element.attr("href");
            System.out.println(href);
        }
    }
    @Test
    public void test5() throws IOException {
        Document document = Jsoup.connect("https://www.dy2018.com/html/gndy/dyzz/index.html").get();
        Elements elements = document.select(".co_content8 a");
        //System.out.println(elements);
        //elments.for
        for (Element element : elements) {
            String title = element.attr("title");
            String url = element.attr("abs:href");
            System.out.println(title);
            //System.out.println(url);
            Document document1 = Jsoup.connect(url).get();
            Elements a = document1.select("table>tbody>tr>td>a");
            String ixxechpn = a.attr("href");
            System.out.println(ixxechpn);
        }
    }
}
