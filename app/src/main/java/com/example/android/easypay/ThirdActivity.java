package com.example.android.easypay;


import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.easypay.R;
import com.google.firebase.auth.FirebaseAuth;


public class ThirdActivity extends AppCompatActivity {

    // private final int BARCODE_RECO_REQ_CODE=200;

    // Button scan;
    TextView itemname1;
    TextView itemname2;
    TextView itemname3;
    TextView itemname4;
    TextView itemname5;
    TextView itemname6;
    TextView itemname7;
    TextView itemname8;
    TextView itemname9;
    TextView itemname10;
    TextView itemname11;
    TextView itemname12;
    TextView itemname13;
    TextView itemname14;
    TextView itemname15;

    TextView itemweight1;
    TextView itemweight2;
    TextView itemweight3;
    TextView itemweight4;
    TextView itemweight5;
    TextView itemweight6;
    TextView itemweight7;
    TextView itemweight8;
    TextView itemweight9;
    TextView itemweight10;
    TextView itemweight11;
    TextView itemweight12;
    TextView itemweight13;
    TextView itemweight14;
    TextView itemweight15;

    TextView itemcost1;
    TextView itemcost2;
    TextView itemcost3;
    TextView itemcost4;
    TextView itemcost5;
    TextView itemcost6;
    TextView itemcost7;
    TextView itemcost8;
    TextView itemcost9;
    TextView itemcost10;
    TextView itemcost11;
    TextView itemcost12;
    TextView itemcost13;
    TextView itemcost14;
    TextView itemcost15;
    TextView total;
    TextView comment;


    int counter=0;
    float sum=0,num;

    DatabaseReference databaseitem;


    private FirebaseAuth firebaseAuth;


    private void additem(){


        IntentIntegrator scanIntegrator = new IntentIntegrator(ThirdActivity.this);
        scanIntegrator.initiateScan();

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu2,menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.idadditem: {
                additem();
            }
        }

        return super.onOptionsItemSelected(item);
    }

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);



        total=(TextView) findViewById(R.id.total2);


        itemname1=(TextView) findViewById(R.id.txt1);
        itemname2=(TextView) findViewById(R.id.txt4);
        itemname3=(TextView) findViewById(R.id.txt7);
        itemweight1=(TextView) findViewById(R.id.txt2);
        itemweight2=(TextView) findViewById(R.id.txt5);
        itemweight3=(TextView) findViewById(R.id.txt8);

        itemcost1=(TextView)findViewById(R.id.txt3);
        itemcost2=(TextView)findViewById(R.id.txt6);
        itemcost3=(TextView)findViewById(R.id.txt9);

        itemname4=(TextView) findViewById(R.id.txt10);
        itemweight4=(TextView) findViewById(R.id.txt11);
        itemcost4=(TextView)findViewById(R.id.txt12);

        itemname5=(TextView) findViewById(R.id.txt13);
        itemweight5=(TextView) findViewById(R.id.txt14);
        itemcost5=(TextView)findViewById(R.id.txt15);

        itemname6=(TextView) findViewById(R.id.txt16);
        itemweight6=(TextView) findViewById(R.id.txt17);
        itemcost6=(TextView)findViewById(R.id.txt18);

        itemname7=(TextView) findViewById(R.id.txt19);
        itemweight7=(TextView) findViewById(R.id.txt20);
        itemcost7=(TextView)findViewById(R.id.txt21);

        itemname8=(TextView) findViewById(R.id.txt22);
        itemweight8=(TextView) findViewById(R.id.txt23);
        itemcost8=(TextView)findViewById(R.id.txt24);

        itemname9=(TextView) findViewById(R.id.txt25);
        itemweight9=(TextView) findViewById(R.id.txt26);
        itemcost9=(TextView)findViewById(R.id.txt27);

        itemname10=(TextView) findViewById(R.id.txt28);
        itemweight10=(TextView) findViewById(R.id.txt29);
        itemcost10=(TextView)findViewById(R.id.txt30);

        itemname11=(TextView) findViewById(R.id.txt31);
        itemweight11=(TextView) findViewById(R.id.txt32);
        itemcost11=(TextView)findViewById(R.id.txt33);

        itemname12=(TextView) findViewById(R.id.txt34);
        itemweight12=(TextView) findViewById(R.id.txt35);
        itemcost12=(TextView)findViewById(R.id.txt36);

        itemname13=(TextView) findViewById(R.id.txt37);
        itemweight13=(TextView) findViewById(R.id.txt38);
        itemcost13=(TextView)findViewById(R.id.txt39);

        itemname14=(TextView) findViewById(R.id.txt40);
        itemweight14=(TextView) findViewById(R.id.txt41);
        itemcost14=(TextView)findViewById(R.id.txt42);

        comment=(TextView)findViewById(R.id.comment);

        firebaseAuth = FirebaseAuth.getInstance();

    }

    protected void onActivityResult ( int requestCode, int resultCode, Intent in ) {

        IntentResult scanningResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, in);

        if (scanningResult != null) {



            final String contents = in.getStringExtra( "SCAN_RESULT" );
            String format = in.getStringExtra( "SCAN_RESULT_FORMAT" ) ;
            //Toast.makeText(ThirdActivity.this, "Content-" + contents + " Format-" + format, Toast.LENGTH_LONG).show();
            databaseitem=FirebaseDatabase.getInstance().getReference().child("items").child(contents);
            databaseitem.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    String name=dataSnapshot.child("name").getValue().toString();
                    String weight=dataSnapshot.child("weight").getValue().toString();
                    String cost=dataSnapshot.child("cost").getValue().toString();
                    if(counter==0) {
                        itemname1.setText(name);
                        itemweight1.setText(weight);
                        itemcost1.setText(cost);

                       // String number=itemcost1.getText().toString();
                        num=Float.parseFloat(cost);
                       sum=sum+num;
                       String temp=String.valueOf(sum);
                       total.setText(temp);
                    }

                    else if(counter==1){
                        itemname2.setText(name);
                        itemweight2.setText(weight);
                        itemcost2.setText(cost);
                        num=Float.parseFloat(cost);
                        sum=sum+num;
                        String temp=String.valueOf(sum);
                        total.setText(temp);
                    }

                    else if(counter==2){
                        itemname3.setText(name);
                        itemweight3.setText(weight);
                        itemcost3.setText(cost);
                        num=Float.parseFloat(cost);
                        sum=sum+num;
                        String temp=String.valueOf(sum);
                        total.setText(temp);

                    }

                    else if(counter==3){
                        itemname4.setText(name);
                        itemweight4.setText(weight);
                        itemcost4.setText(cost);
                        num=Float.parseFloat(cost);
                        sum=sum+num;
                        String temp=String.valueOf(sum);
                        total.setText(temp);

                    }

                    else if(counter==4){
                        itemname5.setText(name);
                        itemweight5.setText(weight);
                        itemcost5.setText(cost);
                        num=Float.parseFloat(cost);
                        sum=sum+num;
                        String temp=String.valueOf(sum);
                        total.setText(temp);

                    }

                    else if(counter==5){
                        itemname6.setText(name);
                        itemweight6.setText(weight);
                        itemcost6.setText(cost);
                        num=Float.parseFloat(cost);
                        sum=sum+num;
                        String temp=String.valueOf(sum);
                        total.setText(temp);

                    }

                    else if(counter==6){
                        itemname7.setText(name);
                        itemweight7.setText(weight);
                        itemcost7.setText(cost);
                        num=Float.parseFloat(cost);
                        sum=sum+num;
                        String temp=String.valueOf(sum);
                        total.setText(temp);

                    }

                    else if(counter==7){
                        itemname8.setText(name);
                        itemweight8.setText(weight);
                        itemcost8.setText(cost);
                        num=Float.parseFloat(cost);
                        sum=sum+num;
                        String temp=String.valueOf(sum);
                        total.setText(temp);

                    }

                    else if(counter==8){
                        itemname9.setText(name);
                        itemweight9.setText(weight);
                        itemcost9.setText(cost);
                        num=Float.parseFloat(cost);
                        sum=sum+num;
                        String temp=String.valueOf(sum);
                        total.setText(temp);

                    }

                    else if(counter==9){
                        itemname10.setText(name);
                        itemweight10.setText(weight);
                        itemcost10.setText(cost);
                        num=Float.parseFloat(cost);
                        sum=sum+num;
                        String temp=String.valueOf(sum);
                        total.setText(temp);

                    }

                    else if(counter==10){
                        itemname11.setText(name);
                        itemweight11.setText(weight);
                        itemcost11.setText(cost);
                        num=Float.parseFloat(cost);
                        sum=sum+num;
                        String temp=String.valueOf(sum);
                        total.setText(temp);

                    }

                    else if(counter==11){
                        itemname12.setText(name);
                        itemweight12.setText(weight);
                        itemcost12.setText(cost);
                        num=Float.parseFloat(cost);
                        sum=sum+num;
                        String temp=String.valueOf(sum);
                        total.setText(temp);

                    }

                    else if(counter==12){
                        itemname13.setText(name);
                        itemweight13.setText(weight);
                        itemcost13.setText(cost);
                        num=Float.parseFloat(cost);
                        sum=sum+num;
                        String temp=String.valueOf(sum);
                        total.setText(temp);

                    }

                    else if(counter==13){
                        itemname14.setText(name);
                        itemweight14.setText(weight);
                        itemcost14.setText(cost);
                        num=Float.parseFloat(cost);
                        sum=sum+num;
                        String temp=String.valueOf(sum);
                        total.setText(temp);
                        comment.setText("Thats for this page.Add page to add more");
                    }


                    //itemlist[counter].replace("",name);
                   // weightlist[counter].replace("",weight);
                    //costlist[counter].replace("",cost);
                    counter++;
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }

            });
            // scan_format.setText(format);
            //scan_content.setText(contents);

        }
    }




}















