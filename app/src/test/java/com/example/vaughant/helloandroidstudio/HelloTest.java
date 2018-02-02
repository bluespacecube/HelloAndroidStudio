package com.example.vaughant.helloandroidstudio;

import android.content.Context;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by vaughant on 02/02/2018.
 */
@RunWith(MockitoJUnitRunner.class)
public class HelloTest {

    private static final String TEST_STRING = "Hello world";

    @Mock
    Context mockContext;

    @Test
    public void readStringFromContext_LocalisedString(){
        //
        when(mockContext.getString(R.string.hello_world)).thenReturn(TEST_STRING);
        //
    }

}
