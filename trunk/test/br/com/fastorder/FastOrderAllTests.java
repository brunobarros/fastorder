package br.com.fastorder;

import junit.framework.JUnit4TestAdapter;
import junit.framework.Test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.com.fastorder.action.ContaActionTest;
import br.com.fastorder.action.ProdutoActionTest;
import br.com.fastorder.action.TipoProdutoActionTest;
import br.com.fastorder.action.UsuarioActionTest;
import br.com.fastorder.dao.hibernate.HibernateContaDaoTest;
import br.com.fastorder.dao.hibernate.HibernateGenericDaoTest;
import br.com.fastorder.interceptor.PermissionInterceptorTest;
import br.com.fastorder.model.ContaTest;
import br.com.fastorder.util.Md5Test;

@RunWith(Suite.class)
@SuiteClasses( { 
	ContaActionTest.class, 
	ProdutoActionTest.class ,	
	TipoProdutoActionTest.class,  
	UsuarioActionTest.class,
	HibernateContaDaoTest.class,
	HibernateGenericDaoTest.class,
	PermissionInterceptorTest.class,
	ContaTest.class, 
	Md5Test.class} )
public class FastOrderAllTests {

  public static Test suite() {
    return new JUnit4TestAdapter(FastOrderAllTests.class);
  }

}
