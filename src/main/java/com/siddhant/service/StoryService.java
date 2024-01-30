package com.siddhant.service;

import java.util.List;

import com.siddhant.models.Story;
import com.siddhant.models.User;

public interface StoryService {
	
	public Story createStroy(Story story,User user);

	public List<Story> findUserStory(Integer userId) throws Exception;

}
