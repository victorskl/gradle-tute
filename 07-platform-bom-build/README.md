# platform-bom-build

Goal
- want to have break-out inter-related projects in their own repository
- want to have some share common modules or library version to in-sync with the application which consume them
- want to release software components independent of each other, but operate like μServices fashion


---

## Maven Solution

- Maven BOM + parent POM + private artifact repository


We can achieve this with Maven pretty much it. Try to think of these directores as seperate git repo:

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

- https://maven.apache.org/guides/introduction/introduction-to-dependency-mechanism.html
- https://www.baeldung.com/spring-maven-bom
- https://maven.apache.org/plugins/maven-help-plugin/usage.html


---

## Gradle

- Treat these directories as separate repos:

```
tree -L 1 gradle
gradle
├── banana-app
├── banana-cli
├── banana-platform
└── banana-plug

4 directories, 0 files
```

- Then; let plumb the `platform` and `plugin`

```
rm -rf ~/.m2/repository/com/sankholin/banana/

cd gradle/banana-platform
gw clean --info
tree
gw dependencies --info
gw publishMavenPublicationToMavenLocal --info

ll ~/.m2/repository/com/sankholin/banana/

cd ../banana-plug
gw clean --info
tree
gw dependencies --info
gw publishMavenPublicationToMavenLocal --info

ll ~/.m2/repository/com/sankholin/banana/

```

- Now; we can try test `app` for those `platform` and `plugin` settings that applied

```
cd ../banana-app
gw clean --info
tree
gw dependencies --info
gw assemble --info
tree build
gw hello
```



### Java Platform plugin

- https://docs.gradle.org/current/userguide/building_java_projects.html#sec:building_java_platform
- https://docs.gradle.org/current/userguide/java_platform_plugin.html
- https://docs.gradle.org/current/userguide/migrating_from_maven.html#migmvn:controlling_dep_versions
- https://docs.gradle.org/current/userguide/migrating_from_maven.html#migmvn:using_boms
- https://docs.gradle.org/current/userguide/managing_transitive_dependencies.html#sec:bom_import
- https://docs.gradle.org/current/userguide/dependency_management_for_java_projects.html

### Maven publishing

- https://docs.gradle.org/current/userguide/publishing_maven.html

### Init script

- https://docs.gradle.org/current/userguide/init_scripts.html


### Repository

- https://docs.gradle.org/current/userguide/declaring_repositories.html
- https://docs.gradle.org/current/userguide/repository_types.html


### Custom Plugins

- https://docs.gradle.org/current/userguide/custom_plugins.html



### Resources

- https://stackoverflow.com/questions/54647730/gradle-java-platform-plugin-and-platform-definition
- https://stackoverflow.com/questions/15468109/gradle-parent-pom-like-feature
- https://discuss.gradle.org/t/support-for-gradle-parent-shared-between-projects-cached-locally/488/3
- https://discuss.gradle.org/t/can-i-publish-pom-only-artifacts-with-gradle/3760


