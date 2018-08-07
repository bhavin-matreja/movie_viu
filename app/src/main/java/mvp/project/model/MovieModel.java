package mvp.project.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Bhavin on 8/20/2017.
 */

public class MovieModel {

    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("url")
    @Expose
    public Url url;
    @SerializedName("timestamp")
    @Expose
    public String timestamp;

    public class Url {

        @SerializedName("small")
        @Expose
        public String small;
        @SerializedName("medium")
        @Expose
        public String medium;
        @SerializedName("large")
        @Expose
        public String large;

    }
}
