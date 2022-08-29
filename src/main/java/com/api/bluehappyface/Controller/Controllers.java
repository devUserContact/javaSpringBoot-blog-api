package com.api.bluehappyface.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controllers {

	@GetMapping(value = "/")
	public String getPage() {
		return "blueHappyFace API";
	}

}
