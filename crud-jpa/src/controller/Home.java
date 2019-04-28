package controller;

import java.util.Date;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
//import java.util.Date;
import model.Funcionario;
import view.*;

public class Home extends Funcionario {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("funcionarioPU");
		EntityManager em = emf.createEntityManager();

		Tela telaHome = new Tela();		
		telaHome.tela();
	}

}
