package br.com.fastorder;

import junit.framework.JUnit4TestAdapter;
import junit.framework.Test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.com.fastorder.action.ProdutoActionTest;
import br.com.fastorder.action.TipoProdutoActionTest;
import br.com.fastorder.action.UsuarioActionTest;
import br.com.fastorder.model.ContaTest;
import br.com.fastorder.util.Md5Test;

@RunWith(Suite.class)
@SuiteClasses( { TipoProdutoActionTest.class, 
	ProdutoActionTest.class , 
	UsuarioActionTest.class, 
	ContaTest.class, 
	Md5Test.class} )
public class FastOrderAllTests {

  public static Test suite() {
    return new JUnit4TestAdapter(FastOrderAllTests.class);
  }

}
