package br.ulbra.aula11login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import androidx.appcompat.app.AppCompatActivity;

public class RegistrarActivity extends AppCompatActivity
{
    EditText ednome,eduser,edpas1,edpas2;

    Button btsalvar;

    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);

        db = new DBHelper(this);

        ednome = (EditText) findViewById(R.id.edNome);
        eduser = (EditText) findViewById(R.id.edUser);
        edpas1 = (EditText) findViewById(R.id.edPas1);
        edpas2 = (EditText) findViewById(R.id.edPas2);

        btsalvar = findViewById(R.id.btSalvar);

        btsalvar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                String userName = eduser.getText().toString();
                String pas1 = edpas1.getText().toString();
                String pas2 = edpas2.getText().toString();

                if(userName.equals(""))
                {
                    Toast.makeText(RegistrarActivity.this, "INSIRA O LOGIN DO USUARIO", Toast.LENGTH_SHORT).show();
                }
                else if(pas1.equals("") || pas2.equals(""))
                {
                    Toast.makeText(RegistrarActivity.this, "INSIRA A SENHA DO USUARIO", Toast.LENGTH_SHORT).show();
                }
                else if(!pas1.equals(pas2))
                {
                    Toast.makeText(RegistrarActivity.this, "SENHAS DIFERENTES", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    long res = db.criarUtilizador(userName,pas1);

                    if(res > 0)
                    {
                        Toast.makeText(RegistrarActivity.this, "Registro OK!", Toast.LENGTH_SHORT).show();

                        setContentView(R.layout.activity_main);
                    }
                    else
                    {
                        Toast.makeText(RegistrarActivity.this, "Senha invalida!!!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
