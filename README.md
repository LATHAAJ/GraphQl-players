# GraphQL Cricket Players API

A Spring Boot GraphQL API for managing cricket players, teams, matches, and player statistics.

## 🏏 Features

- **Player Management**: Create, read, update, and delete cricket players
- **Team Support**: Players belong to different IPL teams (CSK, MI, DC, RCB, GT)
- **Match Management**: Track cricket matches with opponents and results
- **Player Statistics**: Store and retrieve player performance data
- **GraphQL API**: Modern, flexible API with GraphQL queries and mutations

## 🚀 Getting Started

### Prerequisites
- Java 24
- Gradle

### Running the Application

1. **Clone the repository**
   ```bash
   git clone https://github.com/LATHAAJ/GraphQl-players.git
   cd GraphQl-players
   ```

2. **Run the application**
   ```bash
   ./gradlew bootRun
   ```

3. **Access GraphiQL**
   Open your browser and go to: `http://localhost:8080/graphiql`

## 📊 API Schema

### Queries
- `findAll` - Get all players
- `findPlayerById(id: ID!)` - Get player by ID
- `findPlayersByTeam(team: Team!)` - Get players by team
- `findPlayersByRole(role: PlayerRole!)` - Get players by role
- `findAllMatches` - Get all matches
- `findMatchById(id: ID!)` - Get match by ID
- `findPlayerStats(playerId: ID!)` - Get player statistics

### Mutations
- `createPlayer(...)` - Create a new player
- `updatePlayer(...)` - Update player information
- `deletePlayer(id: ID!)` - Delete a player
- `createMatch(...)` - Create a new match
- `updatePlayerStats(...)` - Update player statistics

### Types
- `Player` - Cricket player information
- `Team` - Available teams (CSK, MI, DC, RCB, GT)
- `PlayerRole` - Player roles (BATSMAN, BOWLER, ALL_ROUNDER, WICKET_KEEPER)
- `Match` - Match information
- `PlayerStats` - Player statistics
- `MatchResult` - Match results (WON, LOST, DRAW, NO_RESULT)

## 🧪 Example Queries

### Get All Players
```graphql
query GetAllPlayers {
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

### Get Player by ID
```graphql
query GetPlayer($id: ID!) {
  findPlayerById(id: $id) {
    id
    name
    team
    role
    stats {
      matchesPlayed
      runs
      wickets
      average
    }
  }
}
```

### Create New Player
```graphql
mutation CreatePlayer($name: String!, $team: Team!, $role: PlayerRole!) {
  createPlayer(name: $name, team: $team, role: $role) {
    id
    name
    team
    role
  }
}
```

## 🛠️ Technology Stack

- **Java 24**
- **Spring Boot 3.5.5**
- **Spring GraphQL**
- **Gradle**
- **GraphQL Java**

## 📁 Project Structure

```
src/
├── main/
│   ├── java/com/graphQl/demo/
│   │   ├── controller/
│   │   │   └── PlayerController.java
│   │   ├── model/
│   │   │   ├── Player.java
│   │   │   ├── Team.java
│   │   │   ├── PlayerRole.java
│   │   │   ├── Match.java
│   │   │   ├── MatchResult.java
│   │   │   └── PlayerStats.java
│   │   ├── service/
│   │   │   └── PlayerService.java
│   │   └── DemoApplication.java
│   └── resources/
│       ├── application.properties
│       └── graphql/
│           └── schema.graphqls
└── test/
    └── java/com/graphQl/demo/
        └── DemoApplicationTests.java
```

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add some amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

## 📄 License

This project is licensed under the MIT License.

## 👨‍💻 Author

**Latha** - [@LATHAAJ](https://github.com/LATHAAJ)
