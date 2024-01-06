package com.tpanh.dinehub.reponsitory;

import com.tpanh.dinehub.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Integer> {
}