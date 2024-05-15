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
@Table(name = "cantores", catalog = "gravadora_luizabasseto", schema = "")
@NamedQueries({
    @NamedQuery(name = "Cantores.findAll", query = "SELECT c FROM Cantores c"),
    @NamedQuery(name = "Cantores.findByIdCantores", query = "SELECT c FROM Cantores c WHERE c.idCantores = :idCantores"),
    @NamedQuery(name = "Cantores.findByNomeCantores", query = "SELECT c FROM Cantores c WHERE c.nomeCantores = :nomeCantores")})
public class Cantores implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_cantores", nullable = false)
    private Integer idCantores;
    @Basic(optional = false)
    @Column(name = "nome_cantores", nullable = false, length = 45)
    private String nomeCantores;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cantores")
    private List<MusicaHasCantores> musicaHasCantoresList;

    public Cantores() {
    }

    public Cantores(Integer idCantores) {
        this.idCantores = idCantores;
    }

    public Cantores(Integer idCantores, String nomeCantores) {
        this.idCantores = idCantores;
        this.nomeCantores = nomeCantores;
    }

    public Integer getIdCantores() {
        return idCantores;
    }

    public void setIdCantores(Integer idCantores) {
        this.idCantores = idCantores;
    }

    public String getNomeCantores() {
        return nomeCantores;
    }

    public void setNomeCantores(String nomeCantores) {
        this.nomeCantores = nomeCantores;
    }

    public List<MusicaHasCantores> getMusicaHasCantoresList() {
        return musicaHasCantoresList;
    }

    public void setMusicaHasCantoresList(List<MusicaHasCantores> musicaHasCantoresList) {
        this.musicaHasCantoresList = musicaHasCantoresList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCantores != null ? idCantores.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cantores)) {
            return false;
        }
        Cantores other = (Cantores) object;
        if ((this.idCantores == null && other.idCantores != null) || (this.idCantores != null && !this.idCantores.equals(other.idCantores))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return idCantores + ";" + nomeCantores;
    }

}
