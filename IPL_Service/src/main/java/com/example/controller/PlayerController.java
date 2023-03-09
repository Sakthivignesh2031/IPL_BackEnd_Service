package com.example.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Player;
import com.example.service.PlayerService;

import lombok.RequiredArgsConstructor;


@CrossOrigin(origins =  "*")
@RequiredArgsConstructor
@RestController
public class PlayerController {

	
	private final PlayerService playerService;

	
	// 1- List All players
	@GetMapping(value = "api/players")
	public ResponseEntity<?>getAllPlayers(){
		
		List<Player> players = playerService.getAllPlayer();
		return new ResponseEntity<>(players, HttpStatus.OK);
	}
	
	// 2- Add new player
	@PostMapping(value = "api/player", consumes = "application/json")
	public ResponseEntity<?> addNewPlayer(@RequestBody Player player){
		
		Player newPlayer = playerService.addNewPlayer(player);
		return new ResponseEntity<>(newPlayer,HttpStatus.CREATED);
	}
	
	// 3- Update player
	@PutMapping(value = "api/player/{id}")
	public ResponseEntity<?> updatePlayer(@PathVariable int id, @RequestBody Player player){
		
		Player updateplayer = playerService.updatePlayer(id, player);
		return new ResponseEntity<>(updateplayer, HttpStatus.ACCEPTED);
		
	}
	
	// 4- Delete player
	@DeleteMapping(value = "api/player/{id}")
	String deletePlayer(@PathVariable int id) {
		playerService.deletePlayer(id);
		return "Player " + id + " was deleted sucessful";
	}
	
	
	// 5- Get Player By Id
	@GetMapping(value = "api/player/{id}")
	public ResponseEntity<?> getPlayerById(@PathVariable int id){
		Optional<Player> getPlayerDetails = playerService.getById(id);
		return new ResponseEntity<>(getPlayerDetails, HttpStatus.ACCEPTED);
	}


}
