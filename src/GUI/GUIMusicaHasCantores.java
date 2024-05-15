package GUI;

/**
 *
 * @author luiza
 */
import DAOs.DAOCantores;
import DAOs.DAOMusica;
import DAOs.DAOMusicaHasCantores;
import DAOs.DAOMusicaHasCantoresPK;
import DAOs.DAOPaises;
import DAOs.DAOTomMusica;
import Entidade.Cantores;
import Entidade.Musica;
import Entidade.MusicaHasCantores;
import Entidade.MusicaHasCantoresPK;
import Entidade.Paises;
import Entidade.TomMusica;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.ListModel;
import javax.swing.WindowConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import myUtil.JanelaPesquisar;
import myUtil.UsarGridBagLayout;

public class GUIMusicaHasCantores extends JDialog {

    JPanel pnMusica = new JPanel();
    JPanel pnCantores = new JPanel();
    JPanel pnCentro = new JPanel();
    JTextArea lbAviso = new JTextArea();
// Defina as propriedades para a área de texto

    ImageIcon iconeSave = new ImageIcon(getClass().getResource("/icones/save.png"));
    ImageIcon iconeCancel = new ImageIcon(getClass().getResource("/icones/cancel.png"));
    ImageIcon iconeNext = new ImageIcon(getClass().getResource("/icones/retrieve.png"));

    ImageIcon iconeDelete = new ImageIcon(getClass().getResource("/icones/delete.png"));
    JButton btnRetrieve = new JButton(iconeNext);
    JButton btnSave = new JButton(iconeSave);
    JButton btnCancel = new JButton(iconeCancel);
    JButton btnDelete = new JButton(iconeDelete);

    private DefaultListModel jlModelCantores = new DefaultListModel();
    private DefaultListModel jlModelMusica = new DefaultListModel();
    private DefaultListModel jlModelMusicaHasCantores = new DefaultListModel();

    JLabel lbIDmusica = new JLabel("Id Musica");
    JTextField tfIDmusica = new JTextField(20);
    JLabel lbIDcantor = new JLabel("Id Cantor");
    JTextField tfIDcantor = new JTextField(20);
    JTextField inputField = new JTextField();
    JTextField inputFieldd = new JTextField();
    JLabel lbNomeMusica = new JLabel("Pesquisar Musica");
    JLabel lbNomeCantor = new JLabel("Pesquisar Cantor");

    private JList jlCantores = new JList(jlModelCantores);
    private JList jlMusica = new JList(jlModelMusica);
    private JList jlMusicaHasCantores = new JList(jlModelMusicaHasCantores);
    List<Musica> listaMusica;
    List<Cantores> listaCantores;

    DAOMusica daoMusica = new DAOMusica();
    Musica musica;
    DAOCantores daoCantores = new DAOCantores();
    Cantores cantores;
    DAOMusicaHasCantoresPK daoMusicaHasCantoresPK = new DAOMusicaHasCantoresPK();
    MusicaHasCantoresPK musicaHasCantoresPK = new MusicaHasCantoresPK();
    DAOMusicaHasCantores daoMusicaHasCantores = new DAOMusicaHasCantores();
    MusicaHasCantores musicaHasCantores = new MusicaHasCantores();

    Color corPadrao = lbIDmusica.getBackground();

    public GUIMusicaHasCantores(Point posicao, Dimension dimensao) {

        listaMusica = daoMusica.list();
        listaMusica.stream().forEach((p) -> {
            jlModelMusica.addElement(p.toString());
        });

        listaCantores = daoCantores.list();
        listaCantores.stream().forEach((c) -> {
            jlModelCantores.addElement(c.toString());
        });

        jlMusica.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jlCantores.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        inputField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateList();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateList();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateList();
            }
        });

        inputFieldd.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateLists();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateLists();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateLists();
            }
        });

        lbAviso.setEditable(false);
        lbAviso.setLineWrap(true);
        lbAviso.setWrapStyleWord(true);

        JScrollPane SPMusica = new JScrollPane(jlMusica);
        JScrollPane SPCantores = new JScrollPane(jlCantores);

        setTitle("Musica_has_Cantores");
        setSize(dimensao);//tamanho da janela
        setLayout(new BorderLayout());//informa qual gerenciador de layout será usado
        setBackground(Color.CYAN);//cor do fundo da janela
        Container cp = getContentPane();//container principal, para adicionar nele os outros componentes

        btnSave.setToolTipText("Salvar");
        btnCancel.setToolTipText("Cancelar");
        btnDelete.setEnabled(false);
        JToolBar toolbar1 = new JToolBar();
        toolbar1.add(lbIDcantor);
        toolbar1.add(tfIDcantor);
        toolbar1.add(lbIDmusica);
        toolbar1.add(tfIDmusica);
        toolbar1.add(btnRetrieve);
        toolbar1.add(btnDelete);
        toolbar1.add(btnSave);

        if (jlMusica.getSelectedIndex() != -1) {
            if (jlCantores.getSelectedIndex() != -1) {

            }
        }

        JPanel centro = new JPanel();
        UsarGridBagLayout usarGridBagLayout = new UsarGridBagLayout(centro);
        usarGridBagLayout.add(lbNomeCantor, inputFieldd, corPadrao);
        usarGridBagLayout.add(lbNomeMusica, inputField, corPadrao);

        cp.add(toolbar1, BorderLayout.NORTH);
        cp.add(SPCantores, BorderLayout.WEST);
        cp.add(SPMusica, BorderLayout.EAST);
        cp.add(pnCentro, BorderLayout.CENTER);
        cp.add(centro, BorderLayout.SOUTH);

        pnCentro.add(lbAviso);
        lbAviso.setText("");
        btnDelete.setEnabled(false);

        jlMusica.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    String itemSelecionadoMusica = (String) jlMusica.getSelectedValue();
                    String[] itemM = itemSelecionadoMusica.split(";");
                    String a = "";

                    for (int i = 0; i < listaCantores.size(); i++) {
                        musica = daoMusica.obter(Integer.valueOf(itemM[0]));
                        cantores = daoCantores.obter(i);
                        if (musica != null && cantores != null) {
                            try {
                                musicaHasCantoresPK.setCantoresIdCantores(cantores.getIdCantores());
                                musicaHasCantoresPK.setMusicaIdMusica(musica.getIdMusica());

                                musicaHasCantores = daoMusicaHasCantores.obter(musicaHasCantoresPK);
                                if (musicaHasCantores != null) {
                                    a += cantores.getNomeCantores() + "--";
                                    lbAviso.setText(a);
                                    lbAviso.setCaretPosition(lbAviso.getDocument().getLength());
                                } else {
                                }

                            } catch (Exception x) {
                                lbAviso.setText("");
                            }

                        }
                    }

                }
            }
        }
        );

        jlCantores.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    String itemSelecionadoCantores = (String) jlCantores.getSelectedValue();
                    String[] itemM = itemSelecionadoCantores.split(";");
                    String a = "";

                    for (int i = 0; i < listaMusica.size(); i++) {
                        musica = daoMusica.obter(i);
                        cantores = daoCantores.obter(Integer.parseInt(itemM[0]));
                        if (musica != null && cantores != null) {
                            try {
                                musicaHasCantoresPK.setCantoresIdCantores(cantores.getIdCantores());
                                musicaHasCantoresPK.setMusicaIdMusica(musica.getIdMusica());

                                musicaHasCantores = daoMusicaHasCantores.obter(musicaHasCantoresPK);
                                if (musicaHasCantores != null) {
                                    a += musica.getNomeMusica() + "--";
                                    lbAviso.setText(a);
                                }

                            } catch (Exception x) {
                                lbAviso.setText("");
                            }

                        }
                    }

                }
            }
        });

        btnRetrieve.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e
            ) {
                if (tfIDcantor.getText() != null && tfIDmusica.getText() != null) {
                    musica = daoMusica.obter(Integer.valueOf(tfIDmusica.getText()));
                    cantores = daoCantores.obter(Integer.valueOf(tfIDcantor.getText()));
                    if (musica != null && cantores != null) {
                        try {
                            musicaHasCantoresPK.setCantoresIdCantores(cantores.getIdCantores());
                            musicaHasCantoresPK.setMusicaIdMusica(musica.getIdMusica());

                            musicaHasCantores = daoMusicaHasCantores.obter(musicaHasCantoresPK);
                            System.out.println(musicaHasCantoresPK);
                            if (musicaHasCantores != null) {
                                lbAviso.setText("Registro encontrado, pode excluir!");
                                btnDelete.setEnabled(true);

                            } else {
                                lbAviso.setText("Registro não encontrado");
                                btnDelete.setEnabled(false);

                            }
                        } catch (Exception x) {
                            tfIDmusica.setOpaque(true);
                            tfIDmusica.selectAll();
                            tfIDmusica.requestFocus();
                            tfIDmusica.setBackground(Color.red);
                            tfIDcantor.setBackground(Color.red);
                        }
                    }

                    String idCantorText = tfIDcantor.getText();
                    if (!idCantorText.isEmpty()) {
                        int idCantor = Integer.parseInt(idCantorText);
                        for (int i = 0; i < jlModelCantores.getSize(); i++) {
                            String cantorString = (String) jlModelCantores.getElementAt(i);
                            String[] cantorInfo = cantorString.split(";");
                            int cantorId = Integer.parseInt(cantorInfo[0]);
                            if (cantorId == idCantor) {
                                jlCantores.setSelectedValue(cantorString, true);
                                break;
                            }
                        }
                    }
                    String idMusicaText = tfIDmusica.getText();
                    if (!idMusicaText.isEmpty()) {
                        int idCantor = Integer.parseInt(idMusicaText);
                        for (int i = 0; i < jlModelMusica.getSize(); i++) {
                            String cantorString = (String) jlModelMusica.getElementAt(i);
                            String[] cantorInfo = cantorString.split(";");
                            int cantorId = Integer.parseInt(cantorInfo[0]);
                            if (cantorId == idCantor) {
                                jlMusica.setSelectedValue(cantorString, true);
                                break;
                            }
                        }
                    }
                } else {
                    tfIDmusica.setOpaque(true);
                    tfIDmusica.selectAll();
                    tfIDmusica.requestFocus();
                    tfIDmusica.setBackground(Color.red);
                    tfIDcantor.setBackground(Color.red);
                }

            }

        }
        );

        btnSave.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e
            ) {
                String itemSelecionadoMusica = (String) jlMusica.getSelectedValue();
                String[] itemM = itemSelecionadoMusica.split(";");
                String itemSelecionadoCantor = (String) jlCantores.getSelectedValue();
                String[] itemC = itemSelecionadoCantor.split(";");

                musicaHasCantoresPK.setCantoresIdCantores(Integer.parseInt(itemC[0]));
                musicaHasCantoresPK.setMusicaIdMusica(Integer.parseInt(itemM[0]));

                musicaHasCantores.setMusicaHasCantoresPK(musicaHasCantoresPK);
                daoMusicaHasCantores.inserir(musicaHasCantores);
                jlMusica.clearSelection();
                jlCantores.clearSelection();

                lbAviso.setText("Registro salvo!");

                System.out.println("DEU CERTO" + musicaHasCantores);
                btnDelete.setEnabled(false);

            }
        }
        );

        btnDelete.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e
            ) {
                if (JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(null,
                        "Confirma a exclusão do registro <" + musica.getNomeMusica() + " && " + cantores.getNomeCantores() + ">?", "Confirm",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)) {
                    daoMusicaHasCantores.remover(musicaHasCantores);
                }
                tfIDcantor.setText("");
                tfIDmusica.setText("");
                jlMusica.clearSelection();
                jlCantores.clearSelection();
                btnDelete.setEnabled(false);

            }
        }
        );

        btnCancel.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e
            ) {
                jlMusica.clearSelection();
                jlCantores.clearSelection();
                btnDelete.setEnabled(false);
            }
        }
        );

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        }
        );

        setModal(true);
        setLocation(posicao);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

    }

    private void updateList() {
        String searchText = inputField.getText().trim().toLowerCase();
        List<String> filteredItems = new ArrayList<>();

        for (int i = 0; i < jlModelMusica.size(); i++) {
            String item = (String) jlModelMusica.getElementAt(i);
            if (item.toLowerCase().contains(searchText)) {
                filteredItems.add(item);
            }
        }

        jlMusica.setModel(new DefaultListModel<>());
        for (String item : filteredItems) {
            ((DefaultListModel<String>) jlMusica.getModel()).addElement(item);
        }
    }

    private void updateLists() {
        String searchText = inputFieldd.getText().trim().toLowerCase();
        List<String> filteredItems = new ArrayList<>();

        for (int i = 0; i < jlModelCantores.size(); i++) {
            String item = (String) jlModelCantores.getElementAt(i);
            if (item.toLowerCase().contains(searchText)) {
                filteredItems.add(item);
            }
        }

        jlCantores.setModel(new DefaultListModel<>());
        for (String item : filteredItems) {
            ((DefaultListModel<String>) jlCantores.getModel()).addElement(item);
        }
    }

    public static void main(String[] args) {
        new GUIMusicaHasCantores(new Point(880, 550), new Dimension(800, 600));
    }

}
