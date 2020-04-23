package com.fuchsia.fuchsia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

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
		return String.format("Hello %s!", name);
	}

	@PostMapping(value = "/something", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity userController(@RequestBody User user) {
		System.out.println("user is " + user.toString());
		return new ResponseEntity<>(user, HttpStatus.OK);
	}

	@GetMapping(value = "/api/exercise/users", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity getAllUsersController() {
		return new ResponseEntity<>(User.getUserArray(), HttpStatus.OK);
	}


}
