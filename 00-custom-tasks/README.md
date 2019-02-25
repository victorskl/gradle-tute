# custom-tasks

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
    gradle -b meow.gradle tasks --all
    gradle -b meow.gradle meow
    gradle -b hello.gradle tasks
    gradle -b hello.gradle hello
    gradle -b greeting.gradle tasks
    gradle -b greeting.gradle greeting
    gradle -b greeting.gradle gutenTag
    ```
