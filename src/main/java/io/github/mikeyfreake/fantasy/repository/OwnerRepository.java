package io.github.mikeyfreake.fantasy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.mikeyfreake.fantasy.domain.Owner;

public interface OwnerRepository extends JpaRepository<Owner, Long> {

	List<Owner> findByName(String name);
}
