package com.guet.optical.rqm.first20210915to20210922;
 /**
  *问题：Circle等三个子类  sh1数组【未解决】
  */
import java.awt.Shape; 

public class FindMaxDemo {
	/**
	 * Return max item in arr
	 * Preconddition:arr.length>0
	 * @param args
	 */
	public static Comparable findMax(Comparable [] arr) {
		int maxIndex=0;
		for(int i=1;i<arr.length;i++) {
			if(arr[i].compareTo(arr[maxIndex])>0) {
				maxIndex=i;
			}
		}
		return arr[maxIndex];
	}

	/**
	 * test findMax on Shape and String objects
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Shape [] sh1= {new Circle(2.0),
        		       new Square(3.0),
        		       new Rectangle(3.0,4.0)}; 
        
        String [] st1= {"Joe","Bob","Bill","Zeke"};
       // System.out.println(findMax(sh1));
        System.out.println(findMax(st1));
	}

}
