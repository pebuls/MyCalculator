package com.mobile.pebuls.mycalculator;

import android.util.Log;
import android.widget.EditText;

/**
 * Created by pebuls on 29.03.17.
 */

public class HelperMethods {

    public double operate(Double result, Double value, String op){
        switch (op){
            case "+":
                return result + value;
            case "-":
                return result - value;
            case "*":
                return result * value;
            case "/":
                try{
                    return result / value;
                }catch (Exception e){
                    Log.d("Calc", e.getMessage());
                }
            default: return -1;
        }
    }

    public double countSqrt(double value)  {
        return Math.sqrt(value);
    }

    public double countSquare(double value)  {
        return Math.pow(value, 2);
    }

    public double countLog(double value)  {
        return Math.log(value);
    }

    public double countFactorial(double value){
        if (value == 0)
            return 1;
        else
            return(value * countFactorial(value - 1));
    }

    public boolean isEqualUsed (boolean usedEqual, EditText editText)   {
        if(usedEqual) {
            editText.setText("");
        }
        return false;
    }

    public boolean isLastCharComa (EditText editText)  {

        String last = getLastChar(editText);

        if (last.equals(".")) return true;
        return false;
    }

    public boolean isLastCharOperator (EditText editText)  {

        String last = getLastChar(editText);

        if (last.equals("+") || last.equals("-") || last.equals("/") || last.equals("*")) return true;
        return false;
    }

    public String getLastChar (EditText editText)   {

        String last = editText.getText().toString();

        return last.substring(last.length() - 1);
    }

    public String getFirstChar (EditText editText)   {

        String first = editText.getText().toString();

        return first.substring(0, 1);
    }

    public boolean isNegative (EditText editText)   {

        if(getFirstChar(editText).equals("-")) return true;
        return false;
    }

    public double ifIsNegativeReturnNegative (EditText editText, double value)  {

        String first = getFirstChar(editText);

        if(first.equals("-")) {
            value = value * (-1.0);
        }

        return value;
    }

    public String removeLastChar(EditText editText) {

        String last = editText.getText().toString();
        
        if (last != null && last.length() > 0) {
            last = last.substring(0, last.length()-1);
        }
        return last;
    }
}
