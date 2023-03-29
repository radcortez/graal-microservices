package com.radcortez.graalvm.microprofile.number.api.client;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

public class NumberResourceInvoker {
    public static void main(String[] args) {
        System.setProperty("com.radcortez.graalvm.microprofile.number.api.client.NumberResourceClient/mp-rest/url", "http://localhost:5001/number-api/");
        System.out.println(getNumber());
    }

    public static String getNumber() {
        Weld weld = new Weld();
        String number;
        try (WeldContainer container = weld.initialize()) {
            NumberResourceApi numberResourceApi = container.select(NumberResourceApi.class).get();
            number = numberResourceApi.getNumber();
        }
        return number;
    }
}
