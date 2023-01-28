import java.io.File;

public class FileCreate {

    public static String fileName1 = "EDM-Events.txt";
    public static String fileName2 = "Concerts50-Res.txt";

    FileCreate() {
        File file1 = new File(fileName1);
        try {
            if(file1.createNewFile()) {
                System.out.println("File created: " + file1.getName());
            } else {
                System.out.println("File 1 exists, clearing file.");
                file1.delete();
                file1.createNewFile();
            }
        } catch (Exception e) {
            System.out.println("Error Occurred on creation of file 1");
            e.printStackTrace();
        }

        File file2 = new File(fileName2);
        try {
            if(file2.createNewFile()) {
                System.out.println("File created: " + file2.getName());
            } else {
                System.out.println("File 2 exists, clearing file.");
                file2.delete();
                file2.createNewFile();
            }
        } catch (Exception e) {
            System.out.println("Error Occurred on creation of file 2");
            e.printStackTrace();
        }
    }
}
