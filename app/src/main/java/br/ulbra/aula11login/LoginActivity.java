package br.ulbra.aula11login;

import android.os.Bundle;
import android.view.View;
import android.widget.*;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity
{
    EditText edlogin,edpass;

    Button btlogin;

    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        db = new DBHelper(this);

        edlogin = findViewById(R.id.edLogin);
        edpass = findViewById(R.id.edPass);

        btlogin = findViewById(R.id.btLogin);

        btlogin.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                String username = edlogin.getText().toString();
                String password = edpass.getText().toString();

                if(username.equals(""))
                {
                    Toast.makeText(LoginActivity.this, "INSIRA O LOGIN", Toast.LENGTH_SHORT).show();
                }
                else if(password.equals(""))
                {
                    Toast.makeText(LoginActivity.this, "INSIRA A SENHA", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    String res = db.validarLogin(username,password);

                    if(res.equals("OK!"))
                    {
                        Toast.makeText(LoginActivity.this, "Login OK!!", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        Toast.makeText(LoginActivity.this, "Login ou senha erradu", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
