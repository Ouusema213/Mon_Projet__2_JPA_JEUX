package com.nadhem.test;

import com.nadhem.dao.JeuxDao;
import com.nadhem.entities.Jeux;

public class JeuxTest {
	public static void main(String[] args) {
//créer un objet Jeux
		Jeux c = new Jeux();
		c.setNom("Valorant");
		c.setCategorie("War / Action");
		
		Jeux c2 = new Jeux();
		c2.setNom("League Of Legends");
		c2.setCategorie("Action");
		
		
//ajouter l'objet Jeux à la BD
		JeuxDao cltDao = new JeuxDao();
		cltDao.ajouter(c);
		cltDao.ajouter(c2);
		
		System.out.println("Appel de la méthode listerTous");
		
		for (Jeux cl : cltDao.listerTous())
			System.out.println(cl.getCode() + " " + cl.getNom());
		System.out.println("Appel de la méthode listerParNom");
		
		for (Jeux cl : cltDao.listerParNom("Val"))

			System.out.println(cl.getCode() + " " + cl.getNom());

//tester les autres méthodes de la classe JeuxDao
		
		//Supprimer 
		
		
		
		
	}
}
