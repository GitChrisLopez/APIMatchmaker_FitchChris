/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import entities.Profile;
import jakarta.persistence.*;
import java.util.List;
import java.util.Random;

/**
 *
 * @author chris
 */
public class ProfileService {

    private EntityManagerFactory emf
            = Persistence.createEntityManagerFactory("my_persistence_unit");

    public void addProfile(Profile p) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
        em.close();
    }

    public Profile search(String genero, String pais, int edad) {
        EntityManager em = emf.createEntityManager();

        String jpql = "SELECT p FROM Profile p WHERE "
                + "(:g IS NULL OR p.genero = :g) AND "
                + "(:p IS NULL OR p.pais = :p) AND "
                + "(:e = -1 OR p.edad = :e)";

        List<Profile> results = em.createQuery(jpql, Profile.class)
                .setParameter("g", genero)
                .setParameter("p", pais)
                .setParameter("e", edad)
                .getResultList();

        em.close();

        if (results.isEmpty()) {
            return null;
        }

        if (results.size() == 1) {
            return results.get(0);
        }

        return results.get(new Random().nextInt(results.size()));
    }
}
