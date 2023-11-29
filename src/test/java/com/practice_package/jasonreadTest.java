package com.practice_package;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class jasonreadTest {
	public static void main(String[] args) throws IOException, ParseException {
		FileReader fileReader=new FileReader("./src/test/resources/jsonread.json");
		JSONParser j=new JSONParser();
		Object obj = j.parse(fileReader);
		JSONObject map=(JSONObject) obj;
		System.out.println(map.get("browser"));
		System.out.println(map.get("username"));
		System.out.println(map.get("password"));
	}
	
	
	

}
