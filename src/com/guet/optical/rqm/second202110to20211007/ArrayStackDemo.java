package com.guet.optical.rqm.second202110to20211007;

import java.util.Scanner;

public class ArrayStackDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        //测试数组实现的栈
		//创建一个arrayStack对象，表示一个栈
		ArrayStack stack = new ArrayStack(4);
		String key="";//存放键盘输入的操作指令w
		boolean loop=true;//控制是否退出菜单
		Scanner scanner = new Scanner(System.in);
		
		while(loop) {
			System.out.println("show：表示显示栈");
			System.out.println("exit：表示退出程序");
			System.out.println("push：表示添加数据到栈");
			System.out.println("pop：表示从栈中取出数据");
			System.out.print("请输入你的操作选择：");
			key=scanner.next();
			switch(key) {
			case "show":
				stack.list();
				break;
			case "push":
				System.out.println("请输入一个数：");
				int value=scanner.nextInt();
				stack.push(value);
				break;
			case "pop":
				try {
					int res=stack.pop();//如果没有接收到异常【在出栈时可能会抛出异常】则继续执行下一句代码
					System.out.println("出栈的数据为："+res);
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println(e.getMessage());
				}
				break;
			case "exit":
				scanner.close();//关闭scanner数据流
				loop=false;
				//System.out.println("程序已安全退出~");?这退出程序提示的代码为什么是在while循环之后
				break;
			default:
				break;
			}
		}
		System.out.println("程序已安全退出~");
	}

}

/**
 * 定义一个类，表示栈
 * @author Rao'Q'ing'M'ei
 *
 */
class ArrayStack{
	private int maxSize;//栈的大小
	private int[] stack;//数组，数组模拟，数据放在该数组中
	private int top=-1;//表示栈顶，初始化为-1，表示没有数据
	
	/**
	 * 构造器
	 * @param maxSize
	 */
	public ArrayStack(int maxSize) {
		super();
		this.maxSize = maxSize;
		stack=new int[this.maxSize];//数组必须初始化才能往里放数据
	}
	
	/**
	 * 判断是否栈满
	 * @return
	 */
	public boolean isFull() {
		return top==maxSize-1;
	}
	
	/**
	 * 判断栈空
	 * @return
	 */
	public boolean isEmpty() {
		return top==-1;
	}
	
	/**
	 * 入栈操作
	 * @param value
	 */
	public void push(int value) {
		//判断栈满
		if(isFull()){
			System.out.println("栈满");
			return;
		}
		top++;
		stack[top]=value;
	}

	/**
	 * 出栈操作
	 * @return
	 */
	public int pop() {
		//先判断栈是否空
		if(isEmpty()) {
			//抛出异常
			throw new RuntimeException("栈空，无数据可出栈");//与使用return的区别？【如果使用return停止该方法的运行，就没有返回值，会报错】
		}
		int value=stack[top];
		top--;
		return value;
	}

	/**
	 * 遍历栈，显示栈
	 */
	public void list() {
		//判断是否栈空
		if(isEmpty()) {
			System.out.println("栈空，无数据~");
			return;
		}
		for(int i=top;i>=0;i--) {
			System.out.printf("stack[%d]=%d\n",i,stack[i]);
		}
	}
}