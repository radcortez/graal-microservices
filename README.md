# GraalVM with MicroProfile

This is the codebase with all the demos for the presentation GraalVM and MicroProfile: A Polyglot Microservices 
Solution.

## Samples Structure

* number-api (a microservice endpoint that generate an id number, with versions for Java, Node and Ruby)
* number-api-client (a Java client to invoke the number-api)
* number-api-invoker (a Ruby and Python client to invoke the number-api)
* calculator-api (a Java and R Polyglot microservice)

## Running the Samples

### Setup GraalVM

Please refer to the [GraalVM Installation Guide](https://www.graalvm.org/docs/getting-started/#install-graalvm). These
samples were tested with Graal VM version 22.3.x.

#### Install Ruby
* Install the `ruby` language in GraalVM with `gu install ruby`.
* Rebuild the `ruby` language in GraalVM with `gu rebuild-images ruby`.

#### Install Python
* Install the `python` language in GraalVM with `gu install python`.
* Rebuild the `python` language in GraalVM with `gu rebuild-images python`.

### Build

Run `mvn clean install`. This will build all the projects.

---
**NOTE**: 

When running Node or Ruby commands, make sure that you use the binaries from the bin folder inside GraalVM. You 
can set a `GRAAL_HOME` to point to Graal installation folder and then use it to reference the specific binaries easier. 

---

### Samples

Please refer to the specific README file for each sample:

* [Number API](/number-api/README.md)
* [Number API Invoker](/number-api-invoker/README.md)
