/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidade;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author luiza
 */
@Entity
@Table(name = "musica_has_cantores", catalog = "gravadora_luizabasseto", schema = "")
@NamedQueries({
    @NamedQuery(name = "MusicaHasCantores.findAll", query = "SELECT m FROM MusicaHasCantores m"),
    @NamedQuery(name = "MusicaHasCantores.findByMusicaIdMusica", query = "SELECT m FROM MusicaHasCantores m WHERE m.musicaHasCantoresPK.musicaIdMusica = :musicaIdMusica"),
    @NamedQuery(name = "MusicaHasCantores.findByCantoresIdCantores", query = "SELECT m FROM MusicaHasCantores m WHERE m.musicaHasCantoresPK.cantoresIdCantores = :cantoresIdCantores"),
    @NamedQuery(name = "MusicaHasCantores.findByStatus", query = "SELECT m FROM MusicaHasCantores m WHERE m.status = :status")})
public class MusicaHasCantores implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MusicaHasCantoresPK musicaHasCantoresPK;
    @Column(name = "status", length = 1)
    private String status;
    @JoinColumn(name = "cantores_id_cantores", referencedColumnName = "id_cantores", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Cantores cantores;
    @JoinColumn(name = "musica_id_musica", referencedColumnName = "id_musica", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Musica musica;

    public MusicaHasCantores() {
    }

    public MusicaHasCantores(MusicaHasCantoresPK musicaHasCantoresPK) {
        this.musicaHasCantoresPK = musicaHasCantoresPK;
    }

    public MusicaHasCantores(int musicaIdMusica, int cantoresIdCantores) {
        this.musicaHasCantoresPK = new MusicaHasCantoresPK(musicaIdMusica, cantoresIdCantores);
    }

    public MusicaHasCantoresPK getMusicaHasCantoresPK() {
        return musicaHasCantoresPK;
    }

    public void setMusicaHasCantoresPK(MusicaHasCantoresPK musicaHasCantoresPK) {
        this.musicaHasCantoresPK = musicaHasCantoresPK;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Cantores getCantores() {
        return cantores;
    }

    public void setCantores(Cantores cantores) {
        this.cantores = cantores;
    }

    public Musica getMusica() {
        return musica;
    }

    public void setMusica(Musica musica) {
        this.musica = musica;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (musicaHasCantoresPK != null ? musicaHasCantoresPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MusicaHasCantores)) {
            return false;
        }
        MusicaHasCantores other = (MusicaHasCantores) object;
        if ((this.musicaHasCantoresPK == null && other.musicaHasCantoresPK != null) || (this.musicaHasCantoresPK != null && !this.musicaHasCantoresPK.equals(other.musicaHasCantoresPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidade.MusicaHasCantores[ musicaHasCantoresPK=" + musicaHasCantoresPK + " ]";
    }
    
}
