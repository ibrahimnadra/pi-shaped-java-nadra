package com.nashtech.playerService.repository;

import com.nashtech.playerService.entities.Player;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlayerRepository extends JpaRepository<Player, Long>{
    List<Player> findByTeamId(Long teamId);
}
