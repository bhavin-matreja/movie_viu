package mvp.project.ui.movies2;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import mvp.project.R;
import mvp.project.model.MovieModel;
import mvp.project.ui.moviedetail.MovieDetailActivity;
import mvp.project.util.IntentConstants;

/**
 * Created by Bhavin on 11/28/2017.
 */

public class MoviesRecyclerAdapter extends RecyclerView.Adapter<MoviesRecyclerAdapter.ViewHolder> {

    private List<MovieModel> movieList;

    public MoviesRecyclerAdapter(List<MovieModel> movieList) {
        this.movieList = movieList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_movie,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        MovieModel movie = movieList.get(position);
        holder.tvMovieTitle.setText(movie.name);
        Picasso.with(holder.itemView.getContext()).load(movie.url.medium).into(holder.ivMoviePoster);
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private RelativeLayout movieContainer;
        TextView tvMovieTitle;
        ImageView ivMoviePoster;

        public ViewHolder(View itemView) {
            super(itemView);
            tvMovieTitle = (TextView) itemView.findViewById(R.id.tvMovieItemName);
            ivMoviePoster = (ImageView) itemView.findViewById(R.id.ivMoviePoster);
            movieContainer = (RelativeLayout) itemView.findViewById(R.id.rel_lay_movie_container);
            movieContainer.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.rel_lay_movie_container:
                    MovieModel movie = movieList.get(getAdapterPosition());
                    Intent intent = new Intent(itemView.getContext(), MovieDetailActivity.class);
                    intent.putExtra(IntentConstants.MOVIE_NAME, movie.name);
                    intent.putExtra(IntentConstants.MOVIE_URL, movie.url.large);
                    itemView.getContext().startActivity(intent);
                    break;
            }
        }
    }
}
