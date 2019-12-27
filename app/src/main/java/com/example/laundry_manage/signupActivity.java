package com.example.laundry_manage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;

public class signupActivity extends AppCompatActivity {

    EditText email,username,password,confpassword;
    Button signup;
    String EMAIL,USERNAME,PASSWORD;
    FirebaseAuth mAuth;
    FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        signup=findViewById(R.id.signup);
        mAuth=FirebaseAuth.getInstance();


        email=findViewById(R.id.user_email);
        username=findViewById(R.id.user_user);
        password=findViewById(R.id.ent_pass);
        confpassword=findViewById(R.id.conf_pass);

        EMAIL=email.getText().toString();
        PASSWORD=password.getText().toString();
        USERNAME=username.getText().toString();

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*if(PASSWORD.equals(confpassword.getText().toString())) {*/

                    mAuth.createUserWithEmailAndPassword(EMAIL,PASSWORD) .addOnCompleteListener(signupActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                userProfile();
                            } else {
                                // If sign in fails, display a message to the user.
                                Toast.makeText(signupActivity.this, "Sign up failed: " + task.getException(),
                                        Toast.LENGTH_SHORT).show();
                            }
                        }
                    });



                //}
               /* else{
                    Toast.makeText(signupActivity.this, "nothing",
                            Toast.LENGTH_SHORT).show();
                }*/

            }
        });


    }

    private void userProfile() {

        user=mAuth.getCurrentUser();
        if(user != null) {
            UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder()
                    .setDisplayName(USERNAME).build();
            user.updateProfile(profileUpdates);
            Toast.makeText(signupActivity.this, "Sign up success",
                    Toast.LENGTH_SHORT).show();

            startActivity(new Intent(signupActivity.this, logn.class));

        }

    }


}

