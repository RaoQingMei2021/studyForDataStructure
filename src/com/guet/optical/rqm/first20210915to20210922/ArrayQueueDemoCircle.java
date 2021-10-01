package com.guet.optical.rqm.first20210915to20210922;

import java.util.Scanner;

/**
 * ����ģ�⻷�ζ���
 * 
 * @author Rao'Q'ing'M'ei
 *
 */

public class ArrayQueueDemoCircle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayQueueCircle arrayQueueCircle = new ArrayQueueCircle(4);// ע������Ϊ4��������� �������Ч����Ϊ3
		char key = ' ';
		Scanner scanner = new Scanner(System.in);
		boolean loop = true;
		while (loop) {
			System.out.println("a(add):��Ӳ���");
			System.out.println("g(get):���Ӳ���");
			System.out.println("s(show):��ʾ��������Ԫ��");
			System.out.println("e(exit):�˳�����");
			System.out.println("h(head):�鿴����ͷ������");

			key = scanner.next().charAt(0);
			switch (key) {
			case 'a':
				System.out.println("********������һ����********");
				int value = scanner.nextInt();
				arrayQueueCircle.enQueue(value);
				break;
			case 'g':
				try {
					int res = arrayQueueCircle.deQueue();
					System.out.println(res);
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println(e.getMessage());
				}
				break;
			case 's':
				arrayQueueCircle.showQueue();
				break;
			case 'h':
				try {
					int res = arrayQueueCircle.headQueue();
					System.out.printf("����ͷ��������%d\n", res);
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println(e.getMessage());
				}
				break;
			default:
				break;
			}
		}
		System.out.println("�˳����򣡣�");
	}

}

class ArrayQueueCircle {
	private int[] arr;
	private int front;// front����������������front����ָ����еĵ�һ��Ԫ�أ�Ҳ����˵arr[front]���Ƕ��еĵ�һ��Ԫ�ء�front�ĳ�ʼֵ=0
	private int rear;// rear�����ĺ�����������rearָ����е����һ��Ԫ�ص����һ��λ�á���Ϊϣ���ճ�һ��λ����ΪԼ��.rear�ĳ�ʼֵ=0��
	private int maxSize;

	/**
	 * ����������
	 */

	public ArrayQueueCircle(int maxSize) {
		super();
		this.maxSize = maxSize;
		arr = new int[maxSize];
		front = 0;
		rear = 0;
	}

	/**
	 * �������Ƿ�Ϊ��
	 */
	public boolean isEmpty() {
		return front == rear;
	}

	/**
	 * �������Ƿ���
	 */
	public boolean isFull() {

		System.out.printf("****rear:%d**front:%d**%d*********\n", rear, front, rear - front);
//		return front==(1+rear)%maxSize;//����Ƶ���ġ�
		return ((rear - front) == maxSize - 1) || (rear - front == -1);// ���Լ����ģ������еĽ�����ԡ� ȡ����֮������ʾ���ݾ�������
		// ʹ���Լ�����ʱ����ʾʱ���������ԭ�����ڣ��Լ�д�����ж����Ƿ�Ϊ�� ����
		// �н�����Ԫ�س��ӵĲ���֮���ٽ�����ӣ���front��������п��ܵ��ڻ���ڶ��еĴ�С
	}

	/**
	 * ���
	 */
	public void enQueue(int n) {
		if (isFull()) {
			System.out.println("*************�������������޷���ӣ���***************");
			return;
		}
		arr[rear] = n;
//      rear++;
		rear = (rear + 1) % maxSize;// βָ�����ȡģ�����뿼��ȡģ����Ƶ���ġ�

	}

	/**
	 * ����
	 */
	public int deQueue() {
		if (isEmpty()) {
//			System.out.println("*********����Ϊ�գ������ݿ�ȡ***********");//������Ϊʲô����ֱ����ʾ����Ϊ�ն�����Ҫ�׳��쳣
			throw new RuntimeException("����Ϊ�գ������ݿ�ȡ����������");
		}
//	  return arr[front]; ���д������Լ����ڳ��ӵĲ���������ʵ�֣����Ǵ��ںܴ������
		/**
		 * ������Ҫ������front��ָ����еĵ�һ��Ԫ�� 1���Ȱ�front��Ӧ��ֵ������һ����ʱ������ 2����front���ƣ�����ȡģ 3������ʱ����ı�������
		 */
		int value = arr[front];
		front = (front + 1) % maxSize;
		return value;
	}

	/**
	 * ��ʾ����
	 */
	// ��һ����Ϊ�Լ���ʵ�֣����ڵ����⣺1��δ�ж��Ƿ�Ϊ�գ�2������������е�����Ԫ�أ���ô�Ѿ�ȡ����Ԫ��Ҳ����ʾ����
	/*
	 * public void showQueue() { for(int i=0;i<arr.length;i++) {
	 * System.out.printf("arr[%d]=%d\t", i,arr[i]); } System.out.println(); }
	 */
	public void showQueue() {
		// �ж��Ƿ�Ϊ��
		if (isEmpty()) {
			System.out.println("***����Ϊ�գ�������****");
			return;
		}
		// ���� ˼·����front��ʼ�������������ٸ�Ԫ��\
		System.out.printf("********front:%d****size:%d*****", front, size());
		for (int i = front; i < front + size(); i++) {
			System.out.printf("arr[%d]=%d\n", i % maxSize, arr[i % maxSize]);
		}
	}

	/**
	 * �����ǰ������Ч���� �ĸ���
	 */
	public int size() {
		return (rear + maxSize - front) % maxSize;// ����Ƶ���ġ�
//		return (rear-front)%maxSize;//������С����Ϊ3����һ��Ԫ�س��������Ԫ��֮�󣬶��еĴ�С�жϲ��ԡ�
	}

	/**
	 * ��ʾͷԪ�أ�ע�ⲻ��ȡ������
	 */
	public int headQueue() {
		// �ж��Ƿ�Ϊ��
		if (isEmpty()) {
			throw new RuntimeException("����Ϊ�գ������ݣ���");
		}
		return arr[front];
	}
}