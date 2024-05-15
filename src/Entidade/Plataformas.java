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
@Table(name = "plataformas", catalog = "gravadora_luizabasseto", schema = "")
@NamedQueries({
    @NamedQuery(name = "Plataformas.findAll", query = "SELECT p FROM Plataformas p"),
    @NamedQuery(name = "Plataformas.findByIdPlataformas", query = "SELECT p FROM Plataformas p WHERE p.idPlataformas = :idPlataformas"),
    @NamedQuery(name = "Plataformas.findByNomePlataformas", query = "SELECT p FROM Plataformas p WHERE p.nomePlataformas = :nomePlataformas")})
public class Plataformas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_plataformas", nullable = false)
    private Integer idPlataformas;
    @Basic(optional = false)
    @Column(name = "nome_plataformas", nullable = false, length = 45)
    private String nomePlataformas;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "plataformas")
    private List<MusicaHasPlataformas> musicaHasPlataformasList;

    public Plataformas() {
    }

    public Plataformas(Integer idPlataformas) {
        this.idPlataformas = idPlataformas;
    }

    public Plataformas(Integer idPlataformas, String nomePlataformas) {
        this.idPlataformas = idPlataformas;
        this.nomePlataformas = nomePlataformas;
    }

    public Integer getIdPlataformas() {
        return idPlataformas;
    }

    public void setIdPlataformas(Integer idPlataformas) {
        this.idPlataformas = idPlataformas;
    }

    public String getNomePlataformas() {
        return nomePlataformas;
    }

    public void setNomePlataformas(String nomePlataformas) {
        this.nomePlataformas = nomePlataformas;
    }

    public List<MusicaHasPlataformas> getMusicaHasPlataformasList() {
        return musicaHasPlataformasList;
    }

    public void setMusicaHasPlataformasList(List<MusicaHasPlataformas> musicaHasPlataformasList) {
        this.musicaHasPlataformasList = musicaHasPlataformasList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPlataformas != null ? idPlataformas.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Plataformas)) {
            return false;
        }
        Plataformas other = (Plataformas) object;
        if ((this.idPlataformas == null && other.idPlataformas != null) || (this.idPlataformas != null && !this.idPlataformas.equals(other.idPlataformas))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return idPlataformas + ";" + nomePlataformas;
    }

}
