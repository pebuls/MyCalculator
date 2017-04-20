package com.mobile.pebuls.mycalculator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view)
    {
        Intent i;
        if(view.getId()==R.id.simCal)
        {
            i =new Intent(this,SimpleCal.class);
            startActivity(i);
        }
        else if(view.getId()==R.id.sciCal)
        {
            i=new Intent(this,AdvancedCal.class);
            startActivity(i);
        }
        else if(view.getId()==R.id.about)
        {
            Toast.makeText(getBaseContext(), "I informed You that I'm lazy" , Toast.LENGTH_SHORT ).show();
        }
        else if(view.getId()==R.id.exit)
        {
            finish();
        }
    }
}
