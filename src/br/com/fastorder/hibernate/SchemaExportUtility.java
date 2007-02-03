package br.com.fastorder.hibernate;

import org.hibernate.tool.hbm2ddl.SchemaExport;

/**
 * 
 * @author Diogo Cabral de Almeida
 *
 */
public class SchemaExportUtility {
	
	private HibernateSessionFactory sessionFactory;
	
	private SchemaExport schema;
	
	public SchemaExportUtility() {
		sessionFactory = new HibernateSessionFactory();

		schema = new SchemaExport(sessionFactory.getConfiguration());
	}
	
	public void create() {
		schema.setOutputFile("db/script.sql");
		schema.create(true, true);
		
		sessionFactory.closeSession();
	}
	
	public void createScript() {
		schema.setOutputFile("db/script.sql");
		schema.create(true, false);

		sessionFactory.closeSession();
	}
	
	public static void main(String[] args) {
		SchemaExportUtility export = new SchemaExportUtility();
		
		export.create();
	}
	
}
