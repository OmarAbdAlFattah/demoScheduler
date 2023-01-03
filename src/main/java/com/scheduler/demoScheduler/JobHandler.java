package com.scheduler.demoScheduler;

import net.javacrumbs.shedlock.spring.annotation.SchedulerLock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class JobHandler {
//    Logger logger = LoggerFactory.getLogger(JobHandler.class);
//
//    @Scheduled(cron = "0 * * * * *")
//    @SchedulerLock(name = "JobOne", lockAtLeastFor = "155", lockAtMostFor = "205")
//    public void jobOne() throws InterruptedException {
//        for (int i = 0; i < 5; i++) {
//            logger.info("Processing {}", i);
//            Thread.sleep(1000L);
//        }
//    }
}