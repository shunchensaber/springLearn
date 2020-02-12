package com.peige.work.spring.RedisChat;

import com.mysql.cj.log.Log;
import com.mysql.cj.log.Slf4JLogger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicInteger;

public class Receiver {

    private static final Logger logger = LoggerFactory.getLogger(Receiver.class);

    private AtomicInteger count = new AtomicInteger();

    public void receiveMessage(String message)
    {
        logger.info("Received :"+message);
        count.incrementAndGet();
    }

    public int getCount()
    {
        return count.get();
    }

}
