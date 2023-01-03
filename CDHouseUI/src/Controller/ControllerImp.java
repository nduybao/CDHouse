package Controller;

import Model.CD;
import Model.ModelDAO;
import Model.ModelService;
import View.ADD;
import View.GUI;
import View.UPDATE;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import javax.swing.Action;
import javax.swing.JOptionPane;

/**
 *
 * @author duyba
 */
public class ControllerImp implements Action {

    private GUI view;
    ModelDAO dao = new ModelDAO();
    private CD cd;
    private static String id;
    private static String path = "CD.dat";
    private ModelService sv = new ModelService();
    private ADD addGui = new ADD();
    private UPDATE updateGUI = new UPDATE();

    public ControllerImp(GUI view) {
        this.view = view;
        this.sv.setListCD(this.dao.readLineFromFile(path));
        this.view.printListCD(this.sv.getListCD());
        this.addGui.action(this);
        this.updateGUI.action(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String actionCommand = ae.getActionCommand();
        if (actionCommand.equalsIgnoreCase("add cd")) {
            this.addGui.setVisible(true);
            this.addGui.resetForm();
        }

        if (actionCommand.equals("ADD")) {
            if (this.addGui.checkEmpty()) {
                cd = this.addGui.createNewCD();
                if (cd != null) {
                    if (this.sv.checkDuplicateID(cd.getId())) {
                        if (this.sv.getListCD().size() < 20) {
                            this.sv.addNewCD(cd);
                            JOptionPane.showMessageDialog(addGui, "ADD CD SUCESSFULLY!!!");
                            this.view.printListCD(this.sv.getListCD());
                        } else {
                            JOptionPane.showMessageDialog(addGui, "LIST IS FULL");
                        }
                    } else {
                        JOptionPane.showMessageDialog(addGui, "ID IS DUPLICATED!!!");
                    }
                }
            } else {
                JOptionPane.showMessageDialog(addGui, "Information cannot be left blank!!!");
            }
        }

        if (actionCommand.equalsIgnoreCase("Update CD")) {
            String s = this.view.getCDByTable();
            if (!s.equals("")) {
                this.updateGUI.setVisible(true);
                cd = this.sv.getCDbyID(s);
                this.updateGUI.getCDChooseen(cd);
            } else {
                JOptionPane.showMessageDialog(null, "SELECT WHICH CD YOU WANT TO UPDATE");
            }
        }

        if (actionCommand.equalsIgnoreCase("update")) {
            if (this.updateGUI.checkEmpty()) {
                CD cdUpadte = this.updateGUI.createNewCD();
                if (cdUpadte != null) {
                    this.sv.remove(cd);
                    this.sv.addNewCD(cdUpadte);
                    JOptionPane.showMessageDialog(updateGUI, "UPDATE CD SUCESSFULLY!!!");
                    this.view.printListCD(this.sv.getListCD());
                }
            } else {
                JOptionPane.showMessageDialog(updateGUI, "Information cannot be left blank!!!");
            }
        }

        if (actionCommand.equalsIgnoreCase("remove")) {
            String s = this.view.getCDByTable();
            if (!s.equals("")) {
                int input = JOptionPane.showConfirmDialog(null,
                        "Do you want to remove?", "Select an Option...", JOptionPane.YES_NO_OPTION);
                if (input == 0) {
                    this.sv.remove(this.sv.getCDbyID(s));
                    this.view.printListCD(this.sv.getListCD());
                }
                if (input == 1) {
                    JOptionPane.showMessageDialog(null, "CANNEL REMOVE!!!");
                }
            }
            else{
               JOptionPane.showMessageDialog(null, "SELECT WHICH CD YOU WANT TO UPDATE"); 
            }
        }

        if (actionCommand.equalsIgnoreCase("open")) {
            path = this.view.File();
            if (!path.equals("")) {
                this.sv.setListCD(this.dao.readLineFromFile(path));
                this.view.printListCD(this.sv.getListCD());
            }
        }

        if (actionCommand.equals("Save")) {
            String save = this.view.SaveFile();
            if (!save.equals("")) {
                this.dao.writeToFile(this.sv.getListCD(), save);
                JOptionPane.showMessageDialog(null, "Save successfully!!!");
            }
        }

        if (actionCommand.equalsIgnoreCase("exit")) {
            System.exit(0);
        }
    }

    @Override
    public Object getValue(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void putValue(String string, Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setEnabled(boolean bln) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isEnabled() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener pl) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removePropertyChangeListener(PropertyChangeListener pl) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
