package com.malgo.malgoserver.image.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupImageRepository extends JpaRepository<GroupImage, Long> {}
