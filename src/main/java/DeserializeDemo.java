import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeserializeDemo {
    public Movie deserialize() {
        Movie movie = null;
        try {
            FileInputStream fileIn = new FileInputStream("src/main/resources/movie.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            movie = (Movie) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();
            return movie;
        } catch (ClassNotFoundException c) {
            System.out.println("Class not found");
            c.printStackTrace();
            return movie;
        }
        return movie;
    }
}
