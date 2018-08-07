package mvp.project.ui.movies2;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import mvp.project.R;
import mvp.project.model.MovieModel;

/**
 * Created by Bhavin on 11/28/2017.
 */

public class MoviesActivity extends AppCompatActivity implements MoviesContract.iMoviesView {

    private RecyclerView recyclerView;
    private ProgressDialog progressDialog;
    private MoviesPresenter presenter;
    private MoviesService service;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies_list);
        recyclerView = (RecyclerView) findViewById(R.id.rvMoviesList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);

        progressDialog = new ProgressDialog(this);
        progressDialog.setCancelable(false);
        progressDialog.setMessage(getString(R.string.loading));

        service = new MoviesService();
        presenter = new MoviesPresenter(this,service);
        presenter.fetchMoviesData();
    }

    @Override
    public void showProgressDialog() {

    }

    @Override
    public void hideProgressDialog() {

    }

    @Override
    public void setRecyclerAdapter(List<MovieModel> movieModels) {
        MoviesRecyclerAdapter adapter = new MoviesRecyclerAdapter(movieModels);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void showToastMessage(int resId) {

    }
}
