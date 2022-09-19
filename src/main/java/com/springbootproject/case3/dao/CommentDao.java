package com.springbootproject.case3.dao;

import com.springbootproject.case3.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentDao extends JpaRepository<Comment, Long> {
}
