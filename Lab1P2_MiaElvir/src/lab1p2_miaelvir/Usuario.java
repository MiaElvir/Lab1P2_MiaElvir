
package lab1p2_miaelvir;

import java.util.Date;

public class Usuario {
    
    String nombre; 
    String Apellido; 
    Date fechaDeNacimiento; 
    String correoElectronico; 
    String contraseña; 

    public Usuario(String nombre, String Apellido, Date fechaDeNacimiento, String correoElectronico, String contraseña) {
        this.nombre = nombre;
        this.Apellido = Apellido;
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.correoElectronico = correoElectronico;
        this.contraseña = contraseña;
    }

    public Usuario() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public Date getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public void setFechaDeNacimiento(Date fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + "| Apellido: " + Apellido + "| Fecha De Nacimiento: " + fechaDeNacimiento + "| Correo Electronico: "
                + "" + correoElectronico + "| contrase\u00f1a: " + contraseña;
    }
    
    
    
    
}
