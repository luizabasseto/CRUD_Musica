package DAOs;

import static DAOs.DAOGenerico.em;
import Entidade.Plataformas;
import java.util.ArrayList;
import java.util.List;

public class DAOPlataformas extends DAOGenerico<Plataformas> {

    private final List<Plataformas> lista = new ArrayList<>();

    public DAOPlataformas() {
        super(Plataformas.class);
    }

    public int autoIdPlataformas() {
        Integer a = (Integer) em.createQuery("SELECT MAX(e.idPlataformas) FROM Plataformas e ").getSingleResult();
        if (a != null) {
            return a + 1;
        } else {
            return 1;
        }
    }

    public List<Plataformas> listByNome(String nome) {
        return em.createQuery("SELECT e FROM Plataformas e WHERE e.idPlataformas LIKE :nome").setParameter("nome", "%" + nome + "%").getResultList();
    }

    public List<Plataformas> listById(int id) {
        return em.createQuery("SELECT e FROM Plataformas + e WHERE e.nomePlataformas= :id").setParameter("id", id).getResultList();
    }

    public List<Plataformas> listInOrderNome() {
        return em.createQuery("SELECT e FROM Plataformas e ORDER BY e.nomePlataformas").getResultList();
    }

    public List<Plataformas> listInOrderId() {
        return em.createQuery("SELECT e FROM Plataformas e ORDER BY e.idPlataformas").getResultList();
    }

    public List<String> listInOrderNomeStrings(String qualOrdem) {
        List<Plataformas> lf;
        if (qualOrdem.equals("id")) {
            lf = listInOrderId();
        } else {
            lf = listInOrderNome();
        }

        List<String> ls = new ArrayList<>();
        for (int i = 0; i < lf.size(); i++) {
            ls.add(lf.get(i).getIdPlataformas() + "-" + lf.get(i).getNomePlataformas());
        }
        return ls;
    }

    public static void main(String[] args) {
        DAOPlataformas daoPlataformas = new DAOPlataformas();
        List<Plataformas> listaPlataformas = daoPlataformas.list();
        for (Plataformas plataformas : listaPlataformas) {
            System.out.println(plataformas.getIdPlataformas() + "-" + plataformas.getNomePlataformas());
        }
    }
}