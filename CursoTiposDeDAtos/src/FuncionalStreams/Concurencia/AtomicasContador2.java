package FuncionalStreams.Concurencia;

public  class AtomicasContador2 {
    private Integer total= 0;

    public synchronized void agregar(Integer valor){
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        total += valor;
    }
    public synchronized void restar(Integer valor){
        total += valor;
    }
    public synchronized Integer get(){
        return  total;
    }
}
