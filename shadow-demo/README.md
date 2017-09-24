Gradle Shadow plugin for Uber-JAR a.k.a executable JAR

https://github.com/johnrengelman/shadow

http://imperceptiblethoughts.com/shadow/

```
mkdir shadow-demo
cd shadow-demo
gradle init --console plain --type java-application
(edit and add shadow plugin in build.gradle)
./gradlew shadowJar
tree
java -jar build/libs/shadow-demo-1.0-SNAPSHOT-all.jar
```