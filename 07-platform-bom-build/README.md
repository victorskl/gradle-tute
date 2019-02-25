# platform-bom-build

Goal
- want to have break-out inter-related projects in their own repository
- want to have some share common modules or library version to in-sync with the application which consume them
- want to release software components independent of each other, but operate like μServices fashion

Approach
- Maven BOM
- Gradle Java Platform Plugin


### REF

- https://docs.gradle.org/current/userguide/building_java_projects.html#sec:building_java_platform
- https://docs.gradle.org/current/userguide/java_platform_plugin.html
- https://docs.gradle.org/current/userguide/migrating_from_maven.html#migmvn:controlling_dep_versions
- https://docs.gradle.org/current/userguide/migrating_from_maven.html#migmvn:using_boms
- https://docs.gradle.org/current/userguide/managing_transitive_dependencies.html#sec:bom_import
- https://docs.gradle.org/current/userguide/publishing_maven.html


### Resources

- https://stackoverflow.com/questions/54647730/gradle-java-platform-plugin-and-platform-definition
- https://www.baeldung.com/spring-maven-bom



### Useful commands

```
gradle dependencyInsight --configuration testRuntimeClasspath --dependency httpclient
```

