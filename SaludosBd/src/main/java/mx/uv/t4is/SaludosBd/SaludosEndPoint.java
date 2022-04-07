package mx.uv.t4is.SaludosBd;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import https.t4is_uv_mx.saludos.BorraSaludoRequest;
import https.t4is_uv_mx.saludos.BorraSaludoResponse;
import https.t4is_uv_mx.saludos.BuscarSaludosResponse;
import https.t4is_uv_mx.saludos.ModificaSaludoRequest;
import https.t4is_uv_mx.saludos.ModificaSaludoResponse;
import https.t4is_uv_mx.saludos.SaludarRequest;
import https.t4is_uv_mx.saludos.SaludarResponse;
import https.t4is_uv_mx.saludos.BuscarSaludosResponse.Saludos;

public class SaludosEndPoint {
    ArrayList<Saludos> lista = new ArrayList<>();
    private int i=1;
    //@
    //Isaludadores isaludadores;

    @PayloadRoot(localPart = "SaludarRequest", namespace = "https://t4is.uv.mx/saludos")
    @ResponsePayload
    public SaludarResponse Saludar(@RequestBody SaludarRequest peticion){
        SaludarResponse respuesta = new SaludarResponse();
        respuesta.setRespuesta("Hola"+peticion.getNombre());
        Saludos e = new Saludos();
        e.setNombre(peticion.getNombre());
        e.setId(i++); //
        lista.add(e); //
        //isaludadores.save(e);
        return respuesta;
    }
    @PayloadRoot(localPart = "BuscarSaludosRequest", namespace = "https://t4is.uv.mx/saludos")
    @ResponsePayload
    public BuscarSaludosResponse buscarSaludos(){
        BuscarSaludosResponse respuesta = new BuscarSaludosResponse();
        //Iterable<Saludadores> lista = isaludadores.findAll();
        for(Saludos o : lista){
            //BuscarSaludosResponse.Saludos e = new BuscarSaludosResponse.Saludos();
            //e.setNombre(o.getNombre());
            //e.setId(o.getId());
            //respuesta.getSaludos().add(e);
            respuesta.getSaludos().add(o);
     
        }
        return respuesta;
    }
    @PayloadRoot(localPart = "ModificaSaludoRequest", namespace = "https://t4is.uv.mx/saludos")
    @ResponsePayload
    public ModificaSaludoResponse moificarSaludo(@RequestPayload ModificaSaludoRequest peticion){
        ModificaSaludoResponse respuesta = new ModificaSaludoResponse();
        //isaludadores.save
        Saludos e = new Saludos();
        e.setId(peticion.getId());
        e.setNombre(peticion.getNombre());
        lista.set(peticion.getId(), e);//
        respuesta.setRespuesta(true);
        return respuesta;
    }
    @PayloadRoot(localPart = "BorraSaludoRequest", namespace = "https://t4is.uv.mx/saludos")
    @ResponsePayload
    public BorraSaludoResponse modificar(@RequestPayload BorraSaludoRequest peticion){
		BorraSaludoResponse respuesta = new BorraSaludoResponse();
		Saludos e = new Saludos();
		e.setId(peticion.getId());
		lista.remove(peticion.getId()-1);
		respuesta.setRespuesta(true);
		
		return respuesta;
}

}
