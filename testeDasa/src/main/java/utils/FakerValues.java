package utils;

import com.github.javafaker.Faker;

public class FakerValues {

    Faker faker = new Faker();

    public String getTarefa(){
        return faker.stock().nsdqSymbol();
    }
}
