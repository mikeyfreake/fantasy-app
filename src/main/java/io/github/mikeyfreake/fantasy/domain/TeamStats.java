package io.github.mikeyfreake.fantasy.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class TeamStats {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private Integer year;
	private Integer wins;
	private Integer losses;
	private Integer ties;
	private Integer pointsFor;
	private Integer pointsAgainst;
	
	@OneToOne
	private Team teams;
	
	public TeamStats() {}
	
	public TeamStats(Integer year) {
		this.setYear(year);
	}
	
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

	public Integer getWins() {
		return wins;
	}

	public void setWins(Integer wins) {
		this.wins = wins;
	}

	public Integer getLosses() {
		return losses;
	}

	public void setLosses(Integer losses) {
		this.losses = losses;
	}

	public Integer getTies() {
		return ties;
	}

	public void setTies(Integer ties) {
		this.ties = ties;
	}

	public Integer getPointsFor() {
		return pointsFor;
	}

	public void setPointsFor(Integer pointsFor) {
		this.pointsFor = pointsFor;
	}

	public Integer getPointsAgainst() {
		return pointsAgainst;
	}

	public void setPointsAgainst(Integer pointsAgainst) {
		this.pointsAgainst = pointsAgainst;
	}

	public Team getTeams() {
		return teams;
	}

	public void setTeams(Team teams) {
		this.teams = teams;
	}
	
}
