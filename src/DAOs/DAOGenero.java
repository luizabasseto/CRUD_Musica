package DAOs;

import static DAOs.DAOGenerico.em;
import Entidade.Genero;
import java.util.ArrayList;
import java.util.List;

public class DAOGenero extends DAOGenerico<Genero> {

    private final List<Genero> lista = new ArrayList<>();

    public DAOGenero() {
        super(Genero.class);
    }

    public int autoIdGenero() {
        Integer a = (Integer) em.createQuery("SELECT MAX(e.idGenero) FROM Genero e ").getSingleResult();
        if (a != null) {
            return a + 1;
        } else {
            return 1;
        }
    }

    public List<Genero> listByNome(String nome) {
        return em.createQuery("SELECT e FROM Genero e WHERE e.idGenero LIKE :nome").setParameter("nome", "%" + nome + "%").getResultList();
    }

    public List<Genero> listById(int id) {
        return em.createQuery("SELECT e FROM Genero + e WHERE e.nomeGenero= :id").setParameter("id", id).getResultList();
    }

    public List<Genero> listInOrderNome() {
        return em.createQuery("SELECT e FROM Genero e ORDER BY e.nomeGenero").getResultList();
    }

    public List<Genero> listInOrderId() {
        return em.createQuery("SELECT e FROM Genero e ORDER BY e.idGenero").getResultList();
    }

    public List<String> listInOrderNomeStrings(String qualOrdem) {
        List<Genero> lf;
        if (qualOrdem.equals("id")) {
            lf = listInOrderId();
        } else {
            lf = listInOrderNome();
        }

        List<String> ls = new ArrayList<>();
        for (int i = 0; i < lf.size(); i++) {
            ls.add(lf.get(i).getIdGenero() + "-" + lf.get(i).getNomeGenero());
        }
        return ls;
    }

    public static void main(String[] args) {
        DAOGenero daoGenero = new DAOGenero();
        List<Genero> listaGenero = daoGenero.list();
        for (Genero genero : listaGenero) {
            System.out.println(genero.getIdGenero() + "-" + genero.getNomeGenero());
        }
    }
}