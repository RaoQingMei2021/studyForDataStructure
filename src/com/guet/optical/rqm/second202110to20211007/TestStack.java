package com.guet.optical.rqm.second202110to20211007;

import java.util.Stack;

/**
 * 演示栈stack的基本使用
 * @author Rao'Q'ing'M'ei
 *
 */
public class TestStack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<String> stack=new Stack();
		//入栈
		stack.add("jack");
		stack.add("tom");
		stack.add("smith");
		
		//出栈
		while(stack.size()>0) {
			System.out.println(stack.pop());//pop就是将栈顶的数据取出
		}
	}

}
