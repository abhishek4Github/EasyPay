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

import com.example.easypay.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class register extends AppCompatActivity {

    private EditText username;
    private EditText useremail;
    private EditText userpassword;
    private Button regbutton;
    private TextView userlogin;
    private FirebaseAuth firebaseAuth;
    private ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        setupUIViews();
        firebaseAuth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(this);

        regbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validate()){
                    //upload data to the database
                    //String email = "sruthimeena.j@gmail.com";
                    String email=useremail.getText().toString().trim();
                    //useremail.getText().toString().trim();
                    // String password = "sruthi";
                    String  password=userpassword.getText().toString().trim();
                    //userpassword.getText().toString().trim();

                    progressDialog.setMessage("Please wait for verification");
                    progressDialog.show();
                    firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (!task.isSuccessful()) {
                                progressDialog.dismiss();
                                Toast.makeText(register.this, "Registration unsuccessfull", Toast.LENGTH_SHORT).show();
                            } else {
                                progressDialog.dismiss();
                                Toast.makeText(register.this, "Registration successfull", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(register.this, MainActivity.class));
                            }
                        }
                    });

                }
            }
        });
        userlogin.setOnClickListener(new View.OnClickListener (){
            @Override
            public void onClick(View view)  {
                startActivity(new Intent(register.this, MainActivity.class));
            }
        });
    }

    private void setupUIViews(){
        username =(EditText)findViewById(R.id.idusername);
        userpassword=(EditText)findViewById(R.id.idpassword);
        useremail=(EditText)findViewById(R.id.idemail);
        regbutton=(Button)findViewById(R.id.idregister);
        userlogin=(TextView)findViewById(R.id.idalready);


    }

    private Boolean validate()
    {
        Boolean result = false;

        String name=username.getText().toString();
        String password=userpassword.getText().toString();
        String email=useremail.getText().toString();

        if(name.isEmpty() || password.isEmpty() || email.isEmpty()){
            Toast.makeText(this,"please fill all the details", Toast.LENGTH_SHORT).show();

        }else{
            result = true;
        }

        return result;
    }
}
