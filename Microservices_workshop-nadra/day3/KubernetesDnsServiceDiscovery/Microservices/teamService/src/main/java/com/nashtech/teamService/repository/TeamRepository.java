package com.nashtech.teamService.repository;

import com.nashtech.teamService.entities.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Long> {
}
