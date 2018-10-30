package com.example.gravesm.myapplication;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView text = (TextView) findViewById(R.id.text);
    TextInputLayout inputA = (TextInputLayout) findViewById(R.id.inputA);
    TextInputLayout inputB = (TextInputLayout) findViewById(R.id.inputB);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text.setText("Anagram Tester");

        Button demoButton = (Button) findViewById(R.id.demoButton);


        demoButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                String a=inputA.toString();
                String b=inputB.toString();
                text.setText("Is anagram?: "+anagram(a,b));
            }
        });

    }

    static boolean anagram(String a, String b){
        MyHashmap<Integer, String> aMap=new MyHashmap<>();
        MyHashmap<Integer, String> bMap=new MyHashmap<>();

        if(a==null||b==null){ return false; }

        for(int i=0; i<a.length(); i++){
            aMap.put(i, a.substring(i,i+1));
        }
        for(int i=0; i<b.length(); i++){
            bMap.put(i, b.substring(i,i+1));
        }

        if(aMap.size()!=bMap.size()){ return false; }

        Object ae=aMap.head;
        Object be;

        while(aMap.size()!=0){
            be=bMap.head;
            while(((MyHashmap.Entry) ae).getVal()!=((MyHashmap.Entry) be).getVal()){
                if(be==null){ return false; }
                be=((MyHashmap.Entry) be).getAfter();
            }
            ae=((MyHashmap.Entry) ae).getAfter();
        }
        return true;
    }

}
