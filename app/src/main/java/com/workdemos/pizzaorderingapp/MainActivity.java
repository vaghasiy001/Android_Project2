package com.workdemos.pizzaorderingapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.RadioGroup;

import java.text.DecimalFormat;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onCrustSelected(View v){
        RadioGroup sizeGroup = (RadioGroup)findViewById(R.id.sizeGroup);
        double PIZZA_SIZE = 0.00, CRUST = 0.00;
        switch(sizeGroup.getCheckedRadioButtonId()) {
            case R.id.size_small:
                PIZZA_SIZE = 4.50;
                break;
            case R.id.size_medium:
                PIZZA_SIZE = 6.50;
                break;
            case R.id.size_large:
                PIZZA_SIZE = 8.50;
                break;
        }

        switch(v.getId()){
            case R.id.btnHand:
                CRUST = 0.50;
                break;
            case R.id.btnNatural:
                CRUST = 0.60;
                break;
            case R.id.btnPan:
                CRUST = 0.70;
                break;
            case R.id.btnStuffed:
                CRUST = 0.90;
                break;
            case R.id.btnThinCrispy:
                CRUST = 0.80;
                break;
        }
        Intent intent = new Intent(this, MainActivity2.class);
        intent.putExtra("PizzaSize", PIZZA_SIZE);
        intent.putExtra("Crust", CRUST);
        startActivity(intent);
    }
}
