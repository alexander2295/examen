package facci.daryguale.serviciosweb;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import facci.daryguale.serviciosweb.iu.enter.EnterUserActivity;

public class MainActivity extends AppCompatActivity {

    private EditText EditTextUser;
    private View ButtonFollowers, materia;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {

        EditTextUser = findViewById(R.id.enter_user_edit_text);
        ButtonFollowers = findViewById(R.id.enter_user_button);
        materia = findViewById(R.id.materia);

        ButtonFollowers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, InfoUserActivity.class);
                intent.putExtra("loginName",EditTextUser.getText().toString().trim());
                startActivity(intent);
            }
        });

        materia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               startActivity(new Intent(MainActivity.this, Main2ActivityEnviar.class));
            }
        });

    }





}
