package com.example.repository;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

interface RepoInteface {
    @GET("repositories")
    Call<List<Repository>> getRepoList();
}
