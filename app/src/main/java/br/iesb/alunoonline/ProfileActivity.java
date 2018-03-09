package br.iesb.alunoonline;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.UUID;

public class ProfileActivity extends AppCompatActivity {

    TextView myText;

    public static class Interesse{
        public String id;
        public String tag;

        public Interesse(String id, String tag){
            this.id = id;
            this.tag = tag;
        }
    }

    public static class Aluno{
        public String name = "";
        public int matricula;
        public String curso = "";
        public String campus = "";
        public String turno = "";
        public ArrayList<Interesse> interesses = new ArrayList<>();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Button bt = findViewById(R.id.btnSaveProfile);
        bt.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Aluno novoAluno = new Aluno();

                myText = findViewById(R.id.pflName);
                if(myText.getText() != null)
                    novoAluno.name = myText.getText().toString();

                myText = findViewById(R.id.pflMatricula);
                if(myText.getText() != null)
                    novoAluno.matricula = Integer.parseInt(myText.getText().toString());

                myText = findViewById(R.id.pflCurso);
                if(myText.getText() != null)
                    novoAluno.curso = myText.getText().toString();

                myText = findViewById(R.id.pflCampus);
                if(myText.getText() != null)
                    novoAluno.campus= myText.getText().toString();

                myText = findViewById(R.id.pflTurno);
                if(myText.getText() != null)
                    novoAluno.turno = myText.getText().toString();

                myText = findViewById(R.id.pflInteresses);
                String str = myText.getText().toString();
                if(myText.getText() != null)
                    for(String s : str.split(",")){
                        novoAluno.interesses.add(new Interesse(UUID.randomUUID().toString(), s));
                    }

                //Save on database
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("iesb/aluno/" + UUID.randomUUID().toString());

                myRef.setValue(novoAluno);
            }
        });
    }
}
