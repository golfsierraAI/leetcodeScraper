package com.gaurav.scrape.manager;

import com.gaurav.scrape.dao.LeetcodeDAO;
import com.gaurav.scrape.entities.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

@Component
public class Manager {

    @Autowired
    LeetcodeDAO dao;

    public boolean checkTag(String tag) {
        return tag.equalsIgnoreCase("hard") || tag.equalsIgnoreCase("medium") || tag.equalsIgnoreCase("easy");
    }

    public void managerLogic(List<WebElement> table) {
        List<Questions> objectList = new ArrayList<>();
        Set<String> companyList = new HashSet<>();
        Set<String> tags = new HashSet<>();
        table.forEach((row) -> {
            WebElement question = row.findElement(By.tagName("a"));
            String questionLink = question.getAttribute("href");
            String questionName = question.getText();
            String discussionLink = questionLink + "discuss/?currentPage=1&orderBy=most_votes";
            List<WebElement> tagsList = row.findElements(By.cssSelector("td .badge-secondary"));
            List<WebElement> companyTags = row.findElements(By.cssSelector("td .companies img"));
            AtomicReference<String> difficulty = new AtomicReference<>("");
            List<Tags> tagsIdList = new ArrayList<>();
            List<Companies> companyIdList = new ArrayList<>();
            tagsList.forEach((tag) -> {
                if (checkTag(tag.getText())) {
                    difficulty.set(tag.getText());
                } else {
                    //tagsIdList.add(dao.findTagId(tag.getText()));

//                    Comment the line below for executing second time and uncomment the above line.
                    tags.add(tag.getText());
                }
            });
            companyTags.forEach((companyTag) -> {
                //companyIdList.add(dao.findCompanyId(companyTag.getAttribute("alt")));

                //Comment the line below for executing second time and uncomment the above line.
                companyList.add(companyTag.getAttribute("alt"));
            });


            Questions object = new Questions(questionName, questionLink, discussionLink, difficulty.toString());
            Questions questionId = dao.saveQuestion(object);

            //uncomment the lines below for executing second time and comment the above 2 lines.

//            companyIdList.forEach((companies ->{
//                CompaniesMapping companiesMapping=new CompaniesMapping();
//                companiesMapping.setFkCompanyId(companies);
//                companiesMapping.setFkQuestionId(questionId);
//                dao.saveCompanyMapping(companiesMapping);
//            }));
//            tagsIdList.forEach((tags1 ->{
//                TagsMapping tagsMapping=new TagsMapping();
//                tagsMapping.setFkTagId(tags1);
//                tagsMapping.setFkQuestionId(questionId);
//                dao.saveTagMapping(tagsMapping);
//            }));
        });
        tags.forEach((i) -> {
            Tags tag = new Tags();
            tag.setTagName(i);
            dao.saveTag(tag);
        });
        companyList.forEach((i -> {
            Companies company = new Companies(i);
            dao.saveCompany(company);
        }));

    }
}
