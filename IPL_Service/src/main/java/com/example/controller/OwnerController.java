package com.example.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Player;
import com.example.entity.Team;
import com.example.service.PlayerService;

import lombok.RequiredArgsConstructor;


@CrossOrigin(origins = "*")
@RequiredArgsConstructor
@RestController
public class OwnerController {
	
	
	private final PlayerService playerService;
	
	
	
	@GetMapping(value = "api/teamPlayer/{teamId}")
	public List<Player> viewOwnerTeamPlayer(@PathVariable int teamId){
		return playerService.getAllTeamPlayer(teamId);
	}
	
	
	
	@PostMapping(value ="/api/teamPlayer/{teamId}/{playerId}")
	public ResponseEntity<?> addingTeamPlayer(@PathVariable int teamId, @PathVariable int playerId){
		
		Team team = new Team();
		
		team.setTeamId(teamId);
		
		Player player = playerService.getPlayerById(playerId);
		
		player.setTeam(team);
		
		playerService.addNewPlayer(player);
		
		return new ResponseEntity<>(player,HttpStatus.ACCEPTED);
		
	}
	
	
	
	@DeleteMapping(value = "/api/teamPlayer/{playerId}")
	public ResponseEntity<?> deletePlayerFromTeam(@PathVariable int playerId){
		
		Player player = playerService.getPlayerById(playerId);
		player.setTeam(null);
		
		playerService.addNewPlayer(player);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
	

}
