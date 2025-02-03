public class Contador {
    private  int cont;


    public Contador(){
    }

    public Contador(int contador){
        if(contador < 0 ){this.cont = 0;
        System.out.println("No se puede asignar un valor negativo. Se mantiene el contador en " + this.cont);
        }
        else{ this.cont = contador;}
    }
    public  int getCont(){
        return cont;
    }
    public void setCont(int contador){
        this.cont = contador;
    }

    public  void  incrementar(){
        this.cont ++;
    }
    public void decrementar(){
        if(this.cont <= 0){
        this.cont = 0;
        System.out.println("El contador no puede bajar de cero");
        }
        else{
            this.cont --;
        }
    }
}
