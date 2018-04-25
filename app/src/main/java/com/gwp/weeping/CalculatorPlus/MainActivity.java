package com.gwp.weeping.CalculatorPlus;

import android.content.Context;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private AdView banner;
    private MediaPlayer mp;
    private TextView outputDisplay;
    private TextView degDisplay;
    private TextView shiftDisplay;
    private TextView hypDisplay;
    private String currentDisplayedInput = "";
    private String inputToBeParsed = "";
    private MathParse mCalculator;
    private static String PREFS_NAME = "memory";
    private Button buttonMadd, button0, button1, button2, button3, button4, button5, button6, button7, button8, button9, buttonClear, buttonAdd, buttonSub, buttonMultiply, buttonDivide, buttonDot, buttonPercent, buttonDelete, buttonOb, buttonCb, buttonEn, buttonNRoot, buttonDdx;
    private Button buttonFactorial, buttonC, buttonP, buttonPi, buttonEuler, buttonCubeRoot, buttonCube, buttonExp, buttonPower,
            buttonInvSin, buttonInvCos, buttonInvTan, button10X, buttonSinh, buttonCosh, buttonTanh, buttonEqual;
    private Button buttonSin, buttonLn, buttonCos, buttonLog, buttonTan, buttonRoot, buttonSquare, buttonRan;
    private Button buttonDeg, buttonShift, buttonMr, buttonMsub, buttonMc, buttonHyp, buttonAns;
    private boolean degMode = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        MobileAds.initialize(this, "ca-app-pub-9000632191538699/6855335008");
        banner = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        banner.loadAd(adRequest);

        mCalculator = new MathParse();


        mp = MediaPlayer.create(this, R.raw.kbsound);


        outputDisplay = findViewById(R.id.Answer);
        button0 = findViewById(R.id.btn0);
        button1 = findViewById(R.id.btn1);
        button2 = findViewById(R.id.btn2);
        button3 = findViewById(R.id.btn3);
        button4 = findViewById(R.id.btn4);
        button5 = findViewById(R.id.btn5);
        button6 = findViewById(R.id.btn6);
        button7 = findViewById(R.id.btn7);
        button8 = findViewById(R.id.btn8);
        button9 = findViewById(R.id.btn9);
        buttonClear = findViewById(R.id.btnClear);
        buttonAdd = findViewById(R.id.btnAdd);
        buttonSub = findViewById(R.id.btnSub);
        buttonMultiply = findViewById(R.id.btnMultiply);
        buttonDivide = findViewById(R.id.btnDivide);
        buttonDot = findViewById(R.id.btnDot);
        buttonPercent = findViewById(R.id.btnPercent);
        buttonDelete = findViewById(R.id.btnDelete);
        buttonMc = findViewById(R.id.btnMC);
        buttonMadd = findViewById(R.id.btnMadd);
        buttonMsub = findViewById(R.id.btnMsub);
        buttonMr = findViewById(R.id.btnMr);
        buttonRan = findViewById(R.id.btnRan);
        buttonAns = findViewById(R.id.btnAns);
        buttonSin = findViewById(R.id.btnSin);
        buttonCos = findViewById(R.id.btnCos);
        buttonTan = findViewById(R.id.btnTan);
        buttonOb = findViewById(R.id.btnOb);
        buttonCb = findViewById(R.id.btnCb);
        buttonSquare = findViewById(R.id.btnSquare);
        buttonRoot = findViewById(R.id.btnRoot);
        buttonLog = findViewById(R.id.btnLog);
        outputDisplay = findViewById(R.id.Answer);
        buttonFactorial = findViewById(R.id.btnFactorial);
        buttonNRoot = findViewById(R.id.btnNRoot);
        buttonPower = findViewById(R.id.btnPower);
        buttonPi = findViewById(R.id.btnPi);
        buttonShift = findViewById(R.id.btnShift);
        buttonC = findViewById(R.id.btnC);
        buttonClear = findViewById(R.id.btnClear);
        buttonEqual = findViewById(R.id.btnEqual);
        buttonHyp = findViewById(R.id.btnHyp);
        buttonDeg = findViewById(R.id.btnDeg);
        degDisplay = findViewById(R.id.textDeg);
        shiftDisplay = findViewById(R.id.textShift);
        hypDisplay = findViewById(R.id.textHyp);


        button0.setOnClickListener(this);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);
        buttonClear.setOnClickListener(this);
        buttonAdd.setOnClickListener(this);
        buttonSub.setOnClickListener(this);
        buttonMultiply.setOnClickListener(this);
        buttonDivide.setOnClickListener(this);
        buttonDot.setOnClickListener(this);
        buttonRan.setOnClickListener(this);
        buttonAns.setOnClickListener(this);
        buttonPercent.setOnClickListener(this);
        buttonDelete.setOnClickListener(this);
        buttonMc.setOnClickListener(this);
        buttonMadd.setOnClickListener(this);
        buttonMsub.setOnClickListener(this);
        buttonMr.setOnClickListener(this);
        buttonSin.setOnClickListener(this);
        buttonCos.setOnClickListener(this);
        buttonTan.setOnClickListener(this);
        buttonOb.setOnClickListener(this);
        buttonCb.setOnClickListener(this);
        buttonSquare.setOnClickListener(this);
        buttonRoot.setOnClickListener(this);
        buttonLog.setOnClickListener(this);
        buttonFactorial.setOnClickListener(this);
        buttonNRoot.setOnClickListener(this);
        buttonPower.setOnClickListener(this);
        buttonPi.setOnClickListener(this);
        buttonShift.setOnClickListener(this);
        buttonC.setOnClickListener(this);
        buttonEqual.setOnClickListener(this);
        buttonDeg.setOnClickListener(this);
        buttonHyp.setOnClickListener(this);

    }


    private void obtainInputValues(String input){
        switch (input) {
            case "0":
                currentDisplayedInput += "0";
                inputToBeParsed += "0";
                break;
            case "1":
                currentDisplayedInput += "1";
                inputToBeParsed += "1";
                break;
            case "2":
                currentDisplayedInput += "2";
                inputToBeParsed += "2";
                break;
            case "3":
                currentDisplayedInput += "3";
                inputToBeParsed += "3";
                break;
            case "4":
                currentDisplayedInput += "4";
                inputToBeParsed += "4";
                break;
            case "5":
                currentDisplayedInput += "5";
                inputToBeParsed += "5";
                break;
            case "6":
                currentDisplayedInput += "6";
                inputToBeParsed += "6";
                break;
            case "7":
                currentDisplayedInput += "7";
                inputToBeParsed += "7";
                break;
            case "8":
                currentDisplayedInput += "8";
                inputToBeParsed += "8";
                break;
            case "9":
                currentDisplayedInput += "9";
                inputToBeParsed += "9";
                break;
            case ".":
                currentDisplayedInput += ".";
                inputToBeParsed += ".";
                break;
            case "π":
                currentDisplayedInput += "π";
                inputToBeParsed += "pi";
                break;
            case "x":
                currentDisplayedInput += "x";
                inputToBeParsed += "*";
                break;
            case "Ran#":
                double ran = Math.random();
                currentDisplayedInput += String.valueOf(ran);
                inputToBeParsed += String.valueOf(ran);
                break;
            case "÷":
                currentDisplayedInput += "÷";
                inputToBeParsed += "/";
                break;
            case "%":
                currentDisplayedInput += "%";
                inputToBeParsed += "/100";
                break;
            case "+":
                currentDisplayedInput += "+";
                inputToBeParsed += "+";
                break;
            case "-":
                currentDisplayedInput += "-";
                inputToBeParsed += "-";
                break;
            case "(":
                currentDisplayedInput += "(";
                inputToBeParsed += "(";
                break;
            case ")":
                currentDisplayedInput += ")";
                inputToBeParsed += ")";
                break;
            case "Sin\u207b\u00b9":
                currentDisplayedInput += "Sin\u207b\u00b9(";
                inputToBeParsed += "asin(";
                break;
            case "Cos\u207b\u00b9":
                currentDisplayedInput += "Cos\u207b\u00b9(";
                inputToBeParsed += "acos(";
                break;
            case "Tan\u207b\u00b9":
                currentDisplayedInput += "Tan\u207b\u00b9(";
                inputToBeParsed += "atan(";
                break;
            case "Sinh":
                currentDisplayedInput += "Sinh(";
                inputToBeParsed += "sinh(";
                break;
            case "Cosh":
                currentDisplayedInput += "Cosh(";
                inputToBeParsed += "cosh(";
                break;
            case "Tanh":
                currentDisplayedInput += "Tanh(";
                inputToBeParsed += "tanh(";
                break;
            case "Sin":
                currentDisplayedInput += "Sin(";
                inputToBeParsed += "sin(";
                break;
            case "Cos":
                currentDisplayedInput += "Cos(";
                inputToBeParsed += "cos(";
                break;
            case "Tan":
                currentDisplayedInput += "Tan(";
                inputToBeParsed += "tan(";
                break;
            case "\u221b":
                currentDisplayedInput += "\u221b";
                inputToBeParsed += "crt(";
                break;
            case "x\u00B3":
                currentDisplayedInput += "^3";
                inputToBeParsed += "^3";
                break;
            case "x\u00B2":
                currentDisplayedInput += "^2";
                inputToBeParsed += "^2";
                break;
            case "^":
                currentDisplayedInput += "^";
                inputToBeParsed += "^";
                break;
            case "Exp":
                currentDisplayedInput += "*10^";
                inputToBeParsed += "*10^";
                break;
            case "\u207f\u221a":
                currentDisplayedInput += "^(1÷";
                inputToBeParsed += "^(1/";
                break;
            case "e":
                currentDisplayedInput += "e";
                inputToBeParsed += "e";
                break;
            case "x!":
                currentDisplayedInput += "!(";
                inputToBeParsed += "!(";
                break;
            case "√":
                currentDisplayedInput += "√";
                inputToBeParsed += "sqrt(";
                break;
            case "C":
                currentDisplayedInput += "C(";
                inputToBeParsed += "comb(";
                break;
            case "P":
                currentDisplayedInput += "P(";
                inputToBeParsed += "permu(";
                break;
            case ",":
                currentDisplayedInput += ",";
                inputToBeParsed += ",";
                break;
            case "10\u207F":
                currentDisplayedInput += "10^";
                inputToBeParsed += "10^";
                break;
            case "log":
                currentDisplayedInput += "log(";
                inputToBeParsed += "log(";
                break;
            case "ln":
                currentDisplayedInput += "ln(";
                inputToBeParsed += "ln(";
                break;
            case "e\u207F":
                currentDisplayedInput += "e^";
                inputToBeParsed += "e^";
                break;
            case "Ams":
                double inputValue  = isANumber(outputDisplay.getText().toString());
                if(!Double.isNaN(inputValue)){
                    addToMemoryStorage(MainActivity.this, inputValue);
                }
                break;
            case "MR":
                String mValue = getStoredPreferenceValue(MainActivity.this);
                String result = removeTrailingZero(mValue);
                if (!result.equals("0")) {
                    currentDisplayedInput += result;
                    inputToBeParsed += result;
                }
                break;
            case "MS":
                clearMemoryStorage(MainActivity.this);
                break;
            case "M+":
                inputValue = isANumber(outputDisplay.getText().toString());
                if(!Double.isNaN(inputValue)){
                    addToMemoryStorage(MainActivity.this, inputValue);
                }
            case "M-":
                double inputValueMinus = isANumber(outputDisplay.getText().toString());
                if (!Double.isNaN(inputValueMinus)) {
                    subtractMemoryStorage(MainActivity.this, inputValueMinus);
                    break;
                }}
        outputDisplay.setText(currentDisplayedInput);

    }


    @Override
    public void onClick(View v) {
        mp.start();
        Button button = (Button) v;
        String data = button.getText().toString();

        if (data.equals("Clear")) {
            outputDisplay.setText("");
            currentDisplayedInput = "";
            inputToBeParsed = "";
        } else if (data.equals("Del")) {
            String enteredInput = outputDisplay.getText().toString();
            if (enteredInput.length() > 0) {
                enteredInput = enteredInput.substring(0, enteredInput.length() - 1);
                currentDisplayedInput = enteredInput;
                inputToBeParsed = enteredInput;
                outputDisplay.setText(currentDisplayedInput);
            }
        }else if(data.equals("RAD")){
            buttonDeg.setText("DEG");
            degDisplay.setText("RAD");
        }
        else if(data.equals("DEG")) {
            buttonDeg.setText("RAD");
            degDisplay.setText("DEG");

        } else if (data.equals("=")) {
            String enteredInput = outputDisplay.getText().toString();
            String resultObject = mCalculator.getResult(inputToBeParsed);
            outputDisplay.setText(removeTrailingZero(resultObject));

        }else{
        obtainInputValues(data);

    }

    if (data.equals("Shift")){
            buttonShift.setText("SHIFT");
            shiftDisplay.setText("SHIFT");
            buttonSin.setText("Sin\u207b\u00b9");
            buttonCos.setText("Cos\u207b\u00b9");
            buttonTan.setText("Tan\u207b\u00b9");
            buttonLog.setText("ln");
            buttonPower.setText("eⁿ");
            buttonFactorial.setText("10\u207F");
            buttonNRoot.setText("Exp");

    } else if (data.equals("SHIFT")){
        buttonShift.setText("Shift");
        shiftDisplay.setText("");
        buttonSin.setText("Sin");
        buttonCos.setText("Cos");
        buttonTan.setText("Tan");
        buttonLog.setText("log");
        buttonPower.setText("^");
        buttonFactorial.setText("x!");
        buttonNRoot.setText("\u207f\u221a");
    }

    if (data.equals("Hyp")){
        buttonHyp.setText("HYP");
        hypDisplay.setText("hyp");
        buttonSin.setText("Sinh");
        buttonCos.setText("Cosh");
        buttonTan.setText("Tanh");

    } else if (data.equals("HYP")){
        buttonHyp.setText("Hyp");
        hypDisplay.setText("");
        buttonSin.setText("Sin");
        buttonCos.setText("Cos");
        buttonTan.setText("Tan");

    }

    }
    private String removeTrailingZero(String formattingInput){
        if(!formattingInput.contains(".")){
            return formattingInput;
        }
        int dotPosition = formattingInput.indexOf(".");
        String newValue = formattingInput.substring(dotPosition, formattingInput.length());
        if(newValue.equals(".0")){
            return formattingInput.substring(0, dotPosition);
        }
        return formattingInput;
    }

    private double isANumber(String numberInput){
        double result = Double.NaN;
        try{
            result = Double.parseDouble(numberInput);
        }catch(NumberFormatException nfe){
        }
        return result;
    }
    private void addToMemoryStorage(Context context, double inputToStore){
        float returnPrefValue = getPreference(context);
        float newValue = returnPrefValue + (float)inputToStore;
        setPreference(context, newValue);
    }
    private void subtractMemoryStorage(Context context, double inputToStore){
        float returnPrefValue = getPreference(context);
        float newValue = returnPrefValue - (float)inputToStore;
        setPreference(context, newValue);
    }
    private void clearMemoryStorage(Context context){
        setPreference(context, 0);
    }
    private String getStoredPreferenceValue(Context context){
        float returnedValue = getPreference(context);
        return String.valueOf(returnedValue);
    }
    static public boolean setPreference(Context c, float value) {
        SharedPreferences settings;
        settings = c.getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putFloat("key", value);
        return editor.commit();
    }
    static public float getPreference(Context c) {
        SharedPreferences settings;
        settings = c.getSharedPreferences(PREFS_NAME, 0);
        float value = settings.getFloat("key", 0);
        return value;
    }}