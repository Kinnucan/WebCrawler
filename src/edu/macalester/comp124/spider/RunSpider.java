package edu.macalester.comp124.spider;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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
		long start = System.currentTimeMillis();
		int maxURLs = 10;

		Spider spider = new Spider(maxURLs);
		spider.crawl(BEGINNING_URL);

		Spider spider2 = new Spider(maxURLs*2);
		spider2.crawl(BEGINNING_URL);

		printURLCounts(spider.getUrlCounts());
		long end = System.currentTimeMillis();
		double time = (double)(end - start);
		System.out.println(time);
	}

	public static void printURLCounts(UrlCount[] counts){
		for (UrlCount urlCount : counts) {
			System.out.println("url " + urlCount.getUrl() + " is " + urlCount.getCount());
		}
	}

	public static List<UrlCount> getDifference(UrlCount[] set1, UrlCount[] set2){
		List<UrlCount> list = new ArrayList<>();
		boolean found = false;
		for(int i = 0; i < set2.length; i ++){
			for(int z = 0; z < set1.length; z++){
				if(set2[i] == set1[z]){
					found = true;
				}
			}
			if(!found){
				list.add(set2[i]);
			}
			found = false;
		}
		return list;
	}
}
