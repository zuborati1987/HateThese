import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class XMLWriter {

    public void writeXML(MovieStore movieStore) {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;
        try {
            dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.newDocument();
            Element rootElement = doc.createElementNS("Movies", "Movies");
            doc.appendChild(rootElement);
            for(Movie movie : movieStore.getMovies()) {
                rootElement.appendChild(getMovie(doc, movie.getDescription(), movie.getRating(), movie.getGenre(),
                                        movie.getRuntime(), movie.isAnimation(), movie.isMultilang()));
                TransformerFactory transformerFactory = TransformerFactory.newInstance();
                Transformer transformer = transformerFactory.newTransformer();
                transformer.setOutputProperty(OutputKeys.INDENT, "yes");
                DOMSource source = new DOMSource(doc);
                StreamResult console = new StreamResult(System.out);
                StreamResult file = new StreamResult(new File("src/main/resources/output.xml"));
                transformer.transform(source, console);
                transformer.transform(source, file);
                System.out.println("DONE");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Node getMovie(Document doc, String description, double rating, String genre,
                                 int runtime, boolean animation, boolean multilang) {
        Element movie = doc.createElement("Movie");
        movie.setAttribute("description", description);
        movie.appendChild(getMovieElements(doc, movie, "description", description));
        movie.appendChild(getMovieElements(doc, movie, "rating", String.valueOf(rating)));
        movie.appendChild(getMovieElements(doc, movie, "genre", genre));
        movie.appendChild(getMovieElements(doc, movie, "runtime", String.valueOf(runtime)));
        movie.appendChild(getMovieElements(doc, movie, "animation", String.valueOf(animation)));
        movie.appendChild(getMovieElements(doc, movie, "multilang", String.valueOf(multilang)));
        return movie;
    }

    private static Node getMovieElements(Document doc, Element element, String name, String value) {
        Element node = doc.createElement(name);
        node.appendChild(doc.createTextNode(value));
        return node;
    }

}
