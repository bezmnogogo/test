package com.totalizator.mvc.controller;

import com.totalizator.dao.entities.Message;
import com.totalizator.mvc.modules.interfaces.IMapperModule;
import com.totalizator.mvc.viewmodels.MessageViewModel;
import com.totalizator.services.IDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by kasyanov on 6/14/2016.
 */
@Controller
@RequestMapping(value = "/messages")
public class MessagesController {

	@Autowired
	IDataService dataService;

	@Autowired
	public IMapperModule mapperModule;

	@RequestMapping(method = RequestMethod.GET, value = "/")
	public String index(ModelMap model) {

		List<Message> messages = dataService.findAllMessages();

		model.addAttribute("messagesList", messages);

		return "messages/messages";}

	@RequestMapping(method = RequestMethod.POST, value = "/add")
	@ResponseBody
	public MessageViewModel addMessage(@RequestBody @Valid MessageViewModel messageViewModel,
	                         BindingResult bindingResult) throws Exception {
		if (bindingResult.hasErrors()) {
			throw new Exception("error binding model");
		}

		Message message = mapperModule.map(messageViewModel, Message.class);

		Message msg = dataService.createMessage(message);

		MessageViewModel result = mapperModule.map(msg, MessageViewModel.class);

		return result;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/delete")
	@ResponseBody
	public boolean deleteMessage(@RequestBody @Valid MessageViewModel messageViewModel,
	                               BindingResult bindingResult) throws Exception {
		if (bindingResult.hasErrors()) {
			return false;
		}

		dataService.deleteMessage(messageViewModel.getId());

		return true;
	}
}
