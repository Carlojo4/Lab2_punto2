package com.example.familia.lab2_punto2;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {
    private int opc=0;
    private TextView result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        result = (TextView)findViewById(R.id.tresult);
    }
    public void method (View view){
        if(view.getId()==R.id.rsuma)
            opc=1;
        else if(view.getId()==R.id.rresta)
            opc=2;
        else if(view.getId()==R.id.rmult)
            opc=3;
        else if(view.getId()==R.id.rdiv)
            opc=4;
    }

    public void method_1 (View view){
        final EditText num1 = (EditText)findViewById(R.id.eNum1);
        final EditText num2 = (EditText)findViewById(R.id.eNum2);
        float _num1,_num2, total;
        _num1 = Float.valueOf(num1.getText().toString());
        _num2 = Float.valueOf(num2.getText().toString());
        if ((num1.getText().toString().equals(""))||(num2.getText().toString().equals("")))
            result.setText("No ha ingresado números.");
        switch (opc){
            case 1:
                total = _num1+_num2;
                result.setText(String.valueOf(total));
                break;
            case 2:
                total = _num1-_num2;
                result.setText(String.valueOf(total));
                break;
            case 3:
                total= _num1*_num2;
                result.setText(String.valueOf(total));
                break;
            case 4:
                if (_num2==0)
                    result.setText("NaN");
                else {
                    total = _num1/_num2;
                    result.setText(String.valueOf(total));
                }
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    @Override
    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        String text1= result.getText().toString();
        outState.putString("string1",text1 );
    }
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onRestoreInstanceState(savedInstanceState);
        String text1 = savedInstanceState.getString("string1");
        result.setText(text1);

    }
}
