package com.zionflame.iconsapi.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.zionflame.iconsapi.model.Tag;

import lombok.Getter;

@Getter
public class TagDto {

	private String id;
	private Long uid;
	private String name;

	public TagDto(Tag tag) {
		id = tag.getId();
		name = tag.getName();
		uid = tag.getUid();
	}

	public static List<TagDto> coverter(List<Tag> tags) {
		return tags.stream().map(TagDto::new).collect(Collectors.toList());
	}

}
