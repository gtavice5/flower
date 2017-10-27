package com.jkxy.util;

import java.util.Map;

import com.jkxy.model.Admin;
import com.jkxy.model.Users;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class logininter extends AbstractInterceptor{

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		Map session=(Map)arg0.getInvocationContext().get("session");
		Users users=(Users)session.get("users");
		Admin admin=(Admin)session.get("admin");
		if (users==null&&admin==null) {
			return Action.LOGIN;
		}
		return arg0.invoke();
	}
	
}
