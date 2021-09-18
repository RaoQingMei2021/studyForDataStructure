package com.guet.optical.rqm.first20210915to20210922;

import java.util.Scanner;

/**
 * 数组模拟环形队列
 * @author Rao'Q'ing'M'ei
 *
 */

public class ArrayQueueDemoCircle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       ArrayQueueCircle arrayQueueCircle = new ArrayQueueCircle(3);
       char key=' ';
       Scanner scanner = new Scanner(System.in);
       boolean loop=true;
       while(loop) {
    	   System.out.println("a(add):入队操作");
    	   System.out.println("g(get):出队操作");
    	   System.out.println("s(show):显示队列所有元素");
    	   System.out.println("e(exit):退出程序");
    	   
    	   key=scanner.next().charAt(0);
    	   switch(key) {
    	   case 'a':
    		   System.out.println("********请输入一个数********");
    		   int value=scanner.nextInt();
    		   arrayQueueCircle.enQueue(value);
    		   break;
    	   case 'g':
    		   try {
				int res=arrayQueueCircle.deQueue();
				System.out.println(res);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
			}
    		   break;
    	   case 's':
    		   arrayQueueCircle.showQueue();
    		   break;
    		default:
    			break;
    	   }
       }
       System.out.println("退出程序！！");
	}

}

class ArrayQueueCircle{
	private int[] arr;
	private int front;
	private int rear;
	private int maxSize;
	/**
	 * 创建构造器
	 */

	public ArrayQueueCircle(int maxSize) {
		super();
		this.maxSize = maxSize;
		arr=new int[maxSize];
		front=0;
		rear=0;
	}
	/**
	 * 检测队列是否为空
	 */
	public boolean isEmpty() {
		return front==rear;
	}
	/**
	 * 检测队列是否满
	 */
	public boolean isFull() {
		return front==(1+rear)%maxSize;
	}
	
	/**
	 * 入队
	 */
	public void enQueue(int n) {
      if(isFull()) {
    	  System.out.println("*************队列已满！！无法入队！！***************");
    	  return;
      } 
      arr[rear%maxSize]=n;
      rear++;
	}
	/**
	 * 出队
	 */
	public int deQueue() {
		if(isEmpty()) {
			System.out.println("*********队列为空，无数据可取***********");
		} 
	  return arr[front];
	}
	/**
	 * 显示队列
	 */
	public void showQueue() {
		for(int i=0;i<arr.length;i++) {
			System.out.printf("arr[%d]=%d\t", i,arr[i]);
		}
		System.out.println();
	} 
}