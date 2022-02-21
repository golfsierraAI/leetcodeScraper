package com.gaurav.scrape.service;

import com.gaurav.scrape.manager.Manager;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class ScraperService {
    private static final String URL = "https://seanprashad.com/leetcode-patterns/";

    @Autowired
    private ChromeDriver driver;

    @Autowired
    private Manager manager;

    @PostConstruct
    public void serviceCaller() {
        scrape();
    }
    
    public void scrape() {
        driver.get(URL);
        manager.managerLogic(driver.findElement(By.tagName("table")).findElements(By.cssSelector("tbody tr")));
        driver.close();
    }
}
