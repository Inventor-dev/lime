package xyz.lemone.lime.sys.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/api/login")
public class LoginController {


	@PostMapping("/account")
	public Object login(String type){
		HashMap<Object, Object> map = new HashMap<>();
		map.put("status","ok");
		map.put("type","account");
		map.put("currentAuthority","admin");
		return map;
	}


}
