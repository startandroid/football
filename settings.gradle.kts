pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Football"
include(":app")
include(":core")
include(":core:navigation")
include(":core:network")
include(":features")
include(":features:countries")
include(":features:countries:data")
include(":features:countries:domain")
include(":features:countries:view")
include(":features:countries:api")
include(":features:leagues")
include(":features:leagues:api")
include(":features:leagues:data")
include(":features:leagues:domain")
include(":features:leagues:view")
include(":core:common")
include(":core:ui")
include(":features:standings")
include(":features:standings:domain")
include(":features:standings:data")
include(":features:standings:view")
include(":features:standings:api")
include(":features:teams")
include(":features:teams:data")
include(":features:teams:view")
include(":features:teams:api")
include(":features:players")
include(":features:players:api")
include(":features:players:view")
include(":features:players:data")
include(":features:players:domain")
include(":features:teams:domain")
