package io.github.mikeyfreake.fantasy.controllers;

import java.util.List;
import java.util.Optional;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.mikeyfreake.fantasy.domain.Team;
import io.github.mikeyfreake.fantasy.repository.TeamRepository;

@RestController
@RequestMapping("/api/teams")
public class TeamController {
	
	private final Logger log = LoggerFactory.getLogger(TeamController.class);

	@Inject
	private TeamRepository teamRepo;
	
	@RequestMapping("/{id}")
    public ResponseEntity<Team> getTeam(@PathVariable Long id) {
		log.debug("REST request to get Team : {}", id);
		Team team = teamRepo.findOne(id);
        return Optional.ofNullable(team)
        		.map(result -> new ResponseEntity<>(
                        result,
                        HttpStatus.OK))
                    .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
	
	@RequestMapping("")
	public List<Team> getAllTeams() {
		log.debug("REST request to get all Teams");
		return teamRepo.findAll();
	}

}
