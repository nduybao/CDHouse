package View;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author duyba
 */
public interface View {
    
    <T> void showData(ArrayList<T> list, DefaultTableModel model);
}
