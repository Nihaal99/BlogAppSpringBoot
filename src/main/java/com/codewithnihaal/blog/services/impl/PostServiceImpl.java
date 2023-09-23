package com.codewithnihaal.blog.services.impl;


import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codewithnihaal.blog.entities.Category;
import com.codewithnihaal.blog.entities.Post;
import com.codewithnihaal.blog.entities.User;
import com.codewithnihaal.blog.exceptions.ResourceNotFoundException;
import com.codewithnihaal.blog.payloads.PostDto;
import com.codewithnihaal.blog.repositories.CategoryRepo;
import com.codewithnihaal.blog.repositories.PostRepo;
import com.codewithnihaal.blog.repositories.UserRepo;
import com.codewithnihaal.blog.services.PostService;
@Service
public class PostServiceImpl implements PostService {
@Autowired
	private PostRepo postRepo;
@Autowired
private ModelMapper modelMapper;

@Autowired
private UserRepo userRepo;

@Autowired
private CategoryRepo categoryRepo;

	@Override
	public PostDto createPost(PostDto postDto,Integer userId,Integer categoryId) {
		
		User user=this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User","User id",userId));
		Category category=this.categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category","Category id",categoryId));
		Post post=this.modelMapper.map(postDto, Post.class);
		post.setImageName("default.png");
		post.setAddedDate(new Date());
		post.setUser(user);
		post.setCategory(category);
		
		Post newPost=this.postRepo.save(post);
		return this.modelMapper.map(newPost,PostDto.class);
		
	}

	@Override
	public Post updatePost(PostDto postDto, Integer postId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletePost(Integer postId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Post> getAllPosts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PostDto getPostById(Integer postId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Post> getPostByCategory(Integer categoryId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Post> getPostByUser(Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}

}
