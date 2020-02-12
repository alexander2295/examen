package facci.daryguale.serviciosweb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import facci.daryguale.serviciosweb.rest.adapter.GitHubAdapter;
import facci.daryguale.serviciosweb.rest.model.Owner;
import okhttp3.internal.Util;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Main2ActivityEnviar extends AppCompatActivity {

    EditText cedula, materia, estado;
    Button btnMateria;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2_enviar);
        cedula = findViewById(R.id.cedulUseMateria);
        materia = findViewById(R.id.nombreMateria);
        estado = findViewById(R.id.estadoMateria);
        btnMateria = findViewById(R.id.btnEnviar);

        btnMateria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkData();
            }
        });
    }

    void checkData(){
       Enviar enviar = new Enviar(cedula.getText().toString().trim(),materia.getText().toString().trim(),estado.getText().toString().trim());

        GitHubAdapter adapter = new GitHubAdapter();

        Call<Owner> call = adapter.setEnviar(enviar);

        call.enqueue(new Callback<Owner>() {
            @Override
            public void onResponse(Call<Owner> call, Response<Owner> response) {

            }

            @Override
            public void onFailure(Call<Owner> call, Throwable t) {
                Toast.makeText(Main2ActivityEnviar.this, "not", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public class Enviar {

        @SerializedName("cedula")
        private String cedula;
        @SerializedName("nombre")
        private String nombre;

        @SerializedName("estado")
        private String estado;

        public Enviar(String cedula,String nombre, String estado) {
            this.cedula = cedula;
            this.nombre = nombre;
            this.estado = estado;
        }




        public String getCedula() {
            return cedula;
        }

        public void setCedula(String cedula) {
            this.cedula = cedula;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getEstado() {
            return estado;
        }

        public void setEstado(String estado) {
            this.estado = estado;
        }
    }
}
