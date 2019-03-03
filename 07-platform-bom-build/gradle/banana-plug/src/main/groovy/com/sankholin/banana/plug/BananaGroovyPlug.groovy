package com.sankholin.banana.plug

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.plugins.JavaBasePlugin
import org.gradle.api.publish.maven.MavenPublication

class BananaGroovyPlug implements Plugin<Project> {

  @Override
  void apply(Project project) {

    //-- apply gradle internal plugin

    //project.plugins.apply("java")
    //project.getPluginManager().apply(JavaPlugin.class)
    //def pm = project.pluginManager
    //pm.apply(JavaPlugin.class)
    //pm.apply(MavenPublishPlugin.class)

    project.configure(project) {
      apply plugin: "java"
      apply plugin: "maven-publish"
    }

    //-- extension

    project.allprojects {
      repositories {
        jcenter()
        mavenLocal()
        mavenCentral()

        maven {
          url project.getProperty('repoUrl') + "/repository/maven-public/"
          name = 'Banana'
          credentials {
            username project.getProperty('repoUser')
            password project.getProperty('repoPass')
          }
        }

      }
    }

    //-- afterEvaluate

    project.afterEvaluate {
      project.plugins.withType(JavaBasePlugin) {

        project.dependencies {
          // compileOnly "org.projectlombok:lombok:1.18.0"
        }

        project.setProperty("sourceCompatibility", "8")

        project.publishing {
          publications {
            maven(MavenPublication) { from project.components.java }
          }
          repositories {
            maven {
              def baseUrl = project.getProperty('repoUrl')
              def releasesRepoUrl = "$baseUrl/repository/maven-releases/"
              def snapshotsRepoUrl = "$baseUrl/repository/maven-snapshots/"
              url = project.hasProperty('release') ? releasesRepoUrl : snapshotsRepoUrl
              name = 'Banana'
              credentials {
                username project.getProperty('repoUser')
                password project.getProperty('repoPass')
              }
            }
          }
        }

      }
    }

    //-- custom tasks

    project.task("hello") {
      doLast {
        println project.getName() + " configured to compile with Java: " + project.property("sourceCompatibility")
      }
    }
  }
}

// Banana Conclusion Note
//
// I will leave this banana as it is for now for learning purpose
// For pointing enterprise private repo setting should better be in ~/.gradle/init.gradle
// Since, we have to do ~/.gradle/gradle.properties anyway
//
// And a custom plugin will be doing specific thing
// e.g. applying java plugin and setting 'sourceCompatibility' to 1.8 for any every project
// may not be desirable effect as there may involve none java project.
// So, the approach is, when we do need writing custom plugin, it strategically better start
// with multi-project layout and write any specific customisation in each sub-project plugins.
//
// banana out!
