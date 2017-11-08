package com.agent.hjsun.test;

import java.util.Calendar;

/**
 * <pre>
 * 
 * </pre>
 * @date: 2017. 11. 1. 오후 4:07:03
 * @version:
 * @author: Brian H Sun
 */
public  class SensitiveChechsumImpl {
	//체크섬 제외 옵션 플래그
	protected boolean isNoChecksum = false;
	//이번년도 숫자 플래그
	protected int[] curYearNums;
	

	/**
	 * <pre>
	 * 1. 개요:
	 * 2. 처리내용
	 * </pre>
	 * @Method : verifyJuminNumber
	 * @date: 2017. 11. 1. 오후 4:45:21
	 * @author Brian H Sun
	 * @history:
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용
	 *	----------- ------------------- ---------------------------------------
	 *	2017. 11. 1.		Brian H Sun				최초 작성
	 *	-----------------------------------------------------------------------
	 * @param jumin
	 * @return
	 */
	protected boolean verifyJuminNumber(String jumin) {
		//주민번호 체크섬에 사용할 배열
		int[] nTabs = new int[] {2, 3, 4, 5, 6, 7, 8, 9, 2, 3, 4, 5};
		//주민등록번호 각 자리당  배열
		int[] nNumbers;
		
		//속도를 위해서 반복문을 사용안하고 직접 나눔
		//중간에 - 이나 . 같은 문자열이 존재하는 경우
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
	 * 1. 개요: 주민번호를 년도에 따른 성별 필터링하는 함수
	 * 2. 처리내용 CheckJuminGender로직이 걸러내는 한계가 있어서 개선
	 * </pre>
	 * @Method : isJuminGender
	 * @date: 2017. 11. 1. 오후 4:52:18
	 * @author Brian H Sun
	 * @history:
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용
	 *	----------- ------------------- ---------------------------------------
	 *	2017. 11. 1.		Brian H Sun				최초 작성
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
		
		//현재 년도 뒷자리
		int nNowYear = Integer.parseInt(sNowYear);
		//주민번호 출생년도 앞 2자리
		int nJuminYear = Integer.parseInt(sJuminYear);
		//주민등록번호 성별
		int nGender = nNumbers[6];
		
		//현재 년도보다 클 때
		if (nNowYear < nJuminYear) {
			//2000년 이전 출생자
			if (nGender == 1 || nGender <= 4)
				return true;
		}		
		//100살인 분과 올해 태어난 사람 구분
		else if (nNowYear == 3 || nGender <= 4)
			return true;
		//현재 년도보다 적을 때
		else {
			//2000년도 이후 출생자
			if (nGender == 3 || nGender == 4)
				return true;
			//100살 이상 110살 이하인 경우
			if ((nNowYear - nJuminYear <= 10 && nGender == 1)
			||  (nNowYear - nJuminYear <= 10 && nGender == 2)) {
				return true;
			}
		}
		return false;
	}
}
