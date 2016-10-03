package io.github.mikeyfreake.fantasy.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class TrophyWinner {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@OneToOne
	private Team team;
	
	@OneToOne
	private Season season;
	
	@OneToOne
	private Trophy trophy;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public Season getSeason() {
		return season;
	}

	public void setSeason(Season season) {
		this.season = season;
	}
	
	
	public Trophy getTrophy() {
		return trophy;
	}

	public void setTrophy(Trophy trophy) {
		this.trophy = trophy;
	}
}
