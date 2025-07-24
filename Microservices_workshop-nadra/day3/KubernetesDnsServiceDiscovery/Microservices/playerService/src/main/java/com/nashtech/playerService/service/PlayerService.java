package com.nashtech.playerService.service;
import com.nashtech.playerService.entities.Player;
import java.util.List;

public interface PlayerService {
    public Player create(Player player);
    public Player getOne(Long playerId);
    public List<Player> getAll();
    public List<Player> getPlayerByTeamId(Long teamId);
}
