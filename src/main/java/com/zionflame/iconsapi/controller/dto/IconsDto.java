package com.zionflame.iconsapi.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.zionflame.iconsapi.model.Icons;

import lombok.Getter;

@Getter
public class IconsDto {
	private String tagName;
	private String name;
	private String id;

	public IconsDto(Icons icon) {
		id = icon.getId();
		name = icon.getName();
		tagName = icon.getTag().getName();
	}

	public static List<IconsDto> converter(List<Icons> icons) {
		return icons.stream().map(IconsDto::new).collect(Collectors.toList());
	}

}
