/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

/**
 *
 * @author Estudiante
 */
public class Tarjeta {
    private long numeroTarjeta;
    private int mesVencimiento;
    private int anoVencimiento;
    private int codigoSeguridad;
    private ETipoTarjeta tipoTarjeta;

    public Tarjeta(long numeroTarjeta, int mesVencimiento, int anoVencimiento, int codigoSeguridad, ETipoTarjeta tipoTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
        this.mesVencimiento = mesVencimiento;
        this.anoVencimiento = anoVencimiento;
        this.codigoSeguridad = codigoSeguridad;
        this.tipoTarjeta = tipoTarjeta;
    }

    public long getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public int getMesVencimiento() {
        return mesVencimiento;
    }

    public int getAnoVencimiento() {
        return anoVencimiento;
    }

    public int getCodigoSeguridad() {
        return codigoSeguridad;
    }

    public ETipoTarjeta getTipoTarjeta() {
        return tipoTarjeta;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nnumeroTarjeta=").append(numeroTarjeta);
        sb.append("\nmesVencimiento=").append(mesVencimiento);
        sb.append("\nanoVencimiento=").append(anoVencimiento);
        sb.append("\ncodigoSeguridad=").append(codigoSeguridad);
        sb.append("\ntipoTarjeta=").append(tipoTarjeta);
        return sb.toString();
    }
    
    
    
}
