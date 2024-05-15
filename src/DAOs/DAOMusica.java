package DAOs;

import static DAOs.DAOGenerico.em;
import Entidade.Musica;
import java.util.ArrayList;
import java.util.List;

public class DAOMusica extends DAOGenerico<Musica> {

    private final List<Musica> lista = new ArrayList<>();

    public DAOMusica() {
        super(Musica.class);
    }

    public int autoIdMusica() {
        Integer a = (Integer) em.createQuery("SELECT MAX(e.idMusica) FROM Musica e ").getSingleResult();
        if (a != null) {
            return a + 1;
        } else {
            return 1;
        }
    }

    public List<Musica> listByNome(String nome) {
        return em.createQuery("SELECT e FROM Musica e WHERE e.idMusica LIKE :nome").setParameter("nome", "%" + nome + "%").getResultList();
    }

    public List<Musica> listById(int id) {
        return em.createQuery("SELECT e FROM Musica + e WHERE e.nomeMusica= :id").setParameter("id", id).getResultList();
    }

    public List<Musica> listInOrderNome() {
        return em.createQuery("SELECT e FROM Musica e ORDER BY e.nomeMusica").getResultList();
    }

    public List<Musica> listInOrderId() {
        return em.createQuery("SELECT e FROM Musica e ORDER BY e.idMusica").getResultList();
    }

    public List<String> listInOrderNomeStrings(String qualOrdem) {
        List<Musica> lf;
        if (qualOrdem.equals("id")) {
            lf = listInOrderId();
        } else {
            lf = listInOrderNome();
        }

        List<String> ls = new ArrayList<>();
        for (int i = 0; i < lf.size(); i++) {
            ls.add(lf.get(i).getIdMusica() + "-" + lf.get(i).getNomeMusica());
        }
        return ls;
    }

    public static void main(String[] args) {
        DAOMusica daoMusica = new DAOMusica();
        List<Musica> listaMusica = daoMusica.list();
        for (Musica musica : listaMusica) {
            System.out.println(musica.getIdMusica() + "-" + musica.getNomeMusica());
        }
    }
}