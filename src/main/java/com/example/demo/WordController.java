package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WordController {

	@Value("${words}") String words;
//    String words = "icicle,refrigerator,blizzard,snowball";
	
	@GetMapping("/")
	public @ResponseBody Word getWord() {
		String[] wordArray = words.split(",");
		int i = (int)Math.round(Math.random() * (wordArray.length - 1));
		return new Word(wordArray[i]);
	}
}