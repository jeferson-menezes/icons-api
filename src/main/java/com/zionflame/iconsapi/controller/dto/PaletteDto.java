package com.zionflame.iconsapi.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.zionflame.iconsapi.model.Palette;

import lombok.Getter;

@Getter
public class PaletteDto {

	private String name;
	private Long id;

	public PaletteDto(Palette palette) {
		id = palette.getId();
		name = palette.getName();
	}
	
	public static List<PaletteDto> coverter(List<Palette> palettes) {
		
		return palettes.stream().map(PaletteDto::new).collect(Collectors.toList());
	}

}
