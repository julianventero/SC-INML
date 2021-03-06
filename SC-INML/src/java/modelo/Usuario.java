/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author julia
 */
@Entity
@Table(name = "usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u")
    , @NamedQuery(name = "Usuario.findByCedula", query = "SELECT u FROM Usuario u WHERE u.cedula = :cedula")
    , @NamedQuery(name = "Usuario.findByNombre", query = "SELECT u FROM Usuario u WHERE u.nombre = :nombre")
    , @NamedQuery(name = "Usuario.findByApellido", query = "SELECT u FROM Usuario u WHERE u.apellido = :apellido")
    , @NamedQuery(name = "Usuario.findByContrase\u00f1a", query = "SELECT u FROM Usuario u WHERE u.contrase\u00f1a = :contrase\u00f1a")
    , @NamedQuery(name = "Usuario.findByFechaCreaci\u00f3n", query = "SELECT u FROM Usuario u WHERE u.fechaCreaci\u00f3n = :fechaCreaci\u00f3n")
    , @NamedQuery(name = "Usuario.findByUltimoAcceso", query = "SELECT u FROM Usuario u WHERE u.ultimoAcceso = :ultimoAcceso")
    , @NamedQuery(name = "Usuario.findByCorreo", query = "SELECT u FROM Usuario u WHERE u.correo = :correo")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cedula")
    private Integer cedula;
    @Size(max = 20)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 20)
    @Column(name = "apellido")
    private String apellido;
    @Size(max = 8)
    @Column(name = "contrasena")
    private String contraseña;
    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.DATE)
    private Date fechaCreación;
    @Column(name = "ultimo_acceso")
    @Temporal(TemporalType.DATE)
    private Date ultimoAcceso;
    @Size(max = 45)
    @Column(name = "correo")
    private String correo;
    @ManyToMany(mappedBy = "usuarioList")
    private List<Permisos> permisosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "uSUARIOcedula")
    private List<Grupo> grupoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "uSUARIOcedula")
    private List<Encuesta> encuestaList;
    @JoinColumn(name = "ESTADO_U_idESTADO", referencedColumnName = "idESTADO")
    @ManyToOne(optional = false)
    private EstadoU eSTADOUidESTADO;
    @JoinColumn(name = "GRUPO_idGRUPO", referencedColumnName = "idGRUPO")
    @ManyToOne(optional = false)
    private Grupo gRUPOidGRUPO;
    @JoinColumn(name = "ROL_idROL", referencedColumnName = "idROL")
    @ManyToOne(optional = false)
    private Rol rOLidROL;

    public Usuario() {
    }

    public Usuario(Integer cedula) {
        this.cedula = cedula;
    }

    public Integer getCedula() {
        return cedula;
    }

    public void setCedula(Integer cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public Date getFechaCreación() {
        return fechaCreación;
    }

    public void setFechaCreación(Date fechaCreación) {
        this.fechaCreación = fechaCreación;
    }

    public Date getUltimoAcceso() {
        return ultimoAcceso;
    }

    public void setUltimoAcceso(Date ultimoAcceso) {
        this.ultimoAcceso = ultimoAcceso;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @XmlTransient
    public List<Permisos> getPermisosList() {
        return permisosList;
    }

    public void setPermisosList(List<Permisos> permisosList) {
        this.permisosList = permisosList;
    }

    @XmlTransient
    public List<Grupo> getGrupoList() {
        return grupoList;
    }

    public void setGrupoList(List<Grupo> grupoList) {
        this.grupoList = grupoList;
    }

    @XmlTransient
    public List<Encuesta> getEncuestaList() {
        return encuestaList;
    }

    public void setEncuestaList(List<Encuesta> encuestaList) {
        this.encuestaList = encuestaList;
    }

    public EstadoU getESTADOUidESTADO() {
        return eSTADOUidESTADO;
    }

    public void setESTADOUidESTADO(EstadoU eSTADOUidESTADO) {
        this.eSTADOUidESTADO = eSTADOUidESTADO;
    }

    public Grupo getGRUPOidGRUPO() {
        return gRUPOidGRUPO;
    }

    public void setGRUPOidGRUPO(Grupo gRUPOidGRUPO) {
        this.gRUPOidGRUPO = gRUPOidGRUPO;
    }

    public Rol getROLidROL() {
        return rOLidROL;
    }

    public void setROLidROL(Rol rOLidROL) {
        this.rOLidROL = rOLidROL;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cedula != null ? cedula.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.cedula == null && other.cedula != null) || (this.cedula != null && !this.cedula.equals(other.cedula))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Usuario[ cedula=" + cedula + " ]";
    }
    
}
