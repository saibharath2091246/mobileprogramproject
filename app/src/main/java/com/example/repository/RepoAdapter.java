package com.example.repository;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RepoAdapter extends RecyclerView.Adapter<RepoAdapter.ViewHolder> {

    private ArrayList<Repository> repolist = new ArrayList<>();
    private Context context;


    public RepoAdapter(Context context, ArrayList<Repository> repo) {
        this.repolist = repo;
        this.context = context;
    }

    @NonNull
    @Override
    public RepoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.repo_list_item, viewGroup, false);
        return new RepoAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RepoAdapter.ViewHolder viewHolder, int i) {
        viewHolder.repo_name.setText(repolist.get(i).getName());
        viewHolder.owner_name.setText(repolist.get(i).getOwner().getLogin());
    }

    @Override
    public int getItemCount() {
        return repolist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView repo_name, owner_name;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            owner_name = (TextView) itemView.findViewById(R.id.ownerName);
            repo_name = (TextView) itemView.findViewById(R.id.repoName);
        }
    }
}

