package com.gaurav.scrape.entities;

import javax.persistence.*;

@Entity
@Table(name = "companies")
public class Companies {

    @Column(name = "pk_company_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pkCompanyId;

    @Column(name = "company_name")
    private String companyName;

    public Companies(String companyName) {
        this.companyName = companyName;
    }
    public Companies(){

    }

    public Integer getPkCompanyId() {
        return pkCompanyId;
    }

    public void setPkCompanyId(Integer pkCompanyId) {
        this.pkCompanyId = pkCompanyId;
    }
}
