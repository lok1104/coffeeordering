package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int amount = 1;
    int basePrice = 5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnMinus = findViewById(R.id.btn_minus);
        Button btnPlus = findViewById(R.id.btn_plus);
        final TextView tvAmount = findViewById(R.id.tv_amount);
        final CheckBox checkboxCream = findViewById(R.id.checkbox_cream);
        final CheckBox checkboxChocolate = findViewById(R.id.checkbox_chocolate);
        final CheckBox checkboxVallina = findViewById(R.id.checkbox_vanilla);
        Button btnOrder = findViewById(R.id.button_order);
        final TextView tvYhankYou = findViewById(R.id.thankyou);

        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Do stuff
                if (amount > 1) {
                    amount--;
                    tvAmount.setText(Integer.toString(amount));
                }
            }
        });
        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                amount++;
                tvAmount.setText(Integer.toString(amount));
            }
        });
        btnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int finalPrice = basePrice;

                if (checkboxCream.isChecked()) {
                    finalPrice += 1;
                }
                if (checkboxChocolate.isChecked()) {
                    finalPrice += 2;
                }
                if (checkboxVallina.isChecked()) {
                    finalPrice += 3;

                }
                finalPrice += amount;

                Log.d("FinalPrice",Integer.toString(finalPrice));


                tvYhankYou.setText("Thank for your order. \n The total price is "+Integer.toString(finalPrice));
            }

        });
    }
}
