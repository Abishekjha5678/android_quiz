package com.example.quiz.Models;

public class LeaderboardModels {
    String name,score,id,subj;

    public LeaderboardModels(String name, String score,String id,String Subj) {
        this.name = name;
        this.score = score;
        this.id=id;
        this.subj=Subj;
    }

    public String getId() {
        return id;
    }

    public String getSubj() {
        return subj;
    }

    public void setSubj(String subj) {
        this.subj = subj;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LeaderboardModels() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }
}
