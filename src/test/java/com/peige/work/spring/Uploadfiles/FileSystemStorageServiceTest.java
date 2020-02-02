package com.peige.work.spring.Uploadfiles;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.StringUtils;

import javax.annotation.security.RunAs;

import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class FileSystemStorageServiceTest {

    @Test
    public void get()
    {
        System.out.println(Paths.get("www.baidu.com/aa//a"));
        System.out.println(StringUtils.cleanPath("www.baidu.com//aa//a//a/a"));
    }


}