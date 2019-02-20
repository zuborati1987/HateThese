import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class XMLReader {

    String filepath = "src/main/resources/facts.xml";
    File xmlFile = new File(filepath);
    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
    DocumentBuilder dBuilder;

    public List<Movie> loadXml() {
        List<Movie> movList = new ArrayList<Movie>();
        try {
            dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();
            //System.out.println("Root element: " + doc.getDocumentElement().getNodeName());
            NodeList nodeList = doc.getElementsByTagName("Movie");

            for (int i = 0; i < nodeList.getLength(); i++) {
                movList.add(getMovie(nodeList.item(i)));
            }
            /*for (Movie mov : movList) {
                System.out.println(mov.toString());
            }*/


        } catch (SAXException e1) {
            e1.printStackTrace();
        } catch (ParserConfigurationException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        return movList;
    }

    private static Movie getMovie(Node node) {
        Movie mov = new Movie();
        if(node.getNodeType() == Node.ELEMENT_NODE) {
            Element element = (Element) node;
            mov.setDescription(getTagValue("description", element));
            mov.setRating(Double.parseDouble(getTagValue("rating", element)));
            mov.setGenre(getTagValue("genre", element));
            mov.setRuntime(Integer.parseInt(getTagValue("runtime", element)));
            mov.setAnimation(Boolean.parseBoolean(getTagValue("animation", element)));
            mov.setMultilang(Boolean.parseBoolean(getTagValue("multiple_language", element)));
        }
        return mov;
    }

    private static String getTagValue(String tag, Element element) {
        NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
        Node node = (Node) nodeList.item(0);
        return node.getNodeValue();
    }
}
