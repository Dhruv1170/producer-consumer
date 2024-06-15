package com.pc;

import com.pc.dto.Consumer;
import com.pc.dto.Producer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.concurrent.BlockingQueue;

@SpringBootApplication
@Slf4j
public class PcApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(PcApplication.class, args);
        log.info("required producer consumer beans instantiating......");
        context.getBean(BlockingQueue.class);
        context.getBean(Producer.class);

        // Start consumer thread
        Thread consumerThread = new Thread(context.getBean(Consumer.class));
        consumerThread.start();
        log.info("required producer consumer beans instantiated......");
    }
}
