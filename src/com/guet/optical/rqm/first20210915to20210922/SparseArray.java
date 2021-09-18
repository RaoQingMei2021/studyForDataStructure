package com.guet.optical.rqm.first20210915to20210922;

public class SparseArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//创建原始的二维数组  11*11
		//0：表示没有棋子，1表示黑子2表示蓝子
		int chessArr1[][]=new int[11][11];
		chessArr1[1][2]=1;
		chessArr1[2][3]=2;
		chessArr1[3][3]=6;
		//输出原始的二维数组
		System.out.println("**********************原始的二维数组**************************");
		for(int[] row:chessArr1) {
			for(int data:row){
				System.out.printf("%d\t",data);
			}
			System.out.println();
		}
		
		/**
		 * 将原始的二维数组变换为稀疏数组
		 */
		//1、遍历原始的二维数组，得到非0数据的个数
		int sum=0;
//		for(int i=0;i<11;i++) {
//			for(int j=0;j<11;j++) {
//				if(chessArr1[i][j]!=0) {
//					sum+=1;
//				}
//			}			
//		}
		for(int [] row:chessArr1) {
			for(int k:row ) {
				if(k!=0) { 
					sum+=1;
				}
			}
		}
		System.out.println(sum);
		System.out.println("*****************创建稀疏数组********************");
		int sparseArr[][]=new int[sum+1][3];
		//给稀疏数组赋值，首先是第一行
		sparseArr[0][0]=11;
		sparseArr[0][1]=11;
		sparseArr[0][2]=sum;
		
		//遍历二维数组，将非0的值存放到数组中
		int m=1;//用于记录第几个非零数据
		for(int i=0;i<11;i++) {
			for(int j=0;j<11;j++) {
				if(chessArr1[i][j]!=0) {
					sparseArr[m][0]=i;
					sparseArr[m][1]=j;
					sparseArr[m][2]=chessArr1[i][j];
					m++;
				}
			}
		}
		//输出稀疏数组的形式
		/*
		 * for(int[] row:sparseArr) { for(int data:row){ System.out.printf("%d\t",data);
		 * } System.out.println(); }   //这个方法需要两个for循环
		 */
		 for(int i=0;i<sparseArr.length;i++){
			 System.out.printf("%d\t%d\t%d\t\n",sparseArr[i][0],sparseArr[i][1],sparseArr[i][2]); 
		 }
		 
		 
		 /**
		  * 将稀疏数组恢复为原始数组
		  */
		 int chessArr2[][]=new int[sparseArr[0][0]][sparseArr[0][1]];
		 for(int i=1;i<sparseArr.length;i++) { 
				 chessArr2[sparseArr[i][0]][sparseArr[i][1]]=sparseArr[i][2];
		 }
		 System.out.println("***************输出由稀疏数组恢复出来的原始数组****************");
		 for(int [] row:chessArr2) {
			 for(int data:row) {
				 System.out.printf("%d\t",data);
			 }
			 System.out.println();
		 }
	}
/**
 * 课后思考：将稀疏数组保存到磁盘中，比如map.data，恢复到原来的数组时读取map.data进行恢复
 */
}
