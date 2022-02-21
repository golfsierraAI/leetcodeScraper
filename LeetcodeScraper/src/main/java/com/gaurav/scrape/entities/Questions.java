package com.gaurav.scrape.entities;

import javax.persistence.*;

@Entity
@Table(name = "questions")
public class Questions {
    @Column(name = "pk_question_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "question_name")
    private String questionName;

    @Column(name = "question_link")
    private String questionLink;

    @Column(name = "solution_link")
    private String solutionLink;

    @Column(name = "difficulty")
    private String difficulty;

    public Questions(String questionName, String questionLink, String solutionLink, String difficulty) {
        this.questionName = questionName;
        this.questionLink = questionLink;
        this.solutionLink = solutionLink;
        this.difficulty = difficulty;
    }

    public Integer getId() {
        return id;
    }

    public String getQuestionName() {
        return questionName;
    }

    public void setQuestionName(String questionName) {
        this.questionName = questionName;
    }

    public String getQuestionLink() {
        return questionLink;
    }

    public void setQuestionLink(String questionLink) {
        this.questionLink = questionLink;
    }

    public String getSolutionLink() {
        return solutionLink;
    }

    public void setSolutionLink(String solutionLink) {
        this.solutionLink = solutionLink;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }
}