package com.SpringSecurity.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.SpringSecurity.model.UserVO;
import com.SpringSecurity.util.JwtTokenUtil;

@RestController
public class TestingController {
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@GetMapping("/")
	public String onLoad() {
		return "<h1>Welcome Home<h1>";
	}

	@GetMapping("/user")
	public String user() {
		return "<h1>Welcome User<h1>";
	}
	
	@GetMapping("/admin")
	public String admin() {
		return "<h1>Welcome Admin<h1>";
	}
	@PostMapping("/authenticate")
	public String generateToken(@RequestBody UserVO userVO) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userVO.getUsername(), userVO.getPassword()));
		} catch (Exception e) {
			throw new Exception("Invalid UserName/Password");
		}
		return jwtTokenUtil.generateToken(userVO.getUsername());
	}
}
