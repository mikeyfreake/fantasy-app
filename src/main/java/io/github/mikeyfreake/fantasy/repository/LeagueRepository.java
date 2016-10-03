package io.github.mikeyfreake.fantasy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.mikeyfreake.fantasy.domain.League;

public interface LeagueRepository extends JpaRepository<League, Long> {

	List<League> findByLeagueName(String name);
}
