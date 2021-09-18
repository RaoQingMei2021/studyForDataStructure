package com.guet.optical.rqm.first20210915to20210922;

import java.util.Scanner;

/**
 * ʹ������ģ�����
 * 
 * @author Rao'Q'ing'M'ei
 *
 */
public class ArrayQueueDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// ��������ʵ�ֶ���
		// ����һ������
		ArrayQueue arrayQueue = new ArrayQueue(3);
		char key = ' ';// �����û�����
		Scanner scanner = new Scanner(System.in);
		boolean loop = true;
		while (loop) {
			System.out.println("s(show):��ʾ����");
			System.out.println("e(eixt):�˳�����");
			System.out.println("a(add):������ݵ�����");
			System.out.println("g(get):�Ӷ���ȡ������");
			System.out.println("h(head):�鿴����ͷ������");
			key = scanner.next().charAt(0);// ����һ���ַ�
			switch (key) {
			case 's':
				arrayQueue.showQueue();
				break;
			case 'a':
				System.out.println("������һ����");
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
					System.out.printf("����ͷ��������%d\n", res);
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println(e.getMessage());
				}
				break;
			case 'e':
				scanner.close();// �ر�scanner����������쳣����
				loop = false;
				break;
			default:
				break;
			}
		}
		System.out.println("�����˳�������");
	}

}

//ʹ������ģ�����-��дһ��ArrayQueue��
class ArrayQueue {
	private int maxSize;// ��ʾ������������
	private int front;// ����ͷ
	private int rear;// ����β
	private int[] arr;// ���������ڴ�����ݣ�ģ�����

	/**
	 * �������еĹ�����
	 * 
	 */
	public ArrayQueue(int arrMaxSize) {
		super();
		this.maxSize = arrMaxSize;
		arr = new int[maxSize];
		front = -1;// ָ�����ͷ����������front��ָ�����ͷ��ǰһ��λ��
		rear = -1;// ָ�����β��ָ�����β�����ݣ������е����һ�����ݣ�

	}

	/**
	 * �ж϶����Ƿ���
	 * 
	 */
	public boolean isFull() {
		return rear == maxSize - 1;
	}

	/**
	 * �ж϶����Ƿ�Ϊ��
	 */
	public boolean isEmpty() {
		return rear == front;
	}

	/**
	 * ������ݵ�����
	 */
	public void addQueue(int n) {
		// ��Ҫ�ж϶����Ƿ����������ˣ���Ӳ���ȥ
		if (isFull()) {
			System.out.println("�������������ʧ�ܣ���");
			return;
		}
		rear++;// ��rear����
		arr[rear] = n;
	}

	/**
	 * ��ȡ���е�����/���ݳ�����
	 */
	public int getQueue() {
		if (isEmpty()) {
			// ����Ϊ�գ�ͨ���׳��쳣������
			throw new RuntimeException("����Ϊ�գ�����ȡ���ݣ���");
			// ע�⣺�����ﲻ��дreturn����Ϊ�׳��쳣֮�󣬾�ֹͣ��������������У�
		}
		front++;
		System.out.println("**************���ȡ������֮���ָ���ͷ����ֵfront:"+front);
		return arr[front];
		/**
		 * ע:�ó����е�ʵ�ַ�ʽ��������.������ȡ��,ֻ��frontͷָ���ƶ�,�������������Ԫ��δ�޳�����.��ɵ��������
		 * ��ȡ������ʾ����Ϊ��,������;�����������������ʱ����ʾ��������,�޷��������
		 * 
		 * �����ʹ���㷨�������Ϊ��������
		 */
	}

	/**
	 * ��ʾ���е���������
	 */
	public void showQueue() {
		if (isEmpty()) {
			System.out.println("����Ϊ�գ�������~����");
			return;
		}
		// ����Ϊ�գ�������������
		for (int i=0;i<arr.length;i++) {
			System.out.printf("arr[%d]=%d\n",i,arr[i]);
		}
	}

	/**
	 * ��ʾ���е�ͷ���ݣ�ע�ⲻ��ȡ������
	 */
	public int headQueue() {
		// �жϿ������Ƿ�Ϊ��
		if (isEmpty()) {
			throw new RuntimeException("����Ϊ�գ�����������������");
		}
		return arr[front + 1];
	}
}