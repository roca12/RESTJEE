package com.roca12.restjee;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@Path("info")
public class InfoResource {

    @GET
    @Path("/lainfo")
    @Produces(MediaType.TEXT_PLAIN)
    public Response getResource(@Context UriInfo uriinfo) {
        StringBuilder sb = new StringBuilder();
        sb.append("Path: " + uriinfo.getPath() + "\n");
        sb.append("Absolute path: " + uriinfo.getAbsolutePath() + "\n");
        sb.append("Base URI: " + uriinfo.getBaseUri() + "\n");
        sb.append("Request URI: " + uriinfo.getRequestUri() + "\n");
        return Response.ok(sb.toString()).build();
    }
}
