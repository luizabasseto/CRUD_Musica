package DAOs;

import static DAOs.DAOGenerico.em;
import Entidade.Instrumentos;
import java.util.ArrayList;
import java.util.List;

public class DAOInstrumentos extends DAOGenerico<Instrumentos> {

    private final List<Instrumentos> lista = new ArrayList<>();

    public DAOInstrumentos() {
        super(Instrumentos.class);
    }

    public int autoIdInstrumentos() {
        Integer a = (Integer) em.createQuery("SELECT MAX(e.idInstrumentos) FROM Instrumentos e ").getSingleResult();
        if (a != null) {
            return a + 1;
        } else {
            return 1;
        }
    }

    public List<Instrumentos> listByNome(String nome) {
        return em.createQuery("SELECT e FROM Instrumentos e WHERE e.idInstrumentos LIKE :nome").setParameter("nome", "%" + nome + "%").getResultList();
    }

    public List<Instrumentos> listById(int id) {
        return em.createQuery("SELECT e FROM Instrumentos + e WHERE e.nomeInstrumentos= :id").setParameter("id", id).getResultList();
    }

    public List<Instrumentos> listInOrderNome() {
        return em.createQuery("SELECT e FROM Instrumentos e ORDER BY e.nomeInstrumentos").getResultList();
    }

    public List<Instrumentos> listInOrderId() {
        return em.createQuery("SELECT e FROM Instrumentos e ORDER BY e.idInstrumentos").getResultList();
    }

    public List<String> listInOrderNomeStrings(String qualOrdem) {
        List<Instrumentos> lf;
        if (qualOrdem.equals("id")) {
            lf = listInOrderId();
        } else {
            lf = listInOrderNome();
        }

        List<String> ls = new ArrayList<>();
        for (int i = 0; i < lf.size(); i++) {
            ls.add(lf.get(i).getIdInstrumentos() + "-" + lf.get(i).getNomeInstrumentos());
        }
        return ls;
    }

    public static void main(String[] args) {
        DAOInstrumentos daoInstrumentos = new DAOInstrumentos();
        List<Instrumentos> listaInstrumentos = daoInstrumentos.list();
        for (Instrumentos instrumentos : listaInstrumentos) {
            System.out.println(instrumentos.getIdInstrumentos() + "-" + instrumentos.getNomeInstrumentos());
        }
    }
}