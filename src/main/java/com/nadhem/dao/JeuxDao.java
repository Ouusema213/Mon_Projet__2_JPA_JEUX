package com.nadhem.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.nadhem.entities.Jeux;
import com.nadhem.util.JPAutil;



public class JeuxDao {
	private EntityManager entityManager = JPAutil.getEntityManager("MonProjetJPA");

	
	public void ajouter(Jeux c) {
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.persist(c);
		tx.commit();
	}

	
	public void modifier(Jeux c) {
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.merge(c);
		tx.commit();
	}


	
	public void supprimer(Jeux c) {
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		c = entityManager.merge(c); // important
		entityManager.remove(c);
		tx.commit();
	}

	
	public Jeux consulter(Jeux c, Object id) {
		return entityManager.find(c.getClass(), id);
	}

	
	public List<Jeux> listerTous() {
		List<Jeux> Jeuxs = entityManager.createQuery("select c from Jeux c").getResultList();

		return Jeuxs;
	}


	
	public List<Jeux> listerParNom(String nom) {
		List<Jeux> Jeuxs = entityManager.createQuery("select c from Jeux c where c.nom like :pnom").setParameter("pnom", "%" + nom + "%").getResultList();

		return Jeuxs;
	}
}
