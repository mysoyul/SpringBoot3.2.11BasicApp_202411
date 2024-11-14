package com.basic.myspringboot.runner;

import com.basic.myspringboot.config.vo.CustomVO;
import com.basic.myspringboot.property.MyBootProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class MyRunner implements ApplicationRunner {
    @Value("${myboot.fullName}")
    private String fullName;

    @Value("${myboot.age}")
    private int age;

    @Autowired
    private Environment environment;

    @Autowired
    private MyBootProperties properties;

    @Autowired
    private CustomVO customVO;

    private final Logger logger = LoggerFactory.getLogger(MyRunner.class);

    @Override
    public void run(ApplicationArguments args) throws Exception {
        logger.info("CustomVO = {}", customVO);
        logger.info("MyBootProperties 객체의 getFullName() = {}", properties.getFullName());
        logger.info("${myboot.name} Property = {}", environment.getProperty("myboot.name"));
        logger.info("${myboot.fullName} Property = {}", fullName);
        logger.info("${myboot.age} Property = {}", age);

        logger.debug("VM argument -foo = {}", args.containsOption("foo"));
        logger.debug("Program argument -bar = {}", args.containsOption("bar"));
        //argument name 목록 출력하기
        //forEach(Consumer) Consumer 의 추상메서드 void accept(T t) 람다식
        args.getOptionNames().forEach(name -> logger.info("argument name = {}", name));
        //Method Reference
        args.getOptionNames().forEach(System.out::println);
    }
}
