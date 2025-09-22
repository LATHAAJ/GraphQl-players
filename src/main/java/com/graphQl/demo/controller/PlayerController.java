package com.graphQl.demo.controller;

import com.graphQl.demo.model.*;
import com.graphQl.demo.service.PlayerService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class PlayerController {

  private final PlayerService playerService;

  public PlayerController(PlayerService playerService) {
    this.playerService = playerService;
  }

  @QueryMapping
  public List<Player> findAll() {
    return playerService.findAll();
  }

  @QueryMapping
  public Optional<Player> findPlayerById(@Argument Integer id) {
    return playerService.findOne(id);
  }

  @QueryMapping
  public List<Player> findPlayersByTeam(@Argument Team team) {
    return playerService.findPlayersByTeam(team);
  }

  @QueryMapping
  public List<Player> findPlayersByRole(@Argument PlayerRole role) {
    return playerService.findPlayersByRole(role);
  }

  // Match Queries
  @QueryMapping
  public List<Match> findAllMatches() {
    return playerService.findAllMatches();
  }

  @QueryMapping
  public Optional<Match> findMatchById(@Argument Integer id) {
    return playerService.findMatchById(id);
  }

  // Stats Queries
  @QueryMapping
  public Optional<PlayerStats> findPlayerStats(@Argument Integer playerId) {
    return playerService.getPlayerStats(playerId);
  }

  @MutationMapping
  public Player createPlayer(@Argument String name, @Argument Team team, @Argument PlayerRole role, 
                           @Argument Integer age, @Argument String dateOfBirth, @Argument String country,
                           @Argument Integer jerseyNumber, @Argument String nickname) {
    return playerService.createPlayer(name, team, role, age, dateOfBirth, country, jerseyNumber, nickname);
  }

  @MutationMapping
  public Player updatePlayer(@Argument Integer id, @Argument String name, @Argument Team team, 
                           @Argument PlayerRole role, @Argument Integer age, @Argument String dateOfBirth, @Argument String country,
                           @Argument Integer jerseyNumber, @Argument String nickname) {
    return playerService.updatePlayer(id, name, team, role, age, dateOfBirth, country, jerseyNumber, nickname);
  }

  @MutationMapping
  public Boolean deletePlayer(@Argument Integer id) {
    try {
      playerService.removePlayer(id);
      return true;
    } catch (Exception e) {
      return false;
    }
  }

  @MutationMapping
  public Match createMatch(@Argument String opponent, @Argument String matchDate, 
                         @Argument String venue, @Argument MatchResult result) {
    return playerService.createMatch(opponent, matchDate, venue, result);
  }

  @MutationMapping
  public PlayerStats updatePlayerStats(@Argument Integer playerId, @Argument Integer matchesPlayed, 
                                     @Argument Integer runs, @Argument Integer wickets, @Argument Double average) {
    return playerService.updatePlayerStats(playerId, matchesPlayed, runs, wickets, average);
  }

  @SchemaMapping(typeName = "Player", field = "stats")
  public Optional<PlayerStats> getStats(Player player) {
    return playerService.getPlayerStats(player.Id());
  }

}
