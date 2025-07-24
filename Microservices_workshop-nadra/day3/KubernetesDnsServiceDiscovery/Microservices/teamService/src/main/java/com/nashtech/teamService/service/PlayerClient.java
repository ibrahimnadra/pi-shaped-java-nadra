package com.nashtech.teamService.service;
import com.nashtech.teamService.entities.Player;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

//@FeignClient(url = "http://localhost:8080/", value = "player-service")
// As we using Eureka, we can use the service name instead of the URL
@FeignClient(name = "player-service", url = "http://player-service:8080")
public interface PlayerClient {

    @GetMapping("/players/team/{teamId}")
    List<Player> getPlayersOfTeam(@PathVariable Long teamId);
}
