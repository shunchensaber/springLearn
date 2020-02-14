package com.peige.work.spring.Caching;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
public class SimpleBookRepository implements BookRepository {
    @Override
    @Cacheable("books")
    public Book getbyisbn(String a) {
        waitforaminute();
        return new Book(a,"1");


    }

    private void waitforaminute()
    {
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
