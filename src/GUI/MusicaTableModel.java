package GUI;

import DAOs.DAOPaises;
import Entidade.Musica;
import Entidade.Paises;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Date;
import javax.swing.table.AbstractTableModel;

public class MusicaTableModel extends AbstractTableModel {

//  ------------------------------------------------------------------------------------------------------ 
    private final Class classes[] = new Class[]{Integer.class, String.class, Paises.class};
    private final String colunas[] = new String[]{"id", "nome", "nome_paises"};
    private List<Musica> dados;
    private final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    //private final SimpleDateFormat timeformat = new SimpleDateFormat("h:mm a");
    public MusicaTableModel(List<Musica> dados) {
        this.dados = dados;
    }

    public void setDados(List<Musica> dados) {
        this.dados = dados;
    }

    public List<Musica> getDados() {
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

        Musica musica = dados.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return musica.getIdMusica();
            case 1:
                return musica.getNomeMusica();
            case 2:
                return musica.getPaisesIdPaises();
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
        for (Musica x : dados) {
            if (x.getIdMusica() == (chave)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        String aaa[];
        Musica musica = dados.get(rowIndex);
        switch (columnIndex) {
            case 0:
                if (!chaveExiste((int) aValue)) {
                    musica.setIdMusica((int) aValue);
                }
                break;
            case 1:
                musica.setNomeMusica((String) aValue);
                break;
            case 2:
                String f = (String) aValue;
                String aux[] = f.split("-");
                Paises paises = new DAOPaises().obter(Integer.valueOf(aux[0]));
                musica.setPaisesIdPaises(paises);
                break;
            default:
                throw new IndexOutOfBoundsException("Coluna Inválida!!!");

        }
        fireTableDataChanged();
    }

    public Musica getValue(int rowIndex) {
        return dados.get(rowIndex);
    }

    public int indexOf(Musica musica) {
        return dados.indexOf(musica);
    }

    public void onAdd(Musica musica) {
        dados.add(musica);
        fireTableRowsInserted(indexOf(musica), indexOf(musica));
    }

    public void onRemove(int[] rowIndex) {
        int x;
        for (x = rowIndex.length - 1; x >= 0; x--) {
            dados.remove(rowIndex[x]);
            fireTableRowsDeleted(rowIndex[x], rowIndex[x]);
        }
    }
}
