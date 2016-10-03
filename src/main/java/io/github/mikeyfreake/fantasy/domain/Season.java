package io.github.mikeyfreake.fantasy.domain;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Season {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private Integer year;
	
	@OneToMany
	private Set<TeamStats> teamStats;
	
	@OneToMany
	private Set<PowerRanking> powerRankings;
	
	@ManyToOne
	private League league;
	
	@OneToMany
	private Set<TrophyWinner> trophyWinners;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Set<TeamStats> getTeamStats() {
		return teamStats;
	}

	public void setTeamStats(Set<TeamStats> teamStats) {
		this.teamStats = teamStats;
	}

	public Set<PowerRanking> getPowerRankings() {
		return powerRankings;
	}

	public void setPowerRankings(Set<PowerRanking> powerRankings) {
		this.powerRankings = powerRankings;
	}

	public League getLeague() {
		return league;
	}

	public void setLeague(League league) {
		this.league = league;
	}

	public Set<TrophyWinner> getThrophyWinners() {
		return trophyWinners;
	}

	public void setThrophyWinners(Set<TrophyWinner> throphyWinners) {
		this.trophyWinners = throphyWinners;
	}
	
}
