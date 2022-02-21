package com.gaurav.scrape.entities;

import javax.persistence.*;

@Entity
@Table(name = "companies_mapping")
public class CompaniesMapping {
    @Column(name = "pk_company_mapping_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "fk_company_id")
    private Companies fkCompanyId;

    @ManyToOne
    @JoinColumn(name = "fk_question_id")
    private Questions fkQuestionId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Companies getFkCompanyId() {
        return fkCompanyId;
    }

    public void setFkCompanyId(Companies fkCompanyId) {
        this.fkCompanyId = fkCompanyId;
    }

    public Questions getFkQuestionId() {
        return fkQuestionId;
    }

    public void setFkQuestionId(Questions fkQuestionId) {
        this.fkQuestionId = fkQuestionId;
    }
}
