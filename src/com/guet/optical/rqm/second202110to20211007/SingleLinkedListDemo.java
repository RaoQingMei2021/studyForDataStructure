package com.guet.optical.rqm.second202110to20211007;

import java.util.Stack;

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
		
		
		/**
		 * 测试修改链表的代码
		 */
		System.out.println("*******测试修改代码**********");
		HeroNode newHeroNode=new HeroNode(2,"小卢","玉麒麟~~~");
		singleLinkedList1.update(newHeroNode);
		//显示
		singleLinkedList1.list();
		
		
		/**
		 * 测试删除节点方法的代码
		 */
//		singleLinkedList1.del(1);//测试删除第一个【一般出问题容易在第一个以及最后一个】
//		singleLinkedList1.del(2); 
//		System.out.println("**********删除后的列表**********");
//		singleLinkedList1.list();
		
		/**
		 * 测试单链表的有效节点个数
		 */
		System.out.println("有效的节点个数为："+getLength(singleLinkedList1.getHead()));
		/**
		 * 测试获取倒数第k个节点的代码
		 */
		System.out.println("**************测试获取倒数第k个节点的代码************");
		HeroNode res=findLastIndexNode(singleLinkedList.getHead(),2);
		System.out.println("res="+res);
		
		/**
		 * 测试链表的反转的代码
		 */
		System.out.println("*********测试链表反转的代码********"); 
		System.out.println("*********反转之前的链表********"); 
//		SingleLinkedList reverseList=reverseLinkedList(singleLinkedList1);
//		reverseList.list();
		singleLinkedList1.list();
		System.out.println("*********反转之后的链表********"); 
		reverseList(singleLinkedList1.getHead());
		singleLinkedList1.list();
		
		
		/**
		 * 测试利用栈实现链表的逆序打印
		 */
		System.out.println("*********测试单链表的逆序打印【未改变链表本身的结构】************");
		reversePrint(singleLinkedList1.getHead());
	}
	/**
	 * 方式2：可利用**栈**这个数据结构，将各个节点压入到栈中，然后利用栈的先进后厨的特点实现逆序打印的效果
	 * 实现链表的逆序打印
	 */
	public static void reversePrint(HeroNode head) {
		if(head.next==null){//为空链表
			System.out.println("为空链表无法打印~");
			return;
		}
		//创建一个栈，将各个节点压入栈中
		Stack<HeroNode> stack = new Stack<HeroNode>();
		HeroNode cur=head.next;
		//将链表的所有节点压入栈中
		while(cur!=null) {
			stack.push(cur);
			cur=cur.next;//cur后移
		}
		//将栈中的节点打印
		while(stack.size()>0){
			System.out.println(stack.pop());
		}
	}
	
	
	/**
	 * 链表的反向遍历
	 */
/**	//自己写的，代码有问题
	public static SingleLinkedList reverseLinkedList(SingleLinkedList list) {
		SingleLinkedList reverseList=new SingleLinkedList();
		HeroNode reverseHead=reverseList.getHead();
		HeroNode head=list.getHead();
		HeroNode temp=head.next;
		while(!(temp==null)) {//未遍历完原来的链表
			//temp=temp.next;
			temp.next=reverseHead.next;
			reverseHead.next=temp;
			temp=temp.next;
		}
		return reverseList;
	}
*/	
	//视频给出的
	public static  void reverseList(HeroNode head) {
		//如果当前链表为空，或者只有一个节点，无需反转，直接返回
		if(head.next==null||head.next.next==null) {
			return;
		}
		//定义辅助地指针/变量，帮助遍历原来的链表
		HeroNode cur=head.next;
		HeroNode next=null;//指向当前节点cur的下一个节点
		HeroNode reverseHead=new HeroNode(0,"","");
		//遍历原来的列表，每遍历一个节点，就将其取出，并放在新的链表reverseHead的最前端
		while(cur!=null) {//cur不能为空 
			next=cur.next;//先暂时保存当前节点的下一个节点，因为后面需要使用
			cur.next=reverseHead.next;//将cur的下一个节点指向新的链表的最前端
			reverseHead.next=cur;//将cur链接到新的链表上
			cur=next;//让cur后移
		}
		//将head.next指向reverseHead.next，实现单链表的反转
		head.next=reverseHead.next;
	}
	
	/**
	 * 查找单链表中的倒数第k个节点
	 * 思路
	 * 1、编写一个方法接收head节点，提示接收一个index，
	 * 2、index表示的是倒数第index个节点
	 * 3、先把链表从头到尾遍历，得到链表总的长度getlength
	 * 4、得到size后，从链表的第个开始遍历size-index个
	 * 5、如果找到了就返回该节点，否则返回null
	 */
	public static HeroNode findLastIndexNode(HeroNode head,int index) {
		//判断，如果链表为空，返回null
		if(head.next==null) {
			return null;//没有找到
		}
		//第一次遍历得到链表的长度（节点个数）
		int size=getLength(head);
		//第二次遍历  size-index 位置，就是我们倒数的第k个节点
		//先做一个index的校验
		if(index<=0||index>size) {
			System.out.println("索引无效！！");
			return null;
		}
		//定义一个辅助变量,for循环定位到倒数的index
		HeroNode cur=head.next;
		for(int i=0;i<size-index;i++) {
			cur=cur.next;
		}
		return cur;
	}
	
     
	/**
	 * 方法：获取单链表中的有效节点的个数(如果是待=带头节点的链表，需求不统计头节点)
	 */
	/**
	 * 
	 * @param head  链表的头节点
	 * @return   返回的是链表有效节点的个数
	 */
	public static int getLength(HeroNode head) {
		if(head.next==null) {//空链表
			return 0;
		}
		int length=0;
		//定义一个辅助变量，没有统计头节点
		HeroNode cur=head.next;
		while(cur!=null) {
			length++;
			cur=cur.next;
		}
		return length;
	}
}
//定义一个singleLinkedList  管理英雄
class SingleLinkedList{
	//先初始化一个头节点，头节点不能动【基于遍历的时候的考虑】，不存放具体的数据
	private HeroNode head=new HeroNode(0,"","");
	
	 
	//返回头节点
	public HeroNode getHead() {
		return head;
	}

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
	 * 根据编号修改节点的信息，即规定编号不能修改
	 * 根据节点的编号修改，节点设为newHeroNode  编号为no
	 */
	public void update(HeroNode newHeroNode) {
		//判断是否为空
		if(head.next==null) {
			System.out.println("链表为空！！");
		}
		//找到需要修改的节点，根据no编号
		//定义一个辅助变量
		HeroNode temp=head.next;
		boolean flag=false;//表示是否找到节点
		while(true) {
			if(temp==null) {
				break;//到链表的最后，已经遍历完链表
			}
			if(temp.no==newHeroNode.no) {
				//找到
				flag=true;
				break;
			}
			temp=temp.next;
		}
		//根据flag判断是否找到要修改的节点
		if(flag) {
			temp.name=newHeroNode.name;
			temp.nickname=newHeroNode.nickname;
		}else {//没有找到需要修改的节点
			System.out.printf("没有找到编号%d的节点\n",newHeroNode.no);
		}
	}
	
	/**
	 * 删除节点，根据编号
	 * 思路
	 * 1、head节点不能动，因此需要辅助节点找到待删除节点的前一个节点
	 * 2、说明在比较时，是temp.next.no与需要删除的节点的no比较
	 */
	public void del(int no) {
		/**
		 * 自己写的【逻辑漏洞在于没考虑没找到的情况，所写的代码不会给任何提示】
		 */
//		//根据编号删除链表的数据
//		//查看链表是否为空
//		if(head.next==null) {
//			System.out.println("链表为空！！");
//		}
//		HeroNode temp =head;
//		//遍历链表
//		while(true) {
//			if(temp.next==null) {
//				break;
//			}
//			if(temp.next.no==no) {
//				temp.next=temp.next.next;
//				break;
//			}
//			temp=temp.next;
//		}
		/**
		 * 视频给出的
		 */
		HeroNode temp=head;
		boolean flag=false;//标志是否找到待删除的节点
		while(true) {
			if(temp.next==null) {//已经到链表的最后
				break;
			}
			if(temp.next.no==no) {
				//找到的的待删除的节点的前一个节点
				flag=true;
				break;
			}
			temp=temp.next;
		}
		if(flag) {//找到
			//可以删除
			temp.next=temp.next.next;
		}else {
			System.out.printf("要删除的节点%d不存在\n",no);
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