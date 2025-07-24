package com.nashtech.playerService.service.implementation;

import com.nashtech.playerService.entities.Player;
import com.nashtech.playerService.repository.PlayerRepository;
import com.nashtech.playerService.service.PlayerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerServiceImpl implements PlayerService {

    private PlayerRepository playerRepository;

    public PlayerServiceImpl(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @Override
    public Player create(Player player) {
        return playerRepository.save(player);
    }

    @Override
    public Player getOne(Long playerId) {
        return playerRepository.findById(playerId).orElseThrow(()-> new RuntimeException("Player not found."));
    }

    @Override
    public List<Player> getAll() {
        return playerRepository.findAll();
    }

    @Override
    public List<Player> getPlayerByTeamId(Long teamId) {
        return playerRepository.findByTeamId(teamId);
    }
}
