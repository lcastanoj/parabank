package com.automation.utils;

import org.apache.commons.lang3.RandomStringUtils;
import com.automation.models.UserData;

public class DataGenerator {

    public static UserData randomUser() {

        String randomValue = RandomStringUtils.randomNumeric(5);

        return new UserData(
                "Lucas",
                "Castaño",
                "Calle " + randomValue,
                "Medellín",
                "Antioquia",
                "0500" + randomValue,
                "300" + RandomStringUtils.randomNumeric(7),
                RandomStringUtils.randomNumeric(6),
                "user" + randomValue,
                "Pass123"
        );
    }
}
