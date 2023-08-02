pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}

dependencyResolutionManagement {
//    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        maven(url = "https://developer.huawei.com/repo/")
        google()
        mavenCentral()
    }
}

rootProject.name = "AiLaAi"
include(":androidApp")
include(":shared")