package com.siddhant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;


import com.siddhant.models.Story;
import com.siddhant.models.User;
import com.siddhant.service.StoryService;
import com.siddhant.service.UserService;
@RestController
public class StoryController {
	
	@Autowired
	private StoryService storyService;
	@Autowired
	private UserService userService;

	 @PostMapping("/api/stories")
		public ResponseEntity<Story> createStory(@RequestBody Story story,@RequestHeader("Authorization" )String jwt) {
			User reqUser=userService.findUserByJwt(jwt);
			Story createStory=storyService.createStroy(story, reqUser);
			return new ResponseEntity<>(createStory,HttpStatus.CREATED);
			
		}
	   
	    @GetMapping("/api/story/user/{userId}")
		public ResponseEntity<List<Story>>findUserStory(@PathVariable Integer userId,@RequestHeader("Authorization" )String jwt) throws Exception {
	    	User reqUser=userService.findUserByJwt(jwt);
			List<Story>stories=storyService.findUserStory(userId);
			return new ResponseEntity<List<Story>>(stories,HttpStatus.OK);
			
		}
}
