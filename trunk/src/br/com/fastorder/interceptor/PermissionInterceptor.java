package br.com.fastorder.interceptor;

import br.com.fastorder.model.Usuario;

import com.opensymphony.xwork.Action;
import com.opensymphony.xwork.ActionContext;
import com.opensymphony.xwork.ActionInvocation;
import com.opensymphony.xwork.interceptor.Interceptor;

public class PermissionInterceptor implements Interceptor {

	private static final long serialVersionUID = 6701174983129586626L;

	public void init() {
	}
	
	public void destroy() {	
	}	

	public String intercept(ActionInvocation action) throws Exception {
		Usuario usuario = (Usuario) ActionContext.getContext().getSession().get("usuario");
		
		if (usuario == null) {
			return Action.LOGIN;
		}
		
		return action.invoke();
	}

}
