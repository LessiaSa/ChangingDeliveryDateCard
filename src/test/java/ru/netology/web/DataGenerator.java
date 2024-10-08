package ru.netology.web;

import lombok.Value;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;

import com.github.javafaker.Faker;


public class DataGenerator {
    private static final Random random = new Random();
    Faker faker = new Faker(new Locale("ru-RU"));

    private DataGenerator() {
    }


    public static String generateDate(int shift) {
        String date = LocalDate.now().plusDays(3 + shift)
                .plusDays(shift).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        return date;
    }

    public static String generateCity(String locale) {
        Faker faker = new Faker(new Locale(locale));
        String city = faker.address().city();
        return city;
    }

    public static String generateName(String locale) {
        Faker faker = new Faker(new Locale(locale));
        String name = faker.name().fullName();
        return name;
    }

    public static String generatePhone(String locale) {
        Faker faker = new Faker(new Locale(locale));
        String phone = faker.phoneNumber().phoneNumber();
        return phone;
    }

    public static class Registration {
        private Registration(){
        }


        public static UserInfo generateUser(String locale) {
            UserInfo user = new UserInfo(generateCity(locale),generateName(locale),generatePhone(locale));
            return user;
        }

    }
    @Value
    public static class UserInfo {
        String city;
        String name;
        String phone;
    }
}
