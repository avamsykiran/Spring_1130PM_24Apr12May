package com.cts.sbwmd.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/friends")
@Scope("session")
public class FriendsController {

	private List<String> friends;

	@GetMapping
	public ModelAndView friendsAction(@RequestParam(name="fnm",required =false) String friendName) {
		if(friends==null) {
			this.friends=new ArrayList<>();
		}
		if(friendName!=null) {
			this.friends.add(friendName);
		}
		return new ModelAndView("friends/friends-page","friends",friends);
	}
}
