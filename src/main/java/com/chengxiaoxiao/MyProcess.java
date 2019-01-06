package com.chengxiaoxiao;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

/**
 * @author Cheng Xiaoxiao
 */
public class MyProcess implements PageProcessor {
    public void process(Page page) {
        page.addTargetRequests(page.getHtml().links().all());//将当前页面里的所有链接都添加到目标页面中

        System.out.printf(page.getHtml().xpath("//*[@id=\"post_list\"]/*[@class=\"post_item\"]/div[2]/h3/a").toString());
    }

    public Site getSite() {
        return Site.me().setSleepTime(100).setRetryTimes(3);
    }

    public static void main(String[] args) {
        Spider.create(new MyProcess()).addUrl("https://www.cnblogs.com/").thread(5).run();
    }

}
