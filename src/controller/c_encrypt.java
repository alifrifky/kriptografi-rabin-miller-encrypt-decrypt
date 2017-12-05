package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigInteger;
import java.nio.charset.Charset;
import javax.swing.JOptionPane;
import rumus.Rabin;
import view.v_about;
import view.v_encpyt;
import view.v_hasil;

/**
 *
 * @author Alif
 */
public class c_encrypt {

    private view.v_encpyt viewEncrypt;
    private view.v_hasil viewHasil;
    private view.v_about viewAbout;
    private rumus.Rabin Rabinrumus;
    String dec;

    public c_encrypt(v_encpyt viewEncrypt, v_hasil viewHasil, v_about viewAbout) {
        this.viewEncrypt = viewEncrypt;
        this.viewHasil = viewHasil;
        this.viewAbout = viewAbout;
        viewAbout.setVisible(false);
        viewEncrypt.setVisible(true);
        viewHasil.setVisible(false);
        viewEncrypt.addEncryptListener(new Encrypt());
        viewEncrypt.addaboutListener(new About());
        viewHasil.addKembaliListener(new Kembali());
        viewAbout.addbackListener(new back());
    }

    private class Encrypt implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            String s = viewEncrypt.getEncrript();
            if (s.isEmpty()) {
                JOptionPane.showMessageDialog(viewEncrypt, "Masukkan Kata Terlebih dahulu");
            } else {
                for (int i = 0; i < 1; i++) {
                    BigInteger[] key = Rabin.genKey(512);
                    BigInteger N = key[0];
                    BigInteger p = key[1];
                    BigInteger q = key[2];
                    BigInteger m = new BigInteger(s.getBytes(Charset.forName("ascii")));
                    BigInteger c = Rabin.encrypt(m, N);
                    viewHasil.setHasil_encrypt(c.toString());
                    boolean worked = false;
                    BigInteger[] m2 = Rabin.decrypt(c, p, q);
                    for (BigInteger b : m2) {
                        dec = new String(b.toByteArray(), Charset.forName("ascii"));
                        if (dec.equals(s)) {
                            worked = true;
                        }
                        viewHasil.setHasil1("hasil   =" + dec + "\n");
                    }
                    viewEncrypt.setVisible(false);
                    viewHasil.setVisible(true);

                }
            }

        }
    }

    private class Kembali implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            viewHasil.setVisible(false);
            viewEncrypt.setVisible(true);
        }
    }

    private class About implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            viewEncrypt.dispose();
            viewAbout.setVisible(true);
        }
    }

    private class back implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            viewEncrypt.setVisible(true);
            viewAbout.setVisible(false);
        }
    }
}
