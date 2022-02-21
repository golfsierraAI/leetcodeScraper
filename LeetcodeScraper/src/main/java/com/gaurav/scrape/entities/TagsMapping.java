package com.gaurav.scrape.entities;

import javax.persistence.*;

@Entity
@Table(name = "tags_mapping")
public class TagsMapping {

    @Column(name = "pk_tag_mapping_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "fk_tag_id")
    private Tags fkTagId;

    @ManyToOne
    @JoinColumn(name="fk_question_id")
    private Questions fkQuestionId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Tags getFkTagId() {
        return fkTagId;
    }

    public void setFkTagId(Tags fkTagId) {
        this.fkTagId = fkTagId;
    }

    public Questions getFkQuestionId() {
        return fkQuestionId;
    }

    public void setFkQuestionId(Questions fkQuestionId) {
        this.fkQuestionId = fkQuestionId;
    }
}
