package com.feri.feridataweb.webmagic;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.List;

/**
 *@Author feri
 *@Date Created in 2019/3/14 14:54
 */
public class NewsProcess implements PageProcessor {
    private Site site=Site.me().setTimeOut(50000).setRetryTimes(3).setSleepTime(10);
    //处理当前的页面
    @Override
    public void process(Page page) {
        //System.out.println("抓取的整个网页："+page.getHtml().get());
        List<String> titles=page.getHtml().xpath("ul[@id='newsList']/li[@class='listitem']/a/text()").all();
        List<String> details=page.getHtml().xpath("ul[@id='newsList']/li[@class='listitem']/a/@href").all();

        List<String> times=page.getHtml().xpath("ul[@id='newsList']/li[@class='listitem']/span/text()").all();

        for(int i=0;i<times.size();i++){
            System.out.println("标题："+titles.get(i));
            System.out.println("详情地址："+details.get(i));
            System.out.println("时间："+times.get(i));
        }
    }
    //返回站点对象
    @Override
    public Site getSite() {
        return site;
    }
}
