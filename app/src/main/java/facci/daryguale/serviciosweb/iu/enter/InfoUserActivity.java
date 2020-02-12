package facci.daryguale.serviciosweb.iu.enter;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import facci.daryguale.serviciosweb.R;
import facci.daryguale.serviciosweb.iu.enter.AdaptadorFollowers;
import facci.daryguale.serviciosweb.rest.adapter.GitHubAdapter;
import facci.daryguale.serviciosweb.rest.model.Owner;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InfoUserActivity extends AppCompatActivity {

    ArrayList<Owner> listaFollowers;
    RecyclerView recyclerViewFollowers;

    TextView textViewRepositories, textViewFollowing;
    ImageView imageViewProfile;

    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_user);

        textViewFollowing = findViewById(R.id.textViewFollowing);
        textViewRepositories = findViewById(R.id.textViewRepositories);
        imageViewProfile = (ImageView) findViewById(R.id.imageViewProfile);

        progressBar = (ProgressBar)findViewById(R.id.progressBar);

        listaFollowers = new ArrayList<>();
        recyclerViewFollowers = (RecyclerView)findViewById(R.id.recyclerViewFollowers);

        recyclerViewFollowers.setLayoutManager(new LinearLayoutManager(this));

        String loginName = getIntent().getStringExtra("loginName");

        initProgressBar();

       // mostrarDatosBasicos(loginName);
        //mostrarSeguidores(loginName);
    }

    TextView labelFollowing, labelRepositories, labelFollowers;
    private void initProgressBar()
    {
        progressBar.setVisibility(View.VISIBLE);
        textViewFollowing.setVisibility(View.INVISIBLE);
        textViewRepositories.setVisibility(View.INVISIBLE);
        imageViewProfile.setVisibility(View.INVISIBLE);
        recyclerViewFollowers.setVisibility(View.INVISIBLE);

        labelFollowing = (TextView)findViewById(R.id.labelFollowing);
        labelFollowing.setVisibility(View.INVISIBLE);

        labelRepositories = (TextView) findViewById(R.id.labelRepositories);
        labelRepositories.setVisibility(View.INVISIBLE);

        labelFollowers = (TextView) findViewById(R.id.labelFollowers);
        labelFollowers.setVisibility(View.INVISIBLE);

    }

    private void endProgressBar()
    {
        progressBar.setVisibility(View.GONE);
        textViewFollowing.setVisibility(View.VISIBLE);
        textViewRepositories.setVisibility(View.VISIBLE);
        imageViewProfile.setVisibility(View.VISIBLE);
        recyclerViewFollowers.setVisibility(View.VISIBLE);

        labelFollowers.setVisibility(View.VISIBLE);
        labelRepositories.setVisibility(View.VISIBLE);
        labelFollowing.setVisibility(View.VISIBLE);

    }

    /*private void mostrarDatosBasicos(String loginName){
        GitHubAdapter adapter = new GitHubAdapter();

        Call<Owner> call = adapter.getOwner(loginName);

        call.enqueue(new Callback<Owner>() {

            @Override
            public void onResponse(Call<Owner> call, Response<Owner> response) {
                Owner owner = response.body();
                textViewRepositories.setText(owner.getPublicRepos().toString());
                textViewFollowing.setText(owner.getFollowing().toString());

                Picasso.get().load(owner.getAvatarUrl()).into(imageViewProfile);
            }

            @Override
            public void onFailure(Call<Owner> call, Throwable t) {
                //Toast.makeText(this, "Something went worng", Toast.LENGTH_LONG).show();
            }
        });


    }*/

    //public void mostrarSeguidores(View view){
    /*private void mostrarSeguidores(String loginName){
        GitHubAdapter adapter = new GitHubAdapter();
        Call<List<Owner>> call = adapter.getOwnerFollowers();
        call.enqueue(new Callback<List<Owner>>() {
            @Override
            public void onResponse(Call<List<Owner>> call, Response<List<Owner>> response) {
                List<Owner> lista = response.body();
                for (Owner owner: lista
                ) {
                    Log.e("LOGIN", owner.getLogin());
                    listaFollowers.add(owner);
                }
                AdaptadorFollowers adaptadorFollowers = new AdaptadorFollowers(listaFollowers);
                recyclerViewFollowers.setAdapter(adaptadorFollowers);
                endProgressBar();
            }

            @Override
            public void onFailure(Call<List<Owner>> call, Throwable t) {

                labelFollowers.setVisibility(View.VISIBLE);
                progressBar.setVisibility(View.GONE);
                labelFollowers.setText("Something went wrong");
            }
        });
    }*/
}

