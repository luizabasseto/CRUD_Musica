package tools;

import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author radames
 */
public class ImagemAjustada {

    private Image imagemAux;

    public ImageIcon getImagemAjustada(String origem) {
        ImageIcon icone = new ImageIcon(getClass().getResource(origem));
        imagemAux = icone.getImage();
        icone.setImage(imagemAux.getScaledInstance(68, 68, Image.SCALE_FAST));
        return icone;
    }

    public Icon getImagemAjustada(String origem, int tamX, int tamY) {
        ImageIcon icone = new ImageIcon(getClass().getResource(origem));
        imagemAux = icone.getImage();
        icone.setImage(imagemAux.getScaledInstance(68, 68, Image.SCALE_FAST));
        return icone;
    }

}
