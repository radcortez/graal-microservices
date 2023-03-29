package com.radcortez.graalvm.microprofile.calculator.api;

import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.Source;
import org.graalvm.polyglot.Value;

import java.io.IOException;
import java.net.URL;

public enum CalculatorR {
    ADD("add.R"),
    SUBSTRACT("subtract.R"),
    MULTIPLY("multiply.R"),
    DIVIDE("divide.R");

    private final Value function;

    CalculatorR(final String resource) {
        try {
            final URL urlResource = Thread.currentThread().getContextClassLoader().getResource(resource);
            assert urlResource != null;

            final Source source = Source.newBuilder("R", urlResource).build();
            final Context context = Context.newBuilder("R").allowAllAccess(true).build();

            this.function = context.eval(source);

        } catch (IOException e) {
            throw new IllegalStateException();
        }
    }

    public Number execute(final Object... args) {
        return function.execute(args).as(Number.class);
    }
}
