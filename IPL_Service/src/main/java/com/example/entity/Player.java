package com.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "IPL_Players")
public class Player {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int playerId;
	private String name;
	private String age;
	private String imageUrl;
	private boolean isForeign;
	private boolean isAvailable = true;
	
	@Enumerated(EnumType.STRING)
	private Speciality speciality;


	
	
	
	
	
	@ManyToOne(targetEntity = Team.class)
	@JoinColumn(name = "team_id")
	private Team team;

}
