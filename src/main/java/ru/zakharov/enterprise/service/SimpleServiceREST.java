package ru.zakharov.enterprise.service;

import ru.zakharov.enterprise.dto.ResultDTO;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/SimpleService")
public class SimpleServiceREST {

    @GET
    @Path("/ping")
    @Produces(MediaType.APPLICATION_JSON)
    public ResultDTO ping() {
        return new ResultDTO();
    }

    @GET
    @Path("/testJSON")
    @Produces(MediaType.APPLICATION_JSON)
    public ResultDTO testJSON() {
        return new ResultDTO();
    }

    @GET
    @Path("/testXML")
    @Produces(MediaType.APPLICATION_XML)
    public ResultDTO testXML() {
        return new ResultDTO();
    }

}
