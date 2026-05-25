package br.ulbra.applogin;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegistrarActivity extends AppCompatActivity {

    EditText edUser, edPass1, edPass2;
    Button btSalvar;

    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);

        db = new DBHelper(this);

        edUser = findViewById(R.id.edUser);
        edPass1 = findViewById(R.id.edPass1);
        edPass2 = findViewById(R.id.edPass2);

        btSalvar = findViewById(R.id.btSalvar);

        btSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String username =
                        edUser.getText().toString();

                String pass1 =
                        edPass1.getText().toString();

                String pass2 =
                        edPass2.getText().toString();

                if(username.equals("")) {

                    Toast.makeText(
                            RegistrarActivity.this,
                            "Digite o usuário",
                            Toast.LENGTH_SHORT).show();

                }
                else if(pass1.equals("") || pass2.equals("")) {

                    Toast.makeText(
                            RegistrarActivity.this,
                            "Digite as senhas",
                            Toast.LENGTH_SHORT).show();

                }
                else if(!pass1.equals(pass2)) {

                    Toast.makeText(
                            RegistrarActivity.this,
                            "Senhas diferentes",
                            Toast.LENGTH_SHORT).show();

                }
                else {

                    long res =
                            db.criarUtilizador(username,
                                    pass1);

                    if(res > 0) {

                        Toast.makeText(
                                RegistrarActivity.this,
                                "Cadastro realizado",
                                Toast.LENGTH_SHORT).show();

                    }
                    else {

                        Toast.makeText(
                                RegistrarActivity.this,
                                "Erro no cadastro",
                                Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}