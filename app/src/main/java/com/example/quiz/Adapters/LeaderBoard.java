package com.example.quiz.Adapters;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quiz.Models.LeaderboardModels;
import com.example.quiz.Models.Users;
import com.example.quiz.R;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;


public class LeaderBoard extends RecyclerView.Adapter<LeaderBoard.viewHolder>{
Context context;
ArrayList<LeaderboardModels>alldata;

    public LeaderBoard(ArrayList<LeaderboardModels> users,Context context) {
        this.context = context;
        this.alldata = users;
    }


    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.sample_leaderboard,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
    LeaderboardModels model=alldata.get(position);
    holder.id.setText(model.getId());
    holder.email.setText(model.getName());
    holder.score.setText(model.getScore());
   // holder.subj.setText(model.getSubj());

        //Toast.makeText(context, "adsfdffadfs", Toast.LENGTH_SHORT).show();

    }

    @Override
    public int getItemCount() {
        return alldata.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder{
       TextView id,email,score,subj;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            id=itemView.findViewById(R.id.userid);
            email=itemView.findViewById(R.id.username);
            score=itemView.findViewById(R.id.userscore);
           // subj=itemView.findViewById(R.id.usersubj);
        }
    }
}
