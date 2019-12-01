package v1.resources;

import lib.Comment;
import services.CommentsBean;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@ApplicationScoped
@Path("/comments")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CommentsResource {

    @Inject
    private CommentsBean commentsBean;

    @GET
    public Response getComments(@QueryParam("imageId") Integer imageId) {

        List<Comment> comments;

        if (imageId != null) {
            comments = commentsBean.getCommentsForImage(imageId);
        } else {
            comments = commentsBean.getComments();
        }

        return Response.ok(comments).build();
    }

    @GET
    @Path("count")
    public Response getCommentsCount(@QueryParam("imageId") Integer imageId) {

        List<Comment> comments;

        if (imageId != null) {
            comments = commentsBean.getCommentsForImage(imageId);
        } else {
            comments = commentsBean.getComments();
        }

        return Response.ok(comments.size()).build();
    }

    @POST
    public Response addNewComment(Comment comment) {
        commentsBean.addComment(comment);
        return Response.status(Response.Status.OK).entity(commentsBean).build();
    }

}
