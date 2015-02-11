package com.workdemos.pizzaorderingapp;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;


public class MainActivity2 extends Activity {
    private String[] arraySpinner;
    private int NOOFPIZZA = 1;
    TextView subtotal, tax, grandtotal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity2);

        this.arraySpinner = new String[] {
                "1", "2", "3", "4", "5"
        };
        Spinner s = (Spinner) findViewById(R.id.NumberSpinner);
        ArrayAdapter adapter = new ArrayAdapter(this,
                android.R.layout.simple_spinner_item, arraySpinner);
        s.setAdapter(adapter);

        RadioGroup toppingGroup = (RadioGroup) findViewById(R.id.toppingGroup);
        toppingGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                CalculatePrice();
            }
        });

        Spinner numberSpinner = (Spinner) findViewById(R.id.NumberSpinner);
        numberSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                int index = parentView.getSelectedItemPosition();
                NOOFPIZZA = Integer.parseInt(arraySpinner[index]);
                CalculatePrice();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {

            }

        });
        subtotal = (TextView)findViewById(R.id.textSubtotal);
        tax = (TextView)findViewById(R.id.textTax);
        grandtotal = (TextView)findViewById(R.id.textGrandtotal);
        CalculatePrice();
    }

    private void  CalculatePrice() {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            double SubTotal = (extras.getDouble("PizzaSize") + extras.getDouble("Crust") + 1.80) * NOOFPIZZA;
            double Tax = SubTotal * 0.06;
            double GrandTotal = SubTotal + Tax;
            subtotal.setText(getString(R.string.subtotal) + " $" + String.format("%.2f", SubTotal));
            tax.setText(getString(R.string.tax) + " $" + String.format("%.2f", Tax));
            grandtotal.setText(getString(R.string.grandtotal) + " $" + String.format("%.2f", GrandTotal));
        }
    }
}
