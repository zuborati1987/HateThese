import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializeDemo {
    public void serialize(Movie movie) {
        try {
            FileOutputStream fileOut = new FileOutputStream("src/main/resources/movie.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(movie);
            out.close();
            fileOut.close();
            System.out.println("Data serialized");
        } catch (IOException i) {
            i.printStackTrace();
        }
    }
}
