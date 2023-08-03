package br.com.senai.core.dao;

import br.com.senai.core.dao.postgres.DaoPostgresCategoria;
import br.com.senai.core.dao.postgres.DaoPostgresRestaurante;

public class FactoryDao {
	private static FactoryDao instance;
	
	public DaoCategoria getDaoCategoria() {
		return new DaoPostgresCategoria();
	}
	public DaoRestaurante getDaoRestaurante() {
		return new DaoPostgresRestaurante();
	}
	
	private FactoryDao() {
	}
	public static FactoryDao getInstance() {
		if(instance == null) {
			instance = new FactoryDao();
		}
		return instance;
	}
	
}
