package utility;

import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;

import java.util.Locale;

public class GenerateData {
    static FakeValuesService fakeValuesService = new FakeValuesService(new Locale("en-US"), new RandomService());
    static Faker faker = new Faker();
    public static String firstName() {
        return faker.name().firstName();
    }

    public static String lastName() {
        return faker.name().lastName();
    }
    public static String email(){
        return faker.internet().emailAddress();
    }
    public static String password() {
        return faker.bothify("Lp!??##?$#?##?##??#");

    }

}
