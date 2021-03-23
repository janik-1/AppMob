/**
 * Project: Geography Quiz
 *
 * Purpose: A class to set up the structure to develop trivia questions.
 *
 * File:    Question.java
 * Author:  Samantha Romano
 *
 * Resource: Android Programming - The Big Nerd Ranch Guide 3rd Edition
 *
 */

package com.example.sromano.myapplication;

public class Question {

    private int mTextResId;
    private boolean mAnswerTrue;
    private boolean answered = false;

    public Question(int textResId, boolean AnswerTrue) {
        mTextResId = textResId;
        mAnswerTrue = AnswerTrue;
    }
    public int getTextResId() {
        return mTextResId;
    }

    public void setTextResId(int textResId) {
        mTextResId = textResId;
    }

    public boolean isAnswerTrue() {
        return mAnswerTrue;
    }

    public void setAnswerTrue(boolean answerTrue) {
        mAnswerTrue = answerTrue;
    }

    public void clickedAnswer() {
        answered = true;
    }

    public boolean getClickedAnswer() {
        return answered;
    }

    public int correct(boolean answer){
        int result = 0;
        if(answer == true)
        {
            return ++result;
        }
        else {
            return --result;
        }
    }

}
