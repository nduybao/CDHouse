/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Run;

import View.GUI;

/**
 *
 * @author duyba
 */
public class run {
    public static void main(String[] args) {
        try {
             java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI().setVisible(true);
            }
        });
        } catch (Exception e) {
        }
    }
    
}
