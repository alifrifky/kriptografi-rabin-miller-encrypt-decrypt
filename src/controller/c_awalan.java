/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.v_about;
import view.v_awal;
import view.v_hasil;

/**
 *
 * @author Alif
 */
public class c_awalan {

    private view.v_awal viewAwal;

    public c_awalan(v_awal viewAwal) {
        this.viewAwal = viewAwal;
        viewAwal.setVisible(true);
        viewAwal.addmasukListener(new Masuk());

    }

    private class Masuk implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {

            controller.c_encrypt mt = new controller.c_encrypt(new view.v_encpyt(), new v_hasil(),new v_about());
            viewAwal.setVisible(false);
        }
    }

}
