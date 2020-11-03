package com.zionflame.iconsapi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zionflame.iconsapi.model.Palette;

public interface PaletteRepository extends JpaRepository<Palette,Long>{

	Optional<Palette> findByName(String familyName);

}
