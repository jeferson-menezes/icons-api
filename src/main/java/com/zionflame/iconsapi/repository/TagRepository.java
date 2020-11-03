package com.zionflame.iconsapi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zionflame.iconsapi.model.Tag;

public interface TagRepository extends JpaRepository<Tag, Long>{

	Optional<Tag> findByName(String tag);

}
