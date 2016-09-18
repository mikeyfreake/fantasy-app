package io.github.mikeyfreake.fantasy.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import io.github.mikeyfreake.fantasy.domain.Owner;

public interface OwnerRepository extends CrudRepository<Owner, Long> {

	List<Owner> findByName(String name);
}
