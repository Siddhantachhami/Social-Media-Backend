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

import com.siddhant.models.Reels;
import com.siddhant.models.User;
import com.siddhant.service.ReelsService;
import com.siddhant.service.UserService;

@RestController
public class ReelsController {
	@Autowired
	private ReelsService reelsService;
	@Autowired
	private UserService userService;
	
    @PostMapping("/api/reels")
	public ResponseEntity<Reels> createReels(@RequestBody Reels reel,@RequestHeader("Authorization" )String jwt) {
		User reqUser=userService.findUserByJwt(jwt);
		Reels createReels=reelsService.createReel(reel, reqUser);
		return new ResponseEntity<>(createReels,HttpStatus.CREATED);
		
	}
    @GetMapping("/api/reels")
	public ResponseEntity<List<Reels>>findAllReels() {
		
		List<Reels> reels=reelsService.findAllReels();
		return new ResponseEntity<List<Reels>>(reels,HttpStatus.OK);
		
	}
    @GetMapping("/api/reels/user/{userId}")
	public ResponseEntity<List<Reels>>findUserReels(@PathVariable Integer userId) throws Exception {
		
		List<Reels> reels=reelsService.findUserReel(userId);
		return new ResponseEntity<List<Reels>>(reels,HttpStatus.OK);
		
	}
}
