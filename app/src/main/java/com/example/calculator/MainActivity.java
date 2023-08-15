package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.mariuszgromada.math.mxparser.*;

public class MainActivity extends AppCompatActivity {

    private TextView prevcalc;
    private EditText calc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        prevcalc = findViewById(R.id.res);
        calc = findViewById(R.id.et);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {            //to stop the popup of mobile text entering keyboard
            calc.setShowSoftInputOnFocus(false);
        }
    }

    private void updateText(String strTOAdd){
        String oldString = calc.getText().toString();

        int cursorPos = calc.getSelectionStart();
        String leftString = oldString.substring(0,cursorPos);
        String rightString = oldString.substring(cursorPos);;
        //  JA         |      SON
        // LEFT  ADDatCURSOR   RIGHT

        calc.setText(String.format("%s%s%s",leftString,strTOAdd,rightString));  // %S%S used for defining string like %d, %c
        calc.setSelection(cursorPos + strTOAdd.length());   //shift the cursor ----> current to -> lenght of string sin,cos has lenght 1
    }

    public void clearBTNPush (View view){
        calc.setText("");
        prevcalc.setText("");
    }

    public void eraseBTNPush (View view){
        int cursorPos = calc.getSelectionStart();
        int textLen = calc.getText().length();

        if(cursorPos !=0 && textLen !=0){
            SpannableStringBuilder selection = (SpannableStringBuilder) calc.getText();
            selection.replace(cursorPos-1,cursorPos,"");
            calc.setText(selection);
            calc.setSelection(cursorPos-1);
        }
    }
    public void equalBTNPush (View view){
        String userExp = calc.getText().toString();
        prevcalc.setText(userExp);
        userExp = userExp.replaceAll(getResources().getString(R.string.divide),"/");
        userExp = userExp.replaceAll(getResources().getString(R.string.multiply),"*");

        Expression exp = new Expression(userExp);
        String result = String.valueOf(exp.calculate());

        calc.setText(result);
        calc.setSelection(result.length());
    }

    public void zeroBTNPush (View view){
        updateText(getResources().getString(R.string.zero));
    }
    public void oneBTNPush (View view){
        updateText(getResources().getString(R.string.one));
    }
    public void twoBTNPush (View view){
        updateText(getResources().getString(R.string.two));
    }
    public void threeBTNPush (View view){
        updateText(getResources().getString(R.string.three));
    }
    public void fourBTNPush (View view){
        updateText(getResources().getString(R.string.four));
    }
    public void fiveBTNPush (View view){
        updateText(getResources().getString(R.string.five));
    }
    public void sixBTNPush (View view){
        updateText(getResources().getString(R.string.six));
    }
    public void sevenBTNPush (View view){
        updateText(getResources().getString(R.string.seven));
    }
    public void eightBTNPush (View view){
        updateText(getResources().getString(R.string.eight));
    }
    public void nineBTNPush (View view){
        updateText(getResources().getString(R.string.nine));
    }

    public void openParaBTNPush (View view){
        updateText(getResources().getString(R.string.parenthesis1));
    }
    public void closeParaBTNPush (View view){
        updateText(getResources().getString(R.string.parenthesis2));
    }
    public void divBTNPush (View view){
        updateText(getResources().getString(R.string.divide));
    }
    public void mulBTNPush (View view){
        updateText(getResources().getString(R.string.multiply));
    }
    public void subBTNPush (View view){
        updateText(getResources().getString(R.string.sub));
    }
    public void addBTNPush (View view){
        updateText(getResources().getString(R.string.add));
    }
    public void decBTNPush (View view){
        updateText(getResources().getString(R.string.decimal));
    }

    public void trigSinBTNPush(View view){
        updateText("sin(");
    }

    public void trigCosBTNPush(View view){
        updateText("cos(");
    }

    public void trigTanBTNPush(View view){
        updateText("tan(");
    }

    public void trigArcSinBTNPush(View view){
        updateText("arcsin(");
    }

    public void trigArcCosBTNPush(View view){
        updateText("arccos(");
    }

    public void trigArcTanBTNPush(View view){
        updateText("arctan(");
    }

    public void naturalLogBTNPush(View view){
        updateText("ln(");
    }

    public void logBTNPush(View view){
        updateText("log(");
    }

    public void sqrtBTNPush(View view){
        updateText("sqrt(");
    }

    public void absBTNPush(View view){
        updateText("abs(");
    }

    public void piBTNPush(View view){
        updateText("pi");
    }

    public void eBTNPush(View view){
        updateText("e");
    }

    public void xSquaredBTNPush(View view){
        updateText("^(2)");
    }

    public void xPowerYBTNPush(View view){
        updateText("^(");
    }

    public void primeBTNPush(View view){
        updateText("ispr(");
    }

}
