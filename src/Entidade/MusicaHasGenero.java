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
@Table(name = "musica_has_genero", catalog = "gravadora_luizabasseto", schema = "")
@NamedQueries({
    @NamedQuery(name = "MusicaHasGenero.findAll", query = "SELECT m FROM MusicaHasGenero m"),
    @NamedQuery(name = "MusicaHasGenero.findByMusicaIdMusica", query = "SELECT m FROM MusicaHasGenero m WHERE m.musicaHasGeneroPK.musicaIdMusica = :musicaIdMusica"),
    @NamedQuery(name = "MusicaHasGenero.findByGeneroIdGenero", query = "SELECT m FROM MusicaHasGenero m WHERE m.musicaHasGeneroPK.generoIdGenero = :generoIdGenero"),
    @NamedQuery(name = "MusicaHasGenero.findByStatus", query = "SELECT m FROM MusicaHasGenero m WHERE m.status = :status")})
public class MusicaHasGenero implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MusicaHasGeneroPK musicaHasGeneroPK;
    @Column(name = "status", length = 1)
    private String status;
    @JoinColumn(name = "genero_id_genero", referencedColumnName = "id_genero", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Genero genero;
    @JoinColumn(name = "musica_id_musica", referencedColumnName = "id_musica", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Musica musica;

    public MusicaHasGenero() {
    }

    public MusicaHasGenero(MusicaHasGeneroPK musicaHasGeneroPK) {
        this.musicaHasGeneroPK = musicaHasGeneroPK;
    }

    public MusicaHasGenero(int musicaIdMusica, int generoIdGenero) {
        this.musicaHasGeneroPK = new MusicaHasGeneroPK(musicaIdMusica, generoIdGenero);
    }

    public MusicaHasGeneroPK getMusicaHasGeneroPK() {
        return musicaHasGeneroPK;
    }

    public void setMusicaHasGeneroPK(MusicaHasGeneroPK musicaHasGeneroPK) {
        this.musicaHasGeneroPK = musicaHasGeneroPK;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
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
        hash += (musicaHasGeneroPK != null ? musicaHasGeneroPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MusicaHasGenero)) {
            return false;
        }
        MusicaHasGenero other = (MusicaHasGenero) object;
        if ((this.musicaHasGeneroPK == null && other.musicaHasGeneroPK != null) || (this.musicaHasGeneroPK != null && !this.musicaHasGeneroPK.equals(other.musicaHasGeneroPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidade.MusicaHasGenero[ musicaHasGeneroPK=" + musicaHasGeneroPK + " ]";
    }
    
}
