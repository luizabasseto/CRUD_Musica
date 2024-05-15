package DAOs;

import Entidade.Cantores;
import java.util.ArrayList;
import java.util.List;

public class DAOCantores extends DAOGenerico<Cantores> {

    private final List<Cantores> lista = new ArrayList<>();

    public DAOCantores() {
        super(Cantores.class);
    }

    public int autoIdCantores() {
        Integer a = (Integer) em.createQuery("SELECT MAX(e.idCantores) FROM Cantores e ").getSingleResult();
        if (a != null) {
            return a + 1;
        } else {
            return 1;
        }
    }

    public List<Cantores> listByNome(String nome) {
        return em.createQuery("SELECT e FROM Cantores e WHERE e.idCantores LIKE :nome").setParameter("nome", "%" + nome + "%").getResultList();
    }

    public List<Cantores> listById(int id) {
        return em.createQuery("SELECT e FROM Cantores + e WHERE e.nomeCantores= :id").setParameter("id", id).getResultList();
    }

    public List<Cantores> listInOrderNome() {
        return em.createQuery("SELECT e FROM Cantores e ORDER BY e.nomeCantores").getResultList();
    }

    public List<Cantores> listInOrderId() {
        return em.createQuery("SELECT e FROM Cantores e ORDER BY e.idCantores").getResultList();
    }

    public List<String> listInOrderNomeStrings(String qualOrdem) {
        List<Cantores> lf;
        if (qualOrdem.equals("id")) {
            lf = listInOrderId();
        } else {
            lf = listInOrderNome();
        }

        List<String> ls = new ArrayList<>();
        for (int i = 0; i < lf.size(); i++) {
            ls.add(lf.get(i).getIdCantores() + "-" + lf.get(i).getNomeCantores());
        }
        return ls;
    }

    public static void main(String[] args) {
        DAOCantores daoCantores = new DAOCantores();
        List<Cantores> listaCantores = daoCantores.list();
        for (Cantores cantores : listaCantores) {
            System.out.println(cantores.getIdCantores() + "-" + cantores.getNomeCantores());
        }
    }
}