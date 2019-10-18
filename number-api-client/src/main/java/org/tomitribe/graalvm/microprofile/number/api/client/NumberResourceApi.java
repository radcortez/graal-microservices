package org.tomitribe.graalvm.microprofile.number.api.client;

import org.eclipse.microprofile.faulttolerance.CircuitBreaker;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Retry;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.time.temporal.ChronoUnit;

@ApplicationScoped
public class NumberResourceApi {
    @RestClient
    @Inject
    private NumberResourceClient numberService;

    @CircuitBreaker
    @Fallback(NumberResourceClientFallbackHandler.class)
    @Retry(maxRetries = 10, delay = 5, delayUnit = ChronoUnit.SECONDS)
    public String getNumber() {
        return numberService.getNumber();
    }
}
