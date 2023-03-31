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

public class fourthActivity extends AppCompatActivity implements View.OnClickListener {

    public static String questions[]={
            "1. Who developed Python programming language?",
            "2. Which is correct extension of the python file?",
            "3. Which keyword is used for function in python?",
            "4. Which of the following is the truncation division operator in python?",
            "5. Which of these is not a core data type in python?",
            "6. What is output of print(math.pow(3,2))?",
            "7. Which arithmetic operators cannot be used with strings?",
            "8. Which of the following statements is used to create an empty set in python?",
            "9. To add a new element to a list we use which python command?",
            "10. Which function overloads the ==operator?"
    };

    public static String choices[][]={
            {"Wick van Rossum","Rasmus Lerdorf","Guido van Rossum","Niene Stom"},
            {".python",".pl",".py",".p"},
            {"Function","def","Fun","Define"},
            {"/","//","|","%"},
            {"Tuples","Lists","Class","Dictionary"},
            {"9.0","None","9","None of the above"},
            {"+","*","-","All of the mentioned"},
            {"()","[]","{}","set()"},
            {"list1.addEnd(5)","list1.addLast(5)","list1.append(5)","list1.add(5)"},
            {"_eq_()","_equ_()","_isequal_()","none of the above"}
    };

    public static String correctAnswers[]={
            "Guido van Rossum",
            ".py",
            "def",
            "//",
            "Class",
            "9.0",
            "-",
            "set()",
            "list1.append(5)",
            "_eq_()"
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
