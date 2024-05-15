package GUIs;

import Entidade.Cantores;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Date;
import javax.swing.table.AbstractTableModel;

public class CantoresTableModel extends AbstractTableModel {

//  ------------------------------------------------------------------------------------------------------ 
    private final Class classes[] = new Class[]{Integer.class, String.class};
    private final String colunas[] = new String[]{"id", "nome"};
    private List<Cantores> dados;
    private final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    //private final SimpleDateFormat timeformat = new SimpleDateFormat("h:mm a");
    public CantoresTableModel(List<Cantores> dados) {
        this.dados = dados;
    }

    public void setDados(List<Cantores> dados) {
        this.dados = dados;
    }

    public List<Cantores> getDados() {
        return this.dados;
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public int getRowCount() {
        return dados.size();
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return classes[columnIndex];
    }

    @Override
    public String getColumnName(int columnIndex) {
        return colunas[columnIndex];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        Cantores cantores = dados.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return cantores.getIdCantores();
            case 1:
                return cantores.getNomeCantores();
            default:
                throw new IndexOutOfBoundsException("Coluna Inválida!");
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        if (columnIndex == 0) {
            return false;
        }
        return true;
    }

// Para impedir que exista duplicidade na chave primaria
    public boolean chaveExiste(int chave) {
        for (Cantores x : dados) {
            if (x.getIdCantores()==(chave)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        String aaa[];
        Cantores cantores = dados.get(rowIndex);
        switch (columnIndex) {
            case 0:
                if (!chaveExiste((int) aValue)) {
                    cantores.setIdCantores((int) aValue);
                }
                break;
            case 1:
                cantores.setNomeCantores((String) aValue);
                break;
            default:
                throw new IndexOutOfBoundsException("Coluna Inválida!!!");

        }
        fireTableDataChanged();
    }

    public Cantores getValue(int rowIndex) {
        return dados.get(rowIndex);
    }

    public int indexOf(Cantores cantores) {
        return dados.indexOf(cantores);
    }

    public void onAdd(Cantores cantores) {
        dados.add(cantores);
        fireTableRowsInserted(indexOf(cantores), indexOf(cantores));
    }

    public void onRemove(int[] rowIndex) {
        int x;
        for (x = rowIndex.length - 1; x >= 0; x--) {
            dados.remove(rowIndex[x]);
            fireTableRowsDeleted(rowIndex[x], rowIndex[x]);
        }
    }
}
