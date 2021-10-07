package com.guet.optical.rqm.second202110to20211007;

public class Josephu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         //测试构建环形链表，和环形链表的遍历
		CircleSingleLinkedList circleLinkedList = new CircleSingleLinkedList();
		circleLinkedList.addBoy(5);//加入5个节点小孩
		circleLinkedList.showBoy();
		
		//测试小孩出圈的顺序
		circleLinkedList.countBoy(1, 2, 5);
	}

}

/**
 * 创建一个单向的环形链表
 * @author Rao'Q'ing'M'ei
 *
 */
class CircleSingleLinkedList{
	//创建一个first节点，当前没有编号
	private Boy first=new Boy(1);
	
	//添加小孩节点，构建成一个环形链表
	public void addBoy(int nums) {//nums表示需要创建节点的个数
		//为防止传进来的nums为负数，因此需要对nums做一个数据校验
		if(nums<1) {
			System.out.println("nums的值不正确");
			return;
		}
		//使用for循环创建环形链表
		Boy curBoy=null;//辅助指针，帮助构建环形链表
		for(int i=1;i<=nums;i++) {
			//根据编号创建小孩节点
			Boy boy=new Boy(i);
			//如果是第一个小孩
			if(i==1) {
				first=boy;
				first.setNext(first);//构成环
				curBoy=first;//让curBoy指向第一个小孩
			}else {
				curBoy.setNext(boy);
				boy.setNext(first);
				curBoy=boy;
			}
		}
		
	}
	
	/**
	 * 显示环形链表
	 */
	public void showBoy() {
		//判断链表是否为空
		if(first==null) {//链表为空
			System.out.println("没有任何小孩~");
			return;
		}
		//因为first不能动，因此仍然使用辅助指针完成遍历
		Boy curBoy=first;
		while(true) {
			System.out.printf("小孩的编号 %d \n",curBoy.getNo());
			//判断是否到最后
			if(curBoy.getNext()==first) {//说明遍历完毕
				break;
			}
			curBoy=curBoy.getNext();//让curBoy指针后移
		}
	}

/**
 * 小孩节点出圈
 * @param startNo 表示从第几个小孩开始
 * @param countNum  表示数多少下
 * @param nums  表示最初有多少个小孩
 */
	public void countBoy(int startNo,int countNum,int nums) {
		//先对数据进行校验
		if(first==null||startNo<1||startNo>nums) {//环形队列为空
			System.out.println("输入参数有问题，请重新输入");
		}
		
		//创建辅助节点
		Boy helper=first;
		//1、需求创建辅助指针/变量helper，事先应该指向环形链表的最后这个节点
		while(true) {
			if(helper.getNext()==first) {//说明helpser指向最后的小孩节点
				break;
			}
			helper=helper.getNext();			
		}
		//2、当小孩报数时，先让first和helper移动k-1次
		for(int j=0;j<startNo-1;j++) {
			first=first.getNext();
			helper=helper.getNext();
		}
		//3、当小孩报数时，让first和helper指针同时移动m-1次，然后出圈
		while(true) {
			if(helper==first) {//说明圈中只有一人
				break;
			}
			//让first和helper指针同时移动countNum-1次
			for(int j=0;j<countNum-1;j++) {
				first=first.getNext();
				helper=helper.getNext();//让helper移动
			}
			//这时first指向的节点就是要出圈小孩
			System.out.printf("小孩%d出圈",first.getNo());
			first=first.getNext();//让first指向的节点由出圈的节点变化为待出圈节点的下一个节点
			helper.setNext(first);//让helper的下一个节点指向待删除节点后的下一个节点
		}
		System.out.printf("最后留在圈中的小孩编号%d\n",helper.getNo());
	}
	
}

/**
 * 创建一个Boy类，表示一个节点
 * @author Rao'Q'ing'M'ei
 *
 */
class Boy{
	private int no;//编号
	private Boy next;//指向下一节点，默认为空
	
	/**
	 * 构造器
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