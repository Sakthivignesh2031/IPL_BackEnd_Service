package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.entity.Player;
import com.example.exception.NotFoundException;
import com.example.repository.PlayerRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class PlayerServiceImpl implements PlayerService {

	private final PlayerRepository playerRepository;

	// 1- view all players
	@Override
	public List<Player> getAllPlayer() {

		List<Player> players = playerRepository.findAll();
		return players;
	}

	// 2- add new player
	@Override
	public Player addNewPlayer(Player player) {

		return playerRepository.save(player);
	}

	// 3- update player
	@Override
	public Player updatePlayer(int id, Player player) {

		if (!playerRepository.existsById(id)) {
			throw new NotFoundException(id);
		} 
		else {
			Player newPlayer = playerRepository.findById(id).get();

			newPlayer.setName(player.getName());
			newPlayer.setAge(player.getAge());
			newPlayer.setImageUrl(player.getImageUrl());
			newPlayer.setSpeciality(player.getSpeciality());
			newPlayer.setForeign(false);

			return playerRepository.save(newPlayer);
		}
	}

	// 4- Delete player
	@Override
	public void deletePlayer(int id) {

		if (!playerRepository.existsById(id)) {
			throw new NotFoundException(id);
		} 
		else {
			playerRepository.deleteById(id);
		}
	}

	// 5- get by ID
	@Override
	public Optional<Player> getById(int id) {

			return playerRepository.findById(id);
		
	}

	// 6- getAllPlayerByTeamId
	@Override
	public List<Player> getAllTeamPlayer(int id) {

			return playerRepository.getPlayerByTeamId(id);
	
	}

	// 7- getPlayerByID
	@Override
	public Player getPlayerById(int teamId) {

			return playerRepository.findById(teamId).orElse(null);
		
	}

}
