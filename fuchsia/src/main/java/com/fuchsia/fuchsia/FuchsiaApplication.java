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

	@GetMapping("/hello") // corresponds to "http://localhost:9090/hello" route
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) { //
		// @RequestParam is telling Spring to expect a name value in request, but default to
		// "World" if not present
		return String.format("Hello %s!", name);
	}


/*
    @RequestMapping(value = "/api/exercise/new-user", headers = "Content-Type=text/plain", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<User> createUser(@RequestParam("name") String userName) {
		//User user1 = new User(name);
		System.out.println("userName = " + userName);
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

	@PostMapping(value = "/api/user/add", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity userController(@RequestBody User user) {
		System.out.println("user is " + user.toString());
		return new ResponseEntity<>(user, HttpStatus.OK);
	}


	@GetMapping(value = "/api/exercise/users", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity getAllUsers() {
		System.out.println("user_array : " + User.getUserArray());
		return new ResponseEntity<>(User.getUserArray(), HttpStatus.OK);
	}

	@PostMapping(value = "/api/exercise/add", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity addExercise(@RequestBody Exercise exercise) {
		User user = User.getUser(exercise.getUserId());
		user.addExercise(exercise);
		System.out.println("exercise -> : " + user.getExercises());
		return new ResponseEntity<>(user, HttpStatus.OK);
	}

}

/* EXPENSE TRACKER PROJECT
As a user, I should be able tO;
	1. Add an expense to my account that contains:
		- Name of what I bought
		- How much I spent,
		- Note about purchase
		- Date of purchase

	2. Categorize my expenses:
		- in default categories
		- in user created custom categories

	3. Sort them according to
		- date
		- amount spent

	4. Set weekly or monthly expense goals:
		- app will notify user if he/she is near limit (or go over)

	5. Persist my data in a database (PostgreSQL)

	6. Auto-generate email for summary


 */
