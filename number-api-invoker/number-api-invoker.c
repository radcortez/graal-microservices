#include <stdio.h>
#include <graalvm/llvm/polyglot.h>

int main() {
    void *System = polyglot_java_type("java.lang.System");
    void *Weld = polyglot_java_type("org.jboss.weld.environment.se.Weld");
    void *NumberApi = polyglot_java_type("com.radcortez.graalvm.microprofile.number.api.client.NumberResourceApi");

    void *weld = polyglot_new_instance(Weld);
    void *container = polyglot_invoke(weld, "initialize");
    void *numberApi = polyglot_invoke(polyglot_invoke(container, "select", NumberApi), "get");
    void *value = polyglot_invoke(numberApi, "getNumber");

    void *out = polyglot_get_member(System, "out");
    polyglot_invoke(out, "println", value);
}
