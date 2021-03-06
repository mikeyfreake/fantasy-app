package io.github.mikeyfreake.fantasy;

import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.github.mikeyfreake.fantasy.domain.League;
import io.github.mikeyfreake.fantasy.domain.Owner;
import io.github.mikeyfreake.fantasy.domain.Team;
import io.github.mikeyfreake.fantasy.repository.LeagueRepository;
import io.github.mikeyfreake.fantasy.repository.OwnerRepository;
import io.github.mikeyfreake.fantasy.repository.TeamRepository;

@EnableAutoConfiguration
@SpringBootApplication
public class Application {
	
	private static final Logger log = LoggerFactory.getLogger(Application.class);


	public static void main(String[] args) throws Exception {
		SpringApplication.run(Application.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(LeagueRepository lRepo, TeamRepository repo,OwnerRepository oRepo) {
		return (args) -> {
			League league = new League();
			league.setLeagueName("PPFFL");
			lRepo.save(league);
			
			//Save some owners.
			String [][] ownerTeamData = {{"Beerstore", "Beer Barons"}, {"Freake", "Calgary Stink"}, {"Luke", "Ski-doo Jackets"},
				{"Rudy", "Turtle Sack"}, {"Gregory", "Chronics"}, {"Marc", "Rodgers Warriors"}, {"Scott", "Half Chubs"},
				{"Wadio", "Dawson Damaja"}, {"Lanky", "TMI"}, {"Kev", "Team Hull"}, {"Wes", "4 Horsemen"}, {"Brad", "Travelling Bakeapples"},
				{"Rideout", "Terrible Towels"}, {"Drewy", "4 Paper Mixtures"}, {"Crose", "Vandals"}, {"Robbie", "UNB Bombers"},
				{"Jase", "Deer Lake Skanks"}, {"Beaver", "Phantoms ."}};
			
			Set<Team> teams = new HashSet<Team>();
			for (String [] data : ownerTeamData) {
				Owner owner = new Owner(data[0]);
				oRepo.save(owner);
				Team team = new Team(data[1], owner);
				repo.save(team);
				teams.add(team);
			}
			
			league.setTeams(teams);
			//Fetch all leagues
			log.info("Leagues found with findAll();");
			log.info("----------------------------");
			for (League l : lRepo.findAll()) {
				log.info(l.toString());
			}
			
			//Fetch all teams.
			log.info("Teams found with findAll():");
			log.info("----------------------------");
			for (Team o : repo.findAll()) {
				log.info(o.toString());
			}
			
			//Fetch all owners.
			log.info("Owners found with findAll():");
			log.info("----------------------------");
			for (Owner o : oRepo.findAll()) {
				log.info(o.toString());
			}
		};
	}
}
