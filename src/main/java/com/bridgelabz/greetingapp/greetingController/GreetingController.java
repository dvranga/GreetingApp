package com.bridgelabz.greetingapp.greetingController;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.greetingapp.dto.Greeting;

@RestController
public class GreetingController {
	private static final String template="Hello, %s!";
	private final AtomicLong counter=new AtomicLong();
	
	@GetMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name",defaultValue = "world") String name) {
		return new Greeting(counter.incrementAndGet(),
				String.format(template, name));
	}
}
