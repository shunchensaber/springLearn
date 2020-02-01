package com.peige.work.spring;

import com.peige.work.spring.module.Customer;
import com.peige.work.spring.module.Quote;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


@SpringBootApplication
@EnableScheduling
public class Application implements CommandLineRunner{
    //which means it will execute the run() method after the application context is loaded.

   Logger logger = LoggerFactory.getLogger(Application.class);
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


    /**https://www.cnblogs.com/javazhiyin/p/9851775.html
     * 在内部，RestTemplate默认使用HttpMessageConverter实例将HTTP消息转换成POJO或者从POJO转换成HTTP
     * 消息。默认情况下会注册主mime类型的转换器，但也可以通过setMessageConverters注册其他的转换器。
     * @param builder
     * @return
     */
    @Bean
    public RestTemplate getRestTemplate(RestTemplateBuilder builder)
    {
        return builder.build();
    }

    @Bean
    public CommandLineRunner run(RestTemplate restTemplate) throws Exception
    {
        System.out.println("_______________-");
        return args -> {
            Quote quote = restTemplate.getForObject("https://gturnquist-quoters.cfapps.io/api/random", Quote.class);
            logger.info(quote.toString());
        };
    }

    //Spring Boot supports H2 (an in-memory relational database engine) and automatically creates a connection.
    @Override
    public void run(String... args) throws Exception {
        logger.info("Creating DataBases");
        jdbcTemplate.execute("DROP TABLE if exists customers");
        //SERIAL is an alias for BIGINT UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE.
        jdbcTemplate.execute("CREATE  TABLE customers(id SERIAl ,firstname VARCHAR(255),lastname varchar(255))");

        List<Object[]> splitUpNames = Arrays.asList("John Woo", "Jeff Dean", "Josh Bloch", "Josh Long").stream()
                .map(name -> name.split(" "))  //STRAM(Stirng[])
                .collect(Collectors.toList());
        splitUpNames.forEach(name->{
            logger.info(String.format("inserting names %s,%s",name[0],name[1]));
//            jdbcTemplate.batchUpdate(String.format("INSERT INTO customers(firstname,lastname) values ('s','%s')",name[0],name[1]));


        });
        /**
         *
         For single insert statements, the insert method of JdbcTemplate is g
         ood. However, for multiple inserts, it is better to use batchUpdate.
         */
        jdbcTemplate.batchUpdate("INSERT INTO customers(firstname,lastname) values (?,?)",splitUpNames);
        logger.info("Querying for customer records where first_name = 'Josh':");
        jdbcTemplate.query("SELECT id, firstname, lastname FROM customers WHERE firstname = ?", new Object[] { "Josh" },
                (rs,rownnum) -> new Customer(rs.getLong("id"), rs.getString("firstname"), rs.getString("lastname")))
                .forEach(customer -> logger.info(customer.toString()));

        jdbcTemplate.query("select * from customers",(rs,rownum)->new Customer(rs.getLong("id"), rs.getString("firstname"), rs.getString("lastname")))
                .forEach(customer -> logger.info(customer.toString()));



    }

    @Autowired
    JdbcTemplate jdbcTemplate;


}
