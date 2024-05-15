package DAOs;

import static DAOs.DAOGenerico.em;
import Entidade.Paises;
import java.util.ArrayList;
import java.util.List;

public class DAOPaises extends DAOGenerico<Paises> {

    private final List<Paises> lista = new ArrayList<>();

    public DAOPaises() {
        super(Paises.class);
    }

    public int autoIdPaises() {
        Integer a = (Integer) em.createQuery("SELECT MAX(e.idPaises) FROM Paises e ").getSingleResult();
        if (a != null) {
            return a + 1;
        } else {
            return 1;
        }
    }

    public List<Paises> listByNome(String nome) {
        return em.createQuery("SELECT e FROM Paises e WHERE e.idPaises LIKE :nome").setParameter("nome", "%" + nome + "%").getResultList();
    }

    public List<Paises> listById(int id) {
        return em.createQuery("SELECT e FROM Paises + e WHERE e.nomePaises= :id").setParameter("id", id).getResultList();
    }

    public List<Paises> listInOrderNome() {
        return em.createQuery("SELECT e FROM Paises e ORDER BY e.nomePaises").getResultList();
    }

    public List<Paises> listInOrderId() {
        return em.createQuery("SELECT e FROM Paises e ORDER BY e.idPaises").getResultList();
    }

    public List<String> listInOrderNomeStrings(String qualOrdem) {
        List<Paises> lf;
        if (qualOrdem.equals("id")) {
            lf = listInOrderId();
        } else {
            lf = listInOrderNome();
        }

        List<String> ls = new ArrayList<>();
        for (int i = 0; i < lf.size(); i++) {
            ls.add(lf.get(i).getIdPaises() + "-" + lf.get(i).getNomePaises());
        }
        return ls;
    }

    public static void main(String[] args) {
        DAOPaises daoPaises = new DAOPaises();
        List<Paises> listaPaises = daoPaises.list();
        for (Paises paises : listaPaises) {
            System.out.println(paises.getIdPaises() + "-" + paises.getNomePaises());
        }
    }
}