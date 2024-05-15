package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.UIManager;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import myUtil.CentroDoMonitorMaior;

public class MenuPrincipal extends JFrame {

    private Container cp;
    private Point p;
    private JPanel pnSul = new JPanel();
    private JPanel pnCentro = new JPanel();
    private JLabel lbTitulo = new JLabel("Gravadora de Músicas");
    private Font fonte = new Font("Comic Sans MS", Font.BOLD, 28);
    ImageIcon backmusica = new ImageIcon(getClass().getResource("/icones/gravadora.jpeg"));
    private JLabel labelComImagemDeTamanhoDiferente = new JLabel(backmusica);

    private JMenuBar menuBar = new JMenuBar();
    private JMenu menuCadastros = new JMenu("Gravadora");
//------------------------ Itens do Menu ----------------------------
    private JMenuItem GUICantores = new JMenuItem("Cantores");
    private JMenuItem GUIGenero = new JMenuItem("Genero");
    private JMenuItem GUIInstrumentos = new JMenuItem("Instrumentos");
    private JMenuItem GUIMusica = new JMenuItem("Musica");
    private JMenuItem GUIPaises = new JMenuItem("Paises");
    private JMenuItem GUIPlataformas = new JMenuItem("Plataformas");
    private JMenuItem GUITomMusica = new JMenuItem("TomMusica");
    private JMenuItem GUIJTable = new JMenuItem("JTable");
    private JMenuItem GUIMusicaHasCantores = new JMenuItem("MusicaHasCantores");

    public MenuPrincipal(Dimension dimensao) throws ClassNotFoundException {
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(dimensao);
        setTitle("Musicas");

        cp = getContentPane();
        cp.setLayout(new BorderLayout());
        lbTitulo.setFont(fonte);
        labelComImagemDeTamanhoDiferente.setBounds(300, 300, 350, 300);
        pnCentro.add(labelComImagemDeTamanhoDiferente);
        pnCentro.setBackground(Color.black);
        pnSul.add(lbTitulo);
        pnSul.setBackground(Color.BLACK);
        
        lbTitulo.setForeground(Color.white);

        cp.add(pnCentro, BorderLayout.CENTER);
        cp.add(pnSul, BorderLayout.SOUTH);

        setJMenuBar(menuBar);
        menuBar.add(menuCadastros);
        menuCadastros.add(GUICantores);
        menuCadastros.add(GUIGenero);
        menuCadastros.add(GUIInstrumentos);
        menuCadastros.add(GUIMusica);
        menuCadastros.add(GUIPaises);
        menuCadastros.add(GUIPlataformas);
        menuCadastros.add(GUITomMusica);
        menuCadastros.add(GUIJTable);
        menuCadastros.add(GUIMusicaHasCantores);
        GUICantores.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GUICantores guiCantores = new GUICantores(new Point(880, 250), new Dimension(800, 600));
            }
        });

        GUIGenero.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GUIGenero crudGUIGenero = new GUIGenero(new Point(880, 250), new Dimension(800, 600));
            }
        });

        GUIInstrumentos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GUIInstrumentos crudGUIInstrumentos = new GUIInstrumentos(new Point(880, 250), new Dimension(800, 600));
            }
        });

        GUIMusica.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GUIMusica crudGUIMusica = new GUIMusica(new Point(880, 250), new Dimension(800, 600));
            }
        });

        GUIPaises.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GUIPaises crudGUIPaises = new GUIPaises(new Point(880, 250), new Dimension(800, 600));
            }
        });

        GUIPlataformas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GUIPlataformas crudGUIPlataformas = new GUIPlataformas(new Point(880, 250), new Dimension(800, 600));
            }
        });
        GUITomMusica.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GUITomMusica crudGUITomMusica = new GUITomMusica(new Point(880, 250), new Dimension(800, 600));
            }
        });

        GUIJTable.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GUIMusicaJTable guiMusicaJTable = new GUIMusicaJTable(new Point(880, 250), new Dimension(800, 600));
            }
        });
        
        GUIMusicaHasCantores.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GUIMusicaHasCantores guiMusicaHasCantores = new GUIMusicaHasCantores(new Point(880, 250), new Dimension(800, 600));
            }
        });
        

        p = new CentroDoMonitorMaior().getCentroMonitorMaior(this);

        setLocation(p);
        setVisible(true);

    }
}
