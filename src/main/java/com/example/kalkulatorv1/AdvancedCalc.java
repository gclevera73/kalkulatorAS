package com.example.kalkulatorv1;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.support.annotation.NonNull;
import java.lang.reflect.Method;

public class AdvancedCalc extends AppCompatActivity {

    private EditText inputText;
    private Button btn_0, btn_1, btn_2, btn_3, btn_4, btn_5, btn_6, btn_7, btn_8, btn_9;
    private Button btn_dot, btn_c, btn_bksp, btn_pm, btn_mul, btn_div, btn_add, btn_sub, btn_equals, btn_sin, btn_cos, btn_tan, btn_ln, btn_sqrt, btn_power, btn_xpowy, btn_log;
    Double wynik = 0.0;
    Double wartosc = 0.0;
    Double  poprzedni_wynik = 0.0;
    Double  degrees = 0.0;
    Double  radians = 0.0;
    Double base = 0.0;
    Double  L = 0.0;
    Double  tmp = 0.0;
    boolean mAddition, mSubtract, mMultiplication, mDivision, mSin, mCos, mTan, mLn, mSqrt, mPower, mXpowy, mLog ;


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
        this.btn_sin=findViewById(R.id.btn_sin);
        this.btn_cos=findViewById(R.id.btn_cos);
        this.btn_tan=findViewById(R.id.btn_tan);
        this.btn_ln=findViewById(R.id.btn_ln);
        this.btn_sqrt=findViewById(R.id.btn_sqrt);
        this.btn_power=findViewById(R.id.btn_power);
        this.btn_xpowy=findViewById(R.id.btn_xpowy);
        this.btn_log=findViewById(R.id.btn_log);
    }

    protected void ListenForButtons(){

        btn_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { inputText.setText(inputText.getText()+"0");
            }
        });

        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { inputText.setText(inputText.getText()+"1");
            }
        });

        btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { inputText.setText(inputText.getText()+"2");
            }
        });

        btn_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { inputText.setText(inputText.getText()+"3");
            }
        });

        btn_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { inputText.setText(inputText.getText()+"4");
            }
        });

        btn_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { inputText.setText(inputText.getText()+"5");
            }
        });

        btn_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { inputText.setText(inputText.getText()+"6");
            }
        });

        btn_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { inputText.setText(inputText.getText()+"7");
            }
        });

        btn_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { inputText.setText(inputText.getText()+"8");
            }
        });

        btn_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { inputText.setText(inputText.getText()+"9");
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
                    wartosc = Double.parseDouble(inputText.getText() + "");
                    long i = Math.round(wartosc);
                    inputText.setText(i + ".");
                }
            }
        });

        btn_pm.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                if ((inputText.getText() + "") == ""){

                }else {
                    wynik = Double.parseDouble(inputText.getText() + "");
                    wynik = wynik * (-1);
                    inputText.setText(wynik + "");
                }
            }
        });

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mSubtract==true || mMultiplication==true || mDivision == true || mXpowy==true){
                    clean_operations();
                    mAddition=true;
                    calculate();
                }

                else if ((inputText.getText() + "") == ""){

                }else {
                    calculate();
                    wynik = Double.parseDouble(inputText.getText() + "") + poprzedni_wynik;
                    mAddition = true;
                    inputText.setText(null);
                }
            }
        });

        btn_sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mAddition==true || mMultiplication==true || mDivision == true || mXpowy==true){
                    clean_operations();
                    mSubtract=true;
                    calculate();
                }
               else if ((inputText.getText() + "") == ""){

                }else {
                    calculate();
                    wynik = Double.parseDouble(inputText.getText() + "") + poprzedni_wynik;
                    mSubtract = true;
                    inputText.setText(null);

                }
            }
        });

        btn_mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mAddition==true || mSubtract==true || mDivision == true || mXpowy==true){
                    clean_operations();
                    mMultiplication=true;
                    calculate();
                }

                else if ((inputText.getText() + "") == ""){

                }else {
                    calculate();
                    wynik = Double.parseDouble(inputText.getText() + "") + poprzedni_wynik;
                    mMultiplication = true;
                    inputText.setText(null);

                }
            }
        });

        btn_div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mAddition==true || mMultiplication==true || mSubtract == true || mXpowy==true){
                    clean_operations();
                    mDivision=true;
                    calculate();
                }else if ((inputText.getText() + "") == ""){

                }else {
                    calculate();
                    wynik = Double.parseDouble(inputText.getText() + "") + poprzedni_wynik;
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

        btn_sin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((inputText.getText() + "") == ""){

                }else {
                    degrees = Double.parseDouble(inputText.getText() + "");
                    radians = degrees * Math.PI / 180;
                    wynik=Math.sin(radians);
                    inputText.setText(wynik + "");
                    degrees=0.0;
                    radians=0.0;
                }
            }
        });

        btn_cos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((inputText.getText() + "") == ""){

                }else {
                    degrees = Double.parseDouble(inputText.getText() + "");
                    radians = Math.toRadians(degrees);

                    wynik=Math.cos(radians);
                    inputText.setText(wynik + "");
                    degrees=0.0;
                    radians=0.0;
                }
            }
        });

        btn_tan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((inputText.getText() + "") == ""){

                }else {
                    degrees = Double.parseDouble(inputText.getText() + "");
                    radians = Math.toRadians(degrees);

                    wynik=Math.tan(radians);
                    inputText.setText(wynik + "");
                    degrees=0.0;
                    radians=0.0;
                }
            }
        });

        btn_ln.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((inputText.getText() + "") == ""){

                }else {
                    L = Double.parseDouble(inputText.getText() + "");
                    wynik=Math.log(L);
                    inputText.setText(wynik + "");
                    L=0.0;

                }
            }
        });

        btn_sqrt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((inputText.getText() + "") == ""){

                }else {
                    base = Double.parseDouble(inputText.getText() + "");
                    wynik=Math.sqrt(base);
                    inputText.setText(wynik + "");
                    base=0.0;
                }
            }
        });

        btn_power.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((inputText.getText() + "") == ""){

                }else {
                    base = Double.parseDouble(inputText.getText() + "");
                    wynik=Math.pow(base, 2);
                    inputText.setText(wynik + "");
                    base=0.0;
                }
            }
        });

        btn_xpowy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((inputText.getText() + "") == ""){

                }else {
                    calculate();
                    wynik = Double.parseDouble(inputText.getText() + "") + poprzedni_wynik;
                    mXpowy = true;
                    inputText.setText(null);
                }
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_advanced_calc);
        initializeButtons();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
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

       ListenForButtons();

        if (savedInstanceState == null) {
            this.wartosc=0.0;
            this.poprzedni_wynik=0.0;
            this.wartosc=0.0;
        } else {
            this.mAddition=savedInstanceState.getBoolean("mAddition");
            this.mSubtract=savedInstanceState.getBoolean("mSubtract");
            this.mMultiplication=savedInstanceState.getBoolean("mMultiplication");
            this.mDivision=savedInstanceState.getBoolean("mDivision");
            this.mXpowy=savedInstanceState.getBoolean("mXpowy");
            this.wynik=savedInstanceState.getDouble("wynik");
            this.poprzedni_wynik=savedInstanceState.getDouble("poprzedni_wynik");
            this.wartosc=savedInstanceState.getDouble("wartosc");
        }
    }


    @Override
    public void onSaveInstanceState(@NonNull Bundle savedInstanceState) {

        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putBoolean("mAddition", mAddition);
        savedInstanceState.putBoolean("mSubtract", mSubtract);
        savedInstanceState.putBoolean("mDivision", mDivision);
        savedInstanceState.putBoolean("mMultiplication", mMultiplication);
        savedInstanceState.putBoolean("mXpowy", mXpowy);
        savedInstanceState.putDouble("wynik", wynik);
        savedInstanceState.putDouble("poprzedni_wynik", poprzedni_wynik);
        savedInstanceState.putDouble("wartosc", wartosc);
    }

    private void calculate(){
        if ((inputText.getText() + "") == "") {

        } else {
            wartosc = Double.parseDouble(inputText.getText() + "");

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

            if (mXpowy == true) {
                inputText.setText(Math.pow(wynik, wartosc) + "");
                clean_operations();
            }
        }
    }

    private void backspace(){
        if(!(getinput().isEmpty())){
            this.inputText.getText().delete(getinput().length()-1, getinput().length());
        }
    }

    private void clear(){
        wynik = 0.0;
        poprzedni_wynik=0.0;
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
        mXpowy=false;
    }
}