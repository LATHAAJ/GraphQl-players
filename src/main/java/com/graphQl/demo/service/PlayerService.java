package com.graphQl.demo.service;

import com.graphQl.demo.model.*;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Service
public class PlayerService {
  private List<Player> playerList = new ArrayList<>();
  private List<Match> matchList = new ArrayList<>();
  private List<PlayerStats> statsList = new ArrayList<>();

  AtomicInteger playerId = new AtomicInteger(0);
  AtomicInteger matchId = new AtomicInteger(0);

  // Player operations
  public List<Player> findAll() {
    return playerList;
  }

  public Optional<Player> findOne(Integer id) {
    return playerList.stream()
            .filter(player -> player.Id() == id).findFirst();
  }

  public List<Player> findPlayersByTeam(Team team) {
    return playerList.stream()
            .filter(player -> player.team() == team)
            .collect(Collectors.toList());
  }

  public List<Player> findPlayersByRole(PlayerRole role) {
    return playerList.stream()
            .filter(player -> player.role() == role)
            .collect(Collectors.toList());
  }

  public Player createPlayer(String name, Team team, PlayerRole role, Integer age, String dateOfBirth, String country, Integer jerseyNumber, String nickname) {
    Player player = new Player(playerId.incrementAndGet(), name, team, role, age, 
                              dateOfBirth != null ? LocalDate.parse(dateOfBirth) : null, country, jerseyNumber, nickname);
    playerList.add(player);
    return player;
  }

  public Player removePlayer(Integer id) {
    Player player = playerList.stream().filter(item -> item.Id() == id).findFirst().orElseThrow(() -> new IllegalArgumentException());
    playerList.remove(player);
    return player;
  }

  public Player updatePlayer(Integer id, String name, Team team, PlayerRole role, Integer age, String dateOfBirth, String country, Integer jerseyNumber, String nickname) {
    Player updatePlayer = new Player(id, name, team, role, age, 
                                   dateOfBirth != null ? LocalDate.parse(dateOfBirth) : null, country, jerseyNumber, nickname);
    Optional<Player> optional = playerList.stream().filter(c -> c.Id() == id).findFirst();

    if (optional.isPresent()) {
      Player player = optional.get();
      int index = playerList.indexOf(player);
      playerList.set(index, updatePlayer);
    } else {
      throw new IllegalArgumentException("Invalid Player");
    }
    return updatePlayer;
  }

  // Match operations
  public List<Match> findAllMatches() {
    return matchList;
  }

  public Optional<Match> findMatchById(Integer id) {
    return matchList.stream()
            .filter(match -> match.id() == id).findFirst();
  }

  public Match createMatch(String opponent, String matchDate, String venue, MatchResult result) {
    Match match = new Match(matchId.incrementAndGet(), opponent, LocalDate.parse(matchDate), venue, result);
    matchList.add(match);
    return match;
  }

  // Stats operations
  public Optional<PlayerStats> getPlayerStats(Integer playerId) {
    return statsList.stream()
            .filter(stats -> stats.playerId() == playerId).findFirst();
  }

  public PlayerStats updatePlayerStats(Integer playerId, Integer matchesPlayed, Integer runs, Integer wickets, Double average) {
    PlayerStats stats = new PlayerStats(playerId, matchesPlayed, runs, wickets, average);
    Optional<PlayerStats> existing = statsList.stream().filter(s -> s.playerId() == playerId).findFirst();
    
    if (existing.isPresent()) {
      int index = statsList.indexOf(existing.get());
      statsList.set(index, stats);
    } else {
      statsList.add(stats);
    }
    return stats;
  }

  @PostConstruct
  private void init() {
    // Initialize players with enhanced data including jersey numbers and nicknames
    playerList.add(new Player(playerId.incrementAndGet(), "MS Dhoni", Team.CSk, PlayerRole.WICKET_KEEPER, 42, LocalDate.of(1981, 7, 7), "India", 7, "Captain Cool"));
    playerList.add(new Player(playerId.incrementAndGet(), "Rohit Sharma", Team.MI, PlayerRole.BATSMAN, 36, LocalDate.of(1987, 4, 30), "India", 45, "Hitman"));
    playerList.add(new Player(playerId.incrementAndGet(), "Jaspreet Bumrah", Team.MI, PlayerRole.BOWLER, 30, LocalDate.of(1993, 12, 6), "India", 93, "Boom Boom"));
    playerList.add(new Player(playerId.incrementAndGet(), "Rishabh Pant", Team.DC, PlayerRole.WICKET_KEEPER, 26, LocalDate.of(1997, 10, 4), "India", 17, "Pantastic"));
    playerList.add(new Player(playerId.incrementAndGet(), "Suresh Raina", Team.CSk, PlayerRole.ALL_ROUNDER, 37, LocalDate.of(1986, 11, 27), "India", 3, "Mr. IPL"));

    // Initialize some matches
    matchList.add(new Match(matchId.incrementAndGet(), "Mumbai Indians", LocalDate.of(2024, 3, 15), "Wankhede Stadium", MatchResult.WON));
    matchList.add(new Match(matchId.incrementAndGet(), "Delhi Capitals", LocalDate.of(2024, 3, 20), "Feroz Shah Kotla", MatchResult.LOST));

    // Initialize some player stats
    statsList.add(new PlayerStats(1, 200, 5000, 0, 25.5));
    statsList.add(new PlayerStats(2, 150, 4000, 0, 30.2));
    statsList.add(new PlayerStats(3, 100, 500, 150, 3.33));
  }

}
