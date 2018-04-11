package edu.macalester.comp124.spider;


/**
 * Downloads web pages by following http links located
 * in the html of BEGINNING_URL.  Recursively repeats
 * the process.
 * 
 * @author shilad
 *
 */
public class RunSpider {
	private static final String BEGINNING_URL = "https://www.macalester.edu";

	/**
	 * Run the spider program.
	 * @param args
	 */
	public static void main(String [] args) {
		Spider spider = new Spider(10);
		spider.crawl(BEGINNING_URL);
		printURLCounts(spider.getUrlCounts());
	}

	public static void printURLCounts(UrlCount[] counts){
		for (UrlCount urlCount : counts) {
			System.out.println("url " + urlCount.getUrl() + " is " + urlCount.getCount());
		}
	}
}
