import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

public class CSVWriter {

    public void writingToCSV(MovieStore movieStore) {
        File f = new File("Movies.csv");
        try {
            for (Movie movie : movieStore.getMovies()) {
                PrintWriter pw = new PrintWriter(new FileWriter(("Movies.csv"), true));
                StringBuilder sb = new StringBuilder();
                sb.append(movie.getDescription() + ",");
                sb.append(movie.getRating() + ",");
                sb.append(movie.getGenre() + ",");
                sb.append(movie.getRuntime() + ",");
                sb.append(movie.isAnimation() + ",");
                sb.append(movie.isMultilang());
                sb.append("\n");
                pw.append(sb.toString());
                pw.close();

            }

        } catch (
                Exception e) {
            System.out.println("file not found exception");
        }
    }
}
