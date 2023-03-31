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

public class secondActivity extends AppCompatActivity implements View.OnClickListener {

    public static String questions[]={
            "1. Who is invented java?",
             "2. HashSet internally uses?",
            "3. Which of those is synchronized",
            "4. java.util.Collection is a:",
            "5. Which of those allows duplicate elements?",
            "6. What is the use of 'javac' command?",
            "7. Which allows the removal of elements from a collection?",
            "8. What is the extension of java code files?",
            "9. Which of the following is not an oops concept in java?",
            "10. Which of these are selection statements in java?"
    };

    public static String choices[][]={
        {"Games Gosling","Dennis Ritchie","Bjarne stroustrup","Guido van Rossum"},
        {"Set","HashMap","List","Collection"},
            {"ArrayList","LinkedList","Vector","None of the above"},
        {"class","interface","object","None of the above"},
        {"Set","List","All","None of the above"},
            {"Execute a program","Debug a program","Interpret a program","Compile a program"},
            {"Enumeration","Iterator","Both","None of the above"},
            {".js",".txt",".class",".java"},
            {"Polymorphism","Inheritance","Compilation","Encapsulation"},
            {"break","continue","for()","if()"}
    };

    public static String correctAnswers[]={
          "Games Gosling",
            "Set",
            "Vector",
            "class",
            "List",
            "Compile a program",
            "None of the above",
            ".java",
            "Compilation",
            "if()"
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
