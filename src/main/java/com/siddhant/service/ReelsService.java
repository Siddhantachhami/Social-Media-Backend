package com.siddhant.service;

import java.util.List;

import com.siddhant.models.Reels;
import com.siddhant.models.User;

public interface ReelsService {
	public Reels createReel(Reels reel,User user);
	public List<Reels> findAllReels();
	public List<Reels> findUserReel(Integer userId) throws Exception;

}
