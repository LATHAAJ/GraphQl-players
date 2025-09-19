# GraphQL Documentation Generation

This project uses GraphQL-Markdown to generate beautiful documentation from your GraphQL schema.

## Prerequisites

1. **Install Node.js** (if not already installed):
   ```bash
   # Using Homebrew (recommended for macOS)
   brew install node
   
   # Or download from https://nodejs.org/
   ```

2. **Verify installation**:
   ```bash
   node --version
   npm --version
   ```

## Setup Steps

### Step 1: Install GraphQL-Markdown CLI
```bash
npm install -g @graphql-markdown/cli
```

### Step 2: Generate Documentation
```bash
# Run the documentation generator
graphql-markdown

# Or use the provided script
chmod +x generate-docs.sh
./generate-docs.sh
```

## Generated Documentation Structure

After running the command, you'll get a `docs/` folder with:

```
docs/
├── queries.md          # All Query operations
├── mutations.md        # All Mutation operations  
├── subscriptions.md   # All Subscription operations
├── types.md           # All Type definitions
├── enums.md           # All Enum definitions
├── input-objects.md   # All Input type definitions
└── scalars.md         # All Scalar type definitions
```

## Your Schema Overview

Based on your current schema, the documentation will include:

### Types
- **Player**: Main player entity with id, name, team, role, age, etc.
- **PlayerStats**: Player statistics including matches, runs, wickets, average
- **Match**: Match information with opponent, date, venue, result

### Enums
- **Team**: CSk, MI, DC, RCB, GT
- **PlayerRole**: BATSMAN, BOWLER, ALL_ROUNDER, WICKET_KEEPER  
- **MatchResult**: WON, LOST, DRAW, NO_RESULT

### Queries
- `findAll`: Get all players
- `findPlayerById`: Get player by ID
- `findPlayersByTeam`: Get players by team
- `findPlayersByRole`: Get players by role
- `findAllMatches`: Get all matches
- `findMatchById`: Get match by ID
- `findPlayerStats`: Get player statistics

### Mutations
- `createPlayer`: Create new player
- `updatePlayer`: Update existing player
- `deletePlayer`: Delete player
- `createMatch`: Create new match
- `updatePlayerStats`: Update player statistics

## GitHub Integration

1. **Commit the docs folder**:
   ```bash
   git add docs/
   git commit -m "Add GraphQL documentation"
   git push
   ```

2. **View in GitHub**: Navigate to `docs/queries.md` (or other files) in your GitHub repository to see the beautifully rendered documentation.

3. **Optional - GitHub Pages**: Enable GitHub Pages in repository settings and point to the `/docs` folder for a full documentation site.

## Configuration

The configuration is in `graphql-markdown.config.js`:
- **Schema**: Points to your GraphQL schema file
- **Output**: Where documentation files are generated
- **Loaders**: Handles GraphQL file loading

You can customize the configuration as needed for your specific requirements.
