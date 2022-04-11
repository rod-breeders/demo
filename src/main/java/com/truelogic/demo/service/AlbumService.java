package com.truelogic.demo.service;

import com.truelogic.demo.model.Album;
import com.truelogic.demo.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service
@Validated
public class AlbumService {

	@Autowired
	private AlbumRepository albumRepository;


	public List<Album> getAllAlbums(){
		return albumRepository.findAll();
	}


	public Album createAlbum(@Valid Album album) {
		return albumRepository.save(album);
	}

	public Optional<Album> findById(Long albumId){
		return albumRepository.findById(albumId);
	}
}
