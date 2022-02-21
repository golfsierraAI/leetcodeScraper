package com.gaurav.scrape.dao;

import com.gaurav.scrape.entities.*;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
public class LeetcodeDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public Questions saveQuestion(Questions row) {
        entityManager.persist(row);
        entityManager.flush();
        return row;
    }

    @Transactional
    public void saveCompany(Companies company) {
        entityManager.persist(company);
        entityManager.flush();
    }

    @Transactional
    public void saveTag(Tags tag) {
        entityManager.persist(tag);
        entityManager.flush();
    }

    @Transactional
    public Companies findCompanyId(String name) {
        return entityManager.createQuery("from Companies where companyName= :name", Companies.class).setParameter("name", name).getSingleResult();
    }

    @Transactional
    public Tags findTagId(String name) {
        return entityManager.createQuery("from Tags where tagName= :name", Tags.class).setParameter("name", name).getSingleResult();
    }

    @Transactional
    public void saveTagMapping(TagsMapping tagsMapping) {
        entityManager.persist(tagsMapping);
        entityManager.flush();
    }

    @Transactional
    public void saveCompanyMapping(CompaniesMapping companiesMapping) {
        entityManager.persist(companiesMapping);
        entityManager.flush();
    }

}
