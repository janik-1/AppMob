/**
 * Project: Geography Quiz
 *
 * Purpose: A beginner app to develop a basic understanding of
 *          Android development and in particular how a main activity
 *          and layout interact. This app prompts the user with true/false
 *          questions about geography.
 *
 * File:    GeoQuiz.java
 * Author:  Samantha Romano
 *
 * Resource: Android Programming - The Big Nerd Ranch Guide 3rd Edition
 *
 */
package com.example.sromano.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class GeoQuiz extends AppCompatActivity {

    private Button mTrueButton;
    private Button mFalseButton;
    private ImageButton mNextButton;
    private ImageButton mPrevButton;
    private TextView mQuestionTextView;
    private int mCurrentIndex = 0;
    private int counter = -1;
    private double result;
    private static final String TAG = "Quiz Activity";

    /**
     * A Question Array that will prompt one at a time to the user to answer.
     */
    private Question[] mQuestionBank = new Question[] {
            new Question(R.string.question_australia, true),
            new Question(R.string.question_oceans, true),
            new Question(R.string.question_mideast, false),
            new Question(R.string.question_africa, false),
            new Question(R.string.question_asia, true)

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_geo_quiz);
        Log.d(TAG, "onCreate(Bundle) called");

        mQuestionTextView = (TextView) findViewById(R.id.question_text_view);

       updateQuestion();


        mTrueButton = (Button) findViewById(R.id.true_btn);
        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                    mQuestionBank[mCurrentIndex].clickedAnswer();
                    checkAnswer(true);


            }
        });


        mFalseButton = (Button) findViewById(R.id.false_btn);
        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    mQuestionBank[mCurrentIndex].clickedAnswer();
                    checkAnswer(false);


            }
        });

        mNextButton = (ImageButton) findViewById(R.id.next_btn);
        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentIndex = (mCurrentIndex + 1) % mQuestionBank.length;
                updateQuestion();
            }
        });

        mPrevButton = (ImageButton) findViewById(R.id.prev_btn);
        mPrevButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mCurrentIndex == 0) {
                    mCurrentIndex =  mQuestionBank.length - 1;
                }
                else {
                    mCurrentIndex = (mCurrentIndex - 1) % mQuestionBank.length;
                }
                updateQuestion();
            }
        });


    }


    /**
     * Method searches for question in Question Array based on current counter and sets
     * the display to either next or previous question.
     */
    private void updateQuestion() {

        int question = mQuestionBank[mCurrentIndex].getTextResId();
        mQuestionTextView.setText(question);
        counter++;
        allAnswered(counter);
    }

    /**
     * checkAnswer - method validates from user interaction whether the answer is true or false.
     * @param userPressed - True/False response from user to use as comparison to actual answer.
     */
    private void checkAnswer(boolean userPressed) {
        boolean answer = mQuestionBank[mCurrentIndex].isAnswerTrue();
        int messageID = 0;

        if(answer == userPressed) {
            messageID = R.string.correct_toast;
            result = result + 1;
            Log.d("Result Correct", String.valueOf(result));
        }
        else {
            messageID = R.string.incorrect_toast;
            Log.d("Result Incorrect", String.valueOf(result));
        }
        // Displays Correct or Incorrect on the screen
        Toast.makeText(GeoQuiz.this, messageID, Toast.LENGTH_SHORT).show();



    }

    /**
     * Method to calculate the grade user got.
     * @param grade pass in the number correct
     */
    private void finishedQuiz(double grade) {
        Log.d("Incoming Grade", String.valueOf(grade));
        double finalGrade = 100*(grade/(double)(mQuestionBank.length));
        Log.d("Final Grade", String.valueOf(finalGrade));
        Toast.makeText(GeoQuiz.this, "Grade is " + String.valueOf(finalGrade)
                + "%", Toast.LENGTH_LONG).show();
        onStop();
    }

    /**
     * Method to check whether an answer has been selected for each
     * question.
     * @param counter - global variable to track each answer.
     */
    private void allAnswered(int counter) {
      if(counter >= mQuestionBank.length)
       {
            finishedQuiz(result);
       }
    }

    @Override
    public void onStart(){
        super.onStart();
        Log.d(TAG, "onStart() called");
    }

    @Override
    public void onResume(){
        super.onResume();
        Log.d(TAG, "onResume() called");
    }

    @Override
    public void onPause(){
        super.onPause();
        Log.d(TAG, "onPause() called");
    }

    @Override
    public void onStop(){
        super.onStop();
        Log.d(TAG, "onStop() called");
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        Log.d(TAG, "onDestroy() called");
    }

}
