package com.nashtech.playerService.controller;

import com.nashtech.playerService.entities.Player;
import com.nashtech.playerService.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/players/")
public class PlayerController {

    private PlayerService playerService;

    @Autowired
    Environment environment;

    public PlayerController(PlayerService PlayerService) {
        this.playerService = PlayerService;
    }

    @PostMapping
    public Player create(@RequestBody Player player){
        return playerService.create(player);
    }

    @GetMapping("/{playerId}")
    public Player getOne(@PathVariable Long playerId){return playerService.getOne(playerId); }

    @GetMapping
    public List<Player> getAll(){
        return playerService.getAll();
    }

    @GetMapping("/team/{teamId}")
    public List<Player> getPlayerByTeamId(@PathVariable Long teamId){
        System.out.println("Player Service Port: " + environment.getProperty("local.server.port"));
        return playerService.getPlayerByTeamId(teamId);
    }
}

