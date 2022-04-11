package com.truelogic.demo.controller;

import com.truelogic.demo.model.Album;
import com.truelogic.demo.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping(value = "/album")
public class AlbumController {

    @Autowired
    private AlbumService albumService;

    private final static Logger LOGGER =
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Album>> getAllAlbums() {
        List<Album> albums = albumService.getAllAlbums();
        return new ResponseEntity<>(albums, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Album> createAlbum(@RequestBody Album albumDTO) {
        Album album = albumService.createAlbum(albumDTO);
        return new ResponseEntity<>(album, HttpStatus.OK);
    }

    @RequestMapping(value = "/{albumId}", method = RequestMethod.GET)
    public ResponseEntity<Album> findById(@PathVariable("albumId")Long albumId) {
        Optional<Album> product = albumService.findById(albumId);
        return product.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));

    }
}
