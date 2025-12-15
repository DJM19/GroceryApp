package utilities;

import com.github.javafaker.Faker;

public class RandomDataUtility {
Faker faker=new Faker();

public String randomusername() {
	return faker.name().username();
}
public String randomPassword() {
	return faker.internet().password();
}
public String fullname() {
	return faker.name().firstName();
}

public String email() {
	return faker.internet().emailAddress();
}
}
