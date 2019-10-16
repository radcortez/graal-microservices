# GraalVM with MicroProfile

This is the codebase with all the demos for the presentation GraalVM and MicroProfile: A Polyglot Microservices
Solution.

## Samples Structure

* libraries (a fat jar with all the microprofile required implementations to use with GraalVM)
* number-api (a microservice endpoint in Node that generate an id number)

## Running the Samples

### Setup GraalVM

Please refer to the [GraalVM Installation Guide](https://www.graalvm.org/docs/getting-started/#install-graalvm). These
samples were tested with Graal VM version 19.1.x.

#### Install Ruby
* Install the `ruby` language in GraalVM with `gu install ruby`.
* Rebuild the `ruby` language in GraalVM with `gu rebuild-images ruby`.

#### Install Python
* Install the `python` language in GraalVM with `gu install python`.
* Rebuild the `python` language in GraalVM with `gu rebuild-images python`.

### Prepare

Go to the `libraries` folder and run `mvn clean install`. This will build the fat jar with all the required
microprofile dependencies to use with other languages.

---
**NOTE**: 

When running node or ruby commands, make sure that you use the the binaries from the bin folder inside GraalVM. You 
can set a `GRAAL_HOME` to point to Graal installation folder and then use it to reference the specific binaries easier. 

---

### Samples

Please refer to the specific README file for each sample:

* [Number API](/number-api/README.md)
* [Number API Invoker](/number-api-invoker/README.md)

## Resources

TODO 
