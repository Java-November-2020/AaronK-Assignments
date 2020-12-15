package com.aaronkirchhoff.DojoOverflow.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.aaronkirchhoff.DojoOverflow.models.Answer;
import com.aaronkirchhoff.DojoOverflow.models.Question;
import com.aaronkirchhoff.DojoOverflow.models.Tag;
import com.aaronkirchhoff.DojoOverflow.repositories.AnswerRepository;
import com.aaronkirchhoff.DojoOverflow.repositories.QuestionRepository;
import com.aaronkirchhoff.DojoOverflow.repositories.TagRepository;
import com.aaronkirchhoff.DojoOverflow.models.NewQuestion;



@Service
public class OverflowService {
	private final QuestionRepository qRepo;
	private final AnswerRepository aRepo;
	private TagRepository tRepo;

	public OverflowService(QuestionRepository qRepo, AnswerRepository aRepo, TagRepository tRepo) {
		this.qRepo = qRepo;
		this.aRepo = aRepo;
		this.tRepo = tRepo;

	}
	
	public List<Question> getQuestions() {
		return this.qRepo.findAll();
	}
	
	public List<Question> allQuestions() {
		return qRepo.findAll();
	}
	
	public void createQuestion(NewQuestion question) {
		
		List<Tag> questionsTags = new ArrayList<Tag>();
		for(String subject: question.splitTags()) {
			Tag tag = this.tRepo.findBySubject(subject).orElse(null);
			if(tag == null) {
				tag = new Tag(subject);
				this.tRepo.save(tag);
			}
			// prevent dupe tags
			if(!questionsTags.contains(tag))
				questionsTags.add(tag);
		}
		Question newQuestion = new Question(question.getQuestion(), questionsTags);
		this.qRepo.save(newQuestion);
		
//		return qRepo.save(quesiton);
	}
	
	public Question findQuestion(Long id) {
		return this.qRepo.findById(id).orElse(null);
	}

	public Answer createAnswer(Answer answer) {
		return aRepo.save(answer);
	}
}
