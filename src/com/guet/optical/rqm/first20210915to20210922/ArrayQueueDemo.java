package com.guet.optical.rqm.first20210915to20210922;

import java.util.Scanner;

/**
 * 使用数组模拟队列
 * 
 * @author Rao'Q'ing'M'ei
 *
 */
public class ArrayQueueDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 测试数组实现队列
		// 创建一个队列
		ArrayQueue arrayQueue = new ArrayQueue(3);
		char key = ' ';// 接收用户输入
		Scanner scanner = new Scanner(System.in);
		boolean loop = true;
		while (loop) {
			System.out.println("s(show):显示队列");
			System.out.println("e(eixt):退出程序");
			System.out.println("a(add):添加数据到队列");
			System.out.println("g(get):从队列取出数据");
			System.out.println("h(head):查看队列头的数据");
			key = scanner.next().charAt(0);// 接收一个字符
			switch (key) {
			case 's':
				arrayQueue.showQueue();
				break;
			case 'a':
				System.out.println("请输入一个数");
				int value = scanner.nextInt();
				arrayQueue.addQueue(value);
				break;
			case 'g':
				try {
					int res = arrayQueue.getQueue();
					System.out.println(res);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case 'h':
				try {
					int res = arrayQueue.headQueue();
					System.out.printf("队列头的数据是%d\n", res);
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println(e.getMessage());
				}
				break;
			case 'e':
				scanner.close();// 关闭scanner，否则会有异常报错
				loop = false;
				break;
			default:
				break;
			}
		}
		System.out.println("程序退出！！！");
	}

}

//使用数组模拟队列-编写一个ArrayQueue类
class ArrayQueue {
	private int maxSize;// 表示数组的最大容量
	private int front;// 队列头
	private int rear;// 队列尾
	private int[] arr;// 该数组用于存放数据，模拟队列

	/**
	 * 创建队列的构造器
	 * 
	 */
	public ArrayQueue(int arrMaxSize) {
		super();
		this.maxSize = arrMaxSize;
		arr = new int[maxSize];
		front = -1;// 指向队列头部，分析出front是指向队列头的前一个位置
		rear = -1;// 指向队列尾，指向队列尾的数据（即队列的最后一个数据）

	}

	/**
	 * 判断队列是否满
	 * 
	 */
	public boolean isFull() {
		return rear == maxSize - 1;
	}

	/**
	 * 判断队列是否为空
	 */
	public boolean isEmpty() {
		return rear == front;
	}

	/**
	 * 添加数据到队列
	 */
	public void addQueue(int n) {
		// 需要判断队列是否满，若满了，则加不进去
		if (isFull()) {
			System.out.println("队列满！！添加失败！！");
			return;
		}
		rear++;// 让rear后移
		arr[rear] = n;
	}

	/**
	 * 获取队列的数据/数据出队列
	 */
	public int getQueue() {
		if (isEmpty()) {
			// 队列为空，通过抛出异常来处理
			throw new RuntimeException("队列为空，不能取数据！！");
			// 注意：在这里不用写return，因为抛出异常之后，就停止了这个函数的运行？
		}
		front++;
		System.out.println("**************输出取出数据之后的指向队头的数值front:"+front);
		return arr[front];
		/**
		 * 注:该出队列的实现方式存在问题.表面是取了,只是front头指针移动,但数组里的数据元素未剔除出队.造成的现象就是
		 * 再取数据显示队列为空,无数据;但往队列中添加数据时又显示队列已满,无法添加数据
		 * 
		 * 解决：使用算法将数组改为环形数组
		 */
	}

	/**
	 * 显示队列的所有数据
	 */
	public void showQueue() {
		if (isEmpty()) {
			System.out.println("队列为空，无数据~！！");
			return;
		}
		// 若不为空，则遍历数组输出
		for (int i=0;i<arr.length;i++) {
			System.out.printf("arr[%d]=%d\n",i,arr[i]);
		}
	}

	/**
	 * 显示队列的头数据，注意不是取出数据
	 */
	public int headQueue() {
		// 判断看队列是否为空
		if (isEmpty()) {
			throw new RuntimeException("队列为空！！！！！！！！！");
		}
		return arr[front + 1];
	}
}