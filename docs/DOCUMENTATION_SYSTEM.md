# GraphQL Documentation System

This project includes an automated GraphQL documentation generation system that creates GitHub-style documentation from your GraphQL schema.

## Features

- ✅ **Auto-generated documentation** from GraphQL schema
- ✅ **GitHub-style formatting** with proper markdown structure
- ✅ **Real-time watching** for schema changes
- ✅ **GitHub Actions integration** for automated updates
- ✅ **Gradle integration** for seamless workflow

## Quick Start

### Generate Documentation
```bash
npm run docs:generate
```

### Watch for Schema Changes
```bash
npm run docs:watch
```

### Clean Generated Docs
```bash
npm run docs:clean
```

### Build Fresh Documentation
```bash
npm run docs:build
```

## Gradle Integration

You can also use Gradle tasks:

```bash
# Generate documentation
./gradlew generateGraphQLDocs

# Watch for changes
./gradlew watchGraphQLDocs

# Serve documentation
./gradlew serveGraphQLDocs

# Clean documentation
./gradlew cleanGraphQLDocs
```

## File Structure

```
├── scripts/
│   ├── generate-docs.js    # Main documentation generator
│   └── watch-docs.js       # File watcher for auto-regeneration
├── docs/
│   └── README.md           # Generated documentation
├── .github/workflows/
│   └── docs.yml            # GitHub Actions workflow
├── package.json            # NPM scripts
└── build.gradle.kts        # Gradle tasks
```

## How It Works

1. **Schema Parsing**: The system reads your GraphQL schema from `src/main/resources/graphql/schema.graphqls`
2. **Documentation Generation**: Creates comprehensive markdown documentation with:
   - Type definitions
   - Query and mutation descriptions
   - Enum values
   - Example queries and mutations
3. **Auto-updates**: Watches for schema changes and regenerates documentation
4. **GitHub Integration**: Automatically commits documentation updates via GitHub Actions

## Customization

The documentation generator can be customized by editing `scripts/generate-docs.js`:

- Modify the markdown template
- Add custom sections
- Change formatting styles
- Include additional examples

## GitHub Actions

The included GitHub Actions workflow automatically:
- Generates documentation on schema changes
- Commits updates to the repository
- Runs on push to main/develop branches
- Triggers on pull requests

## Examples

The generated documentation includes practical examples for:
- Querying all players
- Creating new players
- Filtering by team
- Updating player statistics
- Error handling patterns

## Notes

- Documentation is generated in `docs/README.md`
- The system preserves your existing manual documentation
- All generated content is clearly marked
- Schema changes trigger automatic regeneration
