package com.guet.optical.rqm.second202110to20211007;

/**
 * ˫�������ѧϰ����������ӡ��޸ġ�ɾ��
 * 
 * @author Rao'Q'ing'M'ei
 *
 */
public class DoubleLinkedListDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// ����
		System.out.println("********˫������Ĳ���********");
		// �ȴ����ڵ�
		HeroNodeD heroNodeD1 = new HeroNodeD(1, "�ν�", "��ʱ��");
		HeroNodeD heroNodeD2 = new HeroNodeD(2, "¬����", "������");
		HeroNodeD heroNodeD3 = new HeroNodeD(3, "����", "�Ƕ���");
		HeroNodeD heroNodeD4 = new HeroNodeD(4, "�ֳ�", "����ͷ");
		
		//����˫���б����
		DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
		//��ӽڵ����
		doubleLinkedList.add(heroNodeD1);
		doubleLinkedList.add(heroNodeD2);
		doubleLinkedList.add(heroNodeD3);
		doubleLinkedList.add(heroNodeD4);
		
		System.out.println("*********�����ӽڵ���˫������*********");
		doubleLinkedList.list();
		
 	//�޸�
		System.out.println("*******����˫��������޸ķ���*********");
		HeroNodeD newHeroNode=new HeroNodeD(4,"����ʤ","������");
		doubleLinkedList.update(newHeroNode);
		System.out.println("*************�޸ĺ���������***************");
		doubleLinkedList.list();
	
		//ɾ��
		System.out.println("**********����˫�������ɾ������**********");
		System.out.println("##############ɾ���ڵ�3ǰ��˫������################");
		doubleLinkedList.list();
		doubleLinkedList.del(3);
		System.out.println("##############ɾ���ڵ�3���˫������################");
		doubleLinkedList.list();
	}

}

/**
 * ����˫���������
 * 
 * @author Rao'Q'ing'M'ei
 *
 */
class DoubleLinkedList {
	// ��ʼ��ͷ�ڵ㣬ͷ�ڵ㲻��������ž��������
	private HeroNodeD head = new HeroNodeD(0, "", "");

	/**
	 * ����ͷ�ڵ�
	 * 
	 * @return
	 */
	public HeroNodeD getHead() {
		return head;
	}

	/**
	 * ����˫������
	 */
	public void list() {
		// �ж������Ƿ�Ϊ��
		if (head.next == null) {
			System.out.println("����Ϊ��");
			return;
		}
		// ��Ϊͷ�ڵ㲻�ܶ��������Ҫһ�������ڵ�������
		HeroNodeD temp = head.next;
		while (true) {
			// �ж��Ƿ���������
			if (temp.next == null) {
				break;
			}
			// ����ڵ����Ϣ
			System.out.println(temp);
			// ���ڵ����
			temp = temp.next;
		}
	}

	/**
	 * ���һ���ڵ㵽˫����������
	 * 
	 * @param heroNode
	 */
	public void add(HeroNodeD heroNode) {
		// ��Ϊhead���ܶ��������Ҫһ��������������temp
		HeroNodeD temp = head;
		// ���������ҵ����
		while (true) {
			// �ҵ���������
			if (temp.next == null) {
				break;
			}
			// ���û���ҵ���󣬽�temp����
			temp = temp.next;
		}
		// ���˳�whileѭ��ʱ��temp��ָ������������
		// �γ�һ��˫������
		temp.next = heroNode;
		heroNode.pre = temp;
	}

	/**
	 * �޸�˫������ ���Կ����͵��������һ����ֻ�ǽڵ�����͸ı�
	 * 
	 * @param newHeroNode
	 */
	public void update(HeroNodeD newHeroNode) {
		// �ж��Ƿ�Ϊ��
		if (head.next == null) {
			System.out.println("����Ϊ��~");
			return;
		}
		// �ҵ���Ҫ�޸ĵĽڵ㣬����no����޸�
		// ����һ����������
		HeroNodeD temp = head.next;
		boolean flag = false;// ��ʾ�Ƿ��ҵ��ýڵ�
		while (true) {
			if (temp == null) {
				break;// �Ѿ�����������
			}
			if (temp.no == newHeroNode.no) {
				// �ҵ�
				flag = true;
				break;
			}
			temp = temp.next;
		}
		// ����flag�ж��Ƿ��ҵ�Ҫ�޸ĵĽڵ�
		if (flag) {
			temp.name = newHeroNode.name;
			temp.nickName = newHeroNode.nickName;
		} else {// û���ҵ�
			System.out.printf("û���ҵ����%d�Ľڵ㣬�����޸�\n", newHeroNode.no);
		}
	}

	/**
	 * ɾ���ڵ�
	 * 
	 * @param no
	 */
	public void del(int no) {
		// �жϵ�ǰ�����Ƿ�Ϊ��
		if (head.next == null) {// ������
			System.out.println("��ǰ����Ϊ�գ��޷�ɾ����");
			return;
		}
		HeroNodeD temp = head.next; // ��������/ָ�롾������Ƚ��ڵ�������ʱ������next�������Ǵӵ�һ�����ݽڵ㿪ʼ��ѯ����������ɾ����
									// ��������������head������Ϊɾ��ʱ�Ĳ�ѯ��Ҫ�ҵ��Ǵ�ɾ���ڵ����һ���ڵ㡿
		boolean flag = false;// ��ע�Ƿ��ҵ��˴�ɾ���Ľڵ�
		while (true) {
			if (temp == null) {// �Ѿ�����������
				break;
			}
			if (temp.no == no) {
				// �ҵ���ɾ���Ľڵ�
				flag = true;
				break;
			}

			temp = temp.next;
		}
		// �ж�flag
		if (flag) {// �ҵ�
			// ����ɾ��
			temp.pre.next = temp.next;
			// ��Ҫһ����������������һ���ڵ㣬�Ͳ���Ҫִ��temp.next.pre=temp.pre��仰������ͳ��ֿ�ָ��
			// temp.next.pre=temp.pre;//������������д�������⣺ɾ���Ľڵ�Ϊ���Ľڵ�ʱ��temp.next��Ϊnull
			if (temp.next != null) {
				temp.next.pre = temp.pre;
			}

		} else {
			System.out.printf("Ҫɾ����%d�ڵ㲻����", no);
		}
	}
}

/**
 * ����HeroNodeD��ÿ��HeroNodeD�������һ���ڵ�
 * 
 * @author Rao'Q'ing'M'ei
 *
 */
class HeroNodeD {
	public int no;
	public String name;
	public String nickName;
	HeroNodeD pre;// ָ��ǰһ���ڵ㣬Ĭ��Ϊnull
	HeroNodeD next;// ָ����һ���ڵ㣬Ĭ��Ϊnull

	/**
	 * ������
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
	 * Ϊ����ʾ���㣬��дtoString����
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "HerNode   no=" + no + ",name=" + name + ",nickName=" + nickName;
	}
}