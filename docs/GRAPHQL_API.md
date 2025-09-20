# GraphQL API Documentation

Welcome to the GraphQL API documentation for the Cricket Players Management System.

## Overview

This GraphQL API provides comprehensive cricket player and match management functionality. It allows you to query player information, match details, and player statistics, as well as perform CRUD operations on players and matches.

## Quick Start

1. **Start the application**: `./gradlew bootRun`
2. **Access GraphiQL**: Visit `http://localhost:8080/graphiql`
3. **Explore the schema**: Use the interactive interface to test queries

## API Reference

### Types

#### Player

**Fields:**

- **id** (`ID`)
- **name** (`String`)
- **team** (`Team`)
- **role** (`PlayerRole`)
- **age** (`Int`)
- **dateOfBirth** (`String`)
- **country** (`String`)
- **stats** (`PlayerStats`)

#### PlayerStats

**Fields:**

- **playerId** (`ID`)
- **matchesPlayed** (`Int`)
- **runs** (`Int`)
- **wickets** (`Int`)
- **average** (`Float`)

#### Match

**Fields:**

- **id** (`ID`)
- **opponent** (`String`)
- **matchDate** (`String`)
- **venue** (`String`)
- **result** (`MatchResult`)

#### Query

**Fields:**

- **findAll** (`[Player]`)
- **id** (`ID`)
- **team** (`Team`)
- **role** (`PlayerRole`)
- **findAllMatches** (`[Match]`)
- **id** (`ID`)
- **playerId** (`ID`)

#### Mutation

**Fields:**

- **name** (`String`)
- **id** (`ID`)
- **id** (`ID`)
- **opponent** (`String`)
- **playerId** (`ID`)

### Enums

#### Team

#### PlayerRole

#### MatchResult

## Examples

### Get All Players
```graphql
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
```

### Create a New Player
```graphql
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
```

### Get Players by Team
```graphql
query {
  findPlayersByTeam(team: CSk) {
    id
    name
    role
    age
    country
  }
}
```

### Get Player Statistics
```graphql
query {
  findPlayerStats(playerId: "1") {
    playerId
    matchesPlayed
    runs
    wickets
    average
  }
}
```

### Update Player Information
```graphql
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
```

## Error Handling

The API returns appropriate error messages for:
- Invalid player/match IDs
- Missing required fields
- Invalid enum values
- Server-side errors

## Getting Started

1. Start the Spring Boot application
2. Access GraphiQL at `http://localhost:8080/graphiql`
3. Use the interactive interface to explore the schema and test queries
4. Copy the queries from this documentation for your application integration

## Notes

- All ID fields are of type `ID!` (non-null)
- Optional fields can be omitted from queries
- The `stats` field on Player is resolved separately and may be null
- Date fields are stored as strings in "YYYY-MM-DD" format
- Boolean mutations return `true` on success, `false` on failure
