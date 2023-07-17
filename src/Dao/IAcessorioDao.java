package Dao;

import Domain.Acessorio;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public interface IAcessorioDao {

    Acessorio cadastrar(Acessorio acessorio);
}

