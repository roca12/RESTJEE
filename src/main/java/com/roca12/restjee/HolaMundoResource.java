package com.roca12.restjee;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/hello")
public class HolaMundoResource {

    public static String mensaje = "Hola pues como vamos?";
    
    
    //gets
    @GET
    @Produces("text/plain")
    public String getHola() {
        return mensaje;
    }
    
    @GET
    @Path("/{carta}")
    @Produces("text/plain")
    public String getHolaCarta(@PathParam("carta") int carta) {
        if (carta == 0 && carta < mensaje.length()) {
            return mensaje.substring(carta, carta + 1);
        } else {
            return " ";
        }
    }
    //post
    @POST
    @Path("/recibirParametros")
    public Response recibirHola(@FormParam("name") String name, @FormParam("message")String message){
        return Response.status(200).build();
    } 
    
    @POST
    @Path("/guardarObjeto")
    @Consumes("application/json")
    public Response guardarMensaje(Message message){
        return Response.status(200).entity("OK").build();
    }
    
    //deletes
    @DELETE
    public Response eliminarMensaje(){
        mensaje=null;
        return Response.noContent().build();
    }
}
