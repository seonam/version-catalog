# gradle version catalog

https://docs.github.com/en/packages/working-with-a-github-packages-registry/working-with-the-gradle-registry

### 준비
Github Personal access token 을 발급받고, github username 과 함께 환경변수(.zshrc 등)로 저장해야합니다.

### 사용법

settings.gradle 파일에 아래와 같이 작성합니다.

```kotlin
enableFeaturePreview("VERSION_CATALOGS")

dependencyResolutionManagement {
    repositories {
        maven {
            url = uri("https://maven.pkg.github.com/disdong123/version-catalog")
            credentials {
                // PAT, github username 을 환경변수 (.zshrc 등)로 저장해야합니다.  
                username = System.getenv("DISDONG_USERNAME")
                password = System.getenv("DISDONG_TOKEN")
            }
        }
    }
    versionCatalogs {
        create("libs") {
            from("kr.disdong:spring-version-catalog:0.0.2")
        }
    }
}
```

### 배포
```
./gradlew publish
```

### TODO
- test
- workflows
- gradle-plugin-repo 로 옮기기