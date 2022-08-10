package com.example.quiz.Models;

public class CategoryModel {
  private  String Name,id;

    public CategoryModel(String id,String name) {
        this.Name = name;
        this.id=id;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }


}
