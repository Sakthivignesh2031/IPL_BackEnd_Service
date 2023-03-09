package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.entity.Team;
import com.example.exception.NotFoundException;
import com.example.exception.TeamException;
import com.example.repository.TeamRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class TeamServiceImpl implements TeamService {

	private final TeamRepository teamRepository;

	// 1- view all team
	@Override
	public List<Team> getAllTeam()  {

		List<Team> teams = teamRepository.findAll();

		return teams;

	}

	// 2- add new team
	@Override
	public Team addNewTeam(Team team) {
		
		if(team.getTeamName().isEmpty() || team.getTeamCity().isEmpty() || team.getTeamState().isEmpty() || team.getOwnerName().isEmpty() || team.getEmail().isEmpty() || team.getPassword().isEmpty()) {
			throw new TeamException("Input Fields Are Empty");
		}

		return teamRepository.save(team);
	}

	// 3- update team
	@Override
	public Team updateTeam(int id, Team team) {

		if (!teamRepository.existsById(id)) {
			throw new NotFoundException(id);
		}

		else {

			Team newTeam = teamRepository.findById(id).get();

			newTeam.setTeamName(team.getTeamName());
			newTeam.setTeamCity(team.getTeamCity());
			newTeam.setTeamState(team.getTeamState());

			return teamRepository.save(newTeam);
		}
	}

	// 4- Delete team
	@Override
	public void deleteTeam(int id) {

		if (!teamRepository.existsById(id)) {
			throw new NotFoundException(id);
		}

		else {
			teamRepository.deleteById(id);
		}
	}

	// 5- Get Team by ID
	@Override
	public Optional<Team> getTeamById(int id) {
		
			return teamRepository.findById(id);
		
	}

	@Override
	public Team getTeamIdByOwnerName(String ownerName) {
		
		return teamRepository.getIdByName(ownerName);
	}

}
