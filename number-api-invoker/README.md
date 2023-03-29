# Number API Invoker

## Build number-api-client

Go to the `number-api-client` folder and run `mvn clean install`. This will build the jar with the client code to call
the number api resource.

## Run number-api-invoker with Ruby

Run the client invoker with:
 
```bash
ruby --jvm --vm.cp=../number-api-client/target/number-api-client.jar:../number-api-client/target/number-api-client-dependencies.jar --vm.Dcom.radcortez.graalvm.microprofile.number.api.client.NumberResourceClient/mp-rest/url=http://localhost:5001/number-api/ number-api-invoker.rb
```

## Run number-api-invoker with Python

Run the client invoker with:

```bash
graalpy --jvm --vm.cp=../number-api-client/target/number-api-client.jar:../number-api-client/target/number-api-client-dependencies.jar --vm.Dcom.radcortez.graalvm.microprofile.number.api.client.NumberResourceClient/mp-rest/url=http://localhost:5001/number-api/ number-api-invoker.py
```

## Run number-api-invoker with LLVM

```bash
$LLVM_TOOLCHAIN/clang number-api-invoker.c -lgraalvm-llvm -o number-api-invoker
lli --jvm --vm.cp=../number-api-client/target/number-api-client.jar:../number-api-client/target/number-api-client-dependencies.jar --vm.Dcom.radcortez.graalvm.microprofile.number.api.client.NumberResourceClient/mp-rest/url=http://localhost:5001/number-api/ number-api-invoker
```
