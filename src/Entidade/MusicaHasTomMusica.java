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
@Table(name = "musica_has_tom_musica", catalog = "gravadora_luizabasseto", schema = "")
@NamedQueries({
    @NamedQuery(name = "MusicaHasTomMusica.findAll", query = "SELECT m FROM MusicaHasTomMusica m"),
    @NamedQuery(name = "MusicaHasTomMusica.findByMusicaIdMusica", query = "SELECT m FROM MusicaHasTomMusica m WHERE m.musicaHasTomMusicaPK.musicaIdMusica = :musicaIdMusica"),
    @NamedQuery(name = "MusicaHasTomMusica.findByTomMusicaIdTomMusica", query = "SELECT m FROM MusicaHasTomMusica m WHERE m.musicaHasTomMusicaPK.tomMusicaIdTomMusica = :tomMusicaIdTomMusica"),
    @NamedQuery(name = "MusicaHasTomMusica.findByStatus", query = "SELECT m FROM MusicaHasTomMusica m WHERE m.status = :status")})
public class MusicaHasTomMusica implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MusicaHasTomMusicaPK musicaHasTomMusicaPK;
    @Column(name = "status", length = 1)
    private String status;
    @JoinColumn(name = "musica_id_musica", referencedColumnName = "id_musica", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Musica musica;
    @JoinColumn(name = "tom_musica_id_tom_musica", referencedColumnName = "id_tom_musica", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private TomMusica tomMusica;

    public MusicaHasTomMusica() {
    }

    public MusicaHasTomMusica(MusicaHasTomMusicaPK musicaHasTomMusicaPK) {
        this.musicaHasTomMusicaPK = musicaHasTomMusicaPK;
    }

    public MusicaHasTomMusica(int musicaIdMusica, int tomMusicaIdTomMusica) {
        this.musicaHasTomMusicaPK = new MusicaHasTomMusicaPK(musicaIdMusica, tomMusicaIdTomMusica);
    }

    public MusicaHasTomMusicaPK getMusicaHasTomMusicaPK() {
        return musicaHasTomMusicaPK;
    }

    public void setMusicaHasTomMusicaPK(MusicaHasTomMusicaPK musicaHasTomMusicaPK) {
        this.musicaHasTomMusicaPK = musicaHasTomMusicaPK;
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

    public TomMusica getTomMusica() {
        return tomMusica;
    }

    public void setTomMusica(TomMusica tomMusica) {
        this.tomMusica = tomMusica;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (musicaHasTomMusicaPK != null ? musicaHasTomMusicaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MusicaHasTomMusica)) {
            return false;
        }
        MusicaHasTomMusica other = (MusicaHasTomMusica) object;
        if ((this.musicaHasTomMusicaPK == null && other.musicaHasTomMusicaPK != null) || (this.musicaHasTomMusicaPK != null && !this.musicaHasTomMusicaPK.equals(other.musicaHasTomMusicaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidade.MusicaHasTomMusica[ musicaHasTomMusicaPK=" + musicaHasTomMusicaPK + " ]";
    }
    
}
