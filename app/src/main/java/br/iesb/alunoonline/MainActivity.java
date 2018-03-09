package br.iesb.alunoonline;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.UUID;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button bt = findViewById(R.id.addData);
        bt.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("iesb/aluno/" + UUID.randomUUID().toString());

                myRef.child("Curso").setValue("ADM");
                myRef.child("Nome").setValue("Aluno2");

            }
        });
    }
}
