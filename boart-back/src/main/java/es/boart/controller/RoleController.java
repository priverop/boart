package es.boart.controller;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

public class RoleController {
	
	public static final List<String> rolesList = Collections.unmodifiableList(Arrays.asList("ADMIN", "USER"));
	
	public static String getRoleRequest(HttpServletRequest request){
				
		String roleRequest = "GUEST";
				
		for (String role : rolesList) {
			if(request.isUserInRole(role)){
				roleRequest = role;
				break;
			}
		}
		
		return "ROL_" + roleRequest;
		
	}
	
}
