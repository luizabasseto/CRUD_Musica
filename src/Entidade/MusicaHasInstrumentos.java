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
@Table(name = "musica_has_instrumentos", catalog = "gravadora_luizabasseto", schema = "")
@NamedQueries({
    @NamedQuery(name = "MusicaHasInstrumentos.findAll", query = "SELECT m FROM MusicaHasInstrumentos m"),
    @NamedQuery(name = "MusicaHasInstrumentos.findByMusicaIdMusica", query = "SELECT m FROM MusicaHasInstrumentos m WHERE m.musicaHasInstrumentosPK.musicaIdMusica = :musicaIdMusica"),
    @NamedQuery(name = "MusicaHasInstrumentos.findByInstrumentosIdInstrumentos", query = "SELECT m FROM MusicaHasInstrumentos m WHERE m.musicaHasInstrumentosPK.instrumentosIdInstrumentos = :instrumentosIdInstrumentos"),
    @NamedQuery(name = "MusicaHasInstrumentos.findByStatus", query = "SELECT m FROM MusicaHasInstrumentos m WHERE m.status = :status")})
public class MusicaHasInstrumentos implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MusicaHasInstrumentosPK musicaHasInstrumentosPK;
    @Column(name = "status", length = 1)
    private String status;
    @JoinColumn(name = "instrumentos_id_instrumentos", referencedColumnName = "id_instrumentos", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Instrumentos instrumentos;
    @JoinColumn(name = "musica_id_musica", referencedColumnName = "id_musica", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Musica musica;

    public MusicaHasInstrumentos() {
    }

    public MusicaHasInstrumentos(MusicaHasInstrumentosPK musicaHasInstrumentosPK) {
        this.musicaHasInstrumentosPK = musicaHasInstrumentosPK;
    }

    public MusicaHasInstrumentos(int musicaIdMusica, int instrumentosIdInstrumentos) {
        this.musicaHasInstrumentosPK = new MusicaHasInstrumentosPK(musicaIdMusica, instrumentosIdInstrumentos);
    }

    public MusicaHasInstrumentosPK getMusicaHasInstrumentosPK() {
        return musicaHasInstrumentosPK;
    }

    public void setMusicaHasInstrumentosPK(MusicaHasInstrumentosPK musicaHasInstrumentosPK) {
        this.musicaHasInstrumentosPK = musicaHasInstrumentosPK;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Instrumentos getInstrumentos() {
        return instrumentos;
    }

    public void setInstrumentos(Instrumentos instrumentos) {
        this.instrumentos = instrumentos;
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
        hash += (musicaHasInstrumentosPK != null ? musicaHasInstrumentosPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MusicaHasInstrumentos)) {
            return false;
        }
        MusicaHasInstrumentos other = (MusicaHasInstrumentos) object;
        if ((this.musicaHasInstrumentosPK == null && other.musicaHasInstrumentosPK != null) || (this.musicaHasInstrumentosPK != null && !this.musicaHasInstrumentosPK.equals(other.musicaHasInstrumentosPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidade.MusicaHasInstrumentos[ musicaHasInstrumentosPK=" + musicaHasInstrumentosPK + " ]";
    }
    
}
