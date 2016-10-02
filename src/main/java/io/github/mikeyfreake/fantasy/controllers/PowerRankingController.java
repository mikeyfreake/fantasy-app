package io.github.mikeyfreake.fantasy.controllers;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.github.mikeyfreake.fantasy.domain.PowerRanking;
import io.github.mikeyfreake.fantasy.repository.PowerRankingRepository;

@RestController
@RequestMapping("/api")
public class PowerRankingController {

	private final Logger log = LoggerFactory.getLogger(PowerRankingController.class);

	@Inject
	private PowerRankingRepository prRepo;
	
	@RequestMapping("/powerrankings/{week}")
    public List<PowerRanking> getRankingsByWeek(@PathVariable Long week) {
		log.debug("REST request to get PowerRakings by WEEK : {}", week);
		List<PowerRanking> list = prRepo.findByWeek(week);
        return list;
    }
	
	@RequestMapping(value="/powerrankings", method=RequestMethod.GET)
	public List<PowerRanking> getAllPowerRankings() {
		log.debug("REST request to get all PowerRankings");
		return prRepo.findAll();
	}
	
	@RequestMapping(value="/powerrankings", method=RequestMethod.POST)
	public ResponseEntity<PowerRanking> createPowerRanking(@RequestBody PowerRanking pr) throws URISyntaxException {
		log.debug("REST request to save PowerRanking : {}", pr);
        if (pr.getId() != null) {
            return ResponseEntity.badRequest().headers(HeaderUtil.createFailureAlert("powerRanking", "idexists", "A new Power Ranking cannot already have an ID")).body(null);
        }
        
        PowerRanking result = prRepo.save(pr);
        return ResponseEntity.created(new URI("/api/powerrankings/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert("powerRanking", result.getId().toString()))
            .body(result);
	}
}
