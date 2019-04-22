package com.example.kalkulatorv1;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.lang.reflect.Method;

public class AdvancedCalc extends AppCompatActivity {

    private EditText inputText;
    private Button btn_0;
    private Button btn_1;
    private Button btn_2;
    private Button btn_3;
    private Button btn_4;
    private Button btn_5;
    private Button btn_6;
    private Button btn_7;
    private Button btn_8;
    private Button btn_9;
    private Button btn_dot;
    private Button btn_c;
    private Button btn_bksp;
    private Button btn_pm;
    private Button btn_mul;
    private Button btn_div;
    private Button btn_add;
    private Button btn_sub;
    private Button btn_equals;
    private Button btn_sin;
    private Button btn_cos;
    private Button btn_tan;
    private Button btn_ln;
    private Button btn_sqrt;
    private Button btn_xpower;
    private Button btn_xpowy;
    private Button btn_log;
    float wynik = 0;
    float wartosc = 0;
    float  poprzedni_wynik = 0;
    boolean mAddition, mSubtract, mMultiplication, mDivision, nextClick ;
    boolean firstOp = false;


    private void initializeButtons(){
        this.inputText = findViewById(R.id.input);
        this.btn_0=findViewById(R.id.btn_0);
        this.btn_1=findViewById(R.id.btn_1);
        this.btn_2=findViewById(R.id.btn_2);
        this.btn_3=findViewById(R.id.btn_3);
        this.btn_4=findViewById(R.id.btn_4);
        this.btn_5=findViewById(R.id.btn_5);
        this.btn_6=findViewById(R.id.btn_6);
        this.btn_7=findViewById(R.id.btn_7);
        this.btn_8=findViewById(R.id.btn_8);
        this.btn_9=findViewById(R.id.btn_9);
        this.btn_dot=findViewById(R.id.btn_dot);
        this.btn_c=findViewById(R.id.btn_c);
        this.btn_bksp=findViewById(R.id.btn_bksp);
        this.btn_pm=findViewById(R.id.btn_pm);
        this.btn_mul=findViewById(R.id.btn_mul);
        this.btn_div=findViewById(R.id.btn_div);
        this.btn_add=findViewById(R.id.btn_add);
        this.btn_sub=findViewById(R.id.btn_sub);
        this.btn_equals=findViewById(R.id.btn_equals);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_simple_calc);
        initializeButtons();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            inputText.setShowSoftInputOnFocus(false);//wyłączenie klawiatury
        } else {
            try {
                final Method method = EditText.class.getMethod(
                        "setShowSoftInputOnFocus"
                        , new Class[]{boolean.class});
                method.setAccessible(true);
                method.invoke(inputText, false);
            } catch (Exception e) {
                // ignore
            }
        }


        btn_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputText.setText(inputText.getText()+"0");
            }
        });

        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputText.setText(inputText.getText()+"1");
            }
        });

        btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputText.setText(inputText.getText()+"2");
            }
        });

        btn_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputText.setText(inputText.getText()+"3");
            }
        });

        btn_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputText.setText(inputText.getText()+"4");
            }
        });

        btn_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputText.setText(inputText.getText()+"5");
            }
        });

        btn_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputText.setText(inputText.getText()+"6");
            }
        });

        btn_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputText.setText(inputText.getText()+"7");
            }
        });

        btn_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputText.setText(inputText.getText()+"8");
            }
        });

        btn_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputText.setText(inputText.getText()+"9");
            }
        });

        btn_dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if((inputText.getText() + "").equals(""))
                    inputText.setText("0.");
                else if((inputText.getText() + "").indexOf(".") > 0)
                {

                }
                else
                {
                    wartosc = Float.parseFloat(inputText.getText() + "");
                    int i = Math.round(wartosc);
                    inputText.setText(i + ".");
                }
            }
        });



//   ||||||||||||||||||||||  FUNKCYJNE |||||||||||||||||||||||||||| ///


        btn_pm.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                if ((inputText.getText() + "") == ""){

                }else {
                    wynik = Float.parseFloat(inputText.getText() + "");
                    wynik = wynik * (-1);
                    inputText.setText(wynik + "");
                }
            }
        });



        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((inputText.getText() + "") == ""){

                }else {
                    calculate();
                    wynik = Float.parseFloat(inputText.getText() + "") + poprzedni_wynik;
                    mAddition = true;
                    inputText.setText(null);

                }
            }
        });

        btn_sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((inputText.getText() + "") == ""){

                }else {
                    calculate();
                    wynik = Float.parseFloat(inputText.getText() + "") + poprzedni_wynik;
                    mSubtract = true;
                    inputText.setText(null);

                }
            }
        });


        btn_mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((inputText.getText() + "") == ""){

                }else {
                    calculate();
                    wynik = Float.parseFloat(inputText.getText() + "") + poprzedni_wynik;
                    mMultiplication = true;
                    inputText.setText(null);

                }
            }
        });

        btn_div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((inputText.getText() + "") == ""){

                }else {
                    calculate();
                    wynik = Float.parseFloat(inputText.getText() + "") + poprzedni_wynik;
                    mDivision = true;
                    inputText.setText(null);

                }
            }
        });

        btn_equals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate();
            }
        });

        btn_c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clear();
                Toast.makeText(getApplicationContext(), "Posprzątano Panie!" , Toast.LENGTH_SHORT).show();
            }
        });

        btn_bksp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backspace();
            }
        });


    }

    private void calculate(){
        if ((inputText.getText() + "") == "") {

        } else {
            wartosc = Float.parseFloat(inputText.getText() + "");

            if (mAddition == true) {
                inputText.setText(wynik + wartosc + "");
                clean_operations();
            }


            if (mSubtract == true) {
                inputText.setText(wynik - wartosc + "");
                clean_operations();
            }

            if (mMultiplication == true) {
                inputText.setText(wynik * wartosc + "");
                clean_operations();
            }

            if (mDivision == true) {
                if(wartosc == 0){
                    Toast.makeText(getApplicationContext(), "Kto dzieli przez zero ten traci szacunek bo jest to niewykonalny rachunek !!!" , Toast.LENGTH_LONG).show();
                    clear();
                }else{
                    inputText.setText(wynik / wartosc + "");
                    clean_operations();
                }

            }
        }
    }

    private void backspace(){
        if(!(getinput().isEmpty())){
            this.inputText.getText().delete(getinput().length()-1, getinput().length());
        }
    }

    private void clear(){
        wynik = 0;
        poprzedni_wynik=0;
        inputText.setText("");
    }


    private String getinput(){
        return this.inputText.getText().toString();
    }


    public void clean_operations(){
        mAddition=false;
        mMultiplication=false;
        mDivision=false;
        mSubtract=false;
    }

}
