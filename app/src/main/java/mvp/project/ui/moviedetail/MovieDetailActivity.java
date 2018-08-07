package mvp.project.ui.moviedetail;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import mvp.project.R;
import mvp.project.util.IntentConstants;

/**
 * Created by Bhavin on 8/20/2017.
 */

public class MovieDetailActivity extends AppCompatActivity implements MovieDetailContract.IMovieDetailView {

    private String movieName,movieUrl;
    private MovieDetailPresenter presenter;
    private ImageView ivMoviePoster;
    private TextView tvMovieName;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        initialiseVariables();
    }

    private void initialiseVariables() {

        if(getIntent().hasExtra(IntentConstants.MOVIE_NAME))
            movieName = getIntent().getStringExtra(IntentConstants.MOVIE_NAME);
        if(getIntent().hasExtra(IntentConstants.MOVIE_URL))
            movieUrl = getIntent().getStringExtra(IntentConstants.MOVIE_URL);

        tvMovieName = (TextView) findViewById(R.id.tvMovieItemName);
        ivMoviePoster = (ImageView) findViewById(R.id.ivMoviePoster);

        presenter = new MovieDetailPresenter(this);
        presenter.loadData(movieName, movieUrl);
    }

    @Override
    public void showToastMessage(@StringRes int resId) {
        Toast.makeText(this, getString(resId), Toast.LENGTH_LONG).show();
    }

    @Override
    public void showMoviePoster(String movieUrl) {
        Picasso.with(this).load(movieUrl).into(ivMoviePoster);
    }

    @Override
    public void showMovieName(String movieName) {
        tvMovieName.setText(movieName);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}
