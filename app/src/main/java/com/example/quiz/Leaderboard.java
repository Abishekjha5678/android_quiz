package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.quiz.Adapters.LeaderBoard;
import com.example.quiz.Models.LeaderboardModels;

import java.util.ArrayList;

public class Leaderboard extends AppCompatActivity {
RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leaderboard);
        getSupportActionBar().setTitle("LeaderBoard");
        ArrayList<LeaderboardModels>alldata;
//
      recyclerView=findViewById(R.id.leaderboard_recylerview);
       Database db=new Database(this);
        alldata=db.getScore();
        Toast.makeText(this, alldata.size()+" ", Toast.LENGTH_SHORT).show();
        LeaderBoard leaderBoard=new LeaderBoard(alldata,this);
        recyclerView.setAdapter(leaderBoard);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);

    }
}