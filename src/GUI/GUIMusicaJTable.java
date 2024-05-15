package GUI;

import myUtil.CentroDoMonitorMaior;
import DAOs.DAOMusica;
import DAOs.DAOPaises;
import Entidade.Musica;
import Entidade.Paises;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.KeyStroke;
import javax.swing.AbstractCellEditor;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableColumn;
import javax.swing.JComboBox;
import javax.swing.DefaultCellEditor;
import java.awt.Dimension;
import java.awt.Point;
import javax.swing.plaf.ComboBoxUI;

public class GUIMusicaJTable extends JDialog {

//  ------------------------------------------------------------------------------------------------------ 
    Container cp;
     JPanel painelAvisos = new JPanel();
     JButton btnAdd = new JButton("Adicionar");
     JButton btnRem = new JButton("Remover");
     JButton btnCarregar = new JButton("Carregar dados");
     JLabel lbAViso = new JLabel("Tecla INS = Insere novo registro   --   Tecla DEL = Exclui registro selecionado");

    JTable table = new JTable();
    MusicaTableModel tableModel;

    DAOPaises daoPaises = new DAOPaises();
    DAOMusica daoMusica = new DAOMusica();

    public GUIMusicaJTable(Point posicao, Dimension dimensao) {

        setTitle("CRUD Musica");
        setLayout(new FlowLayout());
        setSize(dimensao);

        cp = getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(BorderLayout.NORTH, painelAvisos);

        List<Musica> lista = new ArrayList<>();
        tableModel = new MusicaTableModel(lista);
        table.setModel(tableModel);

        JScrollPane scrollPane = new JScrollPane(table);
        cp.add(scrollPane);
        
        lbAViso.setForeground(Color.white);

        painelAvisos.add(lbAViso);
        painelAvisos.setBackground(new Color(1, 81, 41));

        table.setDefaultEditor(Date.class, new DateEditor());
        table.setDefaultRenderer(Date.class, new DateRenderer());

        TableColumn tipoColumn = table.getColumnModel().getColumn(2);

        JComboBox comboBox = new JComboBox();

        List<Paises> ltc = daoPaises.list();
        for (int i = 0; i < ltc.size(); i++) {
            comboBox.addItem(ltc.get(i).getIdPaises() + "-" + ltc.get(i).getNomePaises());
        }

        tipoColumn.setCellEditor(new DefaultCellEditor(comboBox));

        // É necessário clicar antes na tabela para o código funcionar
        InputMap im = table.getInputMap(JTable.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        ActionMap actionMap = table.getActionMap();

        KeyStroke enterKey = KeyStroke.getKeyStroke(KeyEvent.VK_INSERT, 0);
        im.put(enterKey, "Action.insert");

        actionMap.put("Action.insert", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                btnAdd.doClick();
            }
        });

//---------------------------------- button delete -----------------------------
        KeyStroke delKey = KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, 0);
        im.put(delKey, "Action.delete");

        actionMap.put("Action.delete", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if (table.getSelectedRow() >= 0) {

                    if (JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(cp,
                            "Confirma a exclusão do(a) Cantor(a) [" + " - "
                            + tableModel.getValue(table.getSelectedRow()).getNomeMusica() + "]?", "Confirm",
                            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)) {
                        btnRem.doClick();
                    }
                } else {
                    JOptionPane.showMessageDialog(cp, "Escolha na tabela a Musica a ser excluída");
                }
            }
        });

//========================================== fechar a janela ============================================
        this.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(WindowEvent winEvt) {
                dispose();
            }
        });
//========================================== botão add ============================================

        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object[] options = {"OK", "Cancelar"};
                String umCPF = (String) JOptionPane.showInputDialog(cp, "Digite um ID:", "Entrada de Dados", JOptionPane.PLAIN_MESSAGE, null, null, null);

                if ((umCPF != null) && (!umCPF.isEmpty())) {
                    Musica musica = new Musica();

                    Paises paises = daoPaises.obter(1);
                    if (paises == null) {
                        JOptionPane.showMessageDialog(cp, "erro no tipo_atributo");
                        return;
                    } else {
                        // System.out.println("tipo atributo=> " + tipoAtributos.getNomePaises());
                    }

                    musica.setIdMusica(Integer.valueOf(umCPF));
                    musica.setNomeMusica("");
                    String f = (String) comboBox.getSelectedItem();
                    String aux[] = f.split("-");
                    paises = daoPaises.obter(Integer.valueOf(aux[0]));
                    musica.setPaisesIdPaises(paises);

                    try {
                        daoMusica.inserir(musica);
                        tableModel.onAdd(musica);
                        tableModel.fireTableDataChanged();

                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(cp, "Esse ID já está cadastrado");
                    }
                } else {
                    JOptionPane.showMessageDialog(cp, "Você cancelou ou não digitou um ID.");
                }
                table.requestFocus();
            }
        });//============================================ botao remover =======================================================

        btnRem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (table.getSelectedRow() != -1 && table.getSelectedRow() < tableModel.getRowCount()) {
                    Musica musica = tableModel.getValue(table.getSelectedRow());
                    daoMusica.remover(musica);
                    tableModel.onRemove(table.getSelectedRows());

                } else {
                    JOptionPane.showMessageDialog(cp, "Escolha na tabela a conta a ser excluída");
                    table.requestFocus();
                }
                tableModel.fireTableDataChanged();
            }
        });//============================================ botao carregar =======================================================

        btnCarregar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                DAOMusica daoMusica = new DAOMusica();
                try {
                    List<Musica> lc = daoMusica.list();
                    tableModel.setDados(lc);
                    tableModel.fireTableDataChanged();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(cp, "Erro ao carregar os dados..." + ex.getMessage());
                }
            }

        });
//============================================ listener table =======================================================

        tableModel.addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                // if (tableModel.mudou) {
                if (table.getSelectedRow() != -1 && table.getSelectedRow() < tableModel.getRowCount()) {
                    Musica c = tableModel.getValue(table.getSelectedRow());
                    daoMusica.atualizar(c);
                }
                //}
            }
        });//============================================ fim do construtor gui =======================================================

        CentroDoMonitorMaior centroDoMonitorMaior = new CentroDoMonitorMaior();

        setLocation(centroDoMonitorMaior.getCentroMonitorMaior(this));
        btnCarregar.doClick();//carrega os dados 

        pack();
        setModal(true);
        setLocation(posicao);
        setVisible(true);

    } //fim do construtor da GUI

//============================================ date render =======================================================
    static class DateRenderer extends DefaultTableCellRenderer {

        static  long serialVersionUID = 1L;

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if (!(value instanceof Date)) {
                return this;
            }
            DateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");
            setText(DATE_FORMAT.format((Date) value));
            return this;
        }
    }

//============================================ date editor =======================================================
    static class DateEditor extends AbstractCellEditor implements TableCellEditor {

        static  long serialVersionUID = 1L;
         JSpinner theSpinner;
        Object value;

        DateEditor() {
            theSpinner = new JSpinner(new SpinnerDateModel());
            theSpinner.setOpaque(true);
            theSpinner.setEditor(new JSpinner.DateEditor(theSpinner, "dd/MM/yyyy"));
        }

        @Override
        public Object getCellEditorValue() {
            return theSpinner.getValue();
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            theSpinner.setValue(value);
            if (isSelected) {
                theSpinner.setBackground(table.getSelectionBackground());
            } else {
                theSpinner.setBackground(table.getBackground());
            }
            return theSpinner;
        }
    }

    public static void main(String[] args) {
        new GUIMusicaJTable(new Point(880, 250), new Dimension(800, 600));
    }
}
