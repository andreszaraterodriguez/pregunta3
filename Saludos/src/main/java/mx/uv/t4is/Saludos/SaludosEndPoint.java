package mx.uv.t4is.Saludos;

import java.util.ArrayList;
//import java.util.List;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import https.t4is_uv_mx.saludos.BorraSaludoRequest;
import https.t4is_uv_mx.saludos.BorraSaludoResponse;
//import https.t4is_uv_mx.saludos.BorraSaludoResponse;
import https.t4is_uv_mx.saludos.BuscarSaludosResponse;
import https.t4is_uv_mx.saludos.ModificaSaludosRequest;
import https.t4is_uv_mx.saludos.ModificaSaludosResponse;
import https.t4is_uv_mx.saludos.SaludarRequest;
import https.t4is_uv_mx.saludos.SaludarResponse;
import https.t4is_uv_mx.saludos.BuscarSaludosResponse.Saludos;



@Endpoint
public class SaludosEndPoint {
    /*int contadorId = 1;
  //  List<Saludo> saludos = new ArrayList<>();
    List<BuscarSaludosResponse.Saludos> saludos = new ArrayList<>();

    @PayloadRoot(localPart = "SaludarRequest",namespace = "https://t4is.uv.mx/saludos")
    @ResponsePayload
    public SaludarResponse Saludar(@RequestPayload SaludarRequest peticion) {
        SaludarResponse respuesta = new SaludarResponse();
        respuesta.setRespuesta("Hola "+peticion.getNombre());
        //Saludo saludo = new Saludo();
        BuscarSaludosResponse.Saludos saludo = new BuscarSaludosResponse.Saludos();
        saludo.setNombre(peticion.getNombre());
        saludo.setId(contadorId);
        saludos.add(saludo);
        contadorId ++;

        return respuesta;
    }*/

    ArrayList<Saludos> lista = new ArrayList<>();
	private int i = 1;

    @PayloadRoot(localPart = "SaludarRequest",namespace = "https://t4is.uv.mx/saludos")
	@ResponsePayload
	public SaludarResponse Saludar (@RequestPayload SaludarRequest peticion){
		SaludarResponse respuesta = new SaludarResponse();
		respuesta.setRespuesta("Hola "+peticion.getNombre());
        //se agrega a la lista 
		Saludos e = new Saludos();
		e.setId(i++);
		e.setNombre(peticion.getNombre());
		lista.add(e);
		return respuesta;
		
	}
		
	

    
   /* @PayloadRoot(localPart = "BuscarSaludosRequest", namespace = "https://t4is.uv.mx/saludos")
    @ResponsePayload
    public BuscarSaludosResponse buscarSaludos(){
        BuscarSaludosResponse respuesta = new BuscarSaludosResponse();
        for (BuscarSaludosResponse.Saludos saludo : saludos){
         /*   BuscarSaludosResponse.Saludos saludosBuscar = new BuscarSaludosResponse.Saludos();
            saludosBuscar.setId(saludo.getId());
            saludosBuscar.setNombre(saludo.getNombre());
            respuesta.getSaludos().add(saludosBuscar);*
            respuesta.getSaludos().add(saludo);

        }
     
        return respuesta;
    }*/
    
    
     @PayloadRoot(localPart = "BuscarSaludoRequest", namespace = "https://t4is.uv.mx/saludos")
	@ResponsePayload
	public BuscarSaludosResponse buscar(){
		BuscarSaludosResponse respuesta = new BuscarSaludosResponse();
		for(Saludos o : lista){
			/*
            System.out.println
            System.out.println(o);
			Saludos e = new Saludos();
            e.setNombre(o.getNombre());
			e.setNombre(s);*/
			respuesta.getSaludos().add(o);
		}
		return respuesta;
	}

   /* @PayloadRoot(localPart = "BuscarSaludoRequest", namespace = "https://t4is.uv.mx/saludos")
    @ResponsePayload
    public ModificaSaludosResponse modif(@RequestPayload ModificaSaludosRequest peticion){
        ModificaSaludosResponse respuesta = new ModificaSaludosResponse();
        BuscarSaludosResponse.Saludos saludo = new BuscarSaludosResponse.Saludos();
        //Saludos saludo = new Saludos();
        saludo.setNombre(peticion.getNombre());
        saludo.setId(peticion.getId()-1);
        saludos.add(saludo);
        BuscarSaludosResponse+
		
        return respuesta;
    }*/
    @PayloadRoot(localPart = "BuscarSaludoRequest", namespace = "https://t4is.uv.mx/saludos")
	@ResponsePayload
	public ModificaSaludosResponse modificaSaludo(@RequestPayload ModificaSaludosRequest peticion){
		ModificaSaludosResponse respuesta = new ModificaSaludosResponse();
        //modifica lista
		Saludos e = new Saludos();
		e.setNombre(peticion.getNombre());
		e.setId(peticion.getId());
		lista.set(peticion.getId()-1, e);
		respuesta.setRespuesta(true);
		return respuesta;
	}
   @PayloadRoot(localPart = "BorraSaludoRequest", namespace = "https://t4is.uv.mx/saludos")
   public BorraSaludoResponse borrarSaludo(@RequestPayload BorraSaludoRequest peticion){
       BorraSaludoResponse respuesta = new BorraSaludoResponse();
       for (Saludos o : lista){
           if (o.getId()== peticion.getId());
           lista.remove(o);
           break;
       }

       
       respuesta.setRespuesta(true);
       

    return respuesta;
   }
   
    
}


