import com.github.javafaker.Faker;

public class GeneratorUser {

    static Faker faker = new Faker();

    public static CreatingUser getRandomUser() {
        String email = faker.internet().emailAddress();
        String password = faker.internet().password(6, 10);
        String name = faker.name().username();
        return new CreatingUser(email, password, name);
    }
}
