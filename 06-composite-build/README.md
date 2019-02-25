# composite-build

- `my-app` is a standalone project

- `my-utils` is a hierarchical multiproject (produce Java Library)
  ```
  cd my-utils
  tree
  gradle -q projects
  gradle tasks --all
  ```

- `my-app` has lib dependencies on two artifects produced by `my-utils` subprojects `number-utils` and `string-utils`

- perform composite build - using cli argument
  ```
  cd my-app
  gradle --include-build ../my-utils run
  tree build
  ```

- perform composite build - using build script
  ```
  cd composite
  gradle tasks --all
  gradle run --info

  gradle clean --info
  tree ../my-utils ../my-app

  gradle build --info
  tree ../my-utils ../my-app
  ```


### REF

- https://discuss.gradle.org/t/multi-project-build-with-flat-folder-hierarchy/10435
- https://docs.gradle.org/current/userguide/composite_builds.html
- https://github.com/gradle/gradle/tree/master/subprojects/docs/src/samples/compositeBuilds/basic
