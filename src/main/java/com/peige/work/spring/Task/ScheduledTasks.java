package com.peige.work.spring.Task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class ScheduledTasks {
    private static Logger logger  = LoggerFactory.getLogger(ScheduledTasks.class);
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("HH:mm:ss");


    /**
     * fixed rate以每次开始算
     * fixed delay以每次结束算
     * cron 更复杂得任务调度
     */
    @Scheduled(fixedRate = 5000)
    public void readCurrentTime()
    {
        logger.info("time now is {}",DATE_FORMAT.format(new Date()));
    }

}
