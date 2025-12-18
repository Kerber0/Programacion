/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Beans/Bean.java to edit this template
 */
package ceditor;

import java.awt.Color;
import java.awt.Font;
import java.io.Serializable;
import javax.swing.JTextField;

public class TCompEManual extends JTextField implements Serializable {

    private int ancho;
    private Font fuente;
    private Color fondo;
    private Color color;

    public int getAncho() {
        return ancho;
    }

    public Font getFuente() {
        return fuente;
    }

    public Color getFondo() {
        return fondo;
    }

    public Color getColor() {
        return color;
    }

    public void setFondo(Color fondo) {
        this.fondo = fondo;
        this.setBackground(fondo);
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
        this.setColumns(ancho);
    }

    public void setFuente(Font fuente) {
        this.fuente = fuente;
        this.setFont(fuente);
    }

    public void setColor(Color color) {
        this.color = color;
        this.setForeground(color);
    }

    public TCompEManual() {
    }
}
