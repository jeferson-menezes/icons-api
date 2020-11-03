package com.zionflame.iconsapi.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Icons implements Serializable {

	private static final long serialVersionUID = -1898724711997355930L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long uid;
	private String id;
	private String name;
	@Column(columnDefinition = "TEXT")
	private String data;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private User user;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Tag tag;
}
