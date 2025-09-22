plugins {
    java
    id("org.springframework.boot") version "3.5.5"
    id("io.spring.dependency-management") version "1.1.7"
}

group = "com.graphQl"
version = "0.0.1-SNAPSHOT"
description = "graphQl with spring Boot"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(24)
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-graphql")
    implementation("org.springframework.boot:spring-boot-starter-web")
    
    // GraphQL Documentation Tools
    implementation("com.graphql-java:graphql-java-extended-scalars:21.0")
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.springframework.graphql:spring-graphql-test")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.withType<Test> {
    useJUnitPlatform()
}

tasks.register<Copy>("generateGraphQLDocs") {
    group = "documentation"
    description = "Generate GraphQL schema documentation (INSTANT)"

    from("src/main/resources/graphql/schema.graphqls")
    into("build/docs")
    rename { "schema.graphqls" }

    doLast {
        println("⚡ GraphQL documentation generated INSTANTLY!")
        println("📄 Schema location: build/docs/schema.graphqls")
        println("🌐 To access interactive docs, run: ./gradlew bootRun")
        println("🌐 Then visit: http://localhost:8080/graphiql")
    }
}

tasks.register<JavaExec>("generateMarkdownDocs") {
    group = "documentation"
    description = "Generate Markdown documentation using Java"
    
    classpath = sourceSets.main.get().runtimeClasspath
    mainClass.set("com.graphQl.demo.DemoApplication")
    
    args("--spring.main.web-application-type=none")
    systemProperty("spring.profiles.active", "docs")
    
    doLast {
        println("✅ Markdown documentation generated!")
        println("📄 Location: docs/schema-documentation.md")
    }
}

