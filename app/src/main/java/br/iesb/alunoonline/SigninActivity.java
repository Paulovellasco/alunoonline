package br.iesb.alunoonline;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SigninActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private EditText txtEmail;
    private EditText txtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        mAuth = FirebaseAuth.getInstance();

        txtEmail = findViewById(R.id.txtEmail);
        txtPassword = findViewById(R.id.txtPw);

        Button bt = findViewById(R.id.btnCreateAcount);
        bt.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent t = new Intent(SigninActivity.this, MainActivity.class);
                startActivity(t);
            }
        });
    }
/*
    private void Login(){
        mAuth.createWithEmailAndPassword(txtEmail.getText().toString(), txtPassword.getText().toString())
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (!task.isSuccessful()) {
                            Toast.makeText(LoginActivity.this, "Não foi possível efetuar login", Toast.LENGTH_LONG).show();
                        }else {
                            startActivity(new Intent(LoginActivity.this, MainActivity.class));
                        }

                    }
                });
    }
    */
}
