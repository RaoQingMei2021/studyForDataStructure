package com.guet.optical.rqm.first20210915to20210922;

import java.util.Scanner;

/**
 * ����ģ�⻷�ζ���
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
    	   System.out.println("a(add):��Ӳ���");
    	   System.out.println("g(get):���Ӳ���");
    	   System.out.println("s(show):��ʾ��������Ԫ��");
    	   System.out.println("e(exit):�˳�����");
    	   
    	   key=scanner.next().charAt(0);
    	   switch(key) {
    	   case 'a':
    		   System.out.println("********������һ����********");
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
       System.out.println("�˳����򣡣�");
	}

}

class ArrayQueueCircle{
	private int[] arr;
	private int front;
	private int rear;
	private int maxSize;
	/**
	 * ����������
	 */

	public ArrayQueueCircle(int maxSize) {
		super();
		this.maxSize = maxSize;
		arr=new int[maxSize];
		front=0;
		rear=0;
	}
	/**
	 * �������Ƿ�Ϊ��
	 */
	public boolean isEmpty() {
		return front==rear;
	}
	/**
	 * �������Ƿ���
	 */
	public boolean isFull() {
		return front==(1+rear)%maxSize;
	}
	
	/**
	 * ���
	 */
	public void enQueue(int n) {
      if(isFull()) {
    	  System.out.println("*************�������������޷���ӣ���***************");
    	  return;
      } 
      arr[rear%maxSize]=n;
      rear++;
	}
	/**
	 * ����
	 */
	public int deQueue() {
		if(isEmpty()) {
			System.out.println("*********����Ϊ�գ������ݿ�ȡ***********");
		} 
	  return arr[front];
	}
	/**
	 * ��ʾ����
	 */
	public void showQueue() {
		for(int i=0;i<arr.length;i++) {
			System.out.printf("arr[%d]=%d\t", i,arr[i]);
		}
		System.out.println();
	} 
}