package br.com.fastorder.interceptor;

import org.apache.struts2.views.util.UrlHelper;

import br.com.fastorder.model.Usuario;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class PermissionInterceptor implements Interceptor {

	private static final long serialVersionUID = 6701174983129586626L;
	
	private static final String URL_PARAM_SEPARATOR = "&";

	public void init() {
	}
	
	public void destroy() {
	}	

	public String intercept(ActionInvocation action) throws Exception {
		Usuario usuario = (Usuario) ActionContext.getContext().getSession().get("usuario");

		if (usuario == null) {

			ActionContext.getContext().getSession().put("namespace", action.getProxy().getNamespace());
			ActionContext.getContext().getSession().put("uri", getUri(action));
			
			return Action.LOGIN;
		}
		
		return action.invoke();
	}
	
	private String getUri(ActionInvocation action) {
		StringBuffer uri = new StringBuffer();
		
		uri.append(action.getProxy().getActionName());
		
		UrlHelper.buildParametersString(ActionContext.getContext().getParameters(), uri, URL_PARAM_SEPARATOR);	

		return uri.toString();
	}

}
