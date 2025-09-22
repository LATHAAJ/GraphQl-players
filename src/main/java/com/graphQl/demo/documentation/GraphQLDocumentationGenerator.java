package com.graphQl.demo.documentation;

import org.springframework.stereotype.Component;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Enhanced GraphQL Documentation Generator
 * Extracts descriptions directly from GraphQL schema using standard GraphQL description syntax
 */
@Component
public class GraphQLDocumentationGenerator {

    public void generateDocumentation() {
        try {
            String schemaContent = readSchemaFile();
            String markdownDoc = generateMarkdownDocumentation(schemaContent);
            writeDocumentation(markdownDoc);
            System.out.println("✅ GraphQL documentation generated successfully!");
            System.out.println("📄 Location: docs/schema-documentation.md");
        } catch (Exception e) {
            System.err.println("❌ Error generating documentation: " + e.getMessage());
        }
    }

    private String readSchemaFile() throws IOException {
        String schemaPath = "src/main/resources/graphql/schema.graphql";
        return Files.readString(Paths.get(schemaPath));
    }

    private String generateMarkdownDocumentation(String schemaContent) {
        StringBuilder markdown = new StringBuilder();
        
        // Header with GitHub-style structure
        markdown.append("# GraphQL API Documentation\n\n");
        markdown.append("A comprehensive GraphQL API for managing cricket players, teams, matches, and player statistics.\n\n");
        markdown.append("## In this article\n\n");
        markdown.append("* [About the API](#about-the-api)\n");
        markdown.append("* [Queries](#queries)\n");
        markdown.append("* [Mutations](#mutations)\n");
        markdown.append("* [Types](#types)\n");
        markdown.append("* [Enums](#enums)\n");
        markdown.append("* [Example Queries](#example-queries)\n\n");
        markdown.append("---\n\n");

        // About section
        markdown.append("## About the API\n\n");
        markdown.append("This GraphQL API provides comprehensive functionality for managing cricket players and their associated data. The API follows GraphQL best practices and provides type-safe operations for all cricket-related entities.\n\n");
        markdown.append("**Base URL:** `http://localhost:8080/graphql`\n\n");
        markdown.append("**Interactive Playground:** `http://localhost:8080/graphiql`\n\n");

        // Extract and document queries first (like GitHub docs)
        markdown.append("## Queries\n\n");
        markdown.append("The query type defines GraphQL operations that retrieve data from the server.\n\n");
        
        Pattern queryPattern = Pattern.compile("type\\s+Query\\s*\\{([^}]+)\\}", Pattern.MULTILINE | Pattern.DOTALL);
        Matcher queryMatcher = queryPattern.matcher(schemaContent);
        
        if (queryMatcher.find()) {
            String queryBody = queryMatcher.group(1);
            Pattern methodPattern = Pattern.compile("\"\"\"([^\"]+)\"\"\"\\s*(\\w+)\\s*\\(([^)]*)\\)\\s*:\\s*([^!\\s\\[\\]]+)(!)?(\\[.*\\])?", Pattern.MULTILINE);
            Matcher methodMatcher = methodPattern.matcher(queryBody);
            
            while (methodMatcher.find()) {
                String description = methodMatcher.group(1).trim();
                String methodName = methodMatcher.group(2);
                String parameters = methodMatcher.group(3);
                String returnType = methodMatcher.group(4);
                String required = methodMatcher.group(5) != null ? "!" : "";
                String arrayType = methodMatcher.group(6);
                
                markdown.append("### ").append(methodName).append("\n\n");
                markdown.append(description).append("\n\n");
                
                String fullReturnType = returnType + required + (arrayType != null ? arrayType : "");
                markdown.append("**Type:** `").append(fullReturnType).append("`\n\n");
                
                if (!parameters.trim().isEmpty()) {
                    markdown.append("#### Arguments for `").append(methodName).append("`\n\n");
                    markdown.append("| Name | Type | Description |\n");
                    markdown.append("|------|------|-------------|\n");
                    
                    String[] params = parameters.split(",");
                    for (String param : params) {
                        String[] parts = param.trim().split(":");
                        if (parts.length == 2) {
                            String paramName = parts[0].trim();
                            String paramType = parts[1].trim();
                            String paramDesc = getParameterDescription(paramName, methodName);
                            markdown.append("| ").append(paramName)
                                   .append(" | `").append(paramType).append("`")
                                   .append(" | ").append(paramDesc)
                                   .append(" |\n");
                        }
                    }
                    markdown.append("\n");
                }
            }
        }

        // Extract and document mutations
        markdown.append("## Mutations\n\n");
        markdown.append("The mutation type defines GraphQL operations that modify data on the server.\n\n");
        
        Pattern mutationPattern = Pattern.compile("type\\s+Mutation\\s*\\{([^}]+)\\}", Pattern.MULTILINE | Pattern.DOTALL);
        Matcher mutationMatcher = mutationPattern.matcher(schemaContent);
        
        if (mutationMatcher.find()) {
            String mutationBody = mutationMatcher.group(1);
            Pattern methodPattern = Pattern.compile("\"\"\"([^\"]+)\"\"\"\\s*(\\w+)\\s*\\(([^)]*)\\)\\s*:\\s*([^!\\s\\[\\]]+)(!)?(\\[.*\\])?", Pattern.MULTILINE);
            Matcher methodMatcher = methodPattern.matcher(mutationBody);
            
            while (methodMatcher.find()) {
                String description = methodMatcher.group(1).trim();
                String methodName = methodMatcher.group(2);
                String parameters = methodMatcher.group(3);
                String returnType = methodMatcher.group(4);
                String required = methodMatcher.group(5) != null ? "!" : "";
                String arrayType = methodMatcher.group(6);
                
                markdown.append("### ").append(methodName).append("\n\n");
                markdown.append(description).append("\n\n");
                
                String fullReturnType = returnType + required + (arrayType != null ? arrayType : "");
                markdown.append("**Type:** `").append(fullReturnType).append("`\n\n");
                
                if (!parameters.trim().isEmpty()) {
                    markdown.append("#### Arguments for `").append(methodName).append("`\n\n");
                    markdown.append("| Name | Type | Description |\n");
                    markdown.append("|------|------|-------------|\n");
                    
                    String[] params = parameters.split(",");
                    for (String param : params) {
                        String[] parts = param.trim().split(":");
                        if (parts.length == 2) {
                            String paramName = parts[0].trim();
                            String paramType = parts[1].trim();
                            String paramDesc = getParameterDescription(paramName, methodName);
                            markdown.append("| ").append(paramName)
                                   .append(" | `").append(paramType).append("`")
                                   .append(" | ").append(paramDesc)
                                   .append(" |\n");
                        }
                    }
                    markdown.append("\n");
                }
            }
        }

        // Extract and document types
        markdown.append("## Types\n\n");
        Pattern typePattern = Pattern.compile("\"\"\"([^\"]+)\"\"\"\\s*type\\s+(\\w+)\\s*\\{([^}]+)\\}", Pattern.MULTILINE | Pattern.DOTALL);
        Matcher typeMatcher = typePattern.matcher(schemaContent);
        
        while (typeMatcher.find()) {
            String typeDescription = typeMatcher.group(1).trim();
            String typeName = typeMatcher.group(2);
            String typeBody = typeMatcher.group(3);
            
            markdown.append("### ").append(typeName).append("\n\n");
            markdown.append(typeDescription).append("\n\n");
            
            markdown.append("| Field | Type | Description |\n");
            markdown.append("|-------|------|-------------|\n");
            
            // Extract fields with descriptions
            Pattern fieldPattern = Pattern.compile("\"\"\"([^\"]+)\"\"\"\\s*(\\w+)\\s*:\\s*([^!\\s\\[\\]]+)(!)?(\\[.*\\])?", Pattern.MULTILINE);
            Matcher fieldMatcher = fieldPattern.matcher(typeBody);
            
            while (fieldMatcher.find()) {
                String fieldDescription = fieldMatcher.group(1).trim();
                String fieldName = fieldMatcher.group(2);
                String fieldType = fieldMatcher.group(3);
                String required = fieldMatcher.group(4) != null ? "!" : "";
                String arrayType = fieldMatcher.group(5);
                
                String fullFieldType = fieldType + required + (arrayType != null ? arrayType : "");
                
                markdown.append("| ").append(fieldName)
                       .append(" | `").append(fullFieldType).append("`")
                       .append(" | ").append(fieldDescription)
                       .append(" |\n");
            }
            markdown.append("\n");
        }

        // Extract and document enums
        markdown.append("## Enums\n\n");
        Pattern enumPattern = Pattern.compile("\"\"\"([^\"]+)\"\"\"\\s*enum\\s+(\\w+)\\s*\\{([^}]+)\\}", Pattern.MULTILINE | Pattern.DOTALL);
        Matcher enumMatcher = enumPattern.matcher(schemaContent);
        
        while (enumMatcher.find()) {
            String enumDescription = enumMatcher.group(1).trim();
            String enumName = enumMatcher.group(2);
            String enumBody = enumMatcher.group(3);
            
            markdown.append("### ").append(enumName).append("\n\n");
            markdown.append(enumDescription).append("\n\n");
            
            markdown.append("**Values:**\n\n");
            
            // Extract enum values with descriptions
            Pattern valuePattern = Pattern.compile("\"\"\"([^\"]+)\"\"\"\\s*(\\w+)", Pattern.MULTILINE);
            Matcher valueMatcher = valuePattern.matcher(enumBody);
            
            while (valueMatcher.find()) {
                String valueDescription = valueMatcher.group(1).trim();
                String value = valueMatcher.group(2);
                markdown.append("- `").append(value).append("` - ").append(valueDescription).append("\n");
            }
            markdown.append("\n");
        }

        // Add example queries
        markdown.append("## Example Queries\n\n");
        markdown.append("### Get All Players\n");
        markdown.append("```graphql\n");
        markdown.append("query GetAllPlayers {\n");
        markdown.append("  findAll {\n");
        markdown.append("    id\n");
        markdown.append("    name\n");
        markdown.append("    team\n");
        markdown.append("    role\n");
        markdown.append("    age\n");
        markdown.append("    country\n");
        markdown.append("  }\n");
        markdown.append("}\n");
        markdown.append("```\n\n");

        markdown.append("### Get Player by ID\n");
        markdown.append("```graphql\n");
        markdown.append("query GetPlayer($id: ID!) {\n");
        markdown.append("  findPlayerById(id: $id) {\n");
        markdown.append("    id\n");
        markdown.append("    name\n");
        markdown.append("    team\n");
        markdown.append("    role\n");
        markdown.append("    stats {\n");
        markdown.append("      matchesPlayed\n");
        markdown.append("      runs\n");
        markdown.append("      wickets\n");
        markdown.append("      average\n");
        markdown.append("    }\n");
        markdown.append("  }\n");
        markdown.append("}\n");
        markdown.append("```\n\n");

        markdown.append("### Create New Player\n");
        markdown.append("```graphql\n");
        markdown.append("mutation CreatePlayer($name: String!, $team: Team!, $role: PlayerRole!) {\n");
        markdown.append("  createPlayer(name: $name, team: $team, role: $role) {\n");
        markdown.append("    id\n");
        markdown.append("    name\n");
        markdown.append("    team\n");
        markdown.append("    role\n");
        markdown.append("  }\n");
        markdown.append("}\n");
        markdown.append("```\n\n");

        return markdown.toString();
    }

    private void writeDocumentation(String markdownContent) throws IOException {
        // Create docs directory if it doesn't exist
        Files.createDirectories(Paths.get("docs"));
        
        // Write the documentation
        Files.write(Paths.get("docs/schema-documentation.md"), markdownContent.getBytes());
    }

    // Helper method for parameter descriptions (fallback for parameters without descriptions)
    private String getParameterDescription(String paramName, String methodName) {
        switch (paramName) {
            case "id":
                return "The unique identifier of the object.";
            case "name":
                return "The name of the player.";
            case "team":
                return "The team the player belongs to.";
            case "role":
                return "The role/position of the player.";
            case "age":
                return "The age of the player.";
            case "dateOfBirth":
                return "The player's date of birth.";
            case "country":
                return "The country the player represents.";
            case "opponent":
                return "The opposing team in the match.";
            case "matchDate":
                return "The date when the match was played.";
            case "venue":
                return "The location where the match was played.";
            case "result":
                return "The result of the match.";
            case "playerId":
                return "The unique identifier of the player.";
            case "matchesPlayed":
                return "Number of matches the player has participated in.";
            case "runs":
                return "Total runs scored by the player.";
            case "wickets":
                return "Total wickets taken by the player.";
            case "average":
                return "The player's batting or bowling average.";
            default:
                return "Parameter for " + paramName + ".";
        }
    }
}
