package com.fuchsia.fuchsia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.json.JSONObject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@SpringBootApplication
@RestController // this annotation tells Spring that this code describes an endpoint that should
// be made available over the web
public class FuchsiaApplication {

	public static void main(String[] args) {
		SpringApplication.run(FuchsiaApplication.class, args);
	}

	@GetMapping("/hello") // corresponds to "http://localhost:9090/hello" route
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) { //
		// @RequestParam is telling Spring to expect a name value in request, but default to
		// "World" if not present
		String[] test = { "What", "World", "Lol" };
		return String.format("Hello %s!", name);
	}

	//TODO: Create a user
    @RequestMapping(value = "/api/exercise/new-user", headers = "Content-Type=text/plain", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<User> createUser(@RequestParam("name") String userName) {
		//User user1 = new User(name);
		System.out.println("userName = " + userName);
		return null;
	}


//	@RequestMapping(value = "/api/exercise/new-user", method = RequestMethod.POST)
//	@ResponseBody
//	public ResponseEntity<User> createUser(@ResponseBody name=) {
//		//User user1 = new User(name);
//		System.out.println("request = "+ request.toString());
//		System.out.println("response = " + response.toString());
//		String jsonString = request.getParameter("json");
//		System.out.println(jsonString);
//		return null;
//	}

/*
//decorator - wrapper; modify somethign; reusability
	function foo(fn) {
		const id = "fooId";

		return function(name) {
			return fn(id, name);
		}
	}

	}
*/
}
