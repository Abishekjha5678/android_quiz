package com.example.quiz.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quiz.Models.CategoryModel;
import com.example.quiz.QuestionActivity;
import com.example.quiz.R;

import java.util.ArrayList;

public class CategoryAdapters extends RecyclerView.Adapter<CategoryAdapters.viewHolder>{
ArrayList<CategoryModel>categoryModels;
Context context;

    public CategoryAdapters(ArrayList<CategoryModel> categoryModels, Context context) {
        this.categoryModels = categoryModels;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.sample_recylerview,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
    CategoryModel categoryModel=categoryModels.get(position);
    holder.textViewName.setText(categoryModel.getName());

    switch (position){
        case 0:
            holder.textViewName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(context,"Start Test Of Data Structure",Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(context,QuestionActivity.class);
                    intent.putExtra("categoryId","0");
                    context.startActivity(intent);

                }
            });
            break;
        case 1:
            holder.textViewName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent intent=new Intent(context,QuestionActivity.class);
                    intent.putExtra("categoryId","1");
                    context.startActivity(intent);
                    Toast.makeText(context,"Start Test Of NIMCET",Toast.LENGTH_SHORT).show();
                }
            });
            break;
        case 2:
            holder.textViewName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent intent=new Intent(context,QuestionActivity.class);

                    intent.putExtra("categoryId","2");
                    context.startActivity(intent);
                    Toast.makeText(context,"Start Test Of Java",Toast.LENGTH_SHORT).show();
                }
            });
            break;
        case 3:
            holder.textViewName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent=new Intent(context,QuestionActivity.class);
                    intent.putExtra("categoryId","3");
                    context.startActivity(intent);
                    Toast.makeText(context,"Start Test Of Python",Toast.LENGTH_SHORT).show();
                }
            });
            break;
        default:
        }
    }


    @Override
    public int getItemCount() {
        return categoryModels.size();
    }

    public  class viewHolder extends RecyclerView.ViewHolder {
        TextView textViewName;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            textViewName=itemView.findViewById(R.id.nimcet);
        }
    }
}
