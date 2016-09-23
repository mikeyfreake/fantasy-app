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

import io.github.mikeyfreake.fantasy.domain.Owner;
import io.github.mikeyfreake.fantasy.repository.OwnerRepository;

@RestController
@RequestMapping("/api")
public class OwnerController {
	
	private final Logger log = LoggerFactory.getLogger(OwnerController.class);

	@Inject
	private OwnerRepository ownerRepo;
	
	@RequestMapping("/owners/{id}")
    public ResponseEntity<Owner> getOwner(@PathVariable Long id) {
		log.debug("REST request to get Owner : {}", id);
		Owner owner = ownerRepo.findOne(id);
        return Optional.ofNullable(owner)
        		.map(result -> new ResponseEntity<>(
                        result,
                        HttpStatus.OK))
                    .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
	
	@RequestMapping("/owners")
	public List<Owner> getAllOwners() {
		log.debug("REST request to get all Owners");
		return ownerRepo.findAll();
	}
}
