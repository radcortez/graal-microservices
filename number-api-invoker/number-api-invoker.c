#include <stdio.h>
#include <polyglot.h>

int main() {
    void* webbeans = polyglot_java_type("org.apache.webbeans.config.WebBeansContext").currentInstance();
    lifecyle = webbeans.getService(polyglot_java_type("org.apache.webbeans.spi.ContainerLifecycle"))
    lifecyle.startApplication(None)

    number = polyglot_java_type("javax.enterprise.inject.spi.CDI")\
        .current()\
        .select(polyglot_java_type("org.tomitribe.graalvm.microprofile.number.api.client.NumberResourceApi"))\
        .get()

    printf("%s\n", number);

    return 0;
}
