package com.soeguet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.shell.command.annotation.CommandScan;

@SpringBootApplication
@CommandScan
public class PwGenApplication {

    public static void main(String[] args) {

        SpringApplication.run(PwGenApplication.class, args);
    }
}
