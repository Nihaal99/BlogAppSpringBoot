package com.codewithnihaal.blog.payloads;

import java.util.Date;

import com.codewithnihaal.blog.entities.Category;
import com.codewithnihaal.blog.entities.User;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class PostDto {
private String title;
private String content;
private String imageName;
private Date addedDate;
private Category category;
private User user;


}
