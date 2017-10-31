/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dutchrosemedia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 *
 * @author Blackened
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.dutchrosemedia.controller", "com.dutchrosemedia.service"})
public class Main {

    public static String RESOURCE_PATH = "/Users/Blackened/Desktop/AudioLibrary";

    public static void main(String[] args) {
        
        if(args.length > 0){
            RESOURCE_PATH = args[0];
        }
                

        SpringApplication.run(Main.class, args);
    }

}
