package com.guet.optical.rqm.second202110to20211007;

import java.util.Stack;

/**
 * ��ʾջstack�Ļ���ʹ��
 * @author Rao'Q'ing'M'ei
 *
 */
public class TestStack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<String> stack=new Stack();
		//��ջ
		stack.add("jack");
		stack.add("tom");
		stack.add("smith");
		
		//��ջ
		while(stack.size()>0) {
			System.out.println(stack.pop());//pop���ǽ�ջ��������ȡ��
		}
	}

}
