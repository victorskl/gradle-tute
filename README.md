# gradle-tute

- Install
    ```
    brew install gradle
    gradle --version
    ```

- At most, the `build.gradle` can contain nothing
    ```
    touch build.gradle
    gradle tasks
    gradle tasks --all
    ```

- Writing Custom Gradle Tasks

    - https://guides.gradle.org/writing-gradle-tasks/
    - If not the default `build.gradle`, use `-b` flag.
    ```
    gradle -b meow.gradle tasks
    gradle -b hello.gradle tasks
    gradle -b greeting.gradle tasks
    ```
