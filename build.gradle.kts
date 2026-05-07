plugins {
    alias(libs.plugins.kotlin)
    alias(libs.plugins.fabric.loom)
}

val modVersion: String = "1.0.0"

version = "$modVersion+${libs.versions.minecraft.get()}"
group = "ua.bonfiremc"

repositories {

}

dependencies {
    minecraft(libs.minecraft)

    implementation(libs.fabric.loader)
    implementation(libs.fabric.kotlin)
    implementation(libs.fabric.api)
}

java {
    sourceCompatibility = JavaVersion.VERSION_25
    targetCompatibility = JavaVersion.VERSION_25
}

tasks {
    processResources {
        inputs.property("version", version)

        filesMatching("fabric.mod.json") {
            expand("version" to version)
        }
    }

    jar {
        from("LICENSE")
    }
}
