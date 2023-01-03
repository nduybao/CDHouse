package Model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author duyba
 */
public class ModelDAO {

    private FileWriter fw;
    private BufferedWriter bw;
    private PrintWriter pw;
    private FileReader fr;
    private BufferedReader br;
    
 public void openFileToWrite(String fName) {
        try {
            fw = new FileWriter(fName);
            bw = new BufferedWriter(fw);
            pw = new PrintWriter(bw);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void writeToFile(List<CD> listCD, String fName) {
        openFileToWrite(fName);
        try {
            for (CD cd : listCD) {
                pw.println(cd.toString());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        closeFileAfterWrite(fName);
    }

    public void closeFileAfterWrite(String fName) {
        try {
            pw.flush();
            bw.flush();
            pw.close();
            bw.close();
            fw.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void openFileToRead(String fName) {
        try {
            fr = new FileReader(fName);
            br = new BufferedReader(fr);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public ArrayList<CD> readLineFromFile(String fName) {
        ArrayList<CD> list = new ArrayList<>();
        openFileToRead(fName);
        try {
            String datas;
            while ((datas = br.readLine()) != null) {
                CD cd = createCDFromFile(datas);
                list.add(cd);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            System.out.println("Loi roi");
        }
        return list;
    }

    public CD createCDFromFile(String datas) {
        String data[] = datas.split(",");
        String name = data[0];
        String id = data[1];
        boolean type = Boolean.parseBoolean(data[2]);
        String title = data[3];
        double price = Double.parseDouble(data[4]);
        int year = Integer.parseInt(data[5]);
        CD cd  = new CD(name, id, type, title, price, year);
        return cd;
    }
    
       public void closeFileAfterRead(String fName) {
        try {
            br.close();
            fr.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}
