package com.sankholin.banana.plug;

import org.gradle.api.Plugin;
import org.gradle.api.Project;

public class BananaPlug implements Plugin<Project> {

  @Override
  public void apply(Project project) {
    applyPlugins(project);
    addDependencies(project);
    addOptions(project);

    project.task("hello").doLast(c -> {
      System.out.println(project.getName());
      System.out.println(project.property("sourceCompatibility"));
    });
  }

  private void applyPlugins(Project project) {
    project.apply(c -> {
      c.plugin("maven").plugin("java");
    });
  }

  private void addDependencies(Project project) {
    project.afterEvaluate(c -> {
      //c.getDependencies().add("compileOnly", "org.projectlombok:lombok");
    });
  }

  private void addOptions(Project project) {
    project.afterEvaluate(c -> {
      c.setProperty("sourceCompatibility", 8);
    });
  }
}
