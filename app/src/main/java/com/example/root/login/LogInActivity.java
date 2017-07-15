package com.example.root.login;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LogInActivity extends AppCompatActivity {
    EditText email,password;
    Button login,signup;
    private FirebaseAuth auth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        email=(EditText)findViewById(R.id.txt_email);
        password=(EditText)findViewById(R.id.txt_password);
        login=(Button)findViewById(R.id.btn_login);
        signup=(Button)findViewById(R.id.btn_register);
        auth = FirebaseAuth.getInstance();

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email2 = email.getText().toString().trim();
                final String password2 = password.getText().toString().trim();

                auth.signInWithEmailAndPassword(email2, password2)
                        .addOnCompleteListener(LogInActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                // If sign in fails, display a message to the user. If sign in succeeds
                                // the auth state listener will be notified and logic to handle the
                                // signed in user can be handled in the listener.
                                if (!task.isSuccessful()) {
                                    // there was an error
                                    if (password2.length() < 6) {
                                        Log.e("TAG", "onComplete: Password too short" );
                                    } else {
                                        Toast.makeText(LogInActivity.this, "Authentication Failed", Toast.LENGTH_LONG).show();
                                    }
                                } else {
                                    Toast.makeText(LogInActivity.this, "Login successful", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(LogInActivity.this, UploadProduct.class);
                                    startActivity(intent);

                                    finish();
                                }
                            }
                        });

//

            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LogInActivity.this, RegisterActivity.class);
                startActivity(intent);

            }
        });


    }
}
