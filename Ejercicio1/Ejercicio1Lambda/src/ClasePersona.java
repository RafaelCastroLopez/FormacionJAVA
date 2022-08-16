 import java.util.List;

public class ClasePersona {
    private String Nombre;
    private String Poblacion;
    private Integer Edad;

    public void setNombre(String nombre){
        this.Nombre = nombre;
    }

    public void setPoblacion(String poblacion){
        this.Poblacion = poblacion;
    }

    public void setEdad(Integer edad){
        this.Edad = edad;
    }

    public String getNombre(){
        return this.Nombre;
    }

    public String getPoblacion(){
        return this.Poblacion;
    }

    public Integer getEdad(){
        return this.Edad;
    }

}
