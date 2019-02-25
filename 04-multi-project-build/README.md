# gradle multi-project build

1. Hierarchical (aka one root tree)
2. Flat (no tree)

```
cd hierarchical
tree
gradle tasks
gradle tasks --all
gradle api:api
gradle base
gradle -q projects
gradle -q projects --info
gradle -q hello
```

```
cd flat
tree
cd master
gradle tasks
gradle tasks --all
gradle tasks :api:tasks
gradle tasks :api:tasks --all
gradle -q projects
gradle -q api
gradle -q master
gradle -q master api
gradle -q hello
```

### REF

- https://docs.gradle.org/current/userguide/build_lifecycle.html
- https://docs.gradle.org/current/userguide/intro_multi_project_builds.html
- https://docs.gradle.org/current/userguide/multi_project_builds.html
- https://docs.gradle.org/current/userguide/organizing_gradle_projects.html


### Articles

- http://andresalmiray.com/multi-module-project-builds-with-maven-and-gradle/

### Using arbitrary gradle file

- Gradle has construct that one can apply (e.g. common dependencies) configuration from an arbitrary gradle file
  ```
  apply from: 'gradle/dependencies.gradle'
  ...
  apply from: file('../parent/dependencies.gradle')
  ...
  apply from: 'http://wanky-yanky.com/arbitrary/dependencies.gradle'
  ...
  ```


- https://stackoverflow.com/questions/9539986/how-to-share-a-common-build-gradle-via-a-repository
- https://medium.com/freelancer-engineering/managing-dependencies-in-multi-project-builds-with-gradle-7626d9c6448d
- https://github.com/arranlomas/Avoiding-Dependency-Hell-Example


NOTE: 
This approach potentially solve avoiding (some common) dependency version conflicts across multiproject but, 
  major drawback is, a subproject now depends on a file outside of it own project scope.


A better solution is to use Gradle Java Platform Plugin that can apply dependency version constraint across 
  multiple composite projects (i.e. not only multiproject build); just like Maven BOM style.

     see platform-bom-build




