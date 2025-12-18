/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Beans/Bean.java to edit this template
 */
package ceditor;

import java.awt.Font;
import java.awt.Color;
import java.io.Serializable;
import javax.swing.JTextField;

/**
 *
 * @author a24nicolasmpp
 */
public class TComponente extends JTextField implements Serializable {

    private int ancho;
    private Font fuente;
    private Color color;
    private Color fondo;

    public int getAncho() {
        return ancho;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
        this.setColumns(ancho);
    }

    public Font getFuente() {
        return fuente;
    }

    public void setFuente(Font fuente) {
        this.fuente = fuente;
        this.setFont(fuente);
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
        this.setForeground(color);
    }

    public Color getFondo() {
        return fondo;
    }

    public void setFondo(Color fondo) {
        this.fondo = fondo;
        this.setBackground(fondo);
    }

    public TComponente() {
    }
}
