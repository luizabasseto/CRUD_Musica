package DAOs;

import static DAOs.DAOGenerico.em;
import Entidade.TomMusica;
import java.util.ArrayList;
import java.util.List;

public class DAOTomMusica extends DAOGenerico<TomMusica> {

    private final List<TomMusica> lista = new ArrayList<>();

    public DAOTomMusica() {
        super(TomMusica.class);
    }

    public int autoIdTomMusica() {
        Integer a = (Integer) em.createQuery("SELECT MAX(e.idTomMusica) FROM TomMusica e ").getSingleResult();
        if (a != null) {
            return a + 1;
        } else {
            return 1;
        }
    }

    public List<TomMusica> listByNome(String nome) {
        return em.createQuery("SELECT e FROM TomMusica e WHERE e.idTomMusica LIKE :nome").setParameter("nome", "%" + nome + "%").getResultList();
    }

    public List<TomMusica> listById(int id) {
        return em.createQuery("SELECT e FROM TomMusica + e WHERE e.nomeTom= :id").setParameter("id", id).getResultList();
    }

    public List<TomMusica> listInOrderNome() {
        return em.createQuery("SELECT e FROM TomMusica e ORDER BY e.nomeTom").getResultList();
    }

    public List<TomMusica> listInOrderId() {
        return em.createQuery("SELECT e FROM TomMusica e ORDER BY e.idTomMusica").getResultList();
    }

    public List<String> listInOrderNomeStrings(String qualOrdem) {
        List<TomMusica> lf;
        if (qualOrdem.equals("id")) {
            lf = listInOrderId();
        } else {
            lf = listInOrderNome();
        }

        List<String> ls = new ArrayList<>();
        for (int i = 0; i < lf.size(); i++) {
            ls.add(lf.get(i).getIdTomMusica() + "-" + lf.get(i).getNomeTom());
        }
        return ls;
    }

    public static void main(String[] args) {
        DAOTomMusica daoTomMusica = new DAOTomMusica();
        List<TomMusica> listaTomMusica = daoTomMusica.list();
        for (TomMusica tomMusica : listaTomMusica) {
            System.out.println(tomMusica.getIdTomMusica() + "-" + tomMusica.getNomeTom());
        }
    }
}