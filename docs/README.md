# GraphQL Players API Documentation

Welcome to the GraphQL Players API documentation. This API provides comprehensive management of cricket players, teams, matches, and player statistics.

## Overview

This GraphQL API allows you to:
- Manage cricket players and their information
- Track team assignments and player roles
- Record match results and statistics
- Query player performance data

## Quick Start

### Queries
- **[Find All Players](operations/queries/find-all.md)** - Retrieve all players
- **[Find Player by ID](operations/queries/find-player-by-id.md)** - Get specific player details
- **[Find Players by Team](operations/queries/find-players-by-team.md)** - Filter players by team
- **[Find Players by Role](operations/queries/find-players-by-role.md)** - Filter players by role
- **[Find All Matches](operations/queries/find-all-matches.md)** - Retrieve all matches
- **[Find Match by ID](operations/queries/find-match-by-id.md)** - Get specific match details
- **[Find Player Stats](operations/queries/find-player-stats.md)** - Get player statistics

### Mutations
- **[Create Player](operations/mutations/create-player.md)** - Add a new player
- **[Update Player](operations/mutations/update-player.md)** - Modify player information
- **[Delete Player](operations/mutations/delete-player.md)** - Remove a player
- **[Create Match](operations/mutations/create-match.md)** - Add a new match
- **[Update Player Stats](operations/mutations/update-player-stats.md)** - Update player statistics

### Types
- **[Player](types/objects/player.md)** - Player information and details
- **[PlayerStats](types/objects/player-stats.md)** - Player performance statistics
- **[Match](types/objects/match.md)** - Match information and results

### Enums
- **[Team](types/enums/team.md)** - Available teams (CSK, MI, DC, RCB, GT)
- **[PlayerRole](types/enums/player-role.md)** - Player roles (BATSMAN, BOWLER, ALL_ROUNDER, WICKET_KEEPER)
- **[MatchResult](types/enums/match-result.md)** - Match outcomes (WON, LOST, DRAW, NO_RESULT)

## Schema Information

This documentation is automatically generated from the GraphQL schema using [GraphQL-Markdown](https://graphql-markdown.github.io/).

For more detailed information about each type, query, and mutation, please explore the individual documentation pages linked above.
