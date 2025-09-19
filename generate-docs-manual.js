#!/usr/bin/env node

const fs = require('fs');
const path = require('path');

// Read the GraphQL schema
const schemaPath = './src/main/resources/graphql/schema.graphqls';
const outputDir = './docs';

// Create docs directory if it doesn't exist
if (!fs.existsSync(outputDir)) {
  fs.mkdirSync(outputDir, { recursive: true });
}

// Read schema file
const schema = fs.readFileSync(schemaPath, 'utf8');

// Parse schema into sections
const lines = schema.split('\n');
let currentSection = '';
let currentContent = [];

const sections = {
  types: [],
  enums: [],
  queries: [],
  mutations: []
};

// Simple parser
for (let i = 0; i < lines.length; i++) {
  const line = lines[i].trim();
  
  if (line.startsWith('type ')) {
    sections.types.push(line);
  } else if (line.startsWith('enum ')) {
    sections.enums.push(line);
  } else if (line.startsWith('type Query')) {
    // Collect query fields
    let j = i + 1;
    while (j < lines.length && !lines[j].trim().startsWith('}')) {
      const queryLine = lines[j].trim();
      if (queryLine && !queryLine.startsWith('}')) {
        sections.queries.push(queryLine);
      }
      j++;
    }
  } else if (line.startsWith('type Mutation')) {
    // Collect mutation fields
    let j = i + 1;
    while (j < lines.length && !lines[j].trim().startsWith('}')) {
      const mutationLine = lines[j].trim();
      if (mutationLine && !mutationLine.startsWith('}')) {
        sections.mutations.push(mutationLine);
      }
      j++;
    }
  }
}

// Generate Types documentation
const typesDoc = `# Types

${sections.types.map(type => `## ${type}`).join('\n\n')}

${sections.enums.map(enumType => `## ${enumType}`).join('\n\n')}
`;

// Generate Queries documentation
const queriesDoc = `# Queries

${sections.queries.map(query => `## ${query}`).join('\n\n')}
`;

// Generate Mutations documentation
const mutationsDoc = `# Mutations

${sections.mutations.map(mutation => `## ${mutation}`).join('\n\n')}
`;

// Generate main README
const mainDoc = `# GraphQL Players API Documentation

This documentation is generated from the GraphQL schema.

## Available Operations

- [Queries](./queries.md) - Read operations
- [Mutations](./mutations.md) - Write operations  
- [Types](./types.md) - Data types and enums

## Schema Overview

Your GraphQL API provides:

- **Player Management**: Create, read, update, delete players
- **Team Support**: CSk, MI, DC, RCB, GT teams
- **Player Roles**: BATSMAN, BOWLER, ALL_ROUNDER, WICKET_KEEPER
- **Match Tracking**: Match results and statistics
- **Player Statistics**: Runs, wickets, averages, matches played
`;

// Write files
fs.writeFileSync(path.join(outputDir, 'README.md'), mainDoc);
fs.writeFileSync(path.join(outputDir, 'types.md'), typesDoc);
fs.writeFileSync(path.join(outputDir, 'queries.md'), queriesDoc);
fs.writeFileSync(path.join(outputDir, 'mutations.md'), mutationsDoc);

console.log('✅ Documentation generated successfully!');
console.log('📁 Check the ./docs folder for your generated documentation files');
