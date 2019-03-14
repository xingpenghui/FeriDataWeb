package com.feri.feridataweb.webmagic;

import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.ConsolePipeline;

/**
 *@Author feri
 *@Date Created in 2019/3/14 14:59
 */
public class Spider_Main {
    public static void main(String[] args) {
        new Spider(new HouseProcess()).addUrl("https://zz.fang.ke.com/loupan/pg1").thread(3).
                addPipeline(new ConsolePipeline()).run();
    }
}
