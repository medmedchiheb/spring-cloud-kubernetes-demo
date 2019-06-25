package com.github.medmedchiheb;

import java.net.UnknownHostException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class Controller {
	
	@Autowired
	UserService userService;
	

	@Autowired
	Environment env;
	
	@GetMapping("/")
	public String[] profile() {
		return env.getActiveProfiles();
	}
	
	@GetMapping("/get")
	public GetDTO user() {
		return new GetDTO(userService.user(), env.getActiveProfiles().length > 0  ? env.getActiveProfiles()[0] : "");
	}
	
	@GetMapping("/user-host")
	public String userHost() throws UnknownHostException {
		return userService.host();
	}
	
	
	
	
	
}
