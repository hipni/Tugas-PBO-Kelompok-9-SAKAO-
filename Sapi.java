/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AplicationView;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author USER
 */
@Entity
@Table(name = "sapi", catalog = "sakao", schema = "")
@NamedQueries({
    @NamedQuery(name = "Sapi.findAll", query = "SELECT s FROM Sapi s"),
    @NamedQuery(name = "Sapi.findByJenisKelamin", query = "SELECT s FROM Sapi s WHERE s.jenisKelamin = :jenisKelamin"),
    @NamedQuery(name = "Sapi.findByBerat", query = "SELECT s FROM Sapi s WHERE s.berat = :berat"),
    @NamedQuery(name = "Sapi.findByHarga", query = "SELECT s FROM Sapi s WHERE s.harga = :harga")})
public class Sapi implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "Jenis Kelamin")
    private String jenisKelamin;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "Berat")
    private BigDecimal berat;
    @Column(name = "Harga")
    private BigInteger harga;

    public Sapi() {
    }

    public Sapi(BigDecimal berat) {
        this.berat = berat;
    }

    public Sapi(BigDecimal berat, String jenisKelamin) {
        this.berat = berat;
        this.jenisKelamin = jenisKelamin;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(String jenisKelamin) {
        String oldJenisKelamin = this.jenisKelamin;
        this.jenisKelamin = jenisKelamin;
        changeSupport.firePropertyChange("jenisKelamin", oldJenisKelamin, jenisKelamin);
    }

    public BigDecimal getBerat() {
        return berat;
    }

    public void setBerat(BigDecimal berat) {
        BigDecimal oldBerat = this.berat;
        this.berat = berat;
        changeSupport.firePropertyChange("berat", oldBerat, berat);
    }

    public BigInteger getHarga() {
        return harga;
    }

    public void setHarga(BigInteger harga) {
        BigInteger oldHarga = this.harga;
        this.harga = harga;
        changeSupport.firePropertyChange("harga", oldHarga, harga);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (berat != null ? berat.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sapi)) {
            return false;
        }
        Sapi other = (Sapi) object;
        if ((this.berat == null && other.berat != null) || (this.berat != null && !this.berat.equals(other.berat))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "AplicationView.Sapi[ berat=" + berat + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
