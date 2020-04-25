package com.swapnil.numberguesser;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button btn_guess, btn_plus, btn_minus;
    private int rnd_num = 0, txt_num = 0, computer_num, target, cmp1, cmp2;
    TextView display, num, message, computer_guess, tar_num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_guess = (Button) findViewById(R.id.btn_guess);
        btn_minus = (Button) findViewById(R.id.btn_minus);
        btn_plus = (Button) findViewById(R.id.btn_plus);
        display = findViewById(R.id.rnd_num);
        tar_num = findViewById(R.id.txt_value);
        computer_guess = findViewById(R.id.txt_compguess);

        num = findViewById(R.id.txt_num);
        final int numb = new Random().nextInt(10);
        btn_guess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CalculateWinner();
                rnd_num++;
                display.setText(rnd_num + "");

            }
        });
    }

    public void CalculateWinner() {
        final int target = new Random().nextInt(10);
        final int computer_num = new Random().nextInt(10);
        cmp1 = Math.abs(txt_num - target);
        cmp2 = Math.abs(computer_num - target);
        tar_num.setText(target + "");
        computer_guess.setText(computer_num + "");
        if ((cmp1) < (cmp2) && (cmp1 != 0)) {
            Toast.makeText(MainActivity.this, "Player won!! as he is close by " + Math.abs(cmp1) + " number", Toast.LENGTH_SHORT).show();
        } else if ((computer_num == target) && (cmp1 != cmp2)) {
            Toast.makeText(MainActivity.this, "Computer won!!", Toast.LENGTH_SHORT).show();
        } else if ((txt_num == target) && (cmp1 != cmp2)) {
            Toast.makeText(MainActivity.this, "Absolutely geneous!!", Toast.LENGTH_SHORT).show();
        } else if ((cmp2) < (cmp1) && (cmp2 != 0)) {
            Toast.makeText(MainActivity.this, "Computer won!! as it is close by " + Math.abs(cmp2) + " number", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(MainActivity.this, "Match tied", Toast.LENGTH_SHORT).show();

        }
    }

    public void numDecrease(View view) {
        if (txt_num <= 0) {
            txt_num = 0;
            num.setText(txt_num + "");
            Toast.makeText(this, "You cannot enter negative number", Toast.LENGTH_SHORT).show();

        } else {
            txt_num--;
            num.setText(txt_num + "");
        }

    }

    public void numIncrease(View view) {
        txt_num++;
        num.setText(txt_num + "");
    }
}
