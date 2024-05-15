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
@Table(name = "musica_has_plataformas", catalog = "gravadora_luizabasseto", schema = "")
@NamedQueries({
    @NamedQuery(name = "MusicaHasPlataformas.findAll", query = "SELECT m FROM MusicaHasPlataformas m"),
    @NamedQuery(name = "MusicaHasPlataformas.findByMusicaIdMusica", query = "SELECT m FROM MusicaHasPlataformas m WHERE m.musicaHasPlataformasPK.musicaIdMusica = :musicaIdMusica"),
    @NamedQuery(name = "MusicaHasPlataformas.findByPlataformasIdPlataformas", query = "SELECT m FROM MusicaHasPlataformas m WHERE m.musicaHasPlataformasPK.plataformasIdPlataformas = :plataformasIdPlataformas"),
    @NamedQuery(name = "MusicaHasPlataformas.findByStatus", query = "SELECT m FROM MusicaHasPlataformas m WHERE m.status = :status")})
public class MusicaHasPlataformas implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MusicaHasPlataformasPK musicaHasPlataformasPK;
    @Column(name = "status", length = 1)
    private String status;
    @JoinColumn(name = "musica_id_musica", referencedColumnName = "id_musica", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Musica musica;
    @JoinColumn(name = "plataformas_id_plataformas", referencedColumnName = "id_plataformas", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Plataformas plataformas;

    public MusicaHasPlataformas() {
    }

    public MusicaHasPlataformas(MusicaHasPlataformasPK musicaHasPlataformasPK) {
        this.musicaHasPlataformasPK = musicaHasPlataformasPK;
    }

    public MusicaHasPlataformas(int musicaIdMusica, int plataformasIdPlataformas) {
        this.musicaHasPlataformasPK = new MusicaHasPlataformasPK(musicaIdMusica, plataformasIdPlataformas);
    }

    public MusicaHasPlataformasPK getMusicaHasPlataformasPK() {
        return musicaHasPlataformasPK;
    }

    public void setMusicaHasPlataformasPK(MusicaHasPlataformasPK musicaHasPlataformasPK) {
        this.musicaHasPlataformasPK = musicaHasPlataformasPK;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Musica getMusica() {
        return musica;
    }

    public void setMusica(Musica musica) {
        this.musica = musica;
    }

    public Plataformas getPlataformas() {
        return plataformas;
    }

    public void setPlataformas(Plataformas plataformas) {
        this.plataformas = plataformas;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (musicaHasPlataformasPK != null ? musicaHasPlataformasPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MusicaHasPlataformas)) {
            return false;
        }
        MusicaHasPlataformas other = (MusicaHasPlataformas) object;
        if ((this.musicaHasPlataformasPK == null && other.musicaHasPlataformasPK != null) || (this.musicaHasPlataformasPK != null && !this.musicaHasPlataformasPK.equals(other.musicaHasPlataformasPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidade.MusicaHasPlataformas[ musicaHasPlataformasPK=" + musicaHasPlataformasPK + " ]";
    }
    
}
