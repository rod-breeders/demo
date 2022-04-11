package com.truelogic.demo.repository;


import com.truelogic.demo.model.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Long> {

	List<Album> findAll();

	Album save(Album album);

	Optional<Album> findById(Long albumId);
}