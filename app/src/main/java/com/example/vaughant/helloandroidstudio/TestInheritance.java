package com.example.vaughant.helloandroidstudio;

import android.widget.TextView;

/**
 * Created by vaughant on 15/01/2018.
 */

public class TestInheritance extends TestBaseClass {


    @Override
    public void doSomething(TextView tv) {
        //super.doSomething();
        String text = "This is method DoSomething from TestInheritance that extends TestBaseClass";
        setTextViewText(tv,text);
    }
}
