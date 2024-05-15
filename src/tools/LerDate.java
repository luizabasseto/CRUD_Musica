package tools;

import java.awt.Color;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JTextField;

/**
 *
 * @author luiza
 */
public class LerDate {
    
    public Date lerDate(JTextField tfh, JButton jbs) {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        Date s = new Date();
        
        while (true) {
            try {
                String h = tfh.getText();
                s = sdf.parse(h);
                sdf.setLenient(false);
                jbs.setEnabled(true);

            } catch (ParseException ex) {
                tfh.setBackground(Color.red);
                tfh.setBackground(Color.white);
                jbs.setEnabled(false);
            }

            return s;
        }
    }
}
