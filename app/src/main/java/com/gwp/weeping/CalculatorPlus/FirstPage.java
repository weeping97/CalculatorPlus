package com.gwp.weeping.CalculatorPlus;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


/**
 * Created by WeePinG on 10/2/2018.
 */

public class FirstPage extends AppCompatActivity{

    public Button calcbutton;
    public Button unitbutton;

    public void gotoMain(){
        calcbutton = findViewById(R.id.buttonCalc);
        calcbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent it = new Intent(FirstPage.this, MainActivity.class);

                startActivity(it);
            }
        });
    }

    public void gotoUnitConverter(){
        unitbutton = findViewById(R.id.buttonUnit);
        unitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent it = new Intent(FirstPage.this, UnitConverter.class);

                startActivity(it);
            }
        });
    }


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.firstpage);
        gotoMain();
        gotoUnitConverter();
    }

}
