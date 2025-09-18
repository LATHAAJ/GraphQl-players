package com.graphQl.demo.model;

import java.time.LocalDate;

public record Match(Integer id, String opponent, LocalDate matchDate, String venue, MatchResult result) {
}



