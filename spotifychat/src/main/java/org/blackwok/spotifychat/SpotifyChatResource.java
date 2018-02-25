package org.blackwok.spotifychat;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.blackwok.spotifychat.models.ChatMessage;

/**
 * Created by Jemma on 6/17/17.
 */

@Path("/spotifychat")
@Api("/spotifychat")
public class SpotifyChatResource {

    @GET
    @ApiOperation("Create message endpoint")
    public Response get() {
        return Response.ok(new ChatMessage("1234", "Hello, Jemma!")).build();
    }

    @GET
    @ApiOperation("Sample endpoint with path param")
    @Path("/hello-with-path-param/{name}")
    public Response getWithPathParam(@PathParam("name") String name) {
        return Response.ok(new ChatMessage ("Hello " + name)).build();
    }

    @GET
    @ApiOperation("Sample endpoint with query param")
    @Path("/hello-with-query-param")
    public Response getWithQueryParam(@QueryParam("name") String name) {
        return Response.ok(new ChatMessage("Hello " + name)).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @ApiOperation(
            value = "Get access token",
            notes = "Authenticate user and get a access token.",
            response = ChatMessage.class
    )
    public ChatMessage postForToken(
            @FormParam("username") @ApiParam(defaultValue = "username") String username,
            @FormParam("password") @ApiParam(defaultValue = "q") String password
    ) {
        return new ChatMessage("1234", username);
    }

}
