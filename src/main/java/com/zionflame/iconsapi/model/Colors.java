package com.zionflame.iconsapi.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Colors implements Serializable {

	private static final long serialVersionUID = 6097887018488973482L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String hexa;

	@ManyToOne(cascade = CascadeType.ALL)
	private Palette palette;
}
