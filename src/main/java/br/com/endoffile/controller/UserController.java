package br.com.endoffile.controller;

import br.com.endoffile.exception.UserNotFoundException;
import br.com.endoffile.model.User;
import br.com.endoffile.model.dto.UserDTO;
import br.com.endoffile.service.impl.UserService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@RequestScoped
@Path("/v1/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserController {

    private final UserService userService;

    @Inject
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GET
    @Path("/{id}")
    public User getUser(@PathParam("id") int id) throws UserNotFoundException {
        return this.userService.getUserById(id);
    }

    @POST
    @Path("/")
    public User saveUser(@Valid UserDTO userDTO) throws UserNotFoundException {
        return this.userService.saveUser(userDTO.toUser());
    }


}
