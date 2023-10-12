package com.example.youtubeclone.model;

public class Video {
    private String titulo="";
    private String descricao="";
    private String data="";
    private String thumbnail="";
    private String videoId="";

    public Video() {
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String tituloVideo) {
        this.titulo = tituloVideo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }
}
