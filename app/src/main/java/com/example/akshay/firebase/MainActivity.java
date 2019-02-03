package com.example.akshay.firebase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.client.Firebase;

public class MainActivity extends AppCompatActivity {

    EditText t1,t2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        t1=findViewById(R.id.textView1);
        t2=findViewById(R.id.textView2);
    }

    public void click(View view)
    {
   String name = t1.getText().toString();
   String address = t2.getText().toString();
   if(name.equals("")| address.equals(""))
   {
       Toast.makeText(this, "enter the values", Toast.LENGTH_SHORT).show();
   }

    }
}
