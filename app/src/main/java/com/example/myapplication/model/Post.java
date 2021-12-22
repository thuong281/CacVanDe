package com.example.myapplication.model;

import android.net.Uri;

public class Post {
  String id;
  String title;
  Person author;
  Uri image;
  String content;

  public Post(String id, String title, Person author, Uri image, String content) {
    this.id = id;
    this.title = title;
    this.author = author;
    this.image = image;
    this.content = content;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Person getAuthor() {
    return author;
  }

  public void setAuthor(Person author) {
    this.author = author;
  }

  public Uri getImage() {
    return image;
  }

  public void setImage(Uri image) {
    this.image = image;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }
}
