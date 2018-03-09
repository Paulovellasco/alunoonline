package br.iesb.alunoonline;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ForgotPasswordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        Button bt = findViewById(R.id.btnSendNewPw);
        bt.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent t = new Intent(ForgotPasswordActivity.this, LoginActivity.class);
                startActivity(t);
            }
        });
    }
}
