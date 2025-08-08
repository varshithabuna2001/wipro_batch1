package com.exception.test;

import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class maps {
  public static void main(String[] args) {
	 Map<String,String> mymap=new TreeMap<>();
	 mymap.put("ind","india");
	 mymap.put("swz","swizerland");
	 mymap.put("ity","italy");
	 mymap.put("nyc","newyork");
	 for (Entry<String, String> data: mymap.entrySet())
	 {
		 System.out.println(data.getKey() + "-" + data.getValue());
	 }
	 
	 //System.out.println(mymap.get("nyc"));
	 
}
}