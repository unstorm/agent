package com.agent.hjsun.test;

import java.util.Calendar;

/**
 * <pre>
 * 
 * </pre>
 * @date: 2017. 11. 1. ���� 4:07:03
 * @version:
 * @author: Brian H Sun
 */
public  class SensitiveChechsumImpl {
	//üũ�� ���� �ɼ� �÷���
	protected boolean isNoChecksum = false;
	//�̹��⵵ ���� �÷���
	protected int[] curYearNums;
	

	/**
	 * <pre>
	 * 1. ����:
	 * 2. ó������
	 * </pre>
	 * @Method : verifyJuminNumber
	 * @date: 2017. 11. 1. ���� 4:45:21
	 * @author Brian H Sun
	 * @history:
	 *	-----------------------------------------------------------------------
	 *	������				�ۼ���						���泻��
	 *	----------- ------------------- ---------------------------------------
	 *	2017. 11. 1.		Brian H Sun				���� �ۼ�
	 *	-----------------------------------------------------------------------
	 * @param jumin
	 * @return
	 */
	protected boolean verifyJuminNumber(String jumin) {
		//�ֹι�ȣ üũ���� ����� �迭
		int[] nTabs = new int[] {2, 3, 4, 5, 6, 7, 8, 9, 2, 3, 4, 5};
		//�ֹε�Ϲ�ȣ �� �ڸ���  �迭
		int[] nNumbers;
		
		//�ӵ��� ���ؼ� �ݺ����� �����ϰ� ���� ����
		//�߰��� - �̳� . ���� ���ڿ��� �����ϴ� ���
		if(jumin.length() > 13) {
			nNumbers = new int[] { Character.getNumericValue(jumin.charAt(0)), Character.getNumericValue(jumin.charAt(1)),
									   Character.getNumericValue(jumin.charAt(2)), Character.getNumericValue(jumin.charAt(3)),
									   Character.getNumericValue(jumin.charAt(4)), Character.getNumericValue(jumin.charAt(5)),
									   Character.getNumericValue(jumin.charAt(7)), Character.getNumericValue(jumin.charAt(8)),
									   Character.getNumericValue(jumin.charAt(9)), Character.getNumericValue(jumin.charAt(10)),
									   Character.getNumericValue(jumin.charAt(11)), Character.getNumericValue(jumin.charAt(12)),
									   Character.getNumericValue(jumin.charAt(13)),
									   };
		} else {
			nNumbers = new int[] { Character.getNumericValue(jumin.charAt(0)), Character.getNumericValue(jumin.charAt(1)),
									   Character.getNumericValue(jumin.charAt(2)), Character.getNumericValue(jumin.charAt(3)),
									   Character.getNumericValue(jumin.charAt(4)), Character.getNumericValue(jumin.charAt(5)),
									   Character.getNumericValue(jumin.charAt(6)), Character.getNumericValue(jumin.charAt(7)),
									   Character.getNumericValue(jumin.charAt(8)), Character.getNumericValue(jumin.charAt(9)),
									   Character.getNumericValue(jumin.charAt(10)), Character.getNumericValue(jumin.charAt(11)),
									   Character.getNumericValue(jumin.charAt(12)),
					 				   };
		}
		
		  System.out.println(isJuminGender(nNumbers)); 
		  
		  return false;
	}
	
	/**
	 * <pre>
	 * 1. ����: �ֹι�ȣ�� �⵵�� ���� ���� ���͸��ϴ� �Լ�
	 * 2. ó������ CheckJuminGender������ �ɷ����� �Ѱ谡 �־ ����
	 * </pre>
	 * @Method : isJuminGender
	 * @date: 2017. 11. 1. ���� 4:52:18
	 * @author Brian H Sun
	 * @history:
	 *	-----------------------------------------------------------------------
	 *	������				�ۼ���						���泻��
	 *	----------- ------------------- ---------------------------------------
	 *	2017. 11. 1.		Brian H Sun				���� �ۼ�
	 *	-----------------------------------------------------------------------
	 * @param number
	 * @return
	 */
	protected boolean isJuminGender(int[] nNumbers) {		
		Calendar cal = Calendar.getInstance();		
		
		@SuppressWarnings("static-access")
		int nYear = cal.get(cal.YEAR);
		String sYear = Integer.toString(nYear);
		String sNowYear = sYear.substring(2, 4);
		String sJuminYear = Integer.toString(nNumbers[0]) 
							   + Integer.toString(nNumbers[1]);
		
		//���� �⵵ ���ڸ�
		int nNowYear = Integer.parseInt(sNowYear);
		//�ֹι�ȣ ����⵵ �� 2�ڸ�
		int nJuminYear = Integer.parseInt(sJuminYear);
		//�ֹε�Ϲ�ȣ ����
		int nGender = nNumbers[6];
		
		//���� �⵵���� Ŭ ��
		if (nNowYear < nJuminYear) {
			//2000�� ���� �����
			if (nGender == 1 || nGender <= 4)
				return true;
		}		
		//100���� �а� ���� �¾ ��� ����
		else if (nNowYear == 3 || nGender <= 4)
			return true;
		//���� �⵵���� ���� ��
		else {
			//2000�⵵ ���� �����
			if (nGender == 3 || nGender == 4)
				return true;
			//100�� �̻� 110�� ������ ���
			if ((nNowYear - nJuminYear <= 10 && nGender == 1)
			||  (nNowYear - nJuminYear <= 10 && nGender == 2)) {
				return true;
			}
		}
		return false;
	}
}
