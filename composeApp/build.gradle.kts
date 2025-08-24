import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)
    id("co.touchlab.skie") version "0.10.5"
    kotlin("plugin.serialization") version "1.9.20"
    alias(libs.plugins.sqlDelight)


}

kotlin {
    androidTarget {
        @OptIn(ExperimentalKotlinGradlePluginApi::class)
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_11)
        }
    }

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "ComposeApp"
            isStatic = true
        }
    }

// SQLite linker configuration
    targets.withType<org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget>().configureEach {
        binaries.all {
            linkerOpts("-lsqlite3")
        }
    }

    sourceSets {
        androidMain.dependencies {
            implementation(compose.preview)
            implementation(libs.androidx.activity.compose)
            implementation("io.coil-kt:coil-compose:2.5.0")
            implementation(libs.kotlinx.coroutines.core)
            implementation(libs.androidx.lifecycle.viewmodel.ktx)
            implementation("androidx.navigation:navigation-compose:2.9.3")
            implementation(libs.ktor.client.android)
            implementation(libs.koin.androidx.compose)
            implementation(libs.koin.android)
            implementation(libs.sql.android.driver)
            implementation("com.google.accompanist:accompanist-swiperefresh:0.24.13-rc")

        }
        commonMain.dependencies {
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material3)
            implementation(compose.ui)
            implementation(compose.components.resources)
            implementation(compose.components.uiToolingPreview)

            implementation(libs.androidx.lifecycle.viewmodelCompose)
            implementation(libs.androidx.lifecycle.runtimeCompose)
            implementation(libs.ktor.client.core)
            implementation(libs.ktor.client.content.negotiation)
            implementation(libs.kotlin.serialization)
            implementation(libs.kotlinx.datetime)
            implementation(libs.koin.core)
            implementation(libs.sql.coroutines.extensions)
           // implementation("app.cash.sqldelight:runtime:2.1.0")



        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }
        iosMain.dependencies{
            implementation(libs.ktor.client.darwin)
            implementation(libs.sql.native.driver)
            //implementation("app.cash.sqldelight:native-driver:2.0.2") // latest version example
           // implementation("com.squareup.sqldelight:native-driver:1.5.5")
        }
    }

    
}

android {
    namespace = "com.dailypluse"
    compileSdk = libs.versions.android.compileSdk.get().toInt()

    defaultConfig {
        applicationId = "com.dailypluse"
        minSdk = libs.versions.android.minSdk.get().toInt()
        targetSdk = libs.versions.android.targetSdk.get().toInt()
        versionCode = 1
        versionName = "1.0"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}


dependencies {
    debugImplementation(compose.uiTooling)
}

sqldelight {
    databases {
        create(name = "DailyPluseDatabase"){
            packageName.set("com.dailypluse.db")

        }
    }
}

