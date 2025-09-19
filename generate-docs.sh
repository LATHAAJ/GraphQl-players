#!/bin/bash

# GraphQL Documentation Generation Script
# This script generates markdown documentation from your GraphQL schema

echo "🔹 Generating GraphQL Documentation..."

# Check if graphql-markdown is installed
if ! command -v graphql-markdown &> /dev/null; then
    echo "❌ graphql-markdown CLI not found. Installing..."
    npm install -g @graphql-markdown/cli
fi

# Generate documentation
echo "📝 Generating documentation files..."
graphql-markdown

echo "✅ Documentation generated successfully!"
echo "📁 Check the ./docs folder for your generated documentation files"
echo ""
echo "Generated files should include:"
echo "  - queries.md"
echo "  - mutations.md" 
echo "  - types.md"
echo "  - enums.md"
echo "  - input-objects.md"
echo "  - scalars.md"
