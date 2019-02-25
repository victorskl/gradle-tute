Building Java Applications

- https://guides.gradle.org/building-java-applications/

    ```
    mkdir java-demo
    cd java-demo
    gradle init --type java-application
    tree
    ./gradlew build
    tree build
    ./gradlew tasks
    ./gradlew run
    ```

- Observe the generated files using Gradle `init` build script for `java-application` type.

- Also check Java quickstart using Java plugin 
    - a monolithic-single project 
    - multi-project (multi-modules) Java build 
    - https://docs.gradle.org/current/userguide/tutorial_java_projects.html
    
- More articles on Java + Gradle:
    - https://spring.io/guides/gs/gradle/
    - http://nikgrozev.com/2017/02/10/gradle-quickstart/
    - https://www.petrikainulainen.net/getting-started-with-gradle/
