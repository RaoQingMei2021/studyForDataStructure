package com.guet.optical.rqm.second202110to20211007;

public class SingleLinkedListDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       /**
        * 测试代码
        */
		//创建节点  
		HeroNode heroNode1 = new HeroNode(1,"宋江","及时雨");
		HeroNode heroNode2 = new HeroNode(2,"卢俊义","玉麒麟");
		HeroNode heroNode3 = new HeroNode(3,"吴用","智多星");
		HeroNode heroNode4 = new HeroNode(4,"林冲","豹子头");
		
		//加入
		//创建链表
		SingleLinkedList singleLinkedList = new SingleLinkedList();
		//加入

		singleLinkedList.add1(heroNode2);
		singleLinkedList.add1(heroNode1);
		singleLinkedList.add1(heroNode3);
		singleLinkedList.add1(heroNode4);
		//显示
		singleLinkedList.list();
		System.out.println("*************以下为添加后按顺序输出的添加方法的测试***************");
		//加入
		//创建链表
		SingleLinkedList singleLinkedList1 = new SingleLinkedList();
		singleLinkedList1.add2(heroNode2);
		singleLinkedList1.add2(heroNode1);
		singleLinkedList1.add2(heroNode3);
		singleLinkedList1.add2(heroNode4);
		//显示
		singleLinkedList1.list();
	}

}
//定义一个singleLinkedList  管理英雄
class SingleLinkedList{
	//先初始化一个头节点，头节点不能动【基于遍历的时候的考虑】，不存放具体的数据
	private HeroNode head=new HeroNode(0,"","");
	
	/**
	 * 添加节点到单向列表，
	 * 当不考虑编号顺序时，
	 * 1、找到当前列表的最后节点
	 * 2、将最后这个节点的next指向新的节点
	 * 
	 * 该方法为考虑编号顺序【此外实现的可以是，考虑顺序编号，按顺序显示，如果有了输入的编号，则其实相应的信息】
	 */
	public void add1(HeroNode heroNode) {
		//因为head节点不能动，因此需要辅助节点，辅助遍历。temp
		HeroNode temp=head;
		//遍历链表，找到最后节点
		while(true){
			if(temp.next==null) {
				//找到链表的最后
				break;	
			}
            //如果没有找到，next就往后移
			temp=temp.next;			
		}
		//当退出while循环时，temp就指向链表的最后
		temp.next=heroNode;
	}
	
	/**
	 * 添加的第二种方法：按顺序添加，如果已经有了某一编号，则提示相应的信息
	 * 
	 * 1、首先找到新添加的节点的位置。通过辅助变量（与指针的概念相似）找到【重点，通过遍历找到】
	 * 2、新的节点.next=temp.next
	 * 3、将temp.next=新的节点
	 */
	public void add2(HeroNode heroNode) {
		//因为头节点不能动，依旧通过辅助节指针（变量）找到添加的位置
		//因为是单链表，因为找到的temp是位于添加位置的前一个节点，否侧插入不了
	   HeroNode temp=head;
	   boolean flag=false;//标志添加的编号是否存在，默认为false
	   while(true) {
		   if(temp.next==null) {//说明temp已经在链表的最后
			   break;
		   }
		   if(temp.next.no>heroNode.no) {//位置找到了，位置就在temp后【如果用temp比较的话，就是temp编号比要插入的小，但此时无法控制temp的下一个节点的编号比要插入的大】
			   break;
		   }else if(temp.next.no==heroNode.no) {//说明希望添加的heroNode的编号已经存在
			   flag=true;//说明编号存在
			   break;
		   }
		   temp=temp.next;//后移，遍历当前链表
	   }
	   //判断flag的值，=
	   if(flag) {//不能添加，说明编号存在
		   System.out.printf("准备插入的英雄的编号%d已经存在，不能添加\n",heroNode.no);
	   }else {
		   //插入到链表中，temp后面
		   heroNode.next=temp.next;
		   temp.next=heroNode;
	   }
	}
	
	/**
	 * 显示链表
	 */
	public void list() {
		//判断链表是否为空
		if(head.next==null) {
			System.out.println("链表为空！！");
			return;
		}
		//因为头节点不能动，因此需要辅助变量遍历链表
		HeroNode temp=head.next;
		while(true) {
			//判断是否再链表的最后
			if(temp==null) {
				break;
			}
			//输出节点信息
			System.out.println(temp);
			//将next后移
			temp=temp.next;
		}
	}
}

/**
*定义HeroNode，每个HeroNode对象就是一个节点
*/
class HeroNode{
	public int no;
	public String name;
	public String nickname;//表示昵称
	public HeroNode next;//指向下一个节点
	//构造器
	public HeroNode(int no, String name, String nickname) {
		super();
		this.no = no;
		this.name = name;
		this.nickname = nickname; 
	}
   //为了显示方便，重写toString方法
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return  "HeroNode no="+no+",name="+name+",nickName="+nickname;
	}
	
} 