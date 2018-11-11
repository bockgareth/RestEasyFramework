package com.gareth.userappws.ui.controller;

import com.gareth.userappws.service.UserService;
import com.gareth.userappws.shared.dto.UserDto;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/")
public class UserController {

    UserService userService = new UserService();

    @GET
    @Path("/hello")
    public Response hello() {
        return Response.status(200).entity("hello").build();
    }

    @GET
    @Path("/users")
    @Produces(MediaType.APPLICATION_JSON)
    public List<UserDto> getAllUsers() {
        return userService.getAllUsers();
    }

    @GET
    @Path("/users/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public UserDto getUserById(@PathParam("id") int id) {
        return userService.getUserById(id);
    }

    @POST
    @Path("/users")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public UserDto createUser(UserDto user) {
        return userService.createUser(user);
    }

}