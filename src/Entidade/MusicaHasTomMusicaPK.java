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
public class MusicaHasTomMusicaPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "musica_id_musica", nullable = false)
    private int musicaIdMusica;
    @Basic(optional = false)
    @Column(name = "tom_musica_id_tom_musica", nullable = false)
    private int tomMusicaIdTomMusica;

    public MusicaHasTomMusicaPK() {
    }

    public MusicaHasTomMusicaPK(int musicaIdMusica, int tomMusicaIdTomMusica) {
        this.musicaIdMusica = musicaIdMusica;
        this.tomMusicaIdTomMusica = tomMusicaIdTomMusica;
    }

    public int getMusicaIdMusica() {
        return musicaIdMusica;
    }

    public void setMusicaIdMusica(int musicaIdMusica) {
        this.musicaIdMusica = musicaIdMusica;
    }

    public int getTomMusicaIdTomMusica() {
        return tomMusicaIdTomMusica;
    }

    public void setTomMusicaIdTomMusica(int tomMusicaIdTomMusica) {
        this.tomMusicaIdTomMusica = tomMusicaIdTomMusica;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) musicaIdMusica;
        hash += (int) tomMusicaIdTomMusica;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MusicaHasTomMusicaPK)) {
            return false;
        }
        MusicaHasTomMusicaPK other = (MusicaHasTomMusicaPK) object;
        if (this.musicaIdMusica != other.musicaIdMusica) {
            return false;
        }
        if (this.tomMusicaIdTomMusica != other.tomMusicaIdTomMusica) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidade.MusicaHasTomMusicaPK[ musicaIdMusica=" + musicaIdMusica + ", tomMusicaIdTomMusica=" + tomMusicaIdTomMusica + " ]";
    }
    
}
