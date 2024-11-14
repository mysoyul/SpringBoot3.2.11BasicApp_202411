package com.basic.myspringboot.runner;

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

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("${myboot.name} Property = " + environment.getProperty("myboot.name"));
        System.out.println("${myboot.fullName} Property = " + fullName);
        System.out.println("${myboot.age} Property = " + age);

        System.out.println("VM argument -foo = " + args.containsOption("foo"));
        System.out.println("Program argument -bar = " + args.containsOption("bar"));
        //argument name 목록 출력하기
        //forEach(Consumer) Consumer 의 추상메서드 void accept(T t) 람다식
        args.getOptionNames().forEach(name -> System.out.println("argument name = " + name));
        //Method Reference
        args.getOptionNames().forEach(System.out::println);
    }
}
