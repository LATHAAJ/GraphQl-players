package com.graphQl.demo;

import com.graphQl.demo.documentation.GraphQLDocumentationGenerator;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner documentationRunner(GraphQLDocumentationGenerator generator) {
        return args -> {
            // Check if documentation generation is requested
            if (args.length > 0 && args[0].equals("--generate-docs")) {
                System.out.println("🚀 Starting GraphQL documentation generation...");
                generator.generateDocumentation();
                System.exit(0);
            }
        };
    }
}