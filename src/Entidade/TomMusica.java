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
@Table(name = "tom_musica", catalog = "gravadora_luizabasseto", schema = "")
@NamedQueries({
    @NamedQuery(name = "TomMusica.findAll", query = "SELECT t FROM TomMusica t"),
    @NamedQuery(name = "TomMusica.findByIdTomMusica", query = "SELECT t FROM TomMusica t WHERE t.idTomMusica = :idTomMusica"),
    @NamedQuery(name = "TomMusica.findByNomeTom", query = "SELECT t FROM TomMusica t WHERE t.nomeTom = :nomeTom")})
public class TomMusica implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_tom_musica", nullable = false)
    private Integer idTomMusica;
    @Basic(optional = false)
    @Column(name = "nome_tom", nullable = false, length = 45)
    private String nomeTom;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tomMusica")
    private List<MusicaHasTomMusica> musicaHasTomMusicaList;

    public TomMusica() {
    }

    public TomMusica(Integer idTomMusica) {
        this.idTomMusica = idTomMusica;
    }

    public TomMusica(Integer idTomMusica, String nomeTom) {
        this.idTomMusica = idTomMusica;
        this.nomeTom = nomeTom;
    }

    public Integer getIdTomMusica() {
        return idTomMusica;
    }

    public void setIdTomMusica(Integer idTomMusica) {
        this.idTomMusica = idTomMusica;
    }

    public String getNomeTom() {
        return nomeTom;
    }

    public void setNomeTom(String nomeTom) {
        this.nomeTom = nomeTom;
    }

    public List<MusicaHasTomMusica> getMusicaHasTomMusicaList() {
        return musicaHasTomMusicaList;
    }

    public void setMusicaHasTomMusicaList(List<MusicaHasTomMusica> musicaHasTomMusicaList) {
        this.musicaHasTomMusicaList = musicaHasTomMusicaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTomMusica != null ? idTomMusica.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TomMusica)) {
            return false;
        }
        TomMusica other = (TomMusica) object;
        if ((this.idTomMusica == null && other.idTomMusica != null) || (this.idTomMusica != null && !this.idTomMusica.equals(other.idTomMusica))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return idTomMusica + ";" + nomeTom;
    }

}
