package com.example.android.easypay;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import com.example.easypay.R;

public class MainActivity extends AppCompatActivity {

    private EditText Name;
    private EditText Password;
    private Button Login;
    private int counter=5;
    private TextView userreg;
    private FirebaseAuth firebaseauth;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Name=(EditText)findViewById(R.id.idname);
        Password=(EditText)findViewById(R.id.idpassword);
        Login=(Button)findViewById(R.id.idbutton);
        userreg=(TextView)findViewById(R.id.idsignup);
        firebaseauth=FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(this);


        FirebaseUser user = firebaseauth.getCurrentUser();

        if(user != null){
            finish();
            startActivity(new Intent(MainActivity.this, secondactivity.class));
        }
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                validate(Name.getText().toString(),Password.getText().toString());

            }
        });
        userreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,register.class));
            }
        });
    }

    private void validate(String userName,String userPassword)
    {
        progressDialog.setMessage("Please wait for verification");
        progressDialog.show();
        firebaseauth.signInWithEmailAndPassword(userName,userPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    progressDialog.dismiss();
                    Toast.makeText(MainActivity.this,"Login succesfull",Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(MainActivity.this, secondactivity.class));
                }else{
                    Toast.makeText(MainActivity.this,"Login failed",Toast.LENGTH_SHORT).show();
                    counter--;
                    progressDialog.dismiss();
                    if(counter == 0)
                        Login.setEnabled(false);
                }
            }
        });


    }
}
