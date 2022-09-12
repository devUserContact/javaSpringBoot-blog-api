package com.api.bluehappyface.Controller;

//import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@CrossOrigin(origins = "http://localhost:3000")
public class Controllers {

	@GetMapping(value = "/")
	public String getPage() {
		return "blueHappyFace API";
	}

}