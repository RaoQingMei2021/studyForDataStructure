package com.guet.optical.rqm.second202110to20211007;

/**
 * 双向链表的学习：遍历、添加、修改、删除
 * 
 * @author Rao'Q'ing'M'ei
 *
 */
public class DoubleLinkedListDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 测试
		System.out.println("********双向链表的测试********");
		// 先创建节点
		HeroNodeD heroNodeD1 = new HeroNodeD(1, "宋江", "及时雨");
		HeroNodeD heroNodeD2 = new HeroNodeD(2, "卢俊义", "玉麒麟");
		HeroNodeD heroNodeD3 = new HeroNodeD(3, "吴用", "智多星");
		HeroNodeD heroNodeD4 = new HeroNodeD(4, "林冲", "豹子头");
		
		//创建双向列表对象
		DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
		//添加节点对象
		doubleLinkedList.add(heroNodeD1);
		doubleLinkedList.add(heroNodeD2);
		doubleLinkedList.add(heroNodeD3);
		doubleLinkedList.add(heroNodeD4);
		
		System.out.println("*********输出添加节点后的双向链表*********");
		doubleLinkedList.list();
		
 	//修改
		System.out.println("*******测试双向链表的修改方法*********");
		HeroNodeD newHeroNode=new HeroNodeD(4,"公孙胜","入云龙");
		doubleLinkedList.update(newHeroNode);
		System.out.println("*************修改后的链表情况***************");
		doubleLinkedList.list();
	
		//删除
		System.out.println("**********测试双向链表的删除方法**********");
		System.out.println("##############删除节点3前的双向链表################");
		doubleLinkedList.list();
		doubleLinkedList.del(3);
		System.out.println("##############删除节点3后的双向链表################");
		doubleLinkedList.list();
	}

}

/**
 * 创建双向链表的类
 * 
 * @author Rao'Q'ing'M'ei
 *
 */
class DoubleLinkedList {
	// 初始化头节点，头节点不动，不存放具体的数据
	private HeroNodeD head = new HeroNodeD(0, "", "");

	/**
	 * 返回头节点
	 * 
	 * @return
	 */
	public HeroNodeD getHead() {
		return head;
	}

	/**
	 * 遍历双向链表
	 */
	public void list() {
		// 判断链表是否为空
		if (head.next == null) {
			System.out.println("链表为空");
			return;
		}
		// 因为头节点不能动，因此需要一个辅助节点来遍历
		HeroNodeD temp = head.next;
		while (true) {
			// 判断是否到链表的最后
			if (temp.next == null) {
				break;
			}
			// 输出节点的信息
			System.out.println(temp);
			// 将节点后移
			temp = temp.next;
		}
	}

	/**
	 * 添加一个节点到双向链表的最后
	 * 
	 * @param heroNode
	 */
	public void add(HeroNodeD heroNode) {
		// 因为head不能动，因此需要一个辅助变量遍历temp
		HeroNodeD temp = head;
		// 遍历链表，找到最后
		while (true) {
			// 找到链表的最后
			if (temp.next == null) {
				break;
			}
			// 如果没有找到最后，将temp后移
			temp = temp.next;
		}
		// 当退出while循环时，temp就指向了链表的最后
		// 形成一个双向链表
		temp.next = heroNode;
		heroNode.pre = temp;
	}

	/**
	 * 修改双向链表 可以看到和单向链表的一样，只是节点的类型改变
	 * 
	 * @param newHeroNode
	 */
	public void update(HeroNodeD newHeroNode) {
		// 判断是否为空
		if (head.next == null) {
			System.out.println("链表为空~");
			return;
		}
		// 找到需要修改的节点，根据no编号修改
		// 定义一个辅助变量
		HeroNodeD temp = head.next;
		boolean flag = false;// 表示是否找到该节点
		while (true) {
			if (temp == null) {
				break;// 已经遍历完链表
			}
			if (temp.no == newHeroNode.no) {
				// 找到
				flag = true;
				break;
			}
			temp = temp.next;
		}
		// 根据flag判断是否找到要修改的节点
		if (flag) {
			temp.name = newHeroNode.name;
			temp.nickName = newHeroNode.nickName;
		} else {// 没有找到
			System.out.printf("没有找到编号%d的节点，不能修改\n", newHeroNode.no);
		}
	}

	/**
	 * 删除节点
	 * 
	 * @param no
	 */
	public void del(int no) {
		// 判断当前链表是否为空
		if (head.next == null) {// 空链表
			System.out.println("当前链表为空，无法删除！");
			return;
		}
		HeroNodeD temp = head.next; // 辅助变量/指针【这里相比较于单向链表时加入了next，表明是从第一个数据节点开始查询，可以自我删除；
									// 但单向链表中是head，是因为删除时的查询需要找到是待删除节点的上一个节点】
		boolean flag = false;// 标注是否找到了待删除的节点
		while (true) {
			if (temp == null) {// 已经到链表的最后
				break;
			}
			if (temp.no == no) {
				// 找到待删除的节点
				flag = true;
				break;
			}

			temp = temp.next;
		}
		// 判断flag
		if (flag) {// 找到
			// 可以删除
			temp.pre.next = temp.next;
			// 需要一个处理，如果事情最后一个节点，就不需要执行temp.next.pre=temp.pre这句话，否则就出现空指针
			// temp.next.pre=temp.pre;//仅仅是这样子写存在问题：删除的节点为最后的节点时，temp.next就为null
			if (temp.next != null) {
				temp.next.pre = temp.pre;
			}

		} else {
			System.out.printf("要删除的%d节点不存在", no);
		}
	}
}

/**
 * 定义HeroNodeD，每个HeroNodeD对象就是一个节点
 * 
 * @author Rao'Q'ing'M'ei
 *
 */
class HeroNodeD {
	public int no;
	public String name;
	public String nickName;
	HeroNodeD pre;// 指向前一个节点，默认为null
	HeroNodeD next;// 指向下一个节点，默认为null

	/**
	 * 构造器
	 * 
	 * @param no
	 * @param name
	 * @param nickName
	 */
	public HeroNodeD(int no, String name, String nickName) {
		super();
		this.no = no;
		this.name = name;
		this.nickName = nickName;
	}

	/**
	 * 为了显示方便，重写toString方法
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "HerNode   no=" + no + ",name=" + name + ",nickName=" + nickName;
	}
}