package GUI;

import DAOs.DAOMusica;
import DAOs.DAOPaises;
import Entidade.Musica;
import Entidade.Paises;
import java.awt.Dimension;
import java.util.List;
import java.awt.Point;
import javax.swing.JDialog;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.WindowConstants;
import myUtil.JanelaPesquisar;
import java.text.SimpleDateFormat;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javazoom.jl.decoder.Bitstream;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

import myUtil.UsarGridBagLayout;

public class GUIMusica extends JDialog {

    ImageIcon iconeCreate = new ImageIcon(getClass().getResource("/icones/create.png"));
    ImageIcon iconeNext = new ImageIcon(getClass().getResource("/icones/next.png"));
    ImageIcon iconeRetrieve = new ImageIcon(getClass().getResource("/icones/retrieve.png"));
    ImageIcon iconeUpdate = new ImageIcon(getClass().getResource("/icones/update.png"));
    ImageIcon iconeDelete = new ImageIcon(getClass().getResource("/icones/delete.png"));
    ImageIcon iconeSave = new ImageIcon(getClass().getResource("/icones/save.png"));
    ImageIcon iconeCancel = new ImageIcon(getClass().getResource("/icones/cancel.png"));
    ImageIcon iconeListar = new ImageIcon(getClass().getResource("/icones/list.png"));
    ImageIcon iconeReproduzir = new ImageIcon(getClass().getResource("/icones/video-player.png"));
    ImageIcon iconePause = new ImageIcon(getClass().getResource("/icones/botao-de-pausa-de-video.png"));
    JButton btnNext = new JButton(iconeNext);
    JButton btnCreate = new JButton(iconeCreate);
    JButton btnRetrieve = new JButton(iconeRetrieve);
    JButton btnUpdate = new JButton(iconeUpdate);
    JButton btnDelete = new JButton(iconeDelete);
    JButton btnSave = new JButton(iconeSave);
    JButton btnCancel = new JButton(iconeCancel);
    JButton btnList = new JButton(iconeListar);
    JButton btnStop = new JButton(iconePause);
    JButton btnReproduzir = new JButton(iconeReproduzir);
    JButton btnAbrirFile = new JButton("Abrir Arquivo Audio");
    byte[] imagemData;
    String caminhoReproduzir;

    JLabel lbID = new JLabel("Id");
    JTextField tfID = new JTextField(20);
    JLabel lbNome = new JLabel("Nome");
    JTextField tfNome = new JTextField(20);
    JLabel lbPaises = new JLabel("Paises");
    DefaultComboBoxModel comboBoxModel = new DefaultComboBoxModel();
    JComboBox comboBox = new JComboBox(comboBoxModel);
    JLabel lbAudio = new JLabel("Local Audio");
    JTextField tfAudio = new JTextField(20);
    JFileChooser audio = new JFileChooser();

    JPanel pnAvisos = new JPanel();
    JLabel labelAviso = new JLabel("");

    String acao = "";//variavel para facilitar insert e update
    DAOMusica daoMusica = new DAOMusica();
    DAOPaises daoPaises = new DAOPaises();
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    DecimalFormat decimalFormat = new DecimalFormat("###,###,##0.00");
    Musica musica;
    Player player;

    private byte[] lerArquivoComoBytes(File arquivo) {
        try {
            FileInputStream fis = new FileInputStream(arquivo);
            System.out.println("arquivo");
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int bytesRead;

            while ((bytesRead = fis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }

            fis.close();
            bos.close();

            return bos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private void atvBotoes(boolean c, boolean r, boolean u, boolean d) {
        btnCreate.setEnabled(c);
        btnNext.setEnabled(r);
        btnRetrieve.setEnabled(r);
        btnUpdate.setEnabled(u);
        btnDelete.setEnabled(d);
        btnList.setEnabled(r);
    }

    public void mostrarBotoes(boolean visivel) {
        btnCreate.setVisible(visivel);
        btnNext.setVisible(visivel);
        btnRetrieve.setVisible(visivel);
        btnUpdate.setVisible(visivel);
        btnDelete.setVisible(visivel);
        btnList.setVisible(visivel);
        btnSave.setVisible(!visivel);
        btnCancel.setVisible(!visivel);
    }

    private void habilitarAtributos(boolean id, boolean nome, boolean paises, boolean audios, boolean reproduzir, boolean abrir, boolean fechar) {
        if (id) {
            tfID.requestFocus();
            tfID.selectAll();
        }
        tfID.setEnabled(id);
        tfID.setEditable(id);
        tfNome.setEditable(nome);
        comboBox.setEnabled(paises);
        tfAudio.setEnabled(audios);
        btnAbrirFile.setEnabled(abrir);
        btnReproduzir.setEnabled(reproduzir);
        btnStop.setEnabled(fechar);
    }

    public void zerarAtributos() {
        tfNome.setText("");
    }
    Color corPadrao = lbID.getBackground();

    public GUIMusica(Point posicao, Dimension dimensao) {
        setTitle("CRUD - Musica");
        setSize(dimensao);//tamanho da janela
        setLayout(new BorderLayout());//informa qual gerenciador de layout será usado
        setBackground(Color.CYAN);//cor do fundo da janela
        Container cp = getContentPane();//container principal, para adicionar nele os outros componentes

        atvBotoes(false, true, false, false);
        habilitarAtributos(true, false, false, false, false, false, false);
        btnCreate.setToolTipText("Inserir novo registro");
        btnNext.setToolTipText("Próximo novo registro");
        btnRetrieve.setToolTipText("Pesquisar por chave");
        btnUpdate.setToolTipText("Alterar");
        btnDelete.setToolTipText("Excluir");
        btnList.setToolTipText("Listar todos");
        btnSave.setToolTipText("Salvar");
        btnCancel.setToolTipText("Cancelar");
        JToolBar toolbar1 = new JToolBar();
        toolbar1.add(lbID);
        toolbar1.add(tfID);
        toolbar1.add(btnRetrieve);
        toolbar1.add(btnCreate);
        toolbar1.add(btnNext);
        toolbar1.add(btnUpdate);
        toolbar1.add(btnDelete);
        toolbar1.add(btnSave);
        toolbar1.add(btnCancel);
        toolbar1.add(btnList);
        toolbar1.add(btnAbrirFile);
        toolbar1.add(btnReproduzir);
        toolbar1.add(btnStop);

        btnSave.setVisible(false);
        btnCancel.setVisible(false);

//atritubos não chave, todos no painel centro
        JPanel centro = new JPanel();
        UsarGridBagLayout usarGridBagLayout = new UsarGridBagLayout(centro);
        usarGridBagLayout.add(lbNome, tfNome, corPadrao);
        usarGridBagLayout.add(lbPaises, comboBox, corPadrao);
        usarGridBagLayout.add(lbAudio, tfAudio, corPadrao);
        usarGridBagLayout.add(lbAudio, btnAbrirFile, corPadrao);
        pnAvisos.add(labelAviso);
        cp.add(toolbar1, BorderLayout.NORTH);
        cp.add(centro, BorderLayout.CENTER);
        cp.add(pnAvisos, BorderLayout.SOUTH);
        tfID.requestFocus();
        tfID.selectAll();
        labelAviso.setText("Digite um Id e clic [Pesquisar]");

        pnAvisos.setBorder(BorderFactory.createLineBorder(Color.black));
        toolbar1.setBorder(BorderFactory.createLineBorder(Color.black));
        centro.setBorder(BorderFactory.createLineBorder(Color.black));

        centro.setBackground(new Color(135, 206, 235));
        pnAvisos.setBackground(new Color(70, 130, 180));

//--------------- listeners ----------------- 
        tfID.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnRetrieve.doClick();
            }
        });

        List<Paises> paises = daoPaises.list();
        for (Paises string : paises) {
            comboBoxModel.addElement(string.getNomePaises());
        }
        List<String> listaPaises = daoPaises.listInOrderNomeStrings("id");
        for (String s : listaPaises) {
            comboBox.addItem(s);
        }

        btnStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (player != null) {
                    player.close();
                }
            }
        });

//-----------------------------  btnRetrieve ------------------------------------------
        btnRetrieve.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                musica = new Musica();
                tfID.setText(tfID.getText().trim());//caso tenham sido digitados espaços

                if (tfID.getText().equals("")) {
                    List<String> listaAuxiliar = daoMusica.listInOrderNomeStrings("id");
                    if (listaAuxiliar.size() > 0) {
                        Point lc = btnRetrieve.getLocationOnScreen();
                        lc.x = lc.x + btnRetrieve.getWidth();
                        String selectedItem = new JanelaPesquisar(listaAuxiliar,
                                lc.x,
                                lc.y).getValorRetornado();
                        if (!selectedItem.equals("")) {
                            String[] aux = selectedItem.split("-");
                            tfID.setText(aux[0]);
                            btnRetrieve.doClick();
                        } else {
                            tfID.requestFocus();
                            tfID.selectAll();
                        }
                    }

                    tfID.requestFocus();
                    tfID.selectAll();
                } else {
                    try {
                        musica.setIdMusica(Integer.valueOf(tfID.getText()));
                        musica = daoMusica.obter(musica.getIdMusica());
                        if (musica != null) { //se encontrou na lista
                            tfNome.setText(String.valueOf(musica.getNomeMusica()));
                            List<Paises> listaHospede = new DAOPaises().list();
                            comboBox.removeAllItems();
                            for (Paises s : listaHospede) {
                                comboBox.addItem(s);
                            }
                            comboBox.setSelectedItem(musica.getPaisesIdPaises());
                            if (musica.getSom() != null) {
                                tfAudio.setText(musica.getLocalSom());
                                caminhoReproduzir = musica.getLocalSom();
                            } else {
                                tfAudio.setText("Sem som");
                            }
                            atvBotoes(false, true, true, true);
                            habilitarAtributos(true, false, false, false, true, false, true);
                            labelAviso.setText("Encontrou - clic [Pesquisar], [Alterar] ou [Excluir]");
                            acao = "encontrou";
                        } else {
                            atvBotoes(true, true, false, false);
                            zerarAtributos();
                            tfAudio.setText("");
                            labelAviso.setText("Não cadastrado - clic [Inserir] ou digite outra id [Pesquisar]");
                        }

                        tfID.setBackground(Color.green);
                    } catch (Exception x) {
                        tfID.setOpaque(true);
                        tfID.selectAll();
                        tfID.requestFocus();
                        tfID.setBackground(Color.red);
                        labelAviso.setText("Tipo errado - " + x.getMessage());
                    }
                }
            }
        });

        btnCreate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                zerarAtributos();
                habilitarAtributos(false, true, true, false, false, true, false);
                tfNome.requestFocus();
                mostrarBotoes(false);
                labelAviso.setText("Preencha os campos e clic [Salvar] ou clic [Cancelar]");
                acao = "insert";
            }
        });

        // ---------------------- botao next ------------------------------
        btnNext.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int prox = daoMusica.autoIdMusica();
                tfID.setText(String.valueOf(prox));
                btnRetrieve.doClick();
                btnCreate.doClick();
            }
        });

//-----------------------------  SAVE ------------------------------------------
        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                boolean deuRuim = false;
                if (acao.equals("insert")) {
                    musica = new Musica();
                } else {
                    System.out.println("date");
                }
                musica.setIdMusica(Integer.valueOf(tfID.getText()));
                musica.setNomeMusica(String.valueOf(tfNome.getText()));
                if (tfAudio.getText() == null) {
                    musica.setSom(null);
                } else {
                    // Leitura do arquivo MP3 e conversão para byte[]
                    try {
                        File arquivoAudio = new File(tfAudio.getText());
                        System.out.println(tfAudio.getText() + "-----<");
                        byte[] conteudoArquivo = lerArquivoMp3ComoBytes(arquivoAudio);
                        musica.setSom(conteudoArquivo);
                        musica.setLocalSom(tfAudio.getText());
                    } catch (Exception e) {
                        System.out.println("Deu erro");
                    }

                }
                String[] auxHospede = listaPaises.get(comboBox.getSelectedIndex()).split("-");
                int cadastro = Integer.valueOf(auxHospede[0]);
                Paises ed = new DAOPaises().obter(cadastro);
                musica.setPaisesIdPaises(ed);
                if (!deuRuim) {
                    if (acao.equals("insert")) {
                        daoMusica.inserir(musica);
                        labelAviso.setText("Registro inserido.");
                    } else {
                        try {
                            daoMusica.atualizar(musica);
                            labelAviso.setText("Registro alterado.");
                        } catch (Exception e) {
                            System.out.println("erro");
                        }
                       
                    }
                    habilitarAtributos(true, false, false, false, false, false, false);
                    mostrarBotoes(true);
                    atvBotoes(false, true, false, false);
                }//!deu ruim
                else {
                    labelAviso.setText("Erro nos dados - corrija");
                    labelAviso.setBackground(Color.red);
                }
            }
        });
        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                zerarAtributos();
                atvBotoes(false, true, false, false);
                habilitarAtributos(true, false, false, false, false, false, false);
                mostrarBotoes(true);
            }
        });
        btnList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                acao = "list";
                GUIMusicaListagem guiMusicaListagem = new GUIMusicaListagem(daoMusica.listInOrderNome(), getBounds().x, getBounds().y, dimensao);
            }
        });
        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                acao = "update";
                mostrarBotoes(false);
                habilitarAtributos(false, true, true, true, true, true, false);
                System.out.println("up");
            }
        });
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(null,
                        "Confirma a exclusão do registro <ID = " + musica.getNomeMusica() + ">?", "Confirm",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)) {
                    labelAviso.setText("Registro excluído...");
                    daoMusica.remover(musica);
                    zerarAtributos();
                    tfAudio.setText("");
                    mostrarBotoes(true);
                    atvBotoes(false, true, false, false);
                    tfNome.requestFocus();
                    tfNome.selectAll();
                }
            }
        });

        btnAbrirFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!tfID.getText().trim().isEmpty()) {

                    JFileChooser jFileChooser = new JFileChooser();
                    FileNameExtensionFilter filtro = new FileNameExtensionFilter("Sons", "mp3", "wma", "wav", "ogg");
                    jFileChooser.setAcceptAllFileFilterUsed(false);
                    jFileChooser.addChoosableFileFilter(filtro);

                    int respostaDoFileChooser = jFileChooser.showOpenDialog(cp);

                    if (respostaDoFileChooser == JFileChooser.APPROVE_OPTION) {
                        File arquivoSelecionado = jFileChooser.getSelectedFile();
                        String caminho = arquivoSelecionado.getAbsolutePath();
                        tfAudio.setText(caminho);

                        // Leitura do arquivo de áudio
                        byte[] conteudoArquivo = null;
                        try {
                            conteudoArquivo = Files.readAllBytes(arquivoSelecionado.toPath());
                        } catch (IOException ex) {
                            Logger.getLogger(GUIMusica.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        // Atualização do objeto Musica com o novo conteúdo de áudio
                        Musica musica = daoMusica.obter(Integer.valueOf(tfID.getText()));
                        if (musica != null) {
                            musica.setSom(conteudoArquivo);
                            daoMusica.atualizar(musica);
                        }

                    } else {
                        System.out.println("Nenhum arquivo selecionado.");
                    }
                } else {
                    System.out.println("Digite um ID.");
                }
            }
        });

        btnReproduzir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playMusic();
            }
        });

// ----------------   Janela Pesquisar para FKs -----------------
        tfNome.addFocusListener(
                new FocusListener() { //ao receber o foco, fica verde
            @Override
            public void focusGained(FocusEvent fe
            ) {
                tfNome.setBackground(Color.GREEN);
            }

            @Override
            public void focusLost(FocusEvent fe
            ) { //ao perder o foco, fica branco
                tfNome.setBackground(corPadrao);
            }
        }
        );

        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE); //antes de sair do sistema, grava os dados da lista em disco

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                // Sai   
                dispose();
            }
        });

        pack();

        setModal(true);
        setLocation(posicao);

        setVisible(true);//faz a janela ficar visível  
    }

    private void playMusic() {
        try {
            FileInputStream fileInputStream = new FileInputStream(caminhoReproduzir);
            player = new Player(fileInputStream);

            // Reproduz o áudio em uma nova thread para não bloquear a GUI
            new Thread(() -> {
                try {
                    player.play();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }).start();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private byte[] lerArquivoMp3ComoBytes(File arquivo) {
        try {
            Bitstream bitstream = new Bitstream(new FileInputStream(arquivo));
            int totalFrames = 0;
            totalFrames = bitstream.readFrame().max_number_of_frames(totalFrames);
            int totalBytes = totalFrames * 4; // assumindo uma média de 4 bytes por frame

            byte[] buffer = new byte[totalBytes];
            int bytesRead = 0;

            try (FileInputStream fis = new FileInputStream(arquivo)) {
                while (bytesRead < totalBytes) {
                    int count = fis.read(buffer, bytesRead, totalBytes - bytesRead);
                    if (count <= 0) {
                        break;
                    }
                    bytesRead += count;
                }
            }

            return buffer;
        } catch (JavaLayerException | IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        new GUIMusica(new Point(880, 250), new Dimension(800, 600));
    }
}
