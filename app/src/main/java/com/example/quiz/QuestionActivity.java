package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quiz.Models.CategoryModel;
import com.example.quiz.databinding.ActivityQuestionBinding;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Random;

public class QuestionActivity extends AppCompatActivity {
    ActivityQuestionBinding binding;
    ArrayList<QuestionAnswer>questionAnswers;

    QuestionAnswer Question;
    FirebaseFirestore database;
    int index=0;
    int Count=0;
    CountDownTimer timer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        binding=ActivityQuestionBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        questionAnswers=new ArrayList<>();


        binding.exitTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(QuestionActivity.this,ScoreBoard.class);
                String res=String.valueOf(Count);
                intent.putExtra("marks",res);
                String total=String.valueOf(questionAnswers.size());
                intent.putExtra("total",total);
                startActivity(intent);
                finish();
            }
        });




//        Random random=new Random();
//        final int rand=random.nextInt(5);
//        database=FirebaseFirestore.getInstance();
//        final String catId=getIntent().getStringExtra("categoryId");
//        Toast.makeText(this, catId, Toast.LENGTH_SHORT).show();
//        Toast.makeText(this, catId, Toast.LENGTH_SHORT).show();
//        database.collection("categories").document(catId).collection("questions")
//                .orderBy("index")
//                .limit(3).get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
//            @Override
//            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
//                if(queryDocumentSnapshots.getDocuments().size()<3){
//                    database.collection("categories")
//                            .document(catId)
//                            .collection("questions")
//                            .whereLessThanOrEqualTo("index",rand)
//                            .orderBy("index")
//                            .limit(3).get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
//                        @Override
//                        public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
//                                for(DocumentSnapshot snapshot:queryDocumentSnapshots){
//                                    QuestionAnswer question=snapshot.toObject(QuestionAnswer.class);
//                                    questionAnswers.add(question);
//                                }
//                                setNextQuestion();
//                        }
//                    });
//                }else{
//                    for(DocumentSnapshot snapshot:queryDocumentSnapshots){
//                        QuestionAnswer question=snapshot.toObject(QuestionAnswer.class);
//                        questionAnswers.add(question);
//                    }
//                    setNextQuestion();
//                }
//            }
//        });
//
//
    Intent intent=getIntent();
    String id=intent.getStringExtra("categoryId");
       // Toast.makeText(this, id+" aa gaya", Toast.LENGTH_SHORT).show();
        if(id.equals("0")){
    questionAnswers.add(new QuestionAnswer("Which of the following is not the type of queue?","Priority Queue","Single-Ended Queue","Circular Queue","Ordinary Queue","Single-Ended Queue"));
    questionAnswers.add(new QuestionAnswer("LIFO stands for ","Last In First Out"," Late In First Out" ," Light In Figure Out" ," None of the Above","Last In First Out"));
    questionAnswers.add(new QuestionAnswer("On which element we perform insertion and deletion operation is stacks","Front","Rear","Top","None of the Above","Top"));
    questionAnswers.add(new QuestionAnswer("Pick out the non-linear data sturcture","Array","Tree","Stack","String","Tree"));
    questionAnswers.add(new QuestionAnswer("The queues follow","LIFO","FIFO","LILO","NONE","FIFO"));
        }
        else if(id.equals("1")){
            questionAnswers.add(new QuestionAnswer("If A2 – A + I = 0, then the inverse of A is","A + I","A","A – I","I – A ","I – A"));
        questionAnswers.add(new QuestionAnswer("Let P be the point (1, 0) and Q a point on the locus y2 = 8x. The locus of mid point of PQ is"," y2 – 4x + 2 = 0"," y2 + 4x + 2 = 0","x2 + 4y + 2 = 0","x2 - 4y + 2 = 0"," y2 – 4x + 2 = 0"));
        questionAnswers.add(new QuestionAnswer("Let f be differentiable for all x. If f(1) = - 2 and f′(x) ≥ 2 for x ∈ [1, 6] , then\n"," f(6) ≥ 8","f(6) < 8","f(6) < size=\"2\">","f(6) > 8"," f(6) ≥ 8"));
        questionAnswers.add(new QuestionAnswer("If in a triangle ABC, the altitudes from the vertices A, B, C on opposite sides are in H.P., then sin A, sin B, sin C are in","G.P","A.P","AP,GP,HP","HP","A.P"));
        questionAnswers.add(new QuestionAnswer("\t\n" +
                "A computer assisted method for the recording and analyzing of existing or hypothetical systems is","Data transmission","Data flow","Data capture","Data processing","Data flow"));
        questionAnswers.add(new QuestionAnswer("The brain of any computer system is","ALU","Memory","CPU","Control Unit","CPU"));
        questionAnswers.add(new QuestionAnswer("Which of the following is the 1's complement of 10?","01","110","11","10","01"));
        questionAnswers.add(new QuestionAnswer("The binary system uses powers of","2","10","8","16","2"));
        questionAnswers.add(new QuestionAnswer("\t\n" +
                "The time for which a piece of equipment operates is called","Seek time","Effective time","Access time","Real time","Effective time"));
        questionAnswers.add(new QuestionAnswer("\t\n" +
                "The time required for the fetching and execution of one simple machine instruction is","Delay time","CPU cycle","Seek time","Real time","CPU cycle"));
        questionAnswers.add(new QuestionAnswer("\t\n" +
                "The radian of a number system","Is variable","Has nothing to do with digit position value","Equals the number of its distinct counting digits","Is always an even number","Equals the number of its distinct counting digits"));
        }
        else if(id.equals("2")) {
            questionAnswers.add(new QuestionAnswer("What is Java ?", "A Programming Language", "An IDE", "A Compiler", "Scientiest Name", "A Programming Language"));
            questionAnswers.add(new QuestionAnswer("Java language was initially called as ________", "Sumatra", "J++", "Oak", "Pine", "Oak"));
            questionAnswers.add(new QuestionAnswer("Data type long literals are appended by _____", "Uppercase L", "Lowercase L", "Long", "Both A and B", "Both A and B"));
            questionAnswers.add(new QuestionAnswer("Who is known as father of Java Programming Language?", "James Gosling", "M. P Java", "Charls Babbage", "Blais Pasca", "James Gosling"));
            questionAnswers.add(new QuestionAnswer("Which provides runtime environment for java byte code to be executed?", "JDK", "JVM", "JRE", "JAVAC", "JVM"));
            questionAnswers.add(new QuestionAnswer("What is byte code in Java?", "Code generated by a Java compiler", "Code generated by a Java Virtual Machine", "Name of Java source code file", "Block of code written inside a class", "Code generated by a Java compiler"));
            questionAnswers.add(new QuestionAnswer("Which of the following are not Java keywords ?", "double", "switch", "Then", "instanceof", "Then"));
            questionAnswers.add(new QuestionAnswer("Which of these have highest precedence?", "()", "*", "++", ">>", "()"));
            questionAnswers.add(new QuestionAnswer("Which of these is returned by operator '&' ?", "Character", "Boolean", "Float", "Integer", "Character"));
            questionAnswers.add(new QuestionAnswer("Number of primitive data types in Java are?", "6", "7", "8", "9", "8"));
            questionAnswers.add(new QuestionAnswer(" \n" +
                    "What is the size of float and double in java?", "32 and 64", "32 and 32", "64 and 64", "64 and 32", "32 and 64"));

         //   Toast.makeText(this, "000000", Toast.LENGTH_SHORT).show();
        }
        else if(id.equals("3")){
        questionAnswers.add(new QuestionAnswer("Who developed Python Programming Language?","Wick van Rossum","Rasmus Lerdorf","Guido van Rossum","Niene Stom","Guido van Rossum"));
        questionAnswers.add(new QuestionAnswer("Which of the following is the correct extension of the Python file?",".python",".pl",".py",".p",".py"));
        questionAnswers.add(new QuestionAnswer("All keywords in Python are in _________","Capitalized","lower case","UPPER CASE","None of the mentioned","None of the mentioned"));
        questionAnswers.add(new QuestionAnswer(" Which one of the following is not a keyword in Python language?","pass","eval","assert","nonlocal","eval"));
        questionAnswers.add(new QuestionAnswer("What arithmetic operators cannot be used with strings in Python?","+","-","*","All of the mentioned","-"));
        }


         resetTimer();
        setNextQuestion();

    }
    void setNextQuestion(){
        if(timer!=null){
            timer.cancel();
        }
        timer.start();
       // Toast.makeText(this, questionAnswers.size(), Toast.LENGTH_SHORT).show();
        if(index<questionAnswers.size()){
            //binding.questionNumber.setText(index+ " / "+questionAnswers.size());
            binding.questionNumber.setText(String.format("%d / %d", index+1,questionAnswers.size()));
            Question=questionAnswers.get(index);
            binding.questions.setText(Question.getQuestion());
            binding.optionOne.setText(Question.option1);
            binding.option2.setText(Question.option2);
            binding.option3.setText(Question.option3);
            binding.option4.setText(Question.option4);
        }

    }

    public void resetOption(){
        binding.optionOne.setBackground(getResources().getDrawable(R.drawable.answer));
        binding.option2.setBackground(getResources().getDrawable(R.drawable.answer));
        binding.option3.setBackground(getResources().getDrawable(R.drawable.answer));
        binding.option4.setBackground(getResources().getDrawable(R.drawable.answer));
    }
    public void showCorrectAnswer(){

        if(Question.getAnswer().equals(binding.optionOne.getText().toString())){
            binding.optionOne.setBackground(getResources().getDrawable(R.drawable.right_question));
        }
        else if(Question.getAnswer().equals(binding.option2.getText().toString())){
            binding.option2.setBackground(getResources().getDrawable(R.drawable.right_question));
        }
         else if(Question.getAnswer().equals(binding.option3.getText().toString())){
            binding.option3.setBackground(getResources().getDrawable(R.drawable.right_question));
        }else if(Question.getAnswer().equals(binding.option4.getText().toString())){
            binding.option4.setBackground(getResources().getDrawable(R.drawable.right_question));
        }

    }

    void resetTimer(){
        timer=new CountDownTimer(60000,1000) {
            @Override
            public void onTick(long l)
            {
            binding.timer.setText(String.valueOf(l/1000));
            }
            @Override
            public void onFinish() {setNextQuestion();
            }
        };
    }

    public void answerCorrect(TextView textView){

        String selectedAnswer=textView.getText().toString();
        if(selectedAnswer.equals(Question.getAnswer())){
            Count++;
            textView.setBackground(getResources().getDrawable(R.drawable.right_question));
        }else{
            showCorrectAnswer();
            textView.setBackground(getResources().getDrawable(R.drawable.wrong_question));
        }
    }

    public void onClick(View view){

        switch (view.getId()){

            case R.id.optionOne:
            case R.id.option2:
            case R.id.option3:
            case R.id.option4:
                if(timer!=null){
                    timer.cancel();
                }
                TextView selected =(TextView) view;
                answerCorrect(selected);
                break;
            case R.id.next:
                 resetOption();
                if(index<questionAnswers.size()) {
                    index++;
                    setNextQuestion();


                    if(index>=questionAnswers.size())
                    {
                        binding.next.setVisibility(View.INVISIBLE);
                      Intent intent=new Intent(QuestionActivity.this,ScoreBoard.class);
                        String res=String.valueOf(Count);
                        intent.putExtra("marks",res);
                        String total=String.valueOf(questionAnswers.size());
                        intent.putExtra("total",total);
                        startActivity(intent);
                        finish();
                    }
                }else{
                   // binding.questionNumber.setText(index+" / "+questionAnswers.size());

                    Toast.makeText(this, "Question Finished", Toast.LENGTH_SHORT).show();

            }
                break;
        }
    }
}