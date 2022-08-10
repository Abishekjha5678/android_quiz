package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quiz.Adapters.LeaderBoard;
import com.example.quiz.Models.Users;
import com.example.quiz.databinding.ActivityScoreBoardBinding;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ScoreBoard extends AppCompatActivity {
    RecyclerView recyclerView;
    TextView name,score;
    FirebaseAuth auth;
    FirebaseFirestore firebaseFirestore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_board);
        name=findViewById(R.id.resultName);
        score=findViewById(R.id.result);
        auth=FirebaseAuth.getInstance();
        firebaseFirestore=FirebaseFirestore.getInstance();
        Intent intent=getIntent();

        name.setText("your Score");
        String total=intent.getStringExtra("total");
        String res=intent.getStringExtra("marks");
        score.setText(res+" / "+total);
        intent.putExtra("score",res);
        intent.putExtra("total",total);
//      //  String str=intent.getStringExtra("categoryID");
//        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
        Database db=new Database(this);
        String email=auth.getCurrentUser().getEmail();

        db.insert(email,res);

        //startActivity(new Intent(ScoreBoard.this,MainActivity.class));

//        ArrayList<Users>users=new ArrayList<>();
//        LeaderBoard leaderBoard=new LeaderBoard(this,users);
//        recyclerView.setAdapter(leaderBoard);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        FirebaseFirestore firebaseFirestore=FirebaseFirestore.getInstance();
//        firebaseFirestore.collection("users").orderBy("score", Query.Direction.DESCENDING).get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
//            @Override
//            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
//                for(DocumentSnapshot snapshot:queryDocumentSnapshots){
//                    Users user=snapshot.toObject(Users.class);
//                    users.add(user);
//                }
//                leaderBoard.notifyDataSetChanged();
//            }
//        });

    }
}