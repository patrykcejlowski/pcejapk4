package com.example.pepe.calculator;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onButtonClick(View v)
    {
        //2 text fields - edit texts
        EditText a1 = (EditText) findViewById(R.id.TFnum1);
        EditText a2 = (EditText) findViewById(R.id.TFnum2);


        //1 Result label - Edit Text

        TextView tv = (TextView) findViewById(R.id.Lresult);
        boolean flag = false; //no division by 0 error
        double num1, num2, res;
        num1 = Double.parseDouble(a1.getText().toString());
        num2 = Double.parseDouble(a2.getText().toString());
        res = 0;

        if(v.getId() == R.id.Badd)
            res = num1 + num2;
        if(v.getId() == R.id.Bmin)
            res = num1 - num2;
        if(v.getId() == R.id.Bmul)
            res = num1 * num2;
        if(v.getId() == R.id.Bdiv)
            //div by 0 error
            if(num2 == 0)
                flag = true;
            else
                res = num1 / num2;
        tv.setText(res+"");

    }

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
}
