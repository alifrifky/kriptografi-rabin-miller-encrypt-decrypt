/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bismillahkripto;

import controller.c_awalan;
import controller.c_encrypt;
import view.v_awal;

import view.v_encpyt;
import view.v_hasil;

/**
 *
 * @author Alif
 */
public class Bismillahkripto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        view.v_decrypt a=new v_decrypt();
//        c_decrypt c= new c_decrypt(a);
        view.v_awal a = new v_awal();

        c_awalan c = new c_awalan(a);

    }

}
