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
@Table(name = "genero", catalog = "gravadora_luizabasseto", schema = "")
@NamedQueries({
    @NamedQuery(name = "Genero.findAll", query = "SELECT g FROM Genero g"),
    @NamedQuery(name = "Genero.findByIdGenero", query = "SELECT g FROM Genero g WHERE g.idGenero = :idGenero"),
    @NamedQuery(name = "Genero.findByNomeGenero", query = "SELECT g FROM Genero g WHERE g.nomeGenero = :nomeGenero")})
public class Genero implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_genero", nullable = false)
    private Integer idGenero;
    @Basic(optional = false)
    @Column(name = "nome_genero", nullable = false, length = 45)
    private String nomeGenero;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "genero")
    private List<MusicaHasGenero> musicaHasGeneroList;

    public Genero() {
    }

    public Genero(Integer idGenero) {
        this.idGenero = idGenero;
    }

    public Genero(Integer idGenero, String nomeGenero) {
        this.idGenero = idGenero;
        this.nomeGenero = nomeGenero;
    }

    public Integer getIdGenero() {
        return idGenero;
    }

    public void setIdGenero(Integer idGenero) {
        this.idGenero = idGenero;
    }

    public String getNomeGenero() {
        return nomeGenero;
    }

    public void setNomeGenero(String nomeGenero) {
        this.nomeGenero = nomeGenero;
    }

    public List<MusicaHasGenero> getMusicaHasGeneroList() {
        return musicaHasGeneroList;
    }

    public void setMusicaHasGeneroList(List<MusicaHasGenero> musicaHasGeneroList) {
        this.musicaHasGeneroList = musicaHasGeneroList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idGenero != null ? idGenero.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Genero)) {
            return false;
        }
        Genero other = (Genero) object;
        if ((this.idGenero == null && other.idGenero != null) || (this.idGenero != null && !this.idGenero.equals(other.idGenero))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return idGenero + ";" + nomeGenero;
    }

}
