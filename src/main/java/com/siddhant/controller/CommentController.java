package com.siddhant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.siddhant.models.Comment;
import com.siddhant.models.Post;
import com.siddhant.models.User;
import com.siddhant.service.CommentService;
import com.siddhant.service.UserService;

@RestController
public class CommentController {
	@Autowired
	 private CommentService commentService;
	@Autowired
	private UserService userService;
	@PostMapping("/api/comments/post/{postId}")
	public ResponseEntity<Comment> creatComment(@RequestHeader("Authorization")String jwt,@RequestBody Comment comment,@PathVariable Integer postId) throws Exception{
		User user=userService.findUserByJwt(jwt);
		Comment createdComment=commentService.createComment(comment,postId,user.getId());
		return new ResponseEntity<>(createdComment,HttpStatus.CREATED);
	}

	@PutMapping("/comments/like/{commentId}")
	public ResponseEntity<Comment> likeComment(@RequestHeader("Authorization")String jwt,@PathVariable Integer commentId) throws Exception{
		User user=userService.findUserByJwt(jwt);
		Comment likedComment=commentService.likeComment(commentId,user.getId());
		return new ResponseEntity<>(likedComment,HttpStatus.CREATED);
	}
}
