package com.codewithnihaal.blog.services;

import java.util.List;

import com.codewithnihaal.blog.entities.Post;
import com.codewithnihaal.blog.payloads.PostDto;

public interface PostService {
public PostDto createPost(PostDto userDto,Integer userId,Integer categoryId);
public Post updatePost(PostDto postDto,Integer postId);
public void deletePost(Integer postId);
public List<Post> getAllPosts();
public PostDto getPostById(Integer postId);
public List<Post> getPostByCategory(Integer categoryId);
public List<Post> getPostByUser(Integer userId);
}
