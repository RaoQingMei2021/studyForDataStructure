package com.guet.optical.rqm.second202110to20211007;

public class Josephu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         //���Թ������������ͻ�������ı���
		CircleSingleLinkedList circleLinkedList = new CircleSingleLinkedList();
		circleLinkedList.addBoy(5);//����5���ڵ�С��
		circleLinkedList.showBoy();
		
		//����С����Ȧ��˳��
		circleLinkedList.countBoy(1, 2, 5);
	}

}

/**
 * ����һ������Ļ�������
 * @author Rao'Q'ing'M'ei
 *
 */
class CircleSingleLinkedList{
	//����һ��first�ڵ㣬��ǰû�б��
	private Boy first=new Boy(1);
	
	//���С���ڵ㣬������һ����������
	public void addBoy(int nums) {//nums��ʾ��Ҫ�����ڵ�ĸ���
		//Ϊ��ֹ��������numsΪ�����������Ҫ��nums��һ������У��
		if(nums<1) {
			System.out.println("nums��ֵ����ȷ");
			return;
		}
		//ʹ��forѭ��������������
		Boy curBoy=null;//����ָ�룬����������������
		for(int i=1;i<=nums;i++) {
			//���ݱ�Ŵ���С���ڵ�
			Boy boy=new Boy(i);
			//����ǵ�һ��С��
			if(i==1) {
				first=boy;
				first.setNext(first);//���ɻ�
				curBoy=first;//��curBoyָ���һ��С��
			}else {
				curBoy.setNext(boy);
				boy.setNext(first);
				curBoy=boy;
			}
		}
		
	}
	
	/**
	 * ��ʾ��������
	 */
	public void showBoy() {
		//�ж������Ƿ�Ϊ��
		if(first==null) {//����Ϊ��
			System.out.println("û���κ�С��~");
			return;
		}
		//��Ϊfirst���ܶ��������Ȼʹ�ø���ָ����ɱ���
		Boy curBoy=first;
		while(true) {
			System.out.printf("С���ı�� %d \n",curBoy.getNo());
			//�ж��Ƿ����
			if(curBoy.getNext()==first) {//˵���������
				break;
			}
			curBoy=curBoy.getNext();//��curBoyָ�����
		}
	}

/**
 * С���ڵ��Ȧ
 * @param startNo ��ʾ�ӵڼ���С����ʼ
 * @param countNum  ��ʾ��������
 * @param nums  ��ʾ����ж��ٸ�С��
 */
	public void countBoy(int startNo,int countNum,int nums) {
		//�ȶ����ݽ���У��
		if(first==null||startNo<1||startNo>nums) {//���ζ���Ϊ��
			System.out.println("������������⣬����������");
		}
		
		//���������ڵ�
		Boy helper=first;
		//1�����󴴽�����ָ��/����helper������Ӧ��ָ����������������ڵ�
		while(true) {
			if(helper.getNext()==first) {//˵��helpserָ������С���ڵ�
				break;
			}
			helper=helper.getNext();			
		}
		//2����С������ʱ������first��helper�ƶ�k-1��
		for(int j=0;j<startNo-1;j++) {
			first=first.getNext();
			helper=helper.getNext();
		}
		//3����С������ʱ����first��helperָ��ͬʱ�ƶ�m-1�Σ�Ȼ���Ȧ
		while(true) {
			if(helper==first) {//˵��Ȧ��ֻ��һ��
				break;
			}
			//��first��helperָ��ͬʱ�ƶ�countNum-1��
			for(int j=0;j<countNum-1;j++) {
				first=first.getNext();
				helper=helper.getNext();//��helper�ƶ�
			}
			//��ʱfirstָ��Ľڵ����Ҫ��ȦС��
			System.out.printf("С��%d��Ȧ",first.getNo());
			first=first.getNext();//��firstָ��Ľڵ��ɳ�Ȧ�Ľڵ�仯Ϊ����Ȧ�ڵ����һ���ڵ�
			helper.setNext(first);//��helper����һ���ڵ�ָ���ɾ���ڵ�����һ���ڵ�
		}
		System.out.printf("�������Ȧ�е�С�����%d\n",helper.getNo());
	}
	
}

/**
 * ����һ��Boy�࣬��ʾһ���ڵ�
 * @author Rao'Q'ing'M'ei
 *
 */
class Boy{
	private int no;//���
	private Boy next;//ָ����һ�ڵ㣬Ĭ��Ϊ��
	
	/**
	 * ������
	 * @param no
	 */
	public Boy(int no) {
		super();
		this.no = no;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public Boy getNext() {
		return next;
	}

	public void setNext(Boy next) {
		this.next = next;
	}
    
	
}