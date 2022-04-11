package com.truelogic.demo.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "Albums")
public class Album {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "albums_sequence")
    @SequenceGenerator(name="albums_sequence", sequenceName="albums_seq")
    private Long id;

    @NotBlank(message = "Title is required")
    @Column(name = "title")
    private String title;

    @NotBlank(message = "Url is required")
    @Column(name = "url")
    private String url;

    @NotBlank(message = "thumbnailUrl is required")
    @Column(name = "thumbnailUrl")
    private String thumbnailUrl;

    @Override
    public String toString() {
        return "Album [id=" + id + ", title=" + title + ", thumbnailUrl=" + thumbnailUrl + ", url=" + url + "]";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }
}