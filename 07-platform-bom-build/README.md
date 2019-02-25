# platform-bom-build

Goal
- want to have break-out inter-related projects in their own repository
- want to have some share common modules or library version to in-sync with the application which consume them
- want to release software components independent of each other, but operate like μServices fashion

Approach
- Maven BOM
- Gradle Java Platform Plugin

## Gradle

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



### gradle commands

```
gradle dependencyInsight --configuration testRuntimeClasspath --dependency httpclient
```


## Maven Solution

We can achieve this with Maven pretty much it. Try these:

- Think of; these directores as seperate git repo:

```
tree -L 1 maven
maven
├── bom
├── parent
├── project1
├── project2
└── use

5 directories, 0 files
```

- Then;

```
rm -rf ~/.m2/repository/com/test/

cd maven
tree

cd bom
mvn install
ll ~/.m2/repository/com/test/
ll ~/.m2/repository/com/test/bom/1.0.0

cd ../parent
mvn install
ll ~/.m2/repository/com/test/parent/1.0.0

cd ../project1
mvn dependency:tree
mvn help:effective-pom
mvn install

cd ../project2
mvn install

cd ../use
mvn verify
mvn dependency:tree
mvn help:effective-pom
```

### Resources

- https://maven.apache.org/plugins/maven-help-plugin/usage.html

