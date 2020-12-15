package com.aaronkirchhoff.DojoOverflow.controllers;

import javax.validation.Valid;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aaronkirchhoff.DojoOverflow.models.Answer;
import com.aaronkirchhoff.DojoOverflow.models.NewQuestion;
import com.aaronkirchhoff.DojoOverflow.services.OverflowService;


@Controller
public class DojoController {
//	dependency injection= to service, use lowercase languageService in controller, to link it to LanguageService Service file.
	private final OverflowService appService;

	public DojoController(OverflowService appService) {
		this.appService = appService;
	}
	
	@RequestMapping("/")
	public String index() {
		return "addQuestion.jsp";
	}
	
//	http://localhost:8080/questions for all questions
//	http://localhost:8080/newQuestion to add a new question and tags
//	http://localhost:8080/question/10 for a question id and answer submission.
	
	
	
// ok so the way he did this below, to connect both the Question model and Tag model is he created a seperate model called NewQuestion, with the getters and setters for both other models. so the variable names you give for GetQuestion and GetTags, are the variable names you need in the form in addQuestion.jsp.
	@RequestMapping("/newQuestion")
	public String newQ(@ModelAttribute("newQuest") NewQuestion newQuest) {
		return "addQuestion.jsp";
	}
	
// post request, adding new questions, it runs the method below. here again we're using that other model, NewQuestion with the getters for both the Tag and Question model. why do this? instead oh having two @ModelAttibutes. cleans up our code?
	@RequestMapping(value="/addQuestion", method=RequestMethod.POST)
	public String Create(@Valid @ModelAttribute("newQuest") NewQuestion newQuest, BindingResult result) {
		if(result.hasErrors())
			return "addQuestion.jsp";
		this.appService.createQuestion(newQuest);
		return "redirect:/questions";
	}
	
//	type /questions into the url to get to all the questions. DASHBOARD
	@RequestMapping("/questions")
	public String showQuestions(@ModelAttribute("newQuest") NewQuestion newQuest, Model model) {
		model.addAttribute("questions", this.appService.getQuestions());
		return "Dashboard.jsp";
	}	
	
//	type /question/{id} to get the question and all the answers for it. and to submit a nother answer.
	@RequestMapping("/question/{id}")
	public String ThisQuestion(@PathVariable("id") Long id, @ModelAttribute("answers") Answer answer, Model model) {
		model.addAttribute("myQuestion", this.appService.findQuestion(id));
		return "thisQuestion.jsp";
	}
	
	
// to submit a new answer to a question
//	may need path varibale id to carry it after form submission???
	@RequestMapping(value = "/add/answers", method=RequestMethod.POST)
	public String CreateAnswer(@Valid @ModelAttribute("answers") Answer answer, BindingResult result) {
		if(result.hasErrors())
			return "thisQuestion.jsp";
		Answer newAnswer = this.appService.createAnswer(answer);
		return "redirect:/question/" + newAnswer.getQuestion().getId();
// so the method above to add an answer and have it attach to a question and display on the page. first with the jstl form on thisQuestion.jsp, i had to add that line about hidden element, this told the answer to bind to the question ID. then then redirect here is going to the method for showing th specific question id, but is replacing the simple {id}, in the route with newAnswer.getQuestion().getId(); it was a complete guess.
	}
	
	
	

	

}
