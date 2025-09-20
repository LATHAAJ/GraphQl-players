#!/usr/bin/env node

const fs = require('fs');
const path = require('path');

function watchSchemaChanges() {
  console.log('👀 Watching for schema changes...');
  console.log('📝 Schema file: ./src/main/resources/graphql/schema.graphqls');
  console.log('🔄 Auto-regenerating documentation on changes...');
  console.log('⏹️  Press Ctrl+C to stop watching');
  
  let lastModified = 0;
  
  const schemaPath = './src/main/resources/graphql/schema.graphqls';
  
  setInterval(() => {
    try {
      const stats = fs.statSync(schemaPath);
      if (stats.mtime.getTime() > lastModified) {
        lastModified = stats.mtime.getTime();
        console.log('🔄 Schema changed, regenerating documentation...');
        
        // Run the documentation generation
        require('./generate-docs.js');
        
        console.log('✅ Documentation updated!');
      }
    } catch (error) {
      console.error('❌ Error watching schema:', error.message);
    }
  }, 1000); // Check every second
}

watchSchemaChanges();
