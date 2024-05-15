package GUI;

import DAOs.DAOTomMusica;
import Entidade.TomMusica;
import java.awt.Dimension;
import java.util.List;
import java.awt.Point;
import javax.swing.JDialog;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.WindowConstants;
import myUtil.JanelaPesquisar;
import java.text.SimpleDateFormat;
import java.text.DecimalFormat;
import javax.swing.BorderFactory;

import myUtil.UsarGridBagLayout;

public class GUITomMusica extends JDialog {

    ImageIcon iconeCreate = new ImageIcon(getClass().getResource("/icones/create.png"));
    ImageIcon iconeNext = new ImageIcon(getClass().getResource("/icones/next.png"));
    ImageIcon iconeRetrieve = new ImageIcon(getClass().getResource("/icones/retrieve.png"));
    ImageIcon iconeUpdate = new ImageIcon(getClass().getResource("/icones/update.png"));
    ImageIcon iconeDelete = new ImageIcon(getClass().getResource("/icones/delete.png"));
    ImageIcon iconeSave = new ImageIcon(getClass().getResource("/icones/save.png"));
    ImageIcon iconeCancel = new ImageIcon(getClass().getResource("/icones/cancel.png"));
    ImageIcon iconeListar = new ImageIcon(getClass().getResource("/icones/list.png"));
    JButton btnNext = new JButton(iconeNext);
    JButton btnCreate = new JButton(iconeCreate);
    JButton btnRetrieve = new JButton(iconeRetrieve);
    JButton btnUpdate = new JButton(iconeUpdate);
    JButton btnDelete = new JButton(iconeDelete);
    JButton btnSave = new JButton(iconeSave);
    JButton btnCancel = new JButton(iconeCancel);
    JButton btnList = new JButton(iconeListar);

    JLabel lbID = new JLabel("ID");
    JTextField tfID = new JTextField(20);
    JLabel lbNOME = new JLabel("Nome");
    JTextField tfNOME = new JTextField(20);

    JPanel pnAvisos = new JPanel();
    JLabel labelAviso = new JLabel("");

    String acao = "";//variavel para facilitar insert e update
    DAOTomMusica daoTomMusica = new DAOTomMusica();
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    DecimalFormat decimalFormat = new DecimalFormat("###,###,##0.00");
    TomMusica tomMusica;

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

    private void habilitarAtributos(boolean id, boolean nome) {
        if (id) {
            tfID.requestFocus();
            tfID.selectAll();
        }
        tfID.setEnabled(id);
        tfID.setEditable(id);
        tfNOME.setEditable(nome);

    }

    public void zerarAtributos() {
        tfNOME.setText("");
    }

    Color corPadrao = lbID.getBackground();

    public GUITomMusica(Point posicao, Dimension dimensao) {
        setTitle("CRUD - TomMusica");
        setSize(dimensao);//tamanho da janela
        setLayout(new BorderLayout());//informa qual gerenciador de layout será usado
        setBackground(Color.CYAN);//cor do fundo da janela
        Container cp = getContentPane();//container principal, para adicionar nele os outros componentes

        atvBotoes(false, true, false, false);
        habilitarAtributos(true, false);
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
        btnSave.setVisible(false);
        btnCancel.setVisible(false);

//atritubos não chave, todos no painel centro
        JPanel centro = new JPanel();
        UsarGridBagLayout usarGridBagLayout = new UsarGridBagLayout(centro);
        usarGridBagLayout.add(lbNOME, tfNOME, corPadrao);
        pnAvisos.add(labelAviso);
        cp.add(toolbar1, BorderLayout.NORTH);
        cp.add(centro, BorderLayout.CENTER);
        cp.add(pnAvisos, BorderLayout.SOUTH);
        tfID.requestFocus();
        tfID.selectAll();
        labelAviso.setText("Digite um id e clic [Pesquisar]");

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

//-----------------------------  btnRetrieve ------------------------------------------
        btnRetrieve.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                tomMusica = new TomMusica();
                tfID.setText(tfID.getText().trim());//caso tenham sido digitados espaços

                if (tfID.getText().equals("")) {
                    List<String> listaAuxiliar = daoTomMusica.listInOrderNomeStrings("id");
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
                        tomMusica.setIdTomMusica(Integer.valueOf(tfID.getText()));
                        tomMusica = daoTomMusica.obter(tomMusica.getIdTomMusica());
                        if (tomMusica != null) { //se encontrou na lista
                            tfNOME.setText(String.valueOf(tomMusica.getNomeTom()));
                            atvBotoes(false, true, true, true);
                            habilitarAtributos(true, false);
                            labelAviso.setText("Encontrou - clic [Pesquisar], [Alterar] ou [Excluir]");
                            acao = "encontrou";
                        } else {
                            atvBotoes(true, true, false, false);
                            zerarAtributos();
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
                habilitarAtributos(false, true);
                tfNOME.requestFocus();
                mostrarBotoes(false);
                labelAviso.setText("Preencha os campos e clic [Salvar] ou clic [Cancelar]");
                acao = "insert";
            }
        });

        // ---------------------- botao next ------------------------------
        btnNext.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int prox = daoTomMusica.autoIdTomMusica();
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
                    tomMusica = new TomMusica();
                }
                tomMusica.setIdTomMusica(Integer.valueOf(tfID.getText()));
                tomMusica.setNomeTom(String.valueOf(tfNOME.getText()));

                if (!deuRuim) {
                    if (acao.equals("insert")) {
                        daoTomMusica.inserir(tomMusica);
                        labelAviso.setText("Registro inserido.");
                    } else {
                        daoTomMusica.atualizar(tomMusica);
                        labelAviso.setText("Registro alterado.");
                    }
                    habilitarAtributos(true, false);
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
                habilitarAtributos(true, false);
                mostrarBotoes(true);
            }
        });

        btnList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                acao = "list";
              //  GUITomMusicaListagem guiTomMusicaListagem = new GUITomMusicaListagem(daoTomMusica.listInOrderNome(), getBounds().x, getBounds().y, dimensao);
            }
        });

        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                acao = "update";
                mostrarBotoes(false);
                habilitarAtributos(false, true);
            }
        });
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(null,
                        "Confirma a exclusão do registro <ID = " + tomMusica.getNomeTom() + ">?", "Confirm",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)) {
                    labelAviso.setText("Registro excluído...");
                    daoTomMusica.remover(tomMusica);
                    zerarAtributos();
                    mostrarBotoes(true);
                    atvBotoes(false, true, false, false);
                    tfNOME.requestFocus();
                    tfNOME.selectAll();
                }
            }
        });// ----------------   Janela Pesquisar para FKs -----------------
        tfNOME.addFocusListener(new FocusListener() { //ao receber o foco, fica verde
            @Override
            public void focusGained(FocusEvent fe) {
                tfNOME.setBackground(Color.GREEN);
            }

            @Override
            public void focusLost(FocusEvent fe) { //ao perder o foco, fica branco
                tfNOME.setBackground(corPadrao);
            }
        });

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

    public static void main(String[] args) {
        new GUITomMusica(new Point(880, 250), new Dimension(800, 600));
    }
}
