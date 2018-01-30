package com.example.vaughant.helloandroidstudio;

import android.widget.TextView;

/**
 * Created by vaughant on 15/01/2018.
 */

public class TestBaseClass {

    public void doSomething(TextView tv){
        String text = "This is method DoSomething from TestBaseClass";
        setTextViewText(tv, text);
    }
     public void setTextViewText(TextView tv, String text){
         tv.setText(text);
         System.out.println(text);
     }
}
