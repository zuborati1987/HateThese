public class Movie implements java.io.Serializable{
    String description;
    double rating;
    String genre;
    int runtime;
    boolean animation;
    boolean multilang;

    public String getDescription() {
        return description;
    }

    public double getRating() {
        return rating;
    }

    public String getGenre() {
        return genre;
    }

    public int getRuntime() {
        return runtime;
    }

    public boolean isAnimation() {
        return animation;
    }

    public boolean isMultilang() {
        return multilang;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    public void setAnimation(boolean animation) {
        this.animation = animation;
    }

    public void setMultilang(boolean multilang) {
        this.multilang = multilang;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "description='" + description + '\'' +
                ", rating=" + rating +
                ", genre='" + genre + '\'' +
                ", runtime=" + runtime +
                ", animation=" + animation +
                ", multilang=" + multilang +
                '}';
    }
}
