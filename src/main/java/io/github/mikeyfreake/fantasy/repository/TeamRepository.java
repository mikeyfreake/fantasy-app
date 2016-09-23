package io.github.mikeyfreake.fantasy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.mikeyfreake.fantasy.domain.Team;

public interface TeamRepository extends JpaRepository<Team, Long> {

	List<Team> findByName(String name);
}
