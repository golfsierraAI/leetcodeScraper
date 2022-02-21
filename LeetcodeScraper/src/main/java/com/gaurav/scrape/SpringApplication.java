package com.gaurav.scrape;

import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The type Spring application.
 */
@SpringBootApplication
public class SpringApplication {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */

//    We'll have to run this app twice as there is some code in Manager which has to be uncommented for the second time and
//    some code to be commented 2nd time
    public static void main(String[] args) {
        org.springframework.boot.SpringApplication.run(SpringApplication.class, args);
    }
}
