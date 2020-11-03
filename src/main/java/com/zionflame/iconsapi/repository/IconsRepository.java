package com.zionflame.iconsapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zionflame.iconsapi.model.Icons;

public interface IconsRepository extends JpaRepository<Icons, Long>{

	List<Icons> findByNameContaining(String nome);

	List<Icons> findByTagName(String tag);

	List<Icons> findFirst100ByNameContaining(String nome);

}
