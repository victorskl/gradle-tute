# gradle-tute

- Install
    ```
    brew install gradle gdub
    gradle -v
    gw -v
    gw -h
    ```

- However, Gradle has a concept called, localised build wrapper script that go along with source code that it meant to build. Hence, you will find these additional auto-generated _fallout-files_ in every other Gradle projects. You may pay no-attention these files on the starter!
    ```
    gradlew
    gradlew.bat
    gradle/
    gradle/wrapper/
    gradle/wrapper/gradle-wrapper.jar
    gradle/wrapper/gradle-wrapper.properties
    ```

- Opening with IntelliJ IDEA
    > 🙋‍♂️ Note that this tute is meant to follow with command line (Terminal). You may still open with IntelliJ IDEA but, _DO NOT AUTO IMPORT_ when _build script detected_ message balloon-y pop-up. If you happen to click auto import by mistake, close it, `rm -rf .idea` and reopen again. 

    > For that, I would recommend to use Sublime or VSCode or even vim! Just to avoid confusion that may arise with any Java IDE auto setup upon opening thing-y.

### Resources

- https://gradle.org/install/
- https://github.com/dougborg/gdub
- https://www.baeldung.com/gradle

### Useful commands

```
gradle init
gradle wrapper
gradle dependencyInsight --configuration testRuntimeClasspath --dependency httpclient
```
