package com.example.laundry_manage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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



public class logn extends AppCompatActivity {

    EditText emal, Pass;
    TextView forgot;
    Button login;
    FirebaseUser user;

    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logn);

        mAuth=FirebaseAuth.getInstance();

        emal = findViewById(R.id.login_email);
        Pass = findViewById(R.id.login_pass);
        login = findViewById(R.id.login);
        forgot=findViewById(R.id.notreg);



        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = emal.getText().toString();
                String pass = Pass.getText().toString();
                mAuth.signInWithEmailAndPassword(email, pass)
                        .addOnCompleteListener(logn.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
                                    updateUI(user);
                                } else {
                                    // If sign in fails, display a message to the user.
                                    Toast.makeText(logn.this, "Authentication failed: " + task.getException(),
                                            Toast.LENGTH_SHORT).show();
                                    updateUI(null);
                                }
                            }
                        });

            }
            private void updateUI(FirebaseUser user) {
                user = mAuth.getCurrentUser();
                /*-------- Check if user is already logged in or not--------*/
                if (user != null) {
                    /*------------ If user's email is verified then access login -----------*/

                        Toast.makeText(logn.this, "Login Success.",
                                Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(logn.this, MainActivity.class));

                }

            }
        });

        forgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(logn.this,signupActivity.class));
            }
        });




    }

}
