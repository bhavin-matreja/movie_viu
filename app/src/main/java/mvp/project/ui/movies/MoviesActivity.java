package mvp.project.ui.movies;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.List;

import mvp.project.R;
import mvp.project.model.MovieModel;

/**
 * Created by Bhavin on 8/20/2017.
 */

public class MoviesActivity extends AppCompatActivity implements MoviesContract.IMoviesActivityView {

    private RecyclerView recyclerMoviesList;
    private MoviesRecyclerPresenter presenter;
    private MoviesPresenter moviesListPresenter;
    private MoviesService service;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies_list);

        recyclerMoviesList = (RecyclerView) findViewById(R.id.rvMoviesList);
        LinearLayoutManager mLayoutManager
                = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerMoviesList.setLayoutManager(mLayoutManager);

        progressDialog = new ProgressDialog(this);
        progressDialog.setCancelable(false);
        progressDialog.setMessage(getString(R.string.loading));

        service = new MoviesService();
        moviesListPresenter = new MoviesPresenter(this,service);
        moviesListPresenter.fetchMoviesData();
    }

    @Override
    public void setRecyclerAdapter(List<MovieModel> movieModels) {

        presenter = new MoviesRecyclerPresenter(movieModels);
        MoviesRecyclerAdapter adapter = new MoviesRecyclerAdapter(presenter);
        recyclerMoviesList.setAdapter(adapter);
    }

    @Override
    public void showToastMessage(@StringRes int resId) {
        Toast.makeText(this,getString(resId),Toast.LENGTH_LONG).show();
    }

    @Override
    public void showProgressDialog() {
        progressDialog.show();
    }

    @Override
    public void hideProgressDialog() {
        progressDialog.dismiss();
    }
}
