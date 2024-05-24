import java.io.FileWriter;
import java.io.IOException;

public class SaveFile {

    public boolean saveFile(String person) {
        String [] pers = person.split(" ");

        String file = pers[0] + ".txt";
        try (FileWriter writer = new FileWriter(file, true)) {
            writer.append(person);
            writer.append("\n");
            writer.close();
        } catch (IOException e) {

            e.printStackTrace();
        }
        System.out.println(file);
        return true;
    }

}
