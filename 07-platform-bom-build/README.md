# platform-bom-build

Goal
- want to have break-out inter-related projects in their own repository
- want to have some share common modules or library version to in-sync with the application which consume them
- want to release software components independent of each other, but operate like μServices fashion



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



## Gradle Solution

- Gradle solution involves mainly relying on its Plugin feature, i.e. very plugin opinionated!

- To contrast with Maven inheritance style, Gradle's way can be thought of it as _cross cutting_ configuration with custom plugins.

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

- Then; let plumb the `plugin`

```
rm -rf ~/.m2/repository/com/sankholin/banana/

cd gradle/banana-plug
gw clean --info
tree
gw dependencies --info
gw publishToMavenLocal --info
ll ~/.m2/repository/com/sankholin/banana/
```

- Then; let plumb the `platform` for Maven BOM style `dependenciesManagement`

```
rm -rf ~/.m2/repository/com/sankholin/banana/

cd ../banana-platform
gw clean --info
tree
gw dependencies --info
gw publishToMavenLocal --info
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

### Init script

- https://docs.gradle.org/current/userguide/init_scripts.html


### Java Platform plugin

- https://docs.gradle.org/current/userguide/building_java_projects.html#sec:building_java_platform
- https://docs.gradle.org/current/userguide/java_platform_plugin.html
- https://docs.gradle.org/current/userguide/migrating_from_maven.html#migmvn:controlling_dep_versions
- https://docs.gradle.org/current/userguide/migrating_from_maven.html#migmvn:using_boms
- https://docs.gradle.org/current/userguide/managing_transitive_dependencies.html#sec:bom_import
- https://docs.gradle.org/current/userguide/dependency_management_for_java_projects.html

### Maven Publishing plugin

- https://docs.gradle.org/current/userguide/publishing_maven.html
- https://docs.gradle.org/current/userguide/publishing_overview.html

### Signing plugin

- https://docs.gradle.org/current/userguide/signing_plugin.html

### Repository

- https://docs.gradle.org/current/userguide/declaring_repositories.html
- https://docs.gradle.org/current/userguide/repository_types.html

### Credentials

- https://help.sonatype.com/repomanager2/maven-and-other-build-tools/gradle
- ...
- https://discuss.gradle.org/t/publish-to-maven-repository/26138
- https://discuss.gradle.org/t/maven-publish-and-authentication/6833
- https://discuss.gradle.org/t/need-the-gradle-script-to-publish-a-jar-in-my-project-to-a-nexus-repository/22008
- https://discuss.gradle.org/t/avoid-build-repository-credentials-in-build-gradle/25653/2
- https://stackoverflow.com/questions/12749225/where-to-put-gradle-configuration-i-e-credentials-that-should-not-be-committe


### Custom Plugins

- https://guides.gradle.org/writing-gradle-plugins/
- https://guides.gradle.org/implementing-gradle-plugins/
- ...
- https://docs.gradle.org/current/userguide/custom_plugins.html
- https://docs.gradle.org/current/userguide/java_gradle_plugin.html
- https://docs.gradle.org/current/userguide/plugins.html
- ...
- https://www.praqma.com/stories/gradle-plugin-bootstrap/
- http://blog.anorakgirl.co.uk/2014/12/gradle-and-the-parent-pom/
- https://stackoverflow.com/questions/51773218/why-does-gradle-not-look-in-the-local-maven-repository-for-plugins/51775637


### Resources

- https://stackoverflow.com/questions/9539986/how-to-share-a-common-build-gradle-via-a-repository
- https://stackoverflow.com/questions/54647730/gradle-java-platform-plugin-and-platform-definition
- https://stackoverflow.com/questions/15468109/gradle-parent-pom-like-feature
- https://discuss.gradle.org/t/support-for-gradle-parent-shared-between-projects-cached-locally/488/3
- https://discuss.gradle.org/t/can-i-publish-pom-only-artifacts-with-gradle/3760


### aalmiray's kordamp-gradle-plugins

- http://andresalmiray.com/on-joining-gradle/
- ...
- http://andresalmiray.com/the-gradle-pom/
  - https://github.com/jsr377/jsr377-api
- http://andresalmiray.com/the-gradle-superpom/
  - https://gist.github.com/aalmiray/037412256648f8711afa51a622e7f855
- http://andresalmiray.com/gaining-insight-into-a-gradle-build/
- ...
- https://aalmiray.github.io/kordamp-gradle-plugins/
- https://aalmiray.github.io/kordamp-gradle-plugins/api-html/index.html
- https://github.com/aalmiray/kordamp-gradle-plugins



