package com.example.practice14.services;

import com.example.practice14.models.User;
import com.example.practice14.repo.UserFilterRepository;
import org.hibernate.Criteria;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserFilterService implements UserFilterRepository {

    @PersistenceContext
    EntityManager em;

    @Override
    public List<User> findUsersByFirstNameAndLastNameAndMiddleNameAndBirthDate
            (String firstName, String lastName, String middleName, Date birthDate) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<User> userCriteriaQuery = builder.createQuery(User.class);
        Root<User> userRoot = userCriteriaQuery.from(User.class);
        ArrayList<Predicate> predicates = new ArrayList<>();
        if (firstName!= null){
            predicates.add(builder.equal(userRoot.get("firstName"), firstName));
        }
        if (lastName!= null){
            predicates.add(builder.equal(userRoot.get("lastName"), lastName));
        }
        if (middleName!= null){
            predicates.add(builder.equal(userRoot.get("middleName"), middleName));
        }
        if (birthDate!= null){
            predicates.add(builder.equal(userRoot.get("birthDate"), birthDate));
        }
        userCriteriaQuery.where(predicates.toArray(new Predicate[0]));
        return em.createQuery(userCriteriaQuery).getResultList();
    }

}
