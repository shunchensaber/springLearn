package com.peige.work.spring.Caching;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Test implements CommandLineRunner {

    static final Logger logger = LoggerFactory.getLogger(Test.class);

    @Autowired
    BookRepository bookRepository;
    @Override
    public void run(String... args) throws Exception {
        logger.info("开始获取数据了");
        logger.info("获取a"+bookRepository.getbyisbn("a"));
        logger.info("获取a"+bookRepository.getbyisbn("a"));
        logger.info("获取b"+bookRepository.getbyisbn("b"));
        logger.info("获取a"+bookRepository.getbyisbn("a"));
        logger.info("获取c"+bookRepository.getbyisbn("c"));
        logger.info("获取c"+bookRepository.getbyisbn("c"));

    }
}
