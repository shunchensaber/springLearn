package com.peige.work.spring.RedisChat;


import com.peige.work.spring.Application;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.stereotype.Component;

import java.applet.AppletContext;
@Component
public class Sender implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(CommandLineRunner.class);

    @Bean
    RedisMessageListenerContainer container(RedisConnectionFactory connectionFactory,MessageListenerAdapter adapter)
    {
        RedisMessageListenerContainer redisMessageListenerContainer = new RedisMessageListenerContainer();
        redisMessageListenerContainer.setConnectionFactory(connectionFactory);
        redisMessageListenerContainer.addMessageListener(adapter,new PatternTopic("chat"));
        return redisMessageListenerContainer;
    }



    @Bean  //消息监听器
    MessageListenerAdapter messageListenerAdapter(Receiver receiver)
    {
        //当收到消息时，调用相关类的相关方法
        return new MessageListenerAdapter(receiver,"receiveMessage");
    }

    @Bean
    Receiver receiver()
    {
        return new Receiver();
    }

    @Autowired
    ApplicationContext context;
    @Override
    public void run(String... args) throws Exception {

        //直接从容器中获取注册的Bean
        StringRedisTemplate redisTemplate = context.getBean(StringRedisTemplate.class);
        Receiver receiver = context.getBean(Receiver.class);
        while (receiver.getCount()==0)
        {
            logger.info("sendmessage");
            redisTemplate.convertAndSend("chat","from redis");
            redisTemplate.convertAndSend("chat","from redis");
            redisTemplate.convertAndSend("chat","from redis");
            redisTemplate.convertAndSend("chat","from redis");
            Thread.sleep(1000);

        }
        
        System.exit(0);
    }
}
