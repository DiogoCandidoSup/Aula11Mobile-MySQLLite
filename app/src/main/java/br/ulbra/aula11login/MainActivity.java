package br.ulbra.aula11login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity
{
    Button btentrar,btregistrar;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btentrar = (Button) findViewById(R.id.btEntrar);
        btregistrar = (Button) findViewById(R.id.btRegistrar);

        btentrar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                /*
                Intent i = new Intent(MainActivity.this,LoginActivity.class);

                startActivity(i);
                */
                setContentView(R.layout.activity_login);
            }
        });

        btregistrar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                /*
                Intent i = new Intent(MainActivity.this,RegistrarActivity.class);

                startActivity(i);
                */
                setContentView(R.layout.activity_registrar);
            }
        });
    }
}