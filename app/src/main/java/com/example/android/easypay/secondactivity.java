package com.example.android.easypay;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import android.widget.Toast;

import com.example.easypay.R;
import com.google.firebase.auth.FirebaseAuth;

public class secondactivity extends AppCompatActivity implements AdapterView.OnItemClickListener {


   DatabaseReference databaseitem;
    ListView lst;

    String[] months={"RELIANCE FRESH","NILGIRI'S","MY SHOPPEE","AMBIKA SUPERMARKET","ROYAL SUPERMARKET","BIG BAZAAR","SINGAPORE SHOPPEE","SRI VENKATESWARA SUPERMARKET","SPENCER'S HYPER","BOMBAY GENERAL STORES","GRACE SUPERMARKET"};


    private FirebaseAuth firebaseAuth;
    private void Logout(){
        firebaseAuth.signOut();;
        finish();
        startActivity(new Intent(secondactivity.this,MainActivity.class));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondactivity);

        firebaseAuth = FirebaseAuth.getInstance();

        databaseitem= FirebaseDatabase.getInstance().getReference("items");

        lst=(ListView) findViewById(R.id.listvw1);
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,months);
        lst.setAdapter(arrayAdapter);
        lst.setOnItemClickListener(this);
    }

    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

       add();
        startActivity(new Intent(secondactivity.this, ThirdActivity.class));

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.idlogout:{
                Logout();
            }
        }
        return super.onOptionsItemSelected(item);
    }

    private void add(){

        String name1="Patanjali dant kanti";
        String weight1="100g";
        String cost1="66.00";
        items item1=new items(name1,weight1,cost1);
        databaseitem.child("8904109451522").setValue(item1);


        String name2="Cello jet max";
        String weight2="1N";
        String cost2="60.00";
        items item2=new items(name2,weight2,cost2);
        databaseitem.child("8907234000399").setValue(item2);

        String name3="Rin matic";
        String weight3="1kg";
        String cost3="120.00";
        items item3=new items(name3,weight3,cost3);
        databaseitem.child("8901030317859").setValue(item3);

        String name4="Cello Butterflow";
        String weight4="1N";
        String cost4="50.00";
        items item4=new items(name4,weight4,cost4);
        databaseitem.child("8907234505450").setValue(item4);

        String name5="Nataraj Glow";
        String weight5="5pc";
        String cost5="15.00";
        items item5=new items(name5,weight5,cost5);
        databaseitem.child("8901324010473").setValue(item5);

        String name6="Luxor Pilot";
        String weight6="1N";
        String cost6="60.00";
        items item6=new items(name6,weight6,cost6);
        databaseitem.child("8901198107231").setValue(item6);

        String name7="Navratna Oil";
        String weight7="100ml";
        String cost7="75.00";
        items item7=new items(name7,weight7,cost7);
        databaseitem.child("8901248104159").setValue(item7);

        String name8="Cello Super Star";
        String weight8="5pc";
        String cost8="30.00";
        items item8=new items(name8,weight8,cost8);
        databaseitem.child("8907234501711").setValue(item8);

        String name9="Nataraj Gelix";
        String weight9="5pc";
        String cost9="25.00";
        items item9=new items(name9,weight9,cost9);
        databaseitem.child("8901324013160").setValue(item9);

        String name10="Good Knight";
        String weight10="30N";
        String cost10="60.00";
        items item10=new items(name10,weight10,cost10);
        databaseitem.child("8901157000214").setValue(item10);

        String name11="Mysore sandal soap";
        String weight11="75g";
        String cost11="37.00";
        items item11=new items(name11,weight11,cost11);
        databaseitem.child("8901287100013").setValue(item11);

        String name12="Cartini Scissors";
        String weight12="1N";
        String cost12="190.00";
        items item12=new items(name12,weight12,cost12);
        databaseitem.child("8904039471232").setValue(item12);

        String name13="Aachi Pickle";
        String weight13="200g";
        String cost13="50.00";
        items item13=new items(name13,weight13,cost13);
        databaseitem.child("8904209303882").setValue(item13);

        String name14="Fruit Nik";
        String weight14="500ml";
        String cost14="30.00";
        items item14=new items(name14,weight14,cost14);
        databaseitem.child("8906014140027").setValue(item14);

        String name15="zhenix Hook";
        String weight15="1N";
        String cost15="30.00";
        items item15=new items(name15,weight15,cost15);
        databaseitem.child("6930662070087").setValue(item15);

        String name16="Hauser 4 in 1";
        String weight16="1N";
        String cost16="30.00";
        items item16=new items(name16,weight16,cost16);
        databaseitem.child("8901765124043").setValue(item16);

        String name17="Chandrika soap";
        String weight17="125g";
        String cost17="38.00";
        items item17=new items(name17,weight17,cost17);
        databaseitem.child("8901399022012").setValue(item17);

       String name18="Pril DishWash";
        String weight18="225ml";
        String cost18="51.00";
        items item18=new items(name18,weight18,cost18);
        databaseitem.child("8902102160687").setValue(item18);

        String name19="Eno";
        String weight19="5g";
        String cost19="8.00";
        items item19=new items(name19,weight19,cost19);
        databaseitem.child("8901571006854").setValue(item19);

        String name20="Colgate";
        String weight20="200g";
        String cost20="95.00";
        items item20=new items(name20,weight20,cost20);
        databaseitem.child("8901314009081").setValue(item20);

        String name21="Bisleri";
        String weight21="1l";
        String cost21="20.00";
        items item21=new items(name21,weight21,cost21);
        databaseitem.child("8908003470023").setValue(item21);
        //databaseitem.setValue(item);

        String name22="Dairy Milk";
        String weight22="6.6g";
        String cost22="5.00";
        items item22=new items(name22,weight22,cost22);
        databaseitem.child("8901233030517").setValue(item22);
        Toast.makeText(secondactivity.this,"Items are ready",Toast.LENGTH_LONG).show();
    }

}
