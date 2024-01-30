package com.siddhant.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.siddhant.models.Story;
import com.siddhant.models.User;
import com.siddhant.repository.StoryRepository;
@Service
public class StoryServiceImpl implements StoryService {
    @Autowired
	private StoryRepository storyRepository;
    @Autowired
    private UserService userService;
	@Override
	public Story createStroy(Story story, User user) {
		Story createStory=new Story();
		createStory.setCaption(story.getCaption());
		createStory.setImage(story.getImage());
		createStory.setTimeStamp(LocalDateTime.now());
		createStory.setUser(user);
		return storyRepository.save(createStory);
	}

	
	@Override
	public List<Story> findUserStory(Integer userId) throws Exception {
		User user=userService.findUserById(userId);
		return storyRepository.findByUserId(userId);
	}
}
