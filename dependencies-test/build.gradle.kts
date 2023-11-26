plugins {
    `version-catalog`
    `maven-publish`
    `java-platform`
}

group = rootProject.group
version = rootProject.version

javaPlatform {
    allowDependencies()
}

repositories {
    mavenCentral()
}

dependencies {
    api(platform(libs.spring.boot.starter.web))
    api(platform(libs.spring.boot.starter.data.jpa))
    api(platform(libs.spring.boot.starter.test))
    api(platform(libs.spring.boot.starter.batch))
    api(platform(libs.spring.boot.starter.webflux))
    api(platform(libs.spring.boot.starter.validation))

    api(platform(libs.hibernate.types))
    api(platform(libs.infobip.spring.data.jpa.querydsl.boot.starter))
    api(platform(libs.spring.boot.configuration.processor))
}