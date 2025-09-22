package com.graphQl.demo.model;

import java.time.LocalDate;

public record Player(Integer Id, String name, Team team, PlayerRole role, Integer age, LocalDate dateOfBirth, String country, Integer jerseyNumber, String nickname) {

}