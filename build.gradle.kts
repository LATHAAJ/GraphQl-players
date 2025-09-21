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

// GraphQL Documentation Generation Tasks
tasks.register<Exec>("generateGraphQLDocs") {
    group = "documentation"
    description = "Generate comprehensive GraphQL API documentation using GraphQL-Markdown"
    
    commandLine("npm", "run", "docs:generate")
    
    doLast {
        println("📚 GraphQL documentation generated successfully!")
        println("📄 Documentation location: docs/")
        println("🌐 To view docs: npm run docs:serve")
        println("🔄 To watch for changes: npm run docs:watch")
    }
}

tasks.register<Exec>("watchGraphQLDocs") {
    group = "documentation"
    description = "Watch GraphQL schema changes and auto-regenerate documentation"
    
    commandLine("npm", "run", "docs:watch")
}

tasks.register<Exec>("serveGraphQLDocs") {
    group = "documentation"
    description = "Serve GraphQL documentation locally"
    
    commandLine("npm", "run", "docs:serve")
}

tasks.register<Exec>("cleanGraphQLDocs") {
    group = "documentation"
    description = "Clean generated GraphQL documentation"
    
    commandLine("npm", "run", "docs:clean")
}

