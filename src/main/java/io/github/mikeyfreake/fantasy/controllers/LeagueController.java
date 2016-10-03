package io.github.mikeyfreake.fantasy.controllers;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.github.mikeyfreake.fantasy.domain.League;
import io.github.mikeyfreake.fantasy.repository.LeagueRepository;

@RestController
@RequestMapping("/api/league")
public class LeagueController {
	
	private final Logger log = LoggerFactory.getLogger(LeagueController.class);

	@Inject
	private LeagueRepository leagueRepo;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
    public ResponseEntity<League> getLeague(@PathVariable Long id) {
		log.debug("REST request to get league : {}", id);
		League league = leagueRepo.findOne(id);
        return Optional.ofNullable(league)
        		.map(result -> new ResponseEntity<>(
                        result,
                        HttpStatus.OK))
                    .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
	
	@RequestMapping("")
	public List<League> getAllLeagues() {
		log.debug("REST request to get all Leagues");
		return leagueRepo.findAll();
	}
	
	@RequestMapping(value="", method=RequestMethod.POST)
	public ResponseEntity<League> createLeague(@RequestBody League league) throws URISyntaxException {
		log.debug("REST request to save League : {}", league);
        if (league.getId() != null) {
            return ResponseEntity.badRequest().headers(HeaderUtil.createFailureAlert("league", "idexists", "A new League cannot already have an ID")).body(null);
        }
        
        League result = leagueRepo.save(league);
        return ResponseEntity.created(new URI("/api/league/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert("league", result.getId().toString()))
            .body(result);
	}

	@RequestMapping(value="", method=RequestMethod.POST)
	public ResponseEntity<League> updateLeague(@RequestBody League league) throws URISyntaxException {
		log.debug("REST request to save League : {}", league);
        if (league.getId() == null) {
            return ResponseEntity.badRequest().headers(HeaderUtil.createFailureAlert("league", "idmissing", "A League without an ID cannot be updated")).body(null);
        }
        
        League result = leagueRepo.save(league);
        return ResponseEntity.created(new URI("/api/league/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert("league", result.getId().toString()))
            .body(result);
	}
}
