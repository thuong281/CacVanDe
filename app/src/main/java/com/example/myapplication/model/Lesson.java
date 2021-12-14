package com.example.myapplication.model;

import java.util.ArrayList;
import java.util.List;

public class Lesson {
    private String name;
    private int imageRsc;
    private List<Group> groups = new ArrayList();

    public int getImageRsc() {
        return imageRsc;
    }

    public void setImageRsc(int imageRsc) {
        this.imageRsc = imageRsc;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    public Lesson(String name, int imageRsc) {
        this.name = name;
        this.imageRsc = imageRsc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return imageRsc;
    }

    public void setImage(int image) {
        this.imageRsc = image;
    }
}
