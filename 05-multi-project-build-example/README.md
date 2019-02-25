# multi-project-build-example

Example from https://guides.gradle.org/creating-multi-project-builds/

### note

- This is still a multiproject build with Hierarchical layout (see multi-project-build)

```
cd creating-multi-project-builds
tree
gw -q projects
gw task --all --info
gw build --info
tree -L 3
gw assemble --info
gw clean --info
```
