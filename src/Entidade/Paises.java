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
@Table(name = "paises", catalog = "gravadora_luizabasseto", schema = "")
@NamedQueries({
    @NamedQuery(name = "Paises.findAll", query = "SELECT p FROM Paises p"),
    @NamedQuery(name = "Paises.findByIdPaises", query = "SELECT p FROM Paises p WHERE p.idPaises = :idPaises"),
    @NamedQuery(name = "Paises.findByNomePaises", query = "SELECT p FROM Paises p WHERE p.nomePaises = :nomePaises")})
public class Paises implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_paises", nullable = false)
    private Integer idPaises;
    @Basic(optional = false)
    @Column(name = "nome_paises", nullable = false, length = 45)
    private String nomePaises;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "paisesIdPaises")
    private List<Musica> musicaList;

    public Paises() {
    }

    public Paises(Integer idPaises) {
        this.idPaises = idPaises;
    }

    public Paises(Integer idPaises, String nomePaises) {
        this.idPaises = idPaises;
        this.nomePaises = nomePaises;
    }

    public Integer getIdPaises() {
        return idPaises;
    }

    public void setIdPaises(Integer idPaises) {
        this.idPaises = idPaises;
    }

    public String getNomePaises() {
        return nomePaises;
    }

    public void setNomePaises(String nomePaises) {
        this.nomePaises = nomePaises;
    }

    public List<Musica> getMusicaList() {
        return musicaList;
    }

    public void setMusicaList(List<Musica> musicaList) {
        this.musicaList = musicaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPaises != null ? idPaises.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Paises)) {
            return false;
        }
        Paises other = (Paises) object;
        if ((this.idPaises == null && other.idPaises != null) || (this.idPaises != null && !this.idPaises.equals(other.idPaises))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return idPaises + ";" + nomePaises;
    }

}
