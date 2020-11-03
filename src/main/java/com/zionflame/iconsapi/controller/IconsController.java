package com.zionflame.iconsapi.controller;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zionflame.iconsapi.controller.dto.IconsDto;
import com.zionflame.iconsapi.controller.dto.TagDto;
import com.zionflame.iconsapi.controller.form.IconsForm;
import com.zionflame.iconsapi.model.Icons;
import com.zionflame.iconsapi.model.Tag;
import com.zionflame.iconsapi.repository.IconsRepository;
import com.zionflame.iconsapi.repository.TagRepository;

@RestController
@RequestMapping("/icons")
public class IconsController {

	@Autowired
	private IconsRepository iconsRepository;

	@Autowired
	private TagRepository tagRepository;

	@GetMapping
	public ResponseEntity<?> listar(@RequestParam String tag) {
		List<Icons> icons = iconsRepository.findByTagName(tag);
		return ResponseEntity.ok(IconsDto.converter(icons));

	}

	@GetMapping("/filtrar")
	public ResponseEntity<?> filtrar(@RequestParam String nome) {
		System.out.println(nome);
		List<Icons> icons = iconsRepository.findFirst100ByNameContaining(nome);
		return ResponseEntity.ok(IconsDto.converter(icons));
	}

	@Transactional
	@PostMapping
	public ResponseEntity<?> cadastrar(@RequestBody IconsForm form) {
		Tag tag = new Tag();
		Optional<Tag> opt = tagRepository.findByName(form.getTagName());
		if (!opt.isPresent()) {
			tag = new Tag(form.getTagName());
			tagRepository.save(tag);
		} else {
			tag = opt.get();
		}

		List<Icons> icons = form.converter(tag);

		for (Icons icon : icons) {
			iconsRepository.save(icon);
		}
		return ResponseEntity.ok().build();
	}

	@GetMapping("/tags")
	public ResponseEntity<?> listarTags() {
		List<Tag> tags = tagRepository.findAll();
		return ResponseEntity.ok(TagDto.coverter(tags));
	}
}
