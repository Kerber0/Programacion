/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Beans/Bean.java to edit this template
 */
package temporizador;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.EventListener;
import java.io.Serializable;
import javax.swing.JLabel;


/**
 *
 * @author a24nicolasmpp
 */
public class TemporizadorBean extends JLabel implements Serializable, ActionListener{
   
    private transient javax.swing.Timer t;
    private int tiempo;
    
    public TemporizadorBean() {
        tiempo = 10; 
        t = new javax.swing.Timer(1000, this); 
        setText(Integer.toString(tiempo)); 
        setActivo(true); 
    }
    
    private int getTiempo(){
        return tiempo;
    }
    
    public void setTiempo(int tiempo){
        this.tiempo = tiempo;
        setText(Integer.toString(tiempo));
        repaint();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        setText(Integer.toString(tiempo));
        repaint();
        if (tiempo == 0) {
            setActivo(false);
            System.out.println("Temporizador finalizado");
            lanzarFinCuentaAtras();
        }
        tiempo--;
    }

    
    public final void setActivo(boolean valor) {
        if (valor)
            t.start();
        else
            t.stop();
        }

    public boolean getActivo() {
        return t.isRunning();
    }
    
    public interface FinCuentaAtrasListener extends EventListener {
        public void capturarFinCuentaAtras(FinCuentaAtrasEvent ev);
    }

    private FinCuentaAtrasListener receptor;
    
    public void addFinCuentaAtrasListener(FinCuentaAtrasListener r) {
        this.receptor = r;
    }
    public void removeFinCuentaAtrasListener(FinCuentaAtrasListener r){
        this.receptor = null;
    }
    
    private void lanzarFinCuentaAtras() {
        if (receptor != null) {
            receptor.capturarFinCuentaAtras(
                new FinCuentaAtrasEvent(this)
            );
        }
}
    
    public void reiniciar() {
    t.stop();         
    tiempo = 10;       
    setText(Integer.toString(tiempo));
    repaint();
    t.start();      
}

    
}
