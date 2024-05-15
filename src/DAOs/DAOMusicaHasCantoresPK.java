package DAOs;

import Entidade.MusicaHasCantores;
import Entidade.MusicaHasCantoresPK;

public class DAOMusicaHasCantoresPK extends DAOGenerico<MusicaHasCantoresPK> {

    public DAOMusicaHasCantoresPK() {
        super(MusicaHasCantoresPK.class);
    }
    
    public MusicaHasCantoresPK obter(MusicaHasCantoresPK musicaHasCantores) {
        return em.find(MusicaHasCantoresPK.class, musicaHasCantores);
    }
    
}  
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

