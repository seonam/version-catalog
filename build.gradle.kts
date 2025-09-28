plugins {
    `version-catalog`
    `maven-publish`
    signing
}

group = "kr.seonam"
version = "0.1.0"

catalog {
    versionCatalog {
        from(files("gradle/libs.versions.toml"))
    }
}

publishing {
    publications {
        create<MavenPublication>("gpr") {
            groupId = project.group as String
            artifactId = "spring-version-catalog"
            version = project.version as String
            from(components["versionCatalog"])
        }
    }

    repositories {
        maven {
            name = "GithubPackages"
            url = uri("https://maven.pkg.github.com/seonam/version-catalog")
            credentials {
                username = project.findProperty("gpr.user") as String? ?: System.getenv("SEONAM_USERNAME")
                password = project.findProperty("gpr.key") as String? ?: System.getenv("SEONAM_TOKEN")
            }
        }
    }
}