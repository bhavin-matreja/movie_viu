package mvp.project.ui.movies;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import mvp.project.R;
import mvp.project.model.MovieModel;
import mvp.project.ui.moviedetail.MovieDetailActivity;
import mvp.project.util.IntentConstants;

/**
 * Created by Bhavin on 8/20/2017.
 */

public class MoviesRecyclerAdapter extends RecyclerView.Adapter<MoviesRecyclerAdapter.ViewHolder> {

    private MoviesRecyclerPresenter presenter;

    public MoviesRecyclerAdapter(MoviesRecyclerPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_movie,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        presenter.onBindRepositoryRowViewAtPosition(position, holder);
    }

    @Override
    public int getItemCount() {
        return presenter.getRepositoriesRowsCount();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener,MoviesRecyclerPresenter.View {

        ImageView ivMoviePoster;
        TextView tvMovieName;
        RelativeLayout movieContainer;

        public ViewHolder(View itemView) {
            super(itemView);
            ivMoviePoster = (ImageView) itemView.findViewById(R.id.ivMoviePoster);
            tvMovieName = (TextView) itemView.findViewById(R.id.tvMovieItemName);
            movieContainer = (RelativeLayout) itemView.findViewById(R.id.rel_lay_movie_container);
            movieContainer.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.rel_lay_movie_container:
                    MovieModel movieData = presenter.onMovieItemClicked(getAdapterPosition());
                    startMovieDetailActivity(movieData);
                    break;
            }
        }

        @Override
        public void setMovieTitle(String name) {
            tvMovieName.setText(name);
        }

        @Override
        public void setMoviePosterImage(String url) {
            Picasso.with(itemView.getContext()).load(url).into(ivMoviePoster);
        }

        public void startMovieDetailActivity(MovieModel movie) {
            Intent intent = new Intent(itemView.getContext(), MovieDetailActivity.class);
            intent.putExtra(IntentConstants.MOVIE_NAME, movie.name);
            intent.putExtra(IntentConstants.MOVIE_URL, movie.url.large);
            itemView.getContext().startActivity(intent);
        }
    }
}
