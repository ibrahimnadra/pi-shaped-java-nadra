package com.nashtech.teamService.service;

import com.nashtech.teamService.entities.Team;

import java.util.List;

public interface TeamService {

    public Team create(Team team);
    public Team getOne(Long teamId);
    public List<Team> getAll();
}
