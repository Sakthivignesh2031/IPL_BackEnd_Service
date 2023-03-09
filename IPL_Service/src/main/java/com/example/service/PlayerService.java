package com.example.service;

import java.util.List;
import java.util.Optional;

import com.example.entity.*;

public interface PlayerService {
	
		// 1- view all players
		List<Player> getAllPlayer();
		
		
		// 2- add new player
		Player addNewPlayer(Player player);
		
		
		// 3- update player
		Player updatePlayer(int id, Player player);
		
		
		// 4- Delete player
		void deletePlayer(int id);
		
		// 5- get by ID
		Optional<Player> getById(int id);
		
		
		
		// 6- getAllPlayerByTeamId
		public List<Player> getAllTeamPlayer(int id);
		
		
		// 7- getPlayerByID
		public Player getPlayerById(int teamId);

}
