package com.codewithnihaal.blog.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codewithnihaal.blog.entities.Category;
import com.codewithnihaal.blog.entities.Post;
import com.codewithnihaal.blog.entities.User;

public interface PostRepo extends JpaRepository<Post,Integer>{

	List<Post> findByUser(User user);
	List<Post> findByCategory(Category category);
}
