package com.gaurav.scrape.entities;


import javax.persistence.*;

@Entity
@Table(name = "tags")
public class Tags {
    @Column(name = "pk_tag_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pkTagId;

    @Column(name = "tag_name")
    private String tagName;

    public Integer getPkTagId() {
        return pkTagId;
    }

    public void setPkTagId(Integer pkTagId) {
        this.pkTagId = pkTagId;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }
}
