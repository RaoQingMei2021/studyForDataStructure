package com.guet.optical.rqm.first20210915to20210922;

import java.util.Scanner;

/**
 * 数组模拟环形队列
 * 
 * @author Rao'Q'ing'M'ei
 *
 */

public class ArrayQueueDemoCircle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayQueueCircle arrayQueueCircle = new ArrayQueueCircle(4);// 注：设置为4，但其队列 的最大有效数字为3
		char key = ' ';
		Scanner scanner = new Scanner(System.in);
		boolean loop = true;
		while (loop) {
			System.out.println("a(add):入队操作");
			System.out.println("g(get):出队操作");
			System.out.println("s(show):显示队列所有元素");
			System.out.println("e(exit):退出程序");
			System.out.println("h(head):查看队列头的数据");

			key = scanner.next().charAt(0);
			switch (key) {
			case 'a':
				System.out.println("********请输入一个数********");
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
					System.out.printf("队列头的数据是%d\n", res);
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println(e.getMessage());
				}
				break;
			default:
				break;
			}
		}
		System.out.println("退出程序！！");
	}

}

class ArrayQueueCircle {
	private int[] arr;
	private int front;// front变量含义做调整：front就是指向队列的第一个元素，也就是说arr[front]就是队列的第一个元素。front的初始值=0
	private int rear;// rear变量的含义做调整：rear指向队列的最后一个元素的最后一个位置。因为希望空出一个位置作为约定.rear的初始值=0。
	private int maxSize;

	/**
	 * 创建构造器
	 */

	public ArrayQueueCircle(int maxSize) {
		super();
		this.maxSize = maxSize;
		arr = new int[maxSize];
		front = 0;
		rear = 0;
	}

	/**
	 * 检测队列是否为空
	 */
	public boolean isEmpty() {
		return front == rear;
	}

	/**
	 * 检测队列是否满
	 */
	public boolean isFull() {

		System.out.printf("****rear:%d**front:%d**%d*********\n", rear, front, rear - front);
//		return front==(1+rear)%maxSize;//【视频给的】
		return ((rear - front) == maxSize - 1) || (rear - front == -1);// 【自己理解的，但运行的结果不对】 取数据之后再显示数据就有问题
		// 使用自己理解的时候显示时产生错误的原因在于：自己写的是判断了是否为满 ，若
		// 有将数据元素出队的操作之后再进行入队，则front的坐标就有可能等于或大于队列的大小
	}

	/**
	 * 入队
	 */
	public void enQueue(int n) {
		if (isFull()) {
			System.out.println("*************队列已满！！无法入队！！***************");
			return;
		}
		arr[rear] = n;
//      rear++;
		rear = (rear + 1) % maxSize;// 尾指针后移取模，必须考虑取模【视频给的】

	}

	/**
	 * 出队
	 */
	public int deQueue() {
		if (isEmpty()) {
//			System.out.println("*********队列为空，无数据可取***********");//在这里为什么不能直接提示队列为空而是需要抛出异常
			throw new RuntimeException("队列为空，无数据可取！！！！！");
		}
//	  return arr[front]; 该行代码是自己对于出队的操作的整个实现，但是存在很大的问题
		/**
		 * 这里需要分析出front是指向队列的第一个元素 1、先把front对应的值保留到一个临时变量的 2、将front后移，考虑取模 3、将临时保存的变量返回
		 */
		int value = arr[front];
		front = (front + 1) % maxSize;
		return value;
	}

	/**
	 * 显示队列
	 */
	// 第一部分为自己的实现，存在的问题：1、未判断是否为空；2、如果遍历所有的数组元素，那么已经取出的元素也会显示出来
	/*
	 * public void showQueue() { for(int i=0;i<arr.length;i++) {
	 * System.out.printf("arr[%d]=%d\t", i,arr[i]); } System.out.println(); }
	 */
	public void showQueue() {
		// 判断是否为空
		if (isEmpty()) {
			System.out.println("***队列为空，无数据****");
			return;
		}
		// 遍历 思路：从front开始遍历，遍历多少个元素\
		System.out.printf("********front:%d****size:%d*****", front, size());
		for (int i = front; i < front + size(); i++) {
			System.out.printf("arr[%d]=%d\n", i % maxSize, arr[i % maxSize]);
		}
	}

	/**
	 * 求出当前队列有效数据 的个数
	 */
	public int size() {
		return (rear + maxSize - front) % maxSize;// 【视频给的】
//		return (rear-front)%maxSize;//【当大小设置为3，而一个元素出队再添加元素之后，队列的大小判断不对】
	}

	/**
	 * 显示头元素，注意不是取出数据
	 */
	public int headQueue() {
		// 判断是否为空
		if (isEmpty()) {
			throw new RuntimeException("队列为空，无数据！！");
		}
		return arr[front];
	}
}