package com.example.quiz;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quiz.Adapters.CategoryAdapters;
import com.example.quiz.Models.CategoryModel;
import com.example.quiz.databinding.ActivityMainBinding;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    FirebaseAuth auth;
    FirebaseFirestore firebaseFirestore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        auth = FirebaseAuth.getInstance();
        firebaseFirestore=FirebaseFirestore.getInstance();


         ArrayList<CategoryModel>list=new ArrayList<>();
        CategoryAdapters categoryAdapters=new CategoryAdapters(list,this);

//....................set Category here........................
//
//        firebaseFirestore.collection("categories").addSnapshotListener(new EventListener<QuerySnapshot>() {
//            @Override
//            public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
//                list.clear();
//                for(DocumentSnapshot snapshot : value.getDocuments()){   //(A DocumentSnapshot contains data read from a document in your Cloud Firestore database. The data can be extracted with the getData()  or get(String)  methods.
//                                  If the DocumentSnapshot points to a non-existing document, getData()  and its corresponding methods will return null. You can always explicitly check for a document's existence by calling exists() .)
//                    CategoryModel model=snapshot.toObject(CategoryModel.class);
//                   // model.setId(snapshot.getId());
//                    list.add(model);
//                }
//                categoryAdapters.notifyDataSetChanged();
//            }
//        });
        list.add(new CategoryModel("0","Data Structure"));
        list.add(new CategoryModel("1","NIMCET"));
        list.add(new CategoryModel("2","Java"));
        list.add(new CategoryModel("3","Python"));

       // Toast.makeText(this, auth., Toast.LENGTH_SHORT).show();
        GridLayoutManager gridLayoutManager=new GridLayoutManager(this,2);
        binding.recylerView.setLayoutManager(gridLayoutManager);
        binding.recylerView.setAdapter(categoryAdapters);
        //Toast.makeText(this, list.size()+"completed", Toast.LENGTH_SHORT).show();




    }
// .......................call menu item here.................................
        @Override
        public boolean onCreateOptionsMenu (Menu menu){
            MenuInflater menuInflater = getMenuInflater();
            menuInflater.inflate(R.menu.menu, menu);
            return super.onCreateOptionsMenu(menu);
        }

        @Override
        public boolean onOptionsItemSelected (@NonNull MenuItem item){
            switch (item.getItemId()) {
                case R.id.logout:
                    auth.signOut();
                    startActivity(new Intent(MainActivity.this, LoginActivity.class));
                    finish();
                    break;
                case R.id.profile:
                    Toast.makeText(MainActivity.this, "Profile", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(MainActivity.this,AccountActivity.class));
                    break;
                case R.id.leaderboard:
                    Toast.makeText(MainActivity.this, "Leaderboard", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(MainActivity.this,Leaderboard.class));
                    break;

            }
            return true;
        }
    }

