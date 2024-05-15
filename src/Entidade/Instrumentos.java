/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidade;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author luiza
 */
@Entity
@Table(name = "instrumentos", catalog = "gravadora_luizabasseto", schema = "")
@NamedQueries({
    @NamedQuery(name = "Instrumentos.findAll", query = "SELECT i FROM Instrumentos i"),
    @NamedQuery(name = "Instrumentos.findByIdInstrumentos", query = "SELECT i FROM Instrumentos i WHERE i.idInstrumentos = :idInstrumentos"),
    @NamedQuery(name = "Instrumentos.findByNomeInstrumentos", query = "SELECT i FROM Instrumentos i WHERE i.nomeInstrumentos = :nomeInstrumentos")})
public class Instrumentos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_instrumentos", nullable = false)
    private Integer idInstrumentos;
    @Column(name = "nome_instrumentos", length = 45)
    private String nomeInstrumentos;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "instrumentos")
    private List<MusicaHasInstrumentos> musicaHasInstrumentosList;

    public Instrumentos() {
    }

    public Instrumentos(Integer idInstrumentos) {
        this.idInstrumentos = idInstrumentos;
    }

    public Integer getIdInstrumentos() {
        return idInstrumentos;
    }

    public void setIdInstrumentos(Integer idInstrumentos) {
        this.idInstrumentos = idInstrumentos;
    }

    public String getNomeInstrumentos() {
        return nomeInstrumentos;
    }

    public void setNomeInstrumentos(String nomeInstrumentos) {
        this.nomeInstrumentos = nomeInstrumentos;
    }

    public List<MusicaHasInstrumentos> getMusicaHasInstrumentosList() {
        return musicaHasInstrumentosList;
    }

    public void setMusicaHasInstrumentosList(List<MusicaHasInstrumentos> musicaHasInstrumentosList) {
        this.musicaHasInstrumentosList = musicaHasInstrumentosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idInstrumentos != null ? idInstrumentos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Instrumentos)) {
            return false;
        }
        Instrumentos other = (Instrumentos) object;
        if ((this.idInstrumentos == null && other.idInstrumentos != null) || (this.idInstrumentos != null && !this.idInstrumentos.equals(other.idInstrumentos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return idInstrumentos + ";" + nomeInstrumentos;
    }

}
