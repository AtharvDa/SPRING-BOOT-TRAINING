package com.effigo.springboot.myfirstwebapp.survey;

import java.util.List;

public class Question {
	
	public Question() {
		
	}

	public Question(String id, String description, List<String> options, String correctAnswer) {
		super();
		this.id = id;
		Description = description;
		this.options = options;
		this.correctAnswer = correctAnswer;
	}
	
	private String id;
	private String Description;
	private List<String> options;
	private String correctAnswer;
	public String getId() {
		return id;
	}

	public String getDescription() {
		return Description;
	}

	public List<String> getOptions() {
		return options;
	}

	public String getCorrectAnswer() {
		return correctAnswer;
	}

	@Override
	public String toString() {
		return "Question [id=" + id + ", Description=" + Description + ", options=" + options + ", correctAnswer="
				+ correctAnswer + "]";
	}
	
	
	
	
	
	
}


