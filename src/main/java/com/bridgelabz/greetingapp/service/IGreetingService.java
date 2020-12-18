package com.bridgelabz.greetingapp.service;

import java.util.List;
import java.util.Optional;

import com.bridgelabz.greetingapp.model.Greeting;
import com.bridgelabz.greetingapp.model.User;

public interface IGreetingService {

    Greeting addGreeting(User user);

	Optional<Greeting> getGreetingById(long id);

	List<Greeting> getAllGreetings();

	Optional<Greeting> editGreetingById(long id, String name);

	String deleteGreeting(long id);

}
