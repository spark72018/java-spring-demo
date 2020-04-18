package com.fuchsia.fuchsia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController // this annotation tells Spring that this code describes an endpoint that should
// be made available over the web
public class FuchsiaApplication {

	public static void main(String[] args) {
		SpringApplication.run(FuchsiaApplication.class, args);
	}

	@GetMapping("/hello") // corresponds to "http://localhost:8080/hello" route
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) { //
		// @RequestParam is telling Spring to expect a name value in request, but default to
		// "World" if not present
		String[] test = { "What", "World", "Lol" };
		return String.format("Hello %s!", name);
	}

}
