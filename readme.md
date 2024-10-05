Sample application that showcases SVG image loading in JavaFX with [PR 1093](https://github.com/openjdk/jfx/pull/1093).

To run this application, replace the following line in `build.gradle.kts` with the path to a locally-built JavaFX SDK with the ImageIO loading capability:
```kotlin
javafx {
    sdk = "<path-to-jfx/build/sdk>"
}
```

Then invoke the `run` task.