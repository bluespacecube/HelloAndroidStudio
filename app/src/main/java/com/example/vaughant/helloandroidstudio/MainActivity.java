package com.example.vaughant.helloandroidstudio;

import android.app.AlertDialog;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int dynTvCounter = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar =  findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        Button btn = findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                TextView f = new TextView(getApplicationContext());
                LinearLayout linlay = findViewById(R.id.items_linLay);
                Snackbar.make(view, "Hi!", Snackbar.LENGTH_SHORT).show();
                f.setText("Dynamically added text view "+ dynTvCounter);
                dynTvCounter += 1;
                linlay.addView(f);
            }
        });
    }

    // maybe make a library or something (for dialogs, etc...)
    // figure out unit testing
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void testInheriClick(View view) {
        TestInheritance testInheritance = new TestInheritance();
        TextView tv = findViewById(R.id.myTextView);
        testInheritance.doSomething(tv);
    }

    public void testBaseClick(View view) {
        TestBaseClass testBaseClass = new TestBaseClass();
        TextView tv = findViewById(R.id.myTextView);
        testBaseClass.doSomething(tv);
    }

    public void testDialogBtnClick(View view) {
        Sapphire("Player ??? Wins!", "OPps?", null,true, true);
    }
    public void Sapphire(String msg, String btnmsg, Drawable img, Boolean cancelable, Boolean cancelableany) {
        View deleteDialogView = LayoutInflater.from(this).inflate(R.layout.cust_popup, null);
        final AlertDialog deleteDialog2 = new AlertDialog.Builder(this).create();
        deleteDialog2.setView(deleteDialogView);
        deleteDialogView.findViewById(R.id.saph_btn).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                deleteDialog2.dismiss();
            }
        });
        if (cancelableany.booleanValue()) {
            deleteDialogView.findViewById(R.id.saph_linlay).setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    deleteDialog2.dismiss();
                }
            });
        }
        ((Button) deleteDialogView.findViewById(R.id.saph_btn)).setText(btnmsg);
        ImageView op = deleteDialogView.findViewById(R.id.saph_imgview);
        ((TextView) deleteDialogView.findViewById(R.id.saph_txt)).setText(msg);
        if (img != null) {
            op.setImageDrawable(img);
        }
        Window window = deleteDialog2.getWindow();
        window.setLayout(-2, -2);
        window.setGravity(17);
        deleteDialog2.setCancelable(cancelable.booleanValue());
        deleteDialog2.show();
    }
}
