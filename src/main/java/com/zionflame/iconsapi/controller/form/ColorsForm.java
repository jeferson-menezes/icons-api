package com.zionflame.iconsapi.controller.form;

import java.util.List;
import java.util.stream.Collectors;

import com.zionflame.iconsapi.model.Colors;
import com.zionflame.iconsapi.model.Palette;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ColorsForm {

	private List<Colors> colors;
	private String paletteName;

	public List<Colors> converter(Palette palette) {

		return colors.stream().map(cor -> {
			cor.setPalette(palette);
			return cor;
		}).collect(Collectors.toList());
	}
}
