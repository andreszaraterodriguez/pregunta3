package mx.uv.t4is.SaludosBd;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Saludadores {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;

public Saludadores(){

}

public Saludadores(int id, String  nombre){
 this.id = id;
 this.nombre = nombre;
}

public int getId(){
    return this.id;
}
public void setId(int id){
    this.id = id;
}

public String getNombre(){
    return this.nombre;
}

public void setNonbre(String nombre){
    this.nombre = nombre;
}

}