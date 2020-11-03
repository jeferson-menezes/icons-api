package com.zionflame.iconsapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zionflame.iconsapi.model.Colors;

public interface ColorsRepository extends JpaRepository<Colors, Long> {

	List<Colors> findByNameContaining(String name);

	List<Colors> findByPaletteName(String palette);

}
