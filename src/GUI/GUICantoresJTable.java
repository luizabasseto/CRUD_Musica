package GUIs;

import myUtil.CentroDoMonitorMaior;
import DAOs.DAOCantores;
import Entidade.Cantores;
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

public class GUICantoresJTable extends JDialog {

//  ------------------------------------------------------------------------------------------------------ 
    private Container cp;
    private final JPanel painelAvisos = new JPanel();
    private final JButton btnAdd = new JButton("Adicionar");
    private final JButton btnRem = new JButton("Remover");
    private final JButton btnCarregar = new JButton("Carregar dados");

    private JTable table = new JTable();
    private CantoresTableModel tableModel;

    private DAOCantores daoCantores = new DAOCantores();

    public GUICantoresJTable(Point posicao, Dimension dimensao) {

        setTitle("CRUD Cantores");
        setLayout(new FlowLayout());
        setSize(dimensao);

        cp = getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(BorderLayout.NORTH, painelAvisos);

        List< Cantores> lista = new ArrayList<>();
        tableModel = new CantoresTableModel(lista);
        table.setModel(tableModel);

        JScrollPane scrollPane = new JScrollPane(table);
        cp.add(scrollPane);

        painelAvisos.add(new JLabel("Tecla INS = Insere novo registro"));
        painelAvisos.add(new JLabel("   --   "));
        painelAvisos.add(new JLabel("Tecla DEL = Exclui registro selecionado"));
        painelAvisos.setBackground(Color.cyan);

        table.setDefaultEditor(Date.class, new DateEditor());
        table.setDefaultRenderer(Date.class, new DateRenderer());

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
                            + tableModel.getValue(table.getSelectedRow()).getNomeCantores()+ "]?", "Confirm",
                            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)) {
                        btnRem.doClick();
                    }
                } else {
                    JOptionPane.showMessageDialog(cp, "Escolha na tabela a Cantores a ser excluída");
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
                    Cantores cantores = new Cantores();

                    cantores.setIdCantores(Integer.valueOf(umCPF));
                    cantores.setNomeCantores("");
                    try {
                        daoCantores.inserir(cantores);
                        tableModel.onAdd(cantores);
                        tableModel.fireTableDataChanged();

                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(cp, "Esse ID já está cadastrado");
                    }
                } else {
                    JOptionPane.showMessageDialog(cp,"Você cancelou ou não digitou um ID.");
                }
                table.requestFocus();
            }
        });//============================================ botao remover =======================================================

        btnRem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (table.getSelectedRow() != -1 && table.getSelectedRow() < tableModel.getRowCount()) {
                    Cantores cantores = tableModel.getValue(table.getSelectedRow());
                    daoCantores.remover(cantores);
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
                DAOCantores daoCantores = new DAOCantores();
                try {
                    List<Cantores> lc = daoCantores.list();
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
                    Cantores c = tableModel.getValue(table.getSelectedRow());
                    daoCantores.atualizar(c);
                }
                //}
            }
        });//============================================ fim do construtor gui =======================================================

        CentroDoMonitorMaior centroDoMonitorMaior = new CentroDoMonitorMaior();

        setLocation(centroDoMonitorMaior.getCentroMonitorMaior(this));
        btnCarregar.doClick();//carrega os dados 

        setModal(true);
        setVisible(true);

    } //fim do construtor da GUI

//============================================ date render =======================================================
    private static class DateRenderer extends DefaultTableCellRenderer {

        private static final long serialVersionUID = 1L;

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
    private static class DateEditor extends AbstractCellEditor implements TableCellEditor {

        private static final long serialVersionUID = 1L;
        private final JSpinner theSpinner;
        private Object value;

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
        new GUICantoresJTable(new Point(880, 250), new Dimension(800, 600));
    }
}
