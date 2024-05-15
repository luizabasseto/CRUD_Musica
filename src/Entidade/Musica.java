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
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author luiza
 */
@Entity
@Table(name = "musica", catalog = "gravadora_luizabasseto", schema = "")
@NamedQueries({
    @NamedQuery(name = "Musica.findAll", query = "SELECT m FROM Musica m"),
    @NamedQuery(name = "Musica.findByIdMusica", query = "SELECT m FROM Musica m WHERE m.idMusica = :idMusica"),
    @NamedQuery(name = "Musica.findByNomeMusica", query = "SELECT m FROM Musica m WHERE m.nomeMusica = :nomeMusica"),
    @NamedQuery(name = "Musica.findByLocalSom", query = "SELECT m FROM Musica m WHERE m.localSom = :localSom")})
public class Musica implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_musica", nullable = false)
    private Integer idMusica;
    @Basic(optional = false)
    @Column(name = "nome_musica", nullable = false, length = 45)
    private String nomeMusica;
    @Lob
    @Column(name = "SOM")
    private byte[] som;
    @Column(name = "local_Som", length = 1000)
    private String localSom;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "musica")
    private List<MusicaHasInstrumentos> musicaHasInstrumentosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "musica")
    private List<MusicaHasPlataformas> musicaHasPlataformasList;
    @JoinColumn(name = "paises_id_paises", referencedColumnName = "id_paises", nullable = false)
    @ManyToOne(optional = false)
    private Paises paisesIdPaises;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "musica")
    private List<MusicaHasGenero> musicaHasGeneroList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "musica")
    private List<MusicaHasCantores> musicaHasCantoresList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "musica")
    private List<MusicaHasTomMusica> musicaHasTomMusicaList;

    public Musica() {
    }

    public Musica(Integer idMusica) {
        this.idMusica = idMusica;
    }

    public Musica(Integer idMusica, String nomeMusica) {
        this.idMusica = idMusica;
        this.nomeMusica = nomeMusica;
    }

    public Integer getIdMusica() {
        return idMusica;
    }

    public void setIdMusica(Integer idMusica) {
        this.idMusica = idMusica;
    }

    public String getNomeMusica() {
        return nomeMusica;
    }

    public void setNomeMusica(String nomeMusica) {
        this.nomeMusica = nomeMusica;
    }

    public byte[] getSom() {
        return som;
    }

    public void setSom(byte[] som) {
        this.som = som;
    }

    public String getLocalSom() {
        return localSom;
    }

    public void setLocalSom(String localSom) {
        this.localSom = localSom;
    }

    public List<MusicaHasInstrumentos> getMusicaHasInstrumentosList() {
        return musicaHasInstrumentosList;
    }

    public void setMusicaHasInstrumentosList(List<MusicaHasInstrumentos> musicaHasInstrumentosList) {
        this.musicaHasInstrumentosList = musicaHasInstrumentosList;
    }

    public List<MusicaHasPlataformas> getMusicaHasPlataformasList() {
        return musicaHasPlataformasList;
    }

    public void setMusicaHasPlataformasList(List<MusicaHasPlataformas> musicaHasPlataformasList) {
        this.musicaHasPlataformasList = musicaHasPlataformasList;
    }

    public Paises getPaisesIdPaises() {
        return paisesIdPaises;
    }

    public void setPaisesIdPaises(Paises paisesIdPaises) {
        this.paisesIdPaises = paisesIdPaises;
    }

    public List<MusicaHasGenero> getMusicaHasGeneroList() {
        return musicaHasGeneroList;
    }

    public void setMusicaHasGeneroList(List<MusicaHasGenero> musicaHasGeneroList) {
        this.musicaHasGeneroList = musicaHasGeneroList;
    }

    public List<MusicaHasCantores> getMusicaHasCantoresList() {
        return musicaHasCantoresList;
    }

    public void setMusicaHasCantoresList(List<MusicaHasCantores> musicaHasCantoresList) {
        this.musicaHasCantoresList = musicaHasCantoresList;
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
        hash += (idMusica != null ? idMusica.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Musica)) {
            return false;
        }
        Musica other = (Musica) object;
        if ((this.idMusica == null && other.idMusica != null) || (this.idMusica != null && !this.idMusica.equals(other.idMusica))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return idMusica + ";" + nomeMusica;
    }

}
