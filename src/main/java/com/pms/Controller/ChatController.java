package com.pms.Controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pms.model.ChatMessage;
import com.pms.service.PersonUserDetails;



@Controller
public class ChatController {
	
	@RequestMapping("/chat")
	public String chatProcess(Authentication authentication, ModelMap modelmap) {
		
		java.lang.Object principal = authentication.getPrincipal();
		
		String usename = null;

		if (principal instanceof UserDetails) {
			usename = ((PersonUserDetails) principal).getPerson().getUsername();
		}
		modelmap.addAttribute("username",usename);
		return "ChatBox.jsp";
	}

	@MessageMapping("/chat.register")
	@SendTo("/topic/public")
	public ChatMessage register(@Payload ChatMessage chatMessage, SimpMessageHeaderAccessor headerAccessor) {
		headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
		return chatMessage;
	}

	@MessageMapping("/chat.send")
	@SendTo("/topic/public")
	public ChatMessage sendMessage(@Payload ChatMessage chatMessage) {
		return chatMessage;
	}

}
