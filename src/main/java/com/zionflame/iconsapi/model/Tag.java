package com.zionflame.iconsapi.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Tag {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long uid;
	private String id;
	private String name;
	
	@OneToMany(mappedBy = "tag")
	private List<Icons> icons;

	public Tag(String name) {
		this.name = name;
	}
	
	public Tag() {
	
	}
}
