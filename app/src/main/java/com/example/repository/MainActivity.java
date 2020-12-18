package com.example.repository;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    ArrayList<Repository> repoList=new ArrayList<>();
    private RepoAdapter repoAdapter;
    private RecyclerView reporecyclerview;
//    private TextView reponame, ownername;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        reporecyclerview=(RecyclerView)findViewById(R.id.repo_recyclerview);
        reporecyclerview.setLayoutManager(new LinearLayoutManager(this));

        getRepoList();
    }

    private void getRepoList() {
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://api.github.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RepoInteface repoInteface=retrofit.create(RepoInteface.class);
        Call<List<Repository>> call=repoInteface.getRepoList();



        call.enqueue(new Callback<List<Repository>>() {
            @Override
            public void onResponse(Call<List<Repository>> call, Response<List<Repository>> response) {
                repoList=new ArrayList<>(response.body());
                repoAdapter=new RepoAdapter(MainActivity.this,repoList);
                reporecyclerview.setAdapter(repoAdapter);
                Toast.makeText(MainActivity.this,"Repo list retrieved successfully",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<List<Repository>> call, Throwable t) {
                Toast.makeText(MainActivity.this,"Failed",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
