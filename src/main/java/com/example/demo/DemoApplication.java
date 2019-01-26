package com.example.demo;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	Map<Character, Character> bracketsMap = new HashMap<Character, Character>() {{
		put('{', '}');
		put('(', ')');
		put('[', ']');
	}};

	public boolean checkBalance(String balanceBracket) {
		Deque<Character> bracketsDeque = new ArrayDeque<Character>();

		for (int i=0; i < balanceBracket.length(); i++) {

			char currChar = balanceBracket.charAt(i);

			if (isCharAOpenBracket(currChar)) {
				bracketsDeque.push(currChar);
			} else if (isCharAClosingBracket(currChar) &&
					isClosingBracketMatchingLastOpening(bracketsDeque, currChar)) {
				return false;
			}
		}
		return bracketsDeque.isEmpty();
	}

	private boolean isCharAOpenBracket(char currChar) {
		return bracketsMap.containsKey(currChar);
	}

	private boolean isCharAClosingBracket(char currChar) {
		return bracketsMap.values().contains(currChar);
	}

	private boolean isClosingBracketMatchingLastOpening(Deque<Character> bracketsDeque, char currChar) {
		return bracketsDeque.size() == 0 || !bracketsMap.get(bracketsDeque.pop()).equals(currChar);
	}





}

