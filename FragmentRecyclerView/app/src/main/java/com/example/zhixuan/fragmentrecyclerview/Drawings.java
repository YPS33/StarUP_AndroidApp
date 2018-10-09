package com.example.zhixuan.fragmentrecyclerview;

public class Drawings {
    private int image;
    private String author;
    private String content;

    public Drawings(int image, String author, String content){
        super();
        this.image = image;
        this.author = author;
        this.content = content;
    }
    public int getImage(){
        return image;
    }
    public String getAuthor(){
        return author;
    }
    public String getContent(){
        return content;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
