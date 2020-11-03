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

import com.zionflame.iconsapi.controller.dto.ColorsDto;
import com.zionflame.iconsapi.controller.dto.PaletteDto;
import com.zionflame.iconsapi.controller.form.ColorsForm;
import com.zionflame.iconsapi.model.Colors;
import com.zionflame.iconsapi.model.Palette;
import com.zionflame.iconsapi.repository.ColorsRepository;
import com.zionflame.iconsapi.repository.PaletteRepository;

@RestController
@RequestMapping("/colors")
public class ColorsController {

	@Autowired
	private ColorsRepository colorsRepository;

	@Autowired
	private PaletteRepository paletteRepository;

	@GetMapping
	public ResponseEntity<?> listar(@RequestParam String palette) {
		List<Colors> colors = colorsRepository.findByPaletteName(palette);
		return ResponseEntity.ok(ColorsDto.converter(colors));
	}

	@GetMapping("/filtrar")
	public ResponseEntity<?> filtrar(@RequestParam String nome) {
		List<Colors> colors = colorsRepository.findByNameContaining(nome);
		return ResponseEntity.ok(ColorsDto.converter(colors));
	}

	@Transactional
	@PostMapping
	public ResponseEntity<?> cadastrar(@RequestBody ColorsForm form) {
		Palette palette = new Palette();
		Optional<Palette> opt = paletteRepository.findByName(form.getPaletteName());
		if (!opt.isPresent()) {
			palette = new Palette(form.getPaletteName());
			paletteRepository.save(palette);
		} else {
			palette = opt.get();
		}
		
		List<Colors> colors = form.converter(palette);
		colorsRepository.saveAll(colors);
		return ResponseEntity.ok().build();
	}

	@GetMapping("/palettes")
	public ResponseEntity<?> listarTags() {
		List<Palette> palettes = paletteRepository.findAll();
		return ResponseEntity.ok(PaletteDto.coverter(palettes));
	}
}
