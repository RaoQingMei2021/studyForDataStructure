package com.guet.optical.rqm.second202110to20211007;

public class ReturnStudy {
      public static void getName() {
    	  String name="username";
    	  if(name!=null) {
    		  return;
    	  }
    	  System.out.println(name);
      }
      public static void main(String[] args) {
		ReturnStudy returnStudy = new ReturnStudy();
		 getName();
	}
}
