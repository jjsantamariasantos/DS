package e2;

public abstract class Objetos {
    private String nombre;

    public Objetos(String nombre)throws IllegalArgumentException{
        if(nombre != null){
            this.nombre = nombre;
        }else {
            throw new IllegalArgumentException("No se cumplen las condiciones");
        }

    }
    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
}
