package facci.daryguale.serviciosweb;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import facci.daryguale.serviciosweb.iu.enter.EnterUserActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText EditTextUser;
    private View ButtonFollowers;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {

        EditTextUser = findViewById(R.id.enter_user_edit_text);
        ButtonFollowers = findViewById(R.id.enter_user_button);
        ButtonFollowers.setOnClickListener(this);


    }


    @Override
    public void onClick(View view) {
        if (view == ButtonFollowers){
            Intent intent = new Intent(this, InfoUserActivity.class);
            intent.putExtra("loginName",EditTextUser.getText().toString().trim());
            startActivity(intent);
        }
    }
}
