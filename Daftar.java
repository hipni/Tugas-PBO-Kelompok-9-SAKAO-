/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AplicationView;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
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
@Table(name = "daftar", catalog = "sakao", schema = "")
@NamedQueries({
    @NamedQuery(name = "Daftar.findAll", query = "SELECT d FROM Daftar d"),
    @NamedQuery(name = "Daftar.findByNamaLengkap", query = "SELECT d FROM Daftar d WHERE d.namaLengkap = :namaLengkap"),
    @NamedQuery(name = "Daftar.findByEmail1", query = "SELECT d FROM Daftar d WHERE d.email1 = :email1"),
    @NamedQuery(name = "Daftar.findByNik", query = "SELECT d FROM Daftar d WHERE d.nik = :nik"),
    @NamedQuery(name = "Daftar.findByAlamat", query = "SELECT d FROM Daftar d WHERE d.alamat = :alamat"),
    @NamedQuery(name = "Daftar.findByPassword1", query = "SELECT d FROM Daftar d WHERE d.password1 = :password1"),
    @NamedQuery(name = "Daftar.findByConfirmPassword", query = "SELECT d FROM Daftar d WHERE d.confirmPassword = :confirmPassword")})
public class Daftar implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "Nama Lengkap")
    private String namaLengkap;
    @Id
    @Basic(optional = false)
    @Column(name = "Email 1")
    private String email1;
    @Basic(optional = false)
    @Column(name = "NIK")
    private String nik;
    @Basic(optional = false)
    @Column(name = "Alamat")
    private String alamat;
    @Basic(optional = false)
    @Column(name = "Password 1")
    private String password1;
    @Basic(optional = false)
    @Column(name = "Confirm Password")
    private int confirmPassword;

    public Daftar() {
    }

    public Daftar(String email1) {
        this.email1 = email1;
    }

    public Daftar(String email1, String namaLengkap, String nik, String alamat, String password1, int confirmPassword) {
        this.email1 = email1;
        this.namaLengkap = namaLengkap;
        this.nik = nik;
        this.alamat = alamat;
        this.password1 = password1;
        this.confirmPassword = confirmPassword;
    }

    public String getNamaLengkap() {
        return namaLengkap;
    }

    public void setNamaLengkap(String namaLengkap) {
        String oldNamaLengkap = this.namaLengkap;
        this.namaLengkap = namaLengkap;
        changeSupport.firePropertyChange("namaLengkap", oldNamaLengkap, namaLengkap);
    }

    public String getEmail1() {
        return email1;
    }

    public void setEmail1(String email1) {
        String oldEmail1 = this.email1;
        this.email1 = email1;
        changeSupport.firePropertyChange("email1", oldEmail1, email1);
    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        String oldNik = this.nik;
        this.nik = nik;
        changeSupport.firePropertyChange("nik", oldNik, nik);
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        String oldAlamat = this.alamat;
        this.alamat = alamat;
        changeSupport.firePropertyChange("alamat", oldAlamat, alamat);
    }

    public String getPassword1() {
        return password1;
    }

    public void setPassword1(String password1) {
        String oldPassword1 = this.password1;
        this.password1 = password1;
        changeSupport.firePropertyChange("password1", oldPassword1, password1);
    }

    public int getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(int confirmPassword) {
        int oldConfirmPassword = this.confirmPassword;
        this.confirmPassword = confirmPassword;
        changeSupport.firePropertyChange("confirmPassword", oldConfirmPassword, confirmPassword);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (email1 != null ? email1.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Daftar)) {
            return false;
        }
        Daftar other = (Daftar) object;
        if ((this.email1 == null && other.email1 != null) || (this.email1 != null && !this.email1.equals(other.email1))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "AplicationView.Daftar[ email1=" + email1 + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
