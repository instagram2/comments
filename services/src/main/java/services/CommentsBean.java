package services;

import lib.Comment;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@ApplicationScoped
public class CommentsBean {

    private Logger log = Logger.getLogger(CommentsBean.class.getName());

    private List<Comment> comments;

    @PostConstruct
    private void init() {
        comments = new ArrayList<>();
        //comments.add(new Comment(1, UUID.randomUUID().toString(), "UAuuu!"));
        //comments.add(new Comment(1, comments.get(0).getAuthorId(), "Lepaa"));
        //comments.add(new Comment(1, UUID.randomUUID().toString(), "Zelo lepo :D"));
    }

    public List<Comment> getComments() {

        return comments;

    }

    public List<Comment> getCommentsForImage(Integer imageId) {

        return comments.stream().filter(comment -> comment.getImageId().equals(imageId)).collect(Collectors.toList());
    }

    public void addComment(Comment comment) {
        comments.add(comment);
    }


}
