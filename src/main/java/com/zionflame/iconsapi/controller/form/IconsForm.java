package com.zionflame.iconsapi.controller.form;

import java.util.List;
import java.util.stream.Collectors;

import com.zionflame.iconsapi.model.Icons;
import com.zionflame.iconsapi.model.Tag;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IconsForm {

	private List<Icons> icons;
	private String tagName;

	public List<Icons> converter(Tag tag) {
		return icons.stream().map(t -> {
			t.setTag(tag);
			return t;
		}).collect(Collectors.toList());
	}
}
