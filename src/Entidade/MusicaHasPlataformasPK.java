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
public class MusicaHasPlataformasPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "musica_id_musica", nullable = false)
    private int musicaIdMusica;
    @Basic(optional = false)
    @Column(name = "plataformas_id_plataformas", nullable = false)
    private int plataformasIdPlataformas;

    public MusicaHasPlataformasPK() {
    }

    public MusicaHasPlataformasPK(int musicaIdMusica, int plataformasIdPlataformas) {
        this.musicaIdMusica = musicaIdMusica;
        this.plataformasIdPlataformas = plataformasIdPlataformas;
    }

    public int getMusicaIdMusica() {
        return musicaIdMusica;
    }

    public void setMusicaIdMusica(int musicaIdMusica) {
        this.musicaIdMusica = musicaIdMusica;
    }

    public int getPlataformasIdPlataformas() {
        return plataformasIdPlataformas;
    }

    public void setPlataformasIdPlataformas(int plataformasIdPlataformas) {
        this.plataformasIdPlataformas = plataformasIdPlataformas;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) musicaIdMusica;
        hash += (int) plataformasIdPlataformas;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MusicaHasPlataformasPK)) {
            return false;
        }
        MusicaHasPlataformasPK other = (MusicaHasPlataformasPK) object;
        if (this.musicaIdMusica != other.musicaIdMusica) {
            return false;
        }
        if (this.plataformasIdPlataformas != other.plataformasIdPlataformas) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidade.MusicaHasPlataformasPK[ musicaIdMusica=" + musicaIdMusica + ", plataformasIdPlataformas=" + plataformasIdPlataformas + " ]";
    }
    
}
