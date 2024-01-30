package com.siddhant.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.siddhant.models.Comment;

public interface CommentRepository  extends JpaRepository<Comment,Integer> {

}
