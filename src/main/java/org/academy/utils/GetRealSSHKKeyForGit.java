package org.academy.utils;

import org.academy.TestConfigurations;

import java.util.Base64;

public class GetRealSSHKKeyForGit {
    private static final String key = new String(Base64.getDecoder().decode(TestConfigurations.getEncodedApiToken()));

    public static String getDecodedKey() {
        return key;
    }
}
