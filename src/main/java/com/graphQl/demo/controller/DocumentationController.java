package com.graphQl.demo.controller;

import com.graphQl.demo.documentation.GraphQLDocumentationGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST Controller for GraphQL Documentation Generation
 * Provides endpoints to generate documentation without Node.js dependencies
 */
@RestController
@RequestMapping("/api/docs")
public class DocumentationController {

    @Autowired
    private GraphQLDocumentationGenerator documentationGenerator;

    /**
     * Generate GraphQL documentation in Markdown format
     * @return Success message with documentation location
     */
    @GetMapping("/generate")
    public ResponseEntity<String> generateDocumentation() {
        try {
            documentationGenerator.generateDocumentation();
            return ResponseEntity.ok("✅ GraphQL documentation generated successfully!\n" +
                    "📄 Location: docs/schema-documentation.md\n" +
                    "🌐 Access GraphiQL at: http://localhost:8080/graphiql");
        } catch (Exception e) {
            return ResponseEntity.internalServerError()
                    .body("❌ Error generating documentation: " + e.getMessage());
        }
    }

    /**
     * Get information about available documentation endpoints
     * @return Documentation information
     */
    @GetMapping("/info")
    public ResponseEntity<String> getDocumentationInfo() {
        return ResponseEntity.ok("""
                📚 GraphQL Documentation Generator
                
                Available endpoints:
                • GET /api/docs/generate - Generate Markdown documentation
                • GET /api/docs/info - This information
                • GET /graphiql - Interactive GraphQL playground
                
                Generated documentation will be saved to: docs/schema-documentation.md
                """);
    }
}
