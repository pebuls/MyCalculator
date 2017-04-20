package com.mobile.pebuls.mycalculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

/**
 * Created by pebuls on 29.03.17.
 */

class SimpleCal extends AppCompatActivity implements View.OnClickListener{

    private HelperMethods helperMethods = new HelperMethods();
    private String op = "", text;
    private EditText editText1, editText2;
    private double value = 0;
    private double result = 0;
    private boolean usedEqual = false;
    private int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState != null) {
            op = savedInstanceState.getString("op");
            text = savedInstanceState.getString("text");
            count = savedInstanceState.getInt("count");
            value = savedInstanceState.getDouble("value");
            result = savedInstanceState.getDouble("result");
            usedEqual = savedInstanceState.getBoolean("usedEqual");
        }

        setContentView(R.layout.activity_simple_main);

        editText1=(EditText)findViewById(R.id.editText1);
        editText2=(EditText)findViewById(R.id.editText2);
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);

        savedInstanceState.putString("op", op);
        savedInstanceState.putString("text", text);
        savedInstanceState.putInt("count", count);
        savedInstanceState.putDouble("value", value);
        savedInstanceState.putDouble("result", result);
        savedInstanceState.putBoolean("usedEqual", usedEqual);
    }

    public void onClick(View view)
    {
        switch(view.getId())
        {
            case R.id.zero:

                usedEqual = helperMethods.isEqualUsed(usedEqual, editText1);

                editText2.setText(editText2.getText()+"0");
                value = Double.parseDouble(editText2.getText().toString());
                break;

            case R.id.one:

                usedEqual = helperMethods.isEqualUsed(usedEqual, editText1);

                editText2.setText(editText2.getText()+"1");
                value = Double.parseDouble(editText2.getText().toString());
                break;

            case R.id.two:
                usedEqual = helperMethods.isEqualUsed(usedEqual, editText1);

                editText2.setText(editText2.getText()+"2");
                value = Double.parseDouble(editText2.getText().toString());
                break;

            case R.id.three:

                usedEqual = helperMethods.isEqualUsed(usedEqual, editText1);

                editText2.setText(editText2.getText()+"3");
                value = Double.parseDouble(editText2.getText().toString());
                break;

            case R.id.four:

                usedEqual = helperMethods.isEqualUsed(usedEqual, editText1);

                editText2.setText(editText2.getText()+"4");
                value = Double.parseDouble(editText2.getText().toString());
                break;

            case R.id.five:

                usedEqual = helperMethods.isEqualUsed(usedEqual, editText1);

                editText2.setText(editText2.getText()+"5");
                value = Double.parseDouble(editText2.getText().toString());
                break;

            case R.id.six:

                usedEqual = helperMethods.isEqualUsed(usedEqual, editText1);

                editText2.setText(editText2.getText()+"6");
                value = Double.parseDouble(editText2.getText().toString());
                break;

            case R.id.seven:

                usedEqual = helperMethods.isEqualUsed(usedEqual, editText1);

                editText2.setText(editText2.getText()+"7");
                value = Double.parseDouble(editText2.getText().toString());
                break;

            case R.id.eight:

                usedEqual = helperMethods.isEqualUsed(usedEqual, editText1);

                editText2.setText(editText2.getText()+"8");
                value = Double.parseDouble(editText2.getText().toString());

            case R.id.nine:

                usedEqual = helperMethods.isEqualUsed(usedEqual, editText1);

                editText2.setText(editText2.getText()+"9");
                value = Double.parseDouble(editText2.getText().toString());
                break;

            case R.id.coma:

                if(count == 0) {
                    if (editText2.length() == 0) {
                        editText2.setText(editText2.getText() + "0.");
                    } else if (!helperMethods.isLastCharComa(editText2) && editText2.length() != 0) {
                        editText2.setText(editText2.getText() + ".");
                    }
                    count++;
                }
                break;

            case R.id.clear:

                editText1.setText("");
                editText2.setText("");
                result = 0;
                value = 0;
                op = "";
                count = 0;
                usedEqual = false;
                break;

            case R.id.posneg:

                if (editText2.length() != 0) {

                    if(helperMethods.getLastChar(editText2).equals(")") && helperMethods.getFirstChar(editText2).equals("(")) {
                        editText2.setText("-(" + value + ")");
                    }else   {
                        text = editText2.getText().toString();

                        if(helperMethods.getFirstChar(editText2).equals("-"))   {
                            editText2.setText(text.substring(1, text.length()));
                        } else editText2.setText("-(" + value + ")");
                    }
                }
                break;

            case R.id.plus:

                usedEqual = helperMethods.isEqualUsed(usedEqual, editText1);

                if(editText2.length() != 0) {
                    if (!op.equals("")) {
                        result = helperMethods.operate(result, value, op);
                    } else result = value;
                }

                op = operationClicked("+");
                break;

            case R.id.minus:

                usedEqual = helperMethods.isEqualUsed(usedEqual, editText1);

                if(editText2.length() != 0) {
                    if (!op.equals("")) {
                        result = helperMethods.operate(result, value, op);
                    } else result = value;
                }

                op = operationClicked("-");
                break;

            case R.id.divide:

                usedEqual = helperMethods.isEqualUsed(usedEqual, editText1);

                if(editText2.length() != 0) {
                    if (!op.equals("")) {
                        result = helperMethods.operate(result, value, op);
                    } else result = value;
                }

                op = operationClicked("/");
                break;

            case R.id.multiply:

                usedEqual = helperMethods.isEqualUsed(usedEqual, editText1);

                if(editText2.length() != 0) {
                    if (!op.equals("")) {
                        result = helperMethods.operate(result, value, op);
                    } else result = value;
                }

                op = operationClicked("*");
                break;

            case R.id.equal:

                if(editText1.length() != 0 || (editText1.length() == 0 && editText2.length() != 0)) {

                    if(editText2.length() != 0) {

                        value = helperMethods.ifIsNegativeReturnNegative(editText2, value);

                        if (!op.equals("")) {
                            result = helperMethods.operate(result, value, op);
                        } else result = value;
                    }

                    try {
                        editText1.setText(result + "");
                        editText2.setText("");
                        result = 0;
                        value = 0;
                        op = "";
                        count = 0;
                        usedEqual = true;

                    } catch (Exception e) {
                        editText2.setText("Invalid Expression");
                        editText1.setText("");
                    }
                }
                break;

            case R.id.backSpace:
                text = editText2.getText().toString();

                if(text.length() > 0)
                {
                    if (text.length() == 1)
                    {
                        editText2.setText("0");
                    }else   {
                        String newText = text.substring(0, text.length()-1);

                        if(newText.endsWith(".")) count--;

                        if(text.endsWith(")"))
                        {
                            char []a = text.toCharArray();
                            int pos = a.length - 2;
                            int counter = 1;

                            for(int i = a.length - 2; i >= 0 ; i--)
                            {
                                if(a[i] == ')')
                                {
                                    counter++;
                                }
                                else if(a[i] == '(')
                                {
                                    counter--;
                                }

                                if(counter == 0)
                                {
                                    pos = i;
                                    break;
                                }
                            }
                            newText=text.substring(0,pos);
                        }

                        if(newText.equals("-")||newText.endsWith("sqrt"))
                        {
                            newText="";
                        }else if(newText.endsWith("^")) {
                            newText = newText.substring(0, newText.length() - 1);
                        }
                        editText2.setText(newText);
                    }
                }
                value = Double.parseDouble(editText2.getText().toString());
                break;
        }
    }

    private String operationClicked(String op)
    {
        if(editText2.length() != 0)
        {
            result = helperMethods.ifIsNegativeReturnNegative(editText2, result);

            if(!helperMethods.isLastCharComa(editText2))  {
                text = editText2.getText().toString();
                editText1.setText(editText1.getText() + text + op);
                editText2.setText("");
            }
        }
        else
        {
            if(editText1.length() > 0)
            {
                editText1.setText(editText1.getText() + op);
            }
        }
        count = 0;
        return op;
    }
}
