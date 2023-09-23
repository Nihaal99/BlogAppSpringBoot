package com.codewithnihaal.blog.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.codewithnihaal.blog.payloads.ApiResponse;
import com.codewithnihaal.blog.payloads.UserDto;
import com.codewithnihaal.blog.services.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
//POST-create user
	@PostMapping("/")
public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto){
	UserDto createUserDto=this.userService.createUser(userDto);
	return new ResponseEntity<>(createUserDto,HttpStatus.CREATED);
}
//PUT-update user
	@PutMapping("/{userId}")
	public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto,@PathVariable("userId")  Integer uid){
		UserDto updateUser=this.userService.updateUser(userDto, uid);
		return ResponseEntity.ok(updateUser);
	}
	
//DELETE-delete user
	@DeleteMapping("/{userId}")
	public ResponseEntity<ApiResponse> deleteUser(@RequestBody UserDto userDto,@PathVariable("userId") Integer uid){
		this.userService.deleteUser(uid);
		//ApiResponse is custom class created to get response as required
		return new ResponseEntity<ApiResponse>(new ApiResponse("User deleted Successfully",true),HttpStatus.OK);
	}
//GET-get all user 
	@GetMapping("/")
	public ResponseEntity<List<UserDto>> getAllUsers(){
	return ResponseEntity.ok(this.userService.getAllUsers());
}
	//GET-get single user 
		@GetMapping("/{userId}")
		public ResponseEntity<UserDto> getAllUsers(@PathVariable("userId") Integer uid){
		return ResponseEntity.ok(this.userService.getUserById(uid));
	}

}