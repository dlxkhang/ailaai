plugins {
    kotlin("multiplatform")
    id("com.android.library")
}

kotlin {
    android {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }
    
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "shared"
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                val ktorVersion = "2.3.0"
                val choiceSdkVersion = "0.3.0"
                val hmsVersion = "6.9.0.300"
                val composeVersion = "1.4.3"
                implementation(project(":shared"))
                implementation("io.ktor:ktor-client-core-jvm:$ktorVersion")
                implementation("io.ktor:ktor-client-okhttp-jvm:$ktorVersion")
                implementation("io.ktor:ktor-client-content-negotiation:$ktorVersion")
                implementation("io.ktor:ktor-serialization-kotlinx-json-jvm:$ktorVersion")
                implementation("androidx.core:core-ktx:1.10.1")
                implementation("androidx.appcompat:appcompat:1.7.0-alpha02")
                implementation("androidx.appcompat:appcompat-resources:1.7.0-alpha02")
                implementation("com.google.android.material:material:1.9.0")
                implementation("androidx.datastore:datastore-preferences:1.0.0")
                implementation("androidx.compose.ui:ui:$composeVersion")
                implementation("androidx.compose.material3:material3:1.1.1")
                implementation("androidx.compose.material3:material3-window-size-class:1.1.1")
                implementation("androidx.compose.material:material-icons-extended:$composeVersion")
                implementation("androidx.compose.ui:ui-tooling-preview:$composeVersion")
                implementation("org.burnoutcrew.composereorderable:reorderable:0.9.6")
                runtimeOnly("androidx.compose.runtime:runtime-rxjava3:$composeVersion")
                implementation("androidx.navigation:navigation-compose:2.6.0")
                implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.6.1")
                implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.1")
                implementation("androidx.activity:activity-compose:1.7.2")
                implementation("at.bluesource.choicesdk:choicesdk-location:$choiceSdkVersion")
                implementation("at.bluesource.choicesdk:choicesdk-maps:$choiceSdkVersion")
                implementation("at.bluesource.choicesdk:choicesdk-messaging:$choiceSdkVersion")
                implementation("com.huawei.hms:base:$hmsVersion")
                implementation("com.huawei.hms:maps:$hmsVersion")
                implementation("com.huawei.hms:push:$hmsVersion")
                implementation("com.huawei.hms:scan:2.10.0.301")
                implementation("com.huawei.hms:hianalytics:$hmsVersion")
                implementation("com.huawei.hms:hwid:$hmsVersion")
                implementation("com.huawei.hms:location:$hmsVersion")
                implementation("org.jetbrains.kotlinx:kotlinx-datetime:0.4.0")
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-core:1.5.1")
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.5.1")
                implementation("androidx.compose.ui:ui-viewbinding:1.4.3")
                implementation("io.coil-kt:coil-compose:2.2.2")
                implementation("com.google.accompanist:accompanist-permissions:0.27.0")
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.1")
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.1")
                implementation("androidx.media3:media3-exoplayer:1.0.2")
                implementation("androidx.media3:media3-ui:1.0.2")
                implementation("com.otaliastudios:transcoder:0.10.5")
                implementation("ch.acra:acra-core:5.9.7")
                implementation("ch.acra:acra-toast:5.9.7")
//                testImplementation("junit:junit:4.13.2")
//                androidTestImplementation("androidx.test.ext:junit:1.1.5")
//                androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
//                androidTestImplementation("androidx.compose.ui:ui-test-junit4:$composeVersion")
//                debugImplementation("androidx.compose.ui:ui-tooling:$composeVersion")
//                kapt("com.google.auto.service:auto-service:1.0.1")
                compileOnly("com.google.auto.service:auto-service-annotations:1.0.1")

            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        val androidMain by getting
//        val androidUnitTest by getting
        val iosX64Main by getting
        val iosArm64Main by getting
        val iosSimulatorArm64Main by getting
        val iosMain by creating {
            dependsOn(commonMain)
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
            iosSimulatorArm64Main.dependsOn(this)
        }
        val iosX64Test by getting
        val iosArm64Test by getting
        val iosSimulatorArm64Test by getting
        val iosTest by creating { dependsOn(commonTest)
            iosX64Test.dependsOn(this)
            iosArm64Test.dependsOn(this)
            iosSimulatorArm64Test.dependsOn(this)
        }
    }
}

android {
    namespace = "com.queatz.ailaai"
    compileSdk = 34
    defaultConfig {
        minSdk = 26
    }
}