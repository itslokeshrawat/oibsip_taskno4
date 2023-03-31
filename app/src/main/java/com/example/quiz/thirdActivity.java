package com.example.quiz;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class thirdActivity extends AppCompatActivity implements View.OnClickListener {

    public static String questions[]={
            "1. The most common use of the one dimensional array in c is",
            "2. The operator << and >> are ",
            "3. Who is the father of C language?",
            "4. All keywords in C are in ",
            "5. Which of the following cannot be a variable name in c?",
            "6. What is an example of iteration in c?",
            "7. What is #include<stdio.h>?",
            "8. The C-preprocessor are specified with    symbol.",
            "9. In C language,FILE is of which data type?",
            "10. Which is exit controlled loop?"
    };

    public static String choices[][]={
            {"function","data","character","string"},
            {"Assignment operators","Bitwise logical operators","Logical operators","Relational operators"},
            {"Steve Jobs","James Gosling","Dennis Ritchie","Ramus Lerdorf"},
            {"LowerCase","UpperCase","CamelCase","None of the above"},
            {"volatile","true","friend","export"},
            {"for","while","do_while","all of the mentioned"},
            {"Preprocessor directive","Inclusion directive","File inclusion directive","None of the mentioned"},
            {"#","$","^","&"},
            {"int","char *","struct","None of the above"},
            {"while","for","do-while","None of the above"}
    };

    public static String correctAnswers[]={
            "string",
            "Bitwise logical operators",
            "Dennis Ritchie",
            "LowerCase",
            "volatile",
            "all of the mentioned",
            "Preprocessor directive",
            "#",
            "struct",
            "do-while"

    };
    TextView total;
    TextView questionTextView;
    Button ansA,ansB,ansC,ansD;
    Button submitBtn;

    int score=0;
    int totalQuestion=questions.length;
    int currentQuestionIndex=0;
    String selectedAnswer="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);


        questionTextView=findViewById(R.id.question);
        total=findViewById(R.id.total);
        ansA=findViewById(R.id.ansA);
        ansB=findViewById(R.id.ansB);
        ansC=findViewById(R.id.ansC);
        ansD=findViewById(R.id.ansD);
        submitBtn=(Button) findViewById(R.id.submitBtn);

        ansA.setOnClickListener(this);
        ansB.setOnClickListener(this);
        ansC.setOnClickListener(this);
        ansD.setOnClickListener(this);
        submitBtn.setOnClickListener(this);

        total.setText("Total questions: "+totalQuestion);
        loadNewQuestion();
    }

    @Override

    public void onClick(View view) {

        ansA.setBackgroundColor(Color.GRAY);
        ansB.setBackgroundColor(Color.GRAY);
        ansC.setBackgroundColor(Color.GRAY);
        ansD.setBackgroundColor(Color.GRAY);


        Button clickedButton=(Button) view;
        if(clickedButton.getId()==R.id.submitBtn){
            if(selectedAnswer.equals(correctAnswers[currentQuestionIndex]))
            {
                score++;

            }
            currentQuestionIndex++;
            loadNewQuestion();
        }
        else
        {
            selectedAnswer=clickedButton.getText().toString();
            clickedButton.setBackgroundColor(Color.GREEN);
        }
    }

    void loadNewQuestion(){

        if(currentQuestionIndex==totalQuestion)
        {
            finishQuiz();
            return;
        }

        questionTextView.setText(questions[currentQuestionIndex]);
        ansA.setText(choices[currentQuestionIndex][0]);
        ansB.setText(choices[currentQuestionIndex][1]);
        ansC.setText(choices[currentQuestionIndex][2]);
        ansD.setText(choices[currentQuestionIndex][3]);
    }

    void finishQuiz()
    {
        String passStatus="";
        if(score>((totalQuestion*50)/100)){
            passStatus="Passed";
        }
        else
        {
            passStatus="Failed";
        }
        new AlertDialog.Builder(this)
                .setTitle(passStatus)
                .setMessage("score is "+score+"out of"+totalQuestion)
                .setPositiveButton("Restart",(dialogInterface, i) -> reStartQuiz())
                .show();
    }

    void reStartQuiz()
    {
        score=0;
        currentQuestionIndex=0;
        loadNewQuestion();
    }

}
