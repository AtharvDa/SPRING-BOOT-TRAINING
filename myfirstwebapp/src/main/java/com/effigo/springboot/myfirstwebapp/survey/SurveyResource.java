package com.effigo.springboot.myfirstwebapp.survey;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class SurveyResource {

	private SurveyService surveyService;

	public SurveyResource(SurveyService surveyService) {
		super();
		this.surveyService = surveyService;
	}

	@GetMapping("/surveys")
	public List<Survey> retrieveAllSurveys() {

		return surveyService.retrieveAllSurveys();
	}

	@GetMapping("/surveys/{surveyId}")
	public Survey retrieveSurveyById(@PathVariable String surveyId) {

		Survey survey = surveyService.retrieveSurveyById(surveyId);
		if (survey == null)
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);

		return survey;

	}

	@GetMapping("/surveys/{surveyId}/questions")
	public List<Question> retrieveAllSurveyQuestions(@PathVariable String surveyId) {

		List<Question> questions = surveyService.retrieveAllSurveyQuestions(surveyId);
		if (questions == null)
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);

		return questions;

	}

	@GetMapping("/surveys/{surveyId}/questions/{questionId}")
	public Question retrieveAllSurveyQuestions(@PathVariable String surveyId, @PathVariable String questionId) {

		Question question = surveyService.retrieveQuestionById(surveyId, questionId);
		if (question == null)
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		return question;
	}

}
