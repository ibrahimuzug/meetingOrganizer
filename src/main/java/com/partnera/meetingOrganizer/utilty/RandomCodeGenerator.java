package com.partnera.meetingOrganizer.utilty;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomCodeGenerator {

    private static final int SHORT_ID_LENGTH = 6;

    public static String generate() {
        return RandomStringUtils.randomAlphabetic(SHORT_ID_LENGTH);
    }
}
