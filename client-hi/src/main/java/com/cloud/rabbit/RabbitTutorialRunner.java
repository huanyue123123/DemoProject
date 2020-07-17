package com.cloud.rabbit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ConfigurableApplicationContext;

public class RabbitTutorialRunner implements CommandLineRunner {

    @Autowired
    private ConfigurableApplicationContext ctx;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Ready ... running for " + 10000 + "ms");
        Thread.sleep(10000);
        ctx.close();
    }
}
