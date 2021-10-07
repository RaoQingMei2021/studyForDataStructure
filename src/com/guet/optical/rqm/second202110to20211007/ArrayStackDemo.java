package com.guet.optical.rqm.second202110to20211007;

import java.util.Scanner;

public class ArrayStackDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        //��������ʵ�ֵ�ջ
		//����һ��arrayStack���󣬱�ʾһ��ջ
		ArrayStack stack = new ArrayStack(4);
		String key="";//��ż�������Ĳ���ָ��w
		boolean loop=true;//�����Ƿ��˳��˵�
		Scanner scanner = new Scanner(System.in);
		
		while(loop) {
			System.out.println("show����ʾ��ʾջ");
			System.out.println("exit����ʾ�˳�����");
			System.out.println("push����ʾ������ݵ�ջ");
			System.out.println("pop����ʾ��ջ��ȡ������");
			System.out.print("��������Ĳ���ѡ��");
			key=scanner.next();
			switch(key) {
			case "show":
				stack.list();
				break;
			case "push":
				System.out.println("������һ������");
				int value=scanner.nextInt();
				stack.push(value);
				break;
			case "pop":
				try {
					int res=stack.pop();//���û�н��յ��쳣���ڳ�ջʱ���ܻ��׳��쳣�������ִ����һ�����
					System.out.println("��ջ������Ϊ��"+res);
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println(e.getMessage());
				}
				break;
			case "exit":
				scanner.close();//�ر�scanner������
				loop=false;
				//System.out.println("�����Ѱ�ȫ�˳�~");?���˳�������ʾ�Ĵ���Ϊʲô����whileѭ��֮��
				break;
			default:
				break;
			}
		}
		System.out.println("�����Ѱ�ȫ�˳�~");
	}

}

/**
 * ����һ���࣬��ʾջ
 * @author Rao'Q'ing'M'ei
 *
 */
class ArrayStack{
	private int maxSize;//ջ�Ĵ�С
	private int[] stack;//���飬����ģ�⣬���ݷ��ڸ�������
	private int top=-1;//��ʾջ������ʼ��Ϊ-1����ʾû������
	
	/**
	 * ������
	 * @param maxSize
	 */
	public ArrayStack(int maxSize) {
		super();
		this.maxSize = maxSize;
		stack=new int[this.maxSize];//��������ʼ���������������
	}
	
	/**
	 * �ж��Ƿ�ջ��
	 * @return
	 */
	public boolean isFull() {
		return top==maxSize-1;
	}
	
	/**
	 * �ж�ջ��
	 * @return
	 */
	public boolean isEmpty() {
		return top==-1;
	}
	
	/**
	 * ��ջ����
	 * @param value
	 */
	public void push(int value) {
		//�ж�ջ��
		if(isFull()){
			System.out.println("ջ��");
			return;
		}
		top++;
		stack[top]=value;
	}

	/**
	 * ��ջ����
	 * @return
	 */
	public int pop() {
		//���ж�ջ�Ƿ��
		if(isEmpty()) {
			//�׳��쳣
			throw new RuntimeException("ջ�գ������ݿɳ�ջ");//��ʹ��return�����𣿡����ʹ��returnֹͣ�÷��������У���û�з���ֵ���ᱨ��
		}
		int value=stack[top];
		top--;
		return value;
	}

	/**
	 * ����ջ����ʾջ
	 */
	public void list() {
		//�ж��Ƿ�ջ��
		if(isEmpty()) {
			System.out.println("ջ�գ�������~");
			return;
		}
		for(int i=top;i>=0;i--) {
			System.out.printf("stack[%d]=%d\n",i,stack[i]);
		}
	}
}