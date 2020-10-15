package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.transition.ChangeTransform;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9,
            btnAdd, btnSub, btnDiv, btnMul, btnEql, btnPer, btnDot, btnClearAll;

    TextView field;

    float valOne, valTwo;

    boolean bAddition, bSubtract, bMultiply, bDivision;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findButtons();
        setOnClicks();
    }

    private void setOnClicks() {

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                field.setText(field.getText() + "0");
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                field.setText(field.getText() + "1");
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                field.setText(field.getText() + "2");
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                field.setText(field.getText() + "3");
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                field.setText(field.getText() + "4");
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                field.setText(field.getText() + "5");
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                field.setText(field.getText() + "6");
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                field.setText(field.getText() + "7");
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                field.setText(field.getText() + "8");
            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                field.setText(field.getText() + "9");
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (field.getText().toString().isEmpty()) {
                    field.setText("");
                } else {
                    valOne = Float.parseFloat(field.getText().toString());
                    bAddition = true;
                    field.setText(field.getText() + "+");
                }
            }
        });

        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(field.getText().toString().isEmpty()){
                    field.setText("-");
                }else if(field.getText().toString().length()!=0 && !field.getText().toString().equals("-")){
                    valOne = Float.parseFloat(field.getText().toString());
                    bSubtract = true;
                    field.setText(field.getText() + "-");
                }

            }
        });

        btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                valOne = Float.parseFloat(field.getText().toString() + "");
                bMultiply = true;
                field.setText(null);
            }
        });

        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                valOne = Float.parseFloat(field.getText().toString() + "");
                bDivision = true;
                field.setText(null);
            }
        });

        btnEql.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String string = field.getText().toString();
                StringBuilder sbValTwo = new StringBuilder();
                for (int i = string.length() - 1; i >= 0; i--) {
                    if (Character.isDigit(string.charAt(i))) {
                        sbValTwo.append(string.charAt(i));
                    }else{
                        i=0;
                    }
                }
                valTwo = Float.parseFloat(sbValTwo.reverse().toString());
                Toast.makeText(MainActivity.this, "val1=" + valOne + " val2=" + valTwo, Toast.LENGTH_SHORT).show();

                if (bAddition) {
                    field.setText(valOne + valTwo + "");
                    bAddition = false;
//                    Toast.makeText(MainActivity.this, "val1=" + valOne + " val2=" + valTwo, Toast.LENGTH_SHORT).show();
                }

                if (bSubtract) {
                    field.setText(valOne - valTwo + "");
                    bSubtract = false;
                }

                if (bMultiply) {
                    field.setText(valOne * valTwo + "");
                    bMultiply = false;
                }

                if (bDivision) {
                    if (valTwo == 0) {
                        Toast.makeText(MainActivity.this, "Деление на ноль!", Toast.LENGTH_SHORT).show();
                        field.setText("0");
                    } else {
                        field.setText(valOne / valTwo + "");
                        bDivision = false;
                    }
                }
            }
        });

        btnClearAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                field.setText("");
            }
        });

        btnDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                field.setText(field.getText().toString() + ".");
            }
        });
    }

    private void findButtons() {
        field = findViewById(R.id.tv_field);

        btn0 = findViewById(R.id.btn_0);
        btn1 = findViewById(R.id.btn_1);
        btn2 = findViewById(R.id.btn_2);
        btn3 = findViewById(R.id.btn_3);
        btn4 = findViewById(R.id.btn_4);
        btn5 = findViewById(R.id.btn_5);
        btn6 = findViewById(R.id.btn_6);
        btn7 = findViewById(R.id.btn_7);
        btn8 = findViewById(R.id.btn_8);
        btn9 = findViewById(R.id.btn_9);

        btnAdd = findViewById(R.id.btn_add);
        btnSub = findViewById(R.id.btn_sub);
        btnDiv = findViewById(R.id.btn_divide);
        btnMul = findViewById(R.id.btn_multiply);
        btnPer = findViewById(R.id.btn_percent);
        btnDot = findViewById(R.id.btn_dot);
        btnClearAll = findViewById(R.id.btn_clear);
        btnEql = findViewById(R.id.btn_equal);
    }
}