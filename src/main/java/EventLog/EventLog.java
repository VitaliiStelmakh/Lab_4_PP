package EventLog;

import Toy.Toy;

import java.io.FileReader;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class EventLog {

    public void ClearSessionLog() {
        try(FileWriter writer = new FileWriter("./src/main/resources/log.txt", false))
        {
            String text = "";
            writer.write(text);

            writer.flush();
        } catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public String GetSessionLog() {
        String result = "";
        try(FileReader reader = new FileReader("./src/main/resources/log.txt"))
        {
            Scanner scan = new Scanner(reader);

            while (scan.hasNextLine()) {
                result += scan.nextLine() + "\n";
            }

            if (result.equals("")) {
                result = "No logs in this session";
            }

        } catch (Exception ex) {

            result = ex.getMessage();
        }
        return result;
    }

    public void AddActionLog(Toy toy, String comment) {
        try(FileWriter writer = new FileWriter("./src/main/resources/log.txt", true))
        {
            Date date = new Date();
            String text = date.toString() + " - " + comment + toy.toString();
            writer.write(text);

            writer.flush();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void AddLog(String message) {
        try(FileWriter writer = new FileWriter("./src/main/resources/log.txt", true))
        {
            SimpleDateFormat formatForDateNow = new SimpleDateFormat("hh:mm:ss");
            Date date = new Date();
            String text = date.toString() + " - " + message + "\n";
            writer.write(text);

            writer.flush();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
