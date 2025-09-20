# GraphQL API Documentation

## Overview
This GraphQL API provides comprehensive cricket player and match management functionality. It allows you to query player information, match details, and player statistics, as well as perform CRUD operations on players and matches.

## Schema Types

### Player
Represents a cricket player with their basic information and team affiliation.

```graphql
type Player {
    id: ID!
    name: String!
    team: Team!
    role: PlayerRole!
    age: Int
    dateOfBirth: String
    country: String
    stats: PlayerStats
}
```

**Fields:**
- `id`: Unique identifier for the player
- `name`: Player's full name
- `team`: Team the player belongs to (enum)
- `role`: Player's role in the team (enum)
- `age`: Player's age (optional)
- `dateOfBirth`: Player's date of birth (optional)
- `country`: Player's country of origin (optional)
- `stats`: Player's statistics (optional)

### PlayerStats
Contains statistical information about a player's performance.

```graphql
type PlayerStats {
    playerId: ID!
    matchesPlayed: Int
    runs: Int
    wickets: Int
    average: Float
}
```

**Fields:**
- `playerId`: Reference to the player
- `matchesPlayed`: Number of matches played (optional)
- `runs`: Total runs scored (optional)
- `wickets`: Total wickets taken (optional)
- `average`: Average performance metric (optional)

### Match
Represents a cricket match with opponent and result information.

```graphql
type Match {
    id: ID!
    opponent: String!
    matchDate: String!
    venue: String!
    result: MatchResult!
}
```

**Fields:**
- `id`: Unique identifier for the match
- `opponent`: Name of the opposing team
- `matchDate`: Date when the match was played
- `venue`: Location where the match was played
- `result`: Result of the match (enum)

## Enums

### Team
Available cricket teams:
- `CSk` - Chennai Super Kings
- `MI` - Mumbai Indians
- `DC` - Delhi Capitals
- `RCB` - Royal Challengers Bangalore
- `GT` - Gujarat Titans

### PlayerRole
Player roles in cricket:
- `BATSMAN` - Specializes in batting
- `BOWLER` - Specializes in bowling
- `ALL_ROUNDER` - Can both bat and bowl effectively
- `WICKET_KEEPER` - Specializes in wicket keeping

### MatchResult
Possible match outcomes:
- `WON` - Team won the match
- `LOST` - Team lost the match
- `DRAW` - Match ended in a draw
- `NO_RESULT` - Match had no result (e.g., rain)

## Queries

### Player Queries

#### findAll
Retrieves all players in the system.

```graphql
query {
  findAll {
    id
    name
    team
    role
    age
    country
    stats {
      matchesPlayed
      runs
      wickets
      average
    }
  }
}
```

#### findPlayerById
Retrieves a specific player by their ID.

```graphql
query {
  findPlayerById(id: "1") {
    id
    name
    team
    role
    age
    dateOfBirth
    country
    stats {
      matchesPlayed
      runs
      wickets
      average
    }
  }
}
```

#### findPlayersByTeam
Retrieves all players belonging to a specific team.

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

#### findPlayersByRole
Retrieves all players with a specific role.

```graphql
query {
  findPlayersByRole(role: BATSMAN) {
    id
    name
    team
    age
    country
  }
}
```

### Match Queries

#### findAllMatches
Retrieves all matches in the system.

```graphql
query {
  findAllMatches {
    id
    opponent
    matchDate
    venue
    result
  }
}
```

#### findMatchById
Retrieves a specific match by its ID.

```graphql
query {
  findMatchById(id: "1") {
    id
    opponent
    matchDate
    venue
    result
  }
}
```

### Statistics Queries

#### findPlayerStats
Retrieves statistics for a specific player.

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

## Mutations

### Player Mutations

#### createPlayer
Creates a new player.

```graphql
mutation {
  createPlayer(
    name: "Virat Kohli"
    team: RCB
    role: BATSMAN
    age: 34
    dateOfBirth: "1988-11-05"
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

#### updatePlayer
Updates an existing player's information.

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

#### deletePlayer
Deletes a player from the system.

```graphql
mutation {
  deletePlayer(id: "1")
}
```

### Match Mutations

#### createMatch
Creates a new match record.

```graphql
mutation {
  createMatch(
    opponent: "Mumbai Indians"
    matchDate: "2024-01-15"
    venue: "Wankhede Stadium"
    result: WON
  ) {
    id
    opponent
    matchDate
    venue
    result
  }
}
```

### Statistics Mutations

#### updatePlayerStats
Updates or creates player statistics.

```graphql
mutation {
  updatePlayerStats(
    playerId: "1"
    matchesPlayed: 10
    runs: 450
    wickets: 5
    average: 45.0
  ) {
    playerId
    matchesPlayed
    runs
    wickets
    average
  }
}
```

## Example Queries

### Get All CSK Players with Their Stats
```graphql
query {
  findPlayersByTeam(team: CSk) {
    id
    name
    role
    age
    country
    stats {
      matchesPlayed
      runs
      wickets
      average
    }
  }
}
```

### Get All Batsmen from All Teams
```graphql
query {
  findPlayersByRole(role: BATSMAN) {
    id
    name
    team
    age
    country
    stats {
      runs
      average
    }
  }
}
```

### Get Match History
```graphql
query {
  findAllMatches {
    id
    opponent
    matchDate
    venue
    result
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
