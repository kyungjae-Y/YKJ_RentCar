package com.basic.rentcar.frontController;

import java.util.HashMap;

import com.basic.rentcar.controller.rentcar.*;
import com.basic.rentcar.controller.user.*;

public class HandlerMapping {
	private HashMap<String, Controller> mappings;
	public HandlerMapping() {
		mappings = new HashMap<String, Controller>();
		mappings.put("/main.do", new MainController());

//		mappings.put("/deleteUser.do", new DeleteUserController());
//		mappings.put("/userAdd.do", new JoinUserController());
		mappings.put("/userLogin.do", new LoginCheckController());
		mappings.put("/logoutCheck.do", new LogoutController());
//		mappings.put("/updateUser.do", new UpdateUserController());
//		mappings.put("userInfo.do", new UserInfoController());
		mappings.put("/validateId.do", new ValidateIdController());

		mappings.put("/carInfo.do", new CarInfoController());
//		mappings.put("/carList.do", new CarListController());
//		mappings.put("/deleteRes.do", new DeleteResController());
//		mappings.put("/insertCar.do", new InsertCarController());
		mappings.put("/reservateCarView.do", new ReservateCarController());
		mappings.put("/reservateCarMain.do", new ReservateCarMainController());
		mappings.put("/reservateCarResult.do", new ReservateCarResultController());
		mappings.put("/selectCarOption.do", new SelectCarOptionController());
//		mappings.put("/uploadCarImg.do", new UploadCarImgConrtroller());
//		mappings.put("/userReserveList.do", new UserReserveListController());
	}

	public Controller getController(String key) {
		return mappings.get(key);
	}
}
