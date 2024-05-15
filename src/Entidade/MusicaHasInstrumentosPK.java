/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidade;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author luiza
 */
@Embeddable
public class MusicaHasInstrumentosPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "musica_id_musica", nullable = false)
    private int musicaIdMusica;
    @Basic(optional = false)
    @Column(name = "instrumentos_id_instrumentos", nullable = false)
    private int instrumentosIdInstrumentos;

    public MusicaHasInstrumentosPK() {
    }

    public MusicaHasInstrumentosPK(int musicaIdMusica, int instrumentosIdInstrumentos) {
        this.musicaIdMusica = musicaIdMusica;
        this.instrumentosIdInstrumentos = instrumentosIdInstrumentos;
    }

    public int getMusicaIdMusica() {
        return musicaIdMusica;
    }

    public void setMusicaIdMusica(int musicaIdMusica) {
        this.musicaIdMusica = musicaIdMusica;
    }

    public int getInstrumentosIdInstrumentos() {
        return instrumentosIdInstrumentos;
    }

    public void setInstrumentosIdInstrumentos(int instrumentosIdInstrumentos) {
        this.instrumentosIdInstrumentos = instrumentosIdInstrumentos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) musicaIdMusica;
        hash += (int) instrumentosIdInstrumentos;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MusicaHasInstrumentosPK)) {
            return false;
        }
        MusicaHasInstrumentosPK other = (MusicaHasInstrumentosPK) object;
        if (this.musicaIdMusica != other.musicaIdMusica) {
            return false;
        }
        if (this.instrumentosIdInstrumentos != other.instrumentosIdInstrumentos) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidade.MusicaHasInstrumentosPK[ musicaIdMusica=" + musicaIdMusica + ", instrumentosIdInstrumentos=" + instrumentosIdInstrumentos + " ]";
    }
    
}
