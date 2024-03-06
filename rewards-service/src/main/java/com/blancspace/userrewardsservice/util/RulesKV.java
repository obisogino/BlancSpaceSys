package com.blancspace.userrewardsservice.util;

public enum RulesKV {
    LIMIT("lim"),
    EXPIRATION("expiration"),
    DEFINITION("definition"),
    REWARD("reward"),
    COMMENT("comment");

    private final String key;

    RulesKV(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public static boolean contains(String key) {
        for (RulesKV k : RulesKV.values()) {
            if (k.getKey().equals(key)) {
                return true;
            }
        }
        return false;
    }
}