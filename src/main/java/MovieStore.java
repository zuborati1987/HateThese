import java.util.List;

public class MovieStore {
    private List<Movie> movies;

    public MovieStore () {
        XMLReader xmlReader = new XMLReader();
        this.movies = xmlReader.loadXml();;
    }

    public List<Movie> getMovies() {
        return movies;
    }
}
