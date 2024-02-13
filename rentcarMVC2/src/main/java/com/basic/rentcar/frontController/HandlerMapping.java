package com.basic.rentcar.frontController;

import java.util.HashMap;

import com.basic.rentcar.controller.user.LoginCheckController;
import com.basic.rentcar.controller.user.MainController;
import com.basic.rentcar.controller.user.ValidateIdController;

public class HandlerMapping {
	private HashMap<String, Controller> mappings;

	public HandlerMapping() {
		mappings = new HashMap<String, Controller>();
		mappings.put("/main.do", new MainController());
		mappings.put("/userLogin.do", new LoginCheckController());
		mappings.put("/validateId.do", new ValidateIdController());
		mappings.put("/validateId.do", new ValidateIdController());
	}

	public Controller getController(String key) {
		return mappings.get(key);
	}
}
