package com.fuchsia.fuchsia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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


/*
    @RequestMapping(value = "/api/exercise/new-user", headers = "Content-Type=text/plain", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<User> createUser(HttpServletRequest request, HttpServletResponse response, Model model) {
		//User user1 = new User(name);
		String jsonString = request.getParameter("json");
		System.out.println(jsonString);
		return null;
	}
*/

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

	@PostMapping(value = "/something", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity userController(@RequestBody User user) {
		System.out.println("user is " + user.toString());
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

}
