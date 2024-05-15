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
public class MusicaHasCantoresPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "musica_id_musica", nullable = false)
    private int musicaIdMusica;
    @Basic(optional = false)
    @Column(name = "cantores_id_cantores", nullable = false)
    private int cantoresIdCantores;

    public MusicaHasCantoresPK() {
    }

    public MusicaHasCantoresPK(int musicaIdMusica, int cantoresIdCantores) {
        this.musicaIdMusica = musicaIdMusica;
        this.cantoresIdCantores = cantoresIdCantores;
    }

    public int getMusicaIdMusica() {
        return musicaIdMusica;
    }

    public void setMusicaIdMusica(int musicaIdMusica) {
        this.musicaIdMusica = musicaIdMusica;
    }

    public int getCantoresIdCantores() {
        return cantoresIdCantores;
    }

    public void setCantoresIdCantores(int cantoresIdCantores) {
        this.cantoresIdCantores = cantoresIdCantores;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) musicaIdMusica;
        hash += (int) cantoresIdCantores;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MusicaHasCantoresPK)) {
            return false;
        }
        MusicaHasCantoresPK other = (MusicaHasCantoresPK) object;
        if (this.musicaIdMusica != other.musicaIdMusica) {
            return false;
        }
        if (this.cantoresIdCantores != other.cantoresIdCantores) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidade.MusicaHasCantoresPK[ musicaIdMusica=" + musicaIdMusica + ", cantoresIdCantores=" + cantoresIdCantores + " ]";
    }
    
}
