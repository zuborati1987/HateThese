
public class Main {

    public static void main(String[] args) {
        MovieStore movieStore = new MovieStore();
        CSVWriter csvWriter = new CSVWriter();
        csvWriter.writingToCSV(movieStore);
        XMLWriter xmlWriter = new XMLWriter();
        xmlWriter.writeXML(movieStore);
        SerializeDemo serializer = new SerializeDemo();
        serializer.serialize(movieStore.getMovies().get(0));
        DeserializeDemo deserializer = new DeserializeDemo();
        System.out.println(deserializer.deserialize());
    }
}
