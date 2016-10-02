package io.github.mikeyfreake.fantasy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.mikeyfreake.fantasy.domain.PowerRanking;

public interface PowerRankingRepository extends JpaRepository<PowerRanking, Long> {

	List<PowerRanking> findByWeek(Long week);

	
}
