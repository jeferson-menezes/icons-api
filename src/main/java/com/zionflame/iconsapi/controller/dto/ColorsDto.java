package com.zionflame.iconsapi.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.zionflame.iconsapi.model.Colors;

import lombok.Getter;

@Getter
public class ColorsDto {

	private Long id;
	private String name;
	private String hexa;
	private String paletteName;

	public ColorsDto(Colors color) {
		id = color.getId();
		name = color.getName();
		hexa = color.getHexa();
		paletteName = color.getPalette().getName();
	}

	public static Object converter(List<Colors> colors) {
		return colors.stream().map(ColorsDto::new).collect(Collectors.toList());
	}

}
