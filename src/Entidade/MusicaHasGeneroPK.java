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
public class MusicaHasGeneroPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "musica_id_musica", nullable = false)
    private int musicaIdMusica;
    @Basic(optional = false)
    @Column(name = "genero_id_genero", nullable = false)
    private int generoIdGenero;

    public MusicaHasGeneroPK() {
    }

    public MusicaHasGeneroPK(int musicaIdMusica, int generoIdGenero) {
        this.musicaIdMusica = musicaIdMusica;
        this.generoIdGenero = generoIdGenero;
    }

    public int getMusicaIdMusica() {
        return musicaIdMusica;
    }

    public void setMusicaIdMusica(int musicaIdMusica) {
        this.musicaIdMusica = musicaIdMusica;
    }

    public int getGeneroIdGenero() {
        return generoIdGenero;
    }

    public void setGeneroIdGenero(int generoIdGenero) {
        this.generoIdGenero = generoIdGenero;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) musicaIdMusica;
        hash += (int) generoIdGenero;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MusicaHasGeneroPK)) {
            return false;
        }
        MusicaHasGeneroPK other = (MusicaHasGeneroPK) object;
        if (this.musicaIdMusica != other.musicaIdMusica) {
            return false;
        }
        if (this.generoIdGenero != other.generoIdGenero) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidade.MusicaHasGeneroPK[ musicaIdMusica=" + musicaIdMusica + ", generoIdGenero=" + generoIdGenero + " ]";
    }
    
}
