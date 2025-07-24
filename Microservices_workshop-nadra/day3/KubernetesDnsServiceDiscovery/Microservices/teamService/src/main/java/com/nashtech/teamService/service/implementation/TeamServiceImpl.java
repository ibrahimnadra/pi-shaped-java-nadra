package com.nashtech.teamService.service.implementation;

import com.nashtech.teamService.entities.Team;
import com.nashtech.teamService.repository.TeamRepository;
import com.nashtech.teamService.service.TeamService;
import org.springframework.stereotype.Service;
import com.nashtech.teamService.service.PlayerClient;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeamServiceImpl implements TeamService {
    private TeamRepository teamRepository;
    private PlayerClient playerClient;

    public TeamServiceImpl(TeamRepository teamRepository, PlayerClient playerClient) {
        this.teamRepository = teamRepository;
        this.playerClient = playerClient;
    }

    @Override
    public Team create(Team team) {
        return teamRepository.save(team);
    }

    @Override
    public Team getOne(Long teamId) {
        Team team = teamRepository.findById(teamId).orElseThrow(()-> new RuntimeException("Team not found."));
        team.setPlayers(playerClient.getPlayersOfTeam(team.getTeamId()));
        return team;
    }

    @Override
    public List<Team> getAll() {
        List<Team> teams = teamRepository.findAll();
        List<Team> teamListWithPlayers = teams.stream().map(team -> {
            team.setPlayers(playerClient.getPlayersOfTeam(team.getTeamId()));
            return team;
        }).collect(Collectors.toList());
        return teamListWithPlayers;
    }
}

