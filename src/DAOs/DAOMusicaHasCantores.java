package DAOs;

import Entidade.MusicaHasCantores;
import Entidade.MusicaHasCantoresPK;
import static DAOs.DAOGenerico.em;
import java.util.ArrayList;
import java.util.List;

public class DAOMusicaHasCantores extends DAOGenerico<MusicaHasCantores> {

    public DAOMusicaHasCantores() {
        super(MusicaHasCantores.class);
    }

    public MusicaHasCantores obter(MusicaHasCantoresPK musicaHasCantores) {
        return em.find(MusicaHasCantores.class, musicaHasCantores);
    }

    public List<MusicaHasCantores> listInOrderNome() {
        return em.createQuery("SELECT e FROM MusicaHasCantores e ORDER BY e.musica").getResultList();
    }

    public List<String> listInOrderNomeStrings() {
        List<MusicaHasCantores> lf = listInOrderNome();
        List<String> ls = new ArrayList<>();
        for (int i = 0; i < lf.size(); i++) {
            ls.add(lf.get(i).getMusicaHasCantoresPK().toString());
        }
        return ls;
    }
}
