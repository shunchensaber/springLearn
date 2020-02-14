package com.peige.work.spring.Caching;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
public class SimpleBookRepository implements BookRepository {
    @Override
    @Cacheable("book")
    public Book getbyisbn(String a) {
        int i =0;
        waitforaminute();
        System.out.println("__________");
        return new Book(a,"2"+i++);


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
