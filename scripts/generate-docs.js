#!/usr/bin/env node

const fs = require('fs');
const path = require('path');

function generateGitHubStyleDocs() {
  try {
    console.log('📚 Generating GitHub-style GraphQL documentation...');
    
    // Read the GraphQL schema
    const schemaPath = './src/main/resources/graphql/schema.graphqls';
    const schemaContent = fs.readFileSync(schemaPath, 'utf8');
    
    console.log('📖 Schema loaded successfully');
    
    // Parse the schema content more accurately
    const lines = schemaContent.split('\n');
    const types = [];
    const queries = [];
    const mutations = [];
    const enums = [];
    let currentType = null;
    let currentDescription = '';
    let braceCount = 0;
    
    for (let i = 0; i < lines.length; i++) {
      const line = lines[i].trim();
      
      if (line.startsWith('type ')) {
        const typeName = line.replace('type ', '').replace(' {', '').trim();
        currentType = { name: typeName, fields: [], description: currentDescription };
        types.push(currentType);
        currentDescription = '';
        braceCount = 0;
      } else if (line.startsWith('type Query')) {
        currentType = { name: 'Query', fields: [], description: 'Root query type' };
        queries.push(currentType);
        braceCount = 0;
      } else if (line.startsWith('type Mutation')) {
        currentType = { name: 'Mutation', fields: [], description: 'Root mutation type' };
        mutations.push(currentType);
        braceCount = 0;
      } else if (line.startsWith('enum ')) {
        const enumName = line.replace('enum ', '').replace(' {', '').trim();
        currentType = { name: enumName, values: [], description: currentDescription };
        enums.push(currentType);
        currentDescription = '';
        braceCount = 0;
      } else if (line.includes('{')) {
        braceCount++;
      } else if (line.includes('}')) {
        braceCount--;
        if (braceCount === 0) {
          currentType = null;
        }
      } else if (currentType && line.includes(':') && !line.includes('{') && !line.includes('}')) {
        // Parse field definitions more carefully
        const fieldMatch = line.match(/(\w+)\s*:\s*([^!]+)!?/);
        if (fieldMatch) {
          const fieldName = fieldMatch[1];
          const fieldType = fieldMatch[2];
          if (currentType.values) {
            currentType.values.push(fieldName);
          } else {
            currentType.fields.push({ name: fieldName, type: fieldType });
          }
        }
      }
    }
    
    // Generate markdown documentation
    let markdown = `# GraphQL API Documentation

Welcome to the GraphQL API documentation for the Cricket Players Management System.

## Overview

This GraphQL API provides comprehensive cricket player and match management functionality. It allows you to query player information, match details, and player statistics, as well as perform CRUD operations on players and matches.

## Quick Start

1. **Start the application**: \`./gradlew bootRun\`
2. **Access GraphiQL**: Visit \`http://localhost:8080/graphiql\`
3. **Explore the schema**: Use the interactive interface to test queries

## API Reference

`;

    // Generate Queries section
    if (queries.length > 0) {
      markdown += `### Queries\n\n`;
      queries.forEach(query => {
        markdown += `#### ${query.name}\n\n`;
        markdown += `${query.description}\n\n`;
        if (query.fields.length > 0) {
          markdown += `**Available queries:**\n\n`;
          query.fields.forEach(field => {
            markdown += `- **${field.name}** (\`${field.type}\`)\n`;
          });
          markdown += '\n';
        }
      });
    }

    // Generate Mutations section
    if (mutations.length > 0) {
      markdown += `### Mutations\n\n`;
      mutations.forEach(mutation => {
        markdown += `#### ${mutation.name}\n\n`;
        markdown += `${mutation.description}\n\n`;
        if (mutation.fields.length > 0) {
          markdown += `**Available mutations:**\n\n`;
          mutation.fields.forEach(field => {
            markdown += `- **${field.name}** (\`${field.type}\`)\n`;
          });
          markdown += '\n';
        }
      });
    }

    // Generate Types section
    if (types.length > 0) {
      markdown += `### Types\n\n`;
      types.forEach(type => {
        markdown += `#### ${type.name}\n\n`;
        if (type.description) {
          markdown += `${type.description}\n\n`;
        }
        if (type.fields && type.fields.length > 0) {
          markdown += `**Fields:**\n\n`;
          type.fields.forEach(field => {
            markdown += `- **${field.name}** (\`${field.type}\`)\n`;
          });
          markdown += '\n';
        }
      });
    }

    // Generate Enums section
    if (enums.length > 0) {
      markdown += `### Enums\n\n`;
      enums.forEach(enumType => {
        markdown += `#### ${enumType.name}\n\n`;
        if (enumType.description) {
          markdown += `${enumType.description}\n\n`;
        }
        if (enumType.values && enumType.values.length > 0) {
          markdown += `**Values:**\n\n`;
          enumType.values.forEach(value => {
            markdown += `- **${value}**\n`;
          });
          markdown += '\n';
        }
      });
    }

    // Add examples section
    markdown += `## Examples

### Get All Players
\`\`\`graphql
query {
  findAll {
    id
    name
    team
    role
    age
    country
  }
}
\`\`\`

### Create a New Player
\`\`\`graphql
mutation {
  createPlayer(
    name: "Virat Kohli"
    team: RCB
    role: BATSMAN
    age: 34
    country: "India"
  ) {
    id
    name
    team
    role
  }
}
\`\`\`

### Get Players by Team
\`\`\`graphql
query {
  findPlayersByTeam(team: CSk) {
    id
    name
    role
    age
    country
  }
}
\`\`\`

### Get Player Statistics
\`\`\`graphql
query {
  findPlayerStats(playerId: "1") {
    playerId
    matchesPlayed
    runs
    wickets
    average
  }
}
\`\`\`

### Update Player Information
\`\`\`graphql
mutation {
  updatePlayer(
    id: "1"
    name: "Virat Kohli"
    team: RCB
    role: BATSMAN
    age: 35
    country: "India"
  ) {
    id
    name
    team
    role
    age
    country
  }
}
\`\`\`

## Error Handling

The API returns appropriate error messages for:
- Invalid player/match IDs
- Missing required fields
- Invalid enum values
- Server-side errors

## Getting Started

1. Start the Spring Boot application
2. Access GraphiQL at \`http://localhost:8080/graphiql\`
3. Use the interactive interface to explore the schema and test queries
4. Copy the queries from this documentation for your application integration

## Notes

- All ID fields are of type \`ID!\` (non-null)
- Optional fields can be omitted from queries
- The \`stats\` field on Player is resolved separately and may be null
- Date fields are stored as strings in "YYYY-MM-DD" format
- Boolean mutations return \`true\` on success, \`false\` on failure
`;

    // Ensure docs directory exists
    const docsDir = './docs';
    if (!fs.existsSync(docsDir)) {
      fs.mkdirSync(docsDir, { recursive: true });
    }
    
    // Write the documentation
    fs.writeFileSync(path.join(docsDir, 'GRAPHQL_API.md'), markdown);
    
    console.log('✅ GitHub-style documentation generated successfully!');
    console.log('📄 Documentation location: docs/GRAPHQL_API.md');
    console.log('🌐 To view docs: open docs/GRAPHQL_API.md');
    
  } catch (error) {
    console.error('❌ Error generating documentation:', error.message);
    process.exit(1);
  }
}

generateGitHubStyleDocs();