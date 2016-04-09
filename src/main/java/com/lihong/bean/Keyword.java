package com.lihong.bean;

/**
 *
 * 
 * @author li hong
 * 
 */
public class Keyword extends DomainObject{
	
	
	private String word;
	
	private String pinyin;
	
	private int weight=0;
	
	public Keyword(){
		
	}

	public Keyword(String word, String pinyin, int weight) {
		this.word = word;
		this.pinyin = pinyin;
		this.weight = weight;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public String getPinyin() {
		return pinyin;
	}

	public void setPinyin(String pinyin) {
		this.pinyin = pinyin;
	}


    
}
