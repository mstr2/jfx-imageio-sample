plugins {
    application
    id("org.openjfx.javafxplugin") version "0.1.0"
}

group = "sample"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

javafx {
    sdk = "<path-to-jfx/build/sdk>"
    modules("javafx.base", "javafx.graphics", "javafx.controls", "javafx.web")
}

application {
    mainClass = "sample.App"
}

dependencies {
    implementation("com.twelvemonkeys.imageio:imageio-batik:3.10.1")
    implementation("org.apache.xmlgraphics:batik-all:1.17")
}
