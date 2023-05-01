package com.example.calculator_;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private Double first, second, result;
    private Boolean isOperationClick;
    private String operation;
    private MaterialButton next_menu;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        next_menu = findViewById(R.id.next_menu);

        next_menu.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            String result = ((TextView) findViewById(R.id.text_view)).getText().toString();
            intent.putExtra("key",result);
            startActivity(intent);


        });

        textView = findViewById(R.id.text_view);
    }

    private void AppendNumber(String number) {
        next_menu.setVisibility(View.INVISIBLE);
        if (textView.getText().toString().equals("0") || isOperationClick) {
            textView.setText(number);
        } else {
            textView.append(number);

        }
    }

    public void onNumberClick(View view) {
        switch (view.getId()) {

            case R.id.btn_zero:
                AppendNumber("0");
                break;

            case R.id.btn_one:
                AppendNumber("1");
                break;

            case R.id.btn_two:
                AppendNumber("2");
                break;

            case R.id.btn_three:
                AppendNumber("3");
                break;

            case R.id.btn_four:
                AppendNumber("4");
                break;

            case R.id.btn_five:
                AppendNumber("5");
                break;

            case R.id.btn_six:
                AppendNumber("6");
                break;

            case R.id.btn_seven:
                AppendNumber("7");
                break;

            case R.id.btn_eight:
                AppendNumber("8");
                break;

            case R.id.btn_nine:
                AppendNumber("9");
                break;

            case R.id.btn_dot:
                textView.append(".");
                break;

            case R.id.btn_clear:
                textView.setText("0");
                first = 0.0;
                second = 0.0;
                break;
        }
        isOperationClick = false;
    }

    public void onOperationClick(View view) {

        switch (view.getId()) {

            case R.id.plus_minus:
                first = Double.parseDouble(textView.getText().toString());
                isOperationClick = true;
                operation = "+/-";
                break;

            case R.id.btn_percent:
                first = Double.parseDouble(textView.getText().toString());
                isOperationClick = true;
                operation = "%";
                break;

            case R.id.btn_division:
                first = Double.parseDouble(textView.getText().toString());
                isOperationClick = true;
                operation = "/";
                break;

            case R.id.btn_lication:
                first = Double.parseDouble(textView.getText().toString());
                isOperationClick = true;
                operation = "*";
                break;

            case R.id.btn_minus:
                first = Double.parseDouble(textView.getText().toString());
                isOperationClick = true;
                operation = "-";
                break;

            case R.id.btn_plus:
                first = Double.parseDouble(textView.getText().toString());
                isOperationClick = true;
                operation = "+";
                break;

            case R.id.btn_equal:
                if (!isOperationClick) {
                    second = Double.parseDouble(textView.getText().toString());
                    switch (operation) {
                        case "+/-":
                            result = first +- second;
                            break;
                        case "%":
                            result = first % second;
                            break;
                        case "+":
                            result = first + second;
                            break;
                        case "-":
                            result = first - second;
                            break;
                        case "*":
                            result = first * second;
                            break;
                        case "/":
                            result = first / second;
                            break;

                    }
                    textView.setText(new DecimalFormat("###.####").format(result));

                    next_menu.setVisibility(view.getVisibility());
                }



                isOperationClick = true;

        }
    }

    public void onPercentClick(View view) {
        textView.setText(Double.toString(Double.valueOf(textView.getText().toString()) * 0.01));
    }

}