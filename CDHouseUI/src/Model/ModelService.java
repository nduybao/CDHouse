package Model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 *
 * @author duyba
 */
public class ModelService {

    private ArrayList<CD> listCD = new ArrayList();

    public ModelService() {
    }

    public void setListCD(ArrayList<CD> listOpen) {
        this.listCD.removeAll(listCD);
        this.listCD.addAll(listOpen);
    }

    public ArrayList<CD> getListCD() {
        Collections.sort(listCD);
        return listCD;
    }

    public void addNewCD(CD cd) {
        this.listCD.add(cd);
    }

    public boolean checkDuplicateID(String id) {
        for (CD cd : listCD) {
            if (id.equalsIgnoreCase(cd.getId())) {
                return false;
            }
        }
        return true;
    }

    public CD getCDbyID(String id) {
        for (CD cd : listCD) {
            if (cd.getId().equalsIgnoreCase(id)) {
                return cd;
            }
        }
        return null;
    }

    public CD getCDByPostion(int pos) {
        return listCD.get(pos);
    }

    public int listCount() {
        return listCD.size();
    }

    public void remove(CD cd) {
        this.listCD.remove(cd);
    }

    public boolean checkCDExist(CD cdUpdate) {
        for (CD cd : listCD) {
            if (cd.equals(cdUpdate)) {
                return false;
            }
        }
        return true;
    }

    public ArrayList<CD> listFound(String titile) {
        ArrayList<CD> listFoundByTT = new ArrayList<>();
        for (CD cd : listCD) {
            if (cd.getTitle().toLowerCase().contains(titile.toLowerCase())) {
                listFoundByTT.add(cd);
            }
        }
        return listFoundByTT;
    }

}
