package com.storageroom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages={"security.*"})
public class StorageRoomApplication {

    public static void main(String[] args) {
        SpringApplication.run(StorageRoomApplication.class, args);
    }

}
