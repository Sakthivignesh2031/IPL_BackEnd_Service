package com.example.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "IPL_Teams")
@JsonIgnoreProperties(value= {"handler","hibernateLazyInitializer","FieldHandler"})
public class Team {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int teamId;
	private String teamName;
	private String teamCity;
	private String teamState;
	
	private String ownerName;
	private String email;
	private String password;
	
	
	
	@OneToMany(targetEntity = Player.class)
	@JsonBackReference
	private List<Player> player;

}
