package com.example.service;

import java.util.List;
import java.util.Optional;

import com.example.entity.Team;

public interface TeamService {

	// 1- view all team
	List<Team> getAllTeam() ;

	// 2- add new team
	Team addNewTeam(Team team);

	// 3- update team
	Team updateTeam(int id, Team team);

	// 4- Delete team
	void deleteTeam(int id);

	// 5- GetByID
	Optional<Team> getTeamById(int id);
	
	public  Team getTeamIdByOwnerName(String ownerName);

}
