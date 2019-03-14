package com.feri.feridataweb.webmagic;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;
import java.util.ArrayList;
import java.util.List;

/**
 *@Author feri
 *@Date Created in 2019/3/14 15:31
 */
public class HouseProcess implements PageProcessor {
    private Site site=Site.me().setTimeOut(50000).setRetryTimes(3).setSleepTime(10);
    @Override
    public void process(Page page) {
        List<String> names=page.getHtml().xpath("ul[@class='resblock-list-wrapper']/li[@class='resblock-list']/div/div/a/text()").all();
        List<String> type1=page.getHtml().xpath("ul[@class='resblock-list-wrapper']/li[@class='resblock-list']/div/div/span[@class='resblock-type']/text()").all();
        List<String> type2=page.getHtml().xpath("ul[@class='resblock-list-wrapper']/li[@class='resblock-list']/div/div/span[1]/text()").all();
        List<String> type3=page.getHtml().xpath("ul[@class='resblock-list-wrapper']/li[@class='resblock-list']/div/a[@class='resblock-location']/html()").all();
        List<String> type4=page.getHtml().xpath("ul[@class='resblock-list-wrapper']/li[@class='resblock-list']/div/div[@class='resblock-price']/div[@class='main-price']/span[@class='number']/text()").all();
        for(int i=0;i<names.size();i++){
            System.out.println("房屋名称："+names.get(i));
            System.out.println("状态："+type1.get(i));
            System.out.println("类型："+type2.get(i));
            String address=type3.get(i);
            System.out.println("位置："+address.substring(address.lastIndexOf('>')+1));
            System.out.println("均价："+type4.get(i));
        }
        if(page.getUrl().get().endsWith("pg1")){
//            List<String> pages=page.getHtml().xpath("div[@class='page-container']/div[@class='page-box']/a/text()").all();
//            System.err.println(pages);
            List<String> targets=new ArrayList<>();
            for(int i=2;i<=100;i++ ){
                String u=page.getUrl().get();
                targets.add(u.substring(0,u.length()-1)+i);
            }
            System.err.println(targets);
            page.addTargetRequests(targets);
        }
    }

    @Override
    public Site getSite() {
        return site;
    }
    //https://zz.fang.ke.com/loupan/

}
