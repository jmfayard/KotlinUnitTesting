group 'me.rozkmin.testing'
version '1.0-SNAPSHOT'

apply plugin: 'java'
apply plugin: 'kotlin'

sourceCompatibility = 1.8

repositories {
    mavenCentral()
    maven { url "https://dl.bintray.com/spekframework/spek-dev" }

}

test {
    useJUnitPlatform {
        includeEngines 'spek2'
    }
}

dependencies {
    implementation project(':application')
    testImplementation ('org.spekframework.spek2:spek-dsl-jvm:2.0.0-alpha.1')  {
        exclude group: 'org.jetbrains.kotlin'
    }
    testRuntimeOnly ('org.spekframework.spek2:spek-runner-junit5:2.0.0-alpha.1') {
        exclude group: 'org.junit.platform'
        exclude group: 'org.jetbrains.kotlin'
    }

    testCompile('org.junit.jupiter:junit-jupiter-api:5.3.1')


    // spek requires kotlin-reflect, can be omitted if already in the classpath
    testRuntimeOnly "org.jetbrains.kotlin:kotlin-reflect:$kotlin_version"
}

compileKotlin {
    kotlinOptions.jvmTarget = "1.8"
}
compileTestKotlin {
    kotlinOptions.jvmTarget = "1.8"
}