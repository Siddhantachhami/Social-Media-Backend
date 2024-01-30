package com.siddhant.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.siddhant.models.Comment;
import com.siddhant.models.Post;
import com.siddhant.models.User;
import com.siddhant.repository.CommentRepository;
import com.siddhant.repository.PostRepository;
@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
	private UserService userService;
    @Autowired
     private PostService postService;
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private PostRepository postRepository;
    
	@Override
	public Comment createComment(Comment comment, Integer postId, Integer userId) throws Exception {
		User user=userService.findUserById(userId);
		Post post=postService.findPostById(postId);
		
	   
		comment.setContent(comment.getContent());
		comment.setCreatedAt(LocalDateTime.now());
		comment.setUser(user);
		Comment savedComment=commentRepository.save(comment) ;
		post.getComments().add(savedComment);
		postRepository.save(post);
		
		return savedComment;
	}

	@Override
	public Comment findCommentById(Integer commentId) throws Exception {
		Optional<Comment> opt=commentRepository.findById(commentId);
		if(opt.isEmpty()) {
			throw  new Exception("comment does not exist with id "+commentId);
		}
		return opt.get();
	
	}

	@Override
	public Comment likeComment(Integer commentId, Integer userId) throws Exception {
		Comment comment=findCommentById(commentId);
		User user=userService.findUserById(userId);
		if(!comment.getLiked().contains(user)) {
			comment.getLiked().add(user);
			
		}else {
		
		comment.getLiked().remove(user);
		}
		
		
		return commentRepository.save(comment);
	}

}
