# Number API Sample

## Run number-api with Node

Install the required node modules with: 

```bash
npm install left-pad express
```

Run the microservice with: 

```bash
node --jvm --vm.cp=../libraries/target/microprofile.jar --vm.DNUMBER_API_PORT=5001 number-api.js
```

And you can test it with:

```bash
curl http://localhost:5001/number-api/number/generate
```

## Run number-api with Ruby

Install Ruby Sinatra with: 

```bash
gem install sinatra
```

Run the microservice with:

```bash
ruby --jvm --vm.cp=../libraries/target/microprofile.jar --vm.DNUMBER_API_PORT=5002 number-api.rb
```

And you can test it with:

```bash
curl http://localhost:5002/number-api/number/generate
```

## Run number-api with Java

Build the code with:

```bash
mvn package
```

Run the microservice with:

```bash
java -jar target/number-api.jar
```

And you can test it with:

```bash
curl http://localhost:3001/number-api/number/generate
```

## Run number-api with Native Image

Build a native image with:

```bash
native-image --no-server --no-fallback --report-unsupported-elements-at-runtime --initialize-at-build-time -H:+ReportExceptionStackTraces -H:+ReportUnsupportedElementsAtRuntime -H:ConfigurationFileDirectories=conf/ -jar target/number-api.jar
```

Run the microservice with: 

```bash
./number-api
```

```bash
curl http://localhost:3001/number-api/number/generate
```
