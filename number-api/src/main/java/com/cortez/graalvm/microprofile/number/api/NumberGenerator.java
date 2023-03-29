package com.cortez.graalvm.microprofile.number.api;

import org.graalvm.polyglot.Context;

public class NumberGenerator {
    public static String generate() {
        try (Context context = Context.create("js")) {
            return context.eval(
                "js",
                "var number = 'MV-' + ((Math.floor(Math.random() * 9999999) + 1) + '').padStart(7, '0');" +
                "console.log(number);" +
                "number;")
                          .as(String.class);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
