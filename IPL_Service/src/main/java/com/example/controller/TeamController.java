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
import org.springframework.web.client.RestTemplate;

import com.example.dto.OwnerCredentials;
import com.example.dto.TeamDetails;
import com.example.entity.Player;
import com.example.entity.Team;
import com.example.service.PlayerService;
import com.example.service.TeamService;

import lombok.RequiredArgsConstructor;



@CrossOrigin(origins =  "*")
@RequiredArgsConstructor
@RestController
public class TeamController {
	
	
	private final TeamService teamService;
	
	private final PlayerService playerService;
	
	private final RestTemplate restTemplate;
		
	
	// 1- GetAllTeams
	@GetMapping(value = "api/teams")
	public ResponseEntity<?> getAllTeam(){
		
		List<Team> teams = teamService.getAllTeam();
		return new ResponseEntity<>(teams, HttpStatus.OK);
 	}
	
	
	// 2- AddNewTeam
	@PostMapping(value =  "api/team", consumes = "application/json")
	public ResponseEntity<?> addNewTeam(@RequestBody Team team) {
		
		Team newTeam = teamService.addNewTeam(team);
		
		
		OwnerCredentials ownerCredentials = new OwnerCredentials();
		ownerCredentials.setUserName(newTeam.getOwnerName());
		ownerCredentials.setEmail(newTeam.getEmail());
		ownerCredentials.setUserPassword(newTeam.getPassword());
		
		restTemplate.postForEntity("http://localhost:8081/registerNewUser", ownerCredentials, null );
		
		return new ResponseEntity<>(newTeam, HttpStatus.CREATED);
	}
	
	
	// 3- UpdateTeamDetails
	@PutMapping(value = "api/team/{id}")
	public ResponseEntity<?> updateTeam(@PathVariable int id, @RequestBody Team team){
		
		Team updateteam = teamService.updateTeam(id, team);
		return new ResponseEntity<>(updateteam, HttpStatus.OK );
	}
	
	
	// 4-DeleteTeam
	@DeleteMapping(value = "api/team/{id}")
	public ResponseEntity<?> deleteTeam(@PathVariable int id){
		
		List<Player> players = playerService.getAllTeamPlayer(id);
		
		for(Player player : players) {
			player.setTeam(null);
			playerService.addNewPlayer(player);
		}
		
		teamService.deleteTeam(id);
		
		return ResponseEntity.status(HttpStatus.OK).body("Team Deleted..");
	}

	
	
	
	// 5- Get Team By Id
	@GetMapping(value = "api/team/{id}")
	public ResponseEntity<?> getTeamById(@PathVariable int id){
		Optional<Team> getTeamDetails = teamService.getTeamById(id);
		return new ResponseEntity<>(getTeamDetails, HttpStatus.ACCEPTED);
	}
	
	
	@GetMapping(value = "api/getId/{ownerName}")
	public ResponseEntity<?> getTeamIdByOwnerName(@PathVariable String ownerName){
		
		Team team = teamService.getTeamIdByOwnerName(ownerName);
		TeamDetails teamDetails = new TeamDetails();
		teamDetails.setTeamId(team.getTeamId());
		teamDetails.setTeamName(team.getTeamName());
		
		return new ResponseEntity<>(teamDetails, HttpStatus.OK);
	}
	

}
