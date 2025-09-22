#!/bin/bash

# Script to move API documentation files to graphql-api-docs repository
# This script will move all GraphQL API documentation files from the main repo to the docs repo

echo "🚀 Moving GraphQL API documentation files to graphql-api-docs repository..."

# Set proper PATH
export PATH="/bin:/usr/bin:/usr/sbin:/sbin:/usr/local/bin:/opt/homebrew/bin:/Users/latha/Downloads/gradle-7.6.2/bin"

# Define paths
MAIN_REPO="/Users/latha/Documents/GitHub/GraphQl-players"
DOCS_REPO="/Users/latha/Documents/GitHub/graphql-api-docs"

# Check if both repositories exist
if [ ! -d "$MAIN_REPO" ]; then
    echo "❌ Main repository not found: $MAIN_REPO"
    exit 1
fi

if [ ! -d "$DOCS_REPO" ]; then
    echo "❌ Documentation repository not found: $DOCS_REPO"
    exit 1
fi

echo "📁 Main repository: $MAIN_REPO"
echo "📁 Documentation repository: $DOCS_REPO"

# Change to main repository
cd "$MAIN_REPO"

# Files to move to docs repository
echo "📋 Files to move to documentation repository:"

# Documentation files
DOC_FILES=(
    "DOCUMENTATION.md"
    "PIPELINE_ARCHITECTURE.md"
    "GITHUB_SETUP_GUIDE.md"
    "QUICK_SETUP.md"
    "SETUP_INSTRUCTIONS.md"
    "docs-repo-initial-docs.md"
    "docs-repo-readme.md"
    "docs-repo-workflow-final.yml"
    "docs-repo-workflow.yml"
    "setup-docs-repo.sh"
    "setup-manual-repo.sh"
    "test-pipeline.sh"
)

# Node.js documentation tools
NODE_FILES=(
    "package.json"
    "package-lock.json"
    ".graphqlrc.yml"
)

# GitHub workflows
GITHUB_DIR=".github"

# Generated documentation
DOCS_DIR="docs"

# Documentation generation code (EXCLUDED - not needed)
# DOC_CODE_DIRS=(
#     "src/main/java/com/graphQl/demo/controller/DocumentationController.java"
#     "src/main/java/com/graphQl/demo/documentation"
# )

echo ""
echo "🔄 Moving files..."

# Move documentation files
for file in "${DOC_FILES[@]}"; do
    if [ -f "$file" ]; then
        echo "  📄 Moving $file"
        cp "$file" "$DOCS_REPO/"
    else
        echo "  ⚠️  File not found: $file"
    fi
done

# Move Node.js files
for file in "${NODE_FILES[@]}"; do
    if [ -f "$file" ]; then
        echo "  📦 Moving $file"
        cp "$file" "$DOCS_REPO/"
    else
        echo "  ⚠️  File not found: $file"
    fi
done

# Move GitHub workflows directory
if [ -d "$GITHUB_DIR" ]; then
    echo "  🔧 Moving $GITHUB_DIR"
    cp -r "$GITHUB_DIR" "$DOCS_REPO/"
else
    echo "  ⚠️  Directory not found: $GITHUB_DIR"
fi

# Move docs directory
if [ -d "$DOCS_DIR" ]; then
    echo "  📚 Moving $DOCS_DIR"
    cp -r "$DOCS_DIR" "$DOCS_REPO/"
else
    echo "  ⚠️  Directory not found: $DOCS_DIR"
fi

# Move documentation generation code (EXCLUDED - not needed)
# for dir in "${DOC_CODE_DIRS[@]}"; do
#     if [ -f "$dir" ] || [ -d "$dir" ]; then
#         echo "  💻 Moving $dir"
#         cp -r "$dir" "$DOCS_REPO/"
#     else
#         echo "  ⚠️  File/Directory not found: $dir"
#     fi
# done

# Change to docs repository
cd "$DOCS_REPO"

echo ""
echo "📊 Files moved to documentation repository:"
ls -la

echo ""
echo "🔍 Git status in documentation repository:"
git status

echo ""
echo "✅ Files moved successfully!"
echo ""
echo "📋 Next steps:"
echo "  1. Review the moved files in $DOCS_REPO"
echo "  2. Add and commit the files: git add . && git commit -m 'Add GraphQL API documentation files'"
echo "  3. Push to remote: git push"
echo "  4. Clean up the main repository by removing the moved files"
echo ""
echo "🧹 To clean up the main repository, run:"
echo "  cd $MAIN_REPO"
echo "  git rm --cached [files]  # Remove from git index"
echo "  rm [files]              # Remove from filesystem"
