package com.example.myapplication.model;

import android.net.Uri;

import java.util.List;

public class Person {
  String id;
  String name;
  Uri profileImage;
  String email;
  List<Post> posts;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Uri getProfileImage() {
    return profileImage;
  }

  public void setProfileImage(Uri profileImage) {
    this.profileImage = profileImage;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public List<Post> getPosts() {
    return posts;
  }

  public void setPosts(List<Post> posts) {
    this.posts = posts;
  }
}
