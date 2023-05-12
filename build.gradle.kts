plugins {
    java
    id("org.springframework.boot") version "2.7.11"
    id("io.spring.dependency-management") version "1.0.15.RELEASE"
}

group = "org.zerock"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}


repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
    implementation("org.springframework.boot:spring-boot-starter-web")
    compileOnly("org.projectlombok:lombok")
    developmentOnly("org.springframework.boot:spring-boot-devtools")
    runtimeOnly("org.mariadb.jdbc:mariadb-java-client")
    annotationProcessor("org.projectlombok:lombok")
    testImplementation("org.springframework.boot:spring-boot-starter-test")

    // 테스트 환경에서 롬복 사용
    testCompileOnly("org.projectlombok:lombok")
    testAnnotationProcessor("org.projectlombok:lombok")

    implementation("nz.net.ultraq.thymeleaf:thymeleaf-layout-dialect:3.1.0")

    // Spring Boot, JPA, Querydsl
    // https://mvnrepository.com/artifact/com.querydsl/querydsl-jpa
    implementation("com.querydsl:querydsl-jpa:5.0.0")
    annotationProcessor("javax.persistence:javax.persistence-api")
    annotationProcessor("javax.annotation:javax.annotation-api")
    annotationProcessor("com.querydsl:querydsl-apt:5.0.0:jpa")
}

tasks.withType<Test> {
    useJUnitPlatform()
}

java.sourceSets["main"].java {
    srcDirs("/src/main/java", "/build/generated")
}