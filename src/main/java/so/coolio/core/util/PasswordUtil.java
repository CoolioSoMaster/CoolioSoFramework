/*
 * ------------------------------------------------------------------------------
 * @Project       : CoolioSo FrameWork
 * @Source        : PasswordUtil.java
 * @Author        : YOUNGMIN JUN
 * @Version       : v1.0
 * Copyright(c) 2015 CoolioSo All rights reserved
 *------------------------------------------------------------------------------
 *                  변         경         사         항                       
 *------------------------------------------------------------------------------
 *    DATE     AUTHOR                      DESCRIPTION                        
 * ----------  ------  --------------------------------------------------------- 
 * 2015. 1. 9.   YOUNGMIN JUN    신규생성                                     
 *------------------------------------------------------------------------------
 */ 
package so.coolio.core.util;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * <pre>
 * so.coolio.core.util
 * _PasswordUtil.java
 * </pre>
 * 
 * Desc : 비밀번호생성 관련 유틸 클래스
 * @Company : CoolioSo Incorporated
 * @Date : 2015. 1. 9.
 * @Version : 1.0
 */
public class PasswordUtil {
	/** 비밀번호 생성시에 사용할 패스워드 길이 */
	protected static int DEFAULT_PASSWORD_LENGTH = 8;
	/** 비밀번호 생성시에 사용할 문자배열 */
	protected static Character[] charaters = {'a','b','c','d','e','f','g','h','i','j'
							   		    	 						   ,'k','l','m','n','o','p','q','r','s','t'
							   		    	 						   ,'u','v','w','x','y','z'};
	/** 비밀번호 생성시에 사용할 숫자배열 */
	protected static Character[] numbers = {'0','1','2','3','4','5','6','7','8','9'};
	/** 비밀번호 생성시에 사용할 심볼배열 */
	protected static Character[] symbols = {'!','@','^','$','*'};
	/** 비밀번호 생성시에 사용할 모든 문자배열 */
	protected static Character[] allCharaters = new Character[charaters.length + numbers.length + symbols.length];
	/** 비밀번호 생성시에 사용할 심볼 + 문자 배열 */
	protected static Character[] symbolsNcharaters = new Character[charaters.length + symbols.length];
	
	static{
		System.arraycopy(charaters, 0, allCharaters, 0, charaters.length);
		System.arraycopy(numbers, 0, allCharaters, charaters.length, numbers.length);
		System.arraycopy(symbols, 0, allCharaters, charaters.length + numbers.length, symbols.length);
		
		System.arraycopy(charaters, 0, symbolsNcharaters, 0, charaters.length);
		System.arraycopy(symbols, 0, symbolsNcharaters, charaters.length, symbols.length);
	}
	
	/**
	 * Desc : 문자배열만을 사용해서 비밀번호를 생성함
	 * @Method Name : getRandomPasswordOnlyCharaters
	 * @return 문자만으로 구성되어 있는 비밀번호
	 */
	public static String getRandomPasswordOnlyCharaters(){
		return getRandomPasswordOnlyCharaters(DEFAULT_PASSWORD_LENGTH);
	}
	
	/**
	 * Desc : 문자배열만을 사용해서 비밀번호를 생성함
	 * @Method Name : getRandomPasswordOnlyCharaters
	 * @return 문자만으로 구성되어 있는 비밀번호
	 */
	public static String getRandomPasswordOnlyCharaters(int passwordLength){
		return getRandomPassword(passwordLength, charaters);
	}
	
	/**
	 * Desc : 숫자배열만을 사용해서 비밀번호를 생성함
	 * @Method Name : getRandomPasswordOnlyNumber
	 * @return 숫자만으로 구성되어 있는 비밀번호
	 */
	public static String getRandomPasswordOnlyNumber(){
		return getRandomPasswordOnlyCharaters(DEFAULT_PASSWORD_LENGTH);
	}
	
	/**
	 * Desc : 숫자배열만을 사용해서 지정된 길이만큼의 비밀번호를 생성함
	 * @Method Name : getRandomPasswordOnlyNumbers
	 * @return 숫자만으로 구성되어 있는 비밀번호
	 */
	public static String getRandomPasswordOnlyNumbers(int passwordLength){
		return getRandomPassword(passwordLength, numbers);
	}
	
	/**
	 * Desc : 특수문자배열만을 사용해서 비밀번호를 생성함
	 * @Method Name : getRandomPasswordOnlySymbols
	 * @return 특수문자만으로 구성되어 있는 비밀번호
	 */
	public static String getRandomPasswordOnlySymbols(){
		return getRandomPasswordOnlySymbols(DEFAULT_PASSWORD_LENGTH);
	}
	
	/**
	 * Desc : 특수문자배열만을 사용해서 지정된 길이만큼의 비밀번호를 생성함
	 * @Method Name : getRandomPasswordOnlySymbols
	 * @return 특수문자만으로 구성되어 있는 비밀번호
	 */
	public static String getRandomPasswordOnlySymbols(int passwordLength){
		return getRandomPassword(passwordLength, symbols);
	}
	
	/**
	 * Desc : 특수문자와 일반문자를 사용해서 비밀번호를 생성함
	 * @Method Name : getRandomPasswordSymbolsAndCharacters
	 * @return 특수문자와 일반문자로 구성되어 있는 비밀번호
	 */
	public static String getRandomPasswordSymbolsAndCharacters(){
		return getRandomPasswordSymbolsAndCharacters(DEFAULT_PASSWORD_LENGTH);
	}
	
	/**
	 * Desc : 특수문자와 일반문자를 사용해서 지정된 길이만큼의 비밀번호를 생성함
	 * @Method Name : getRandomPasswordSymbolsAndCharacters
	 * @param passwordLength : 비밀번호의 길이
	 * @return
	 */
	public static String getRandomPasswordSymbolsAndCharacters(int passwordLength){
		return getRandomPassword(passwordLength, symbolsNcharaters);
	}

	/**
	 * Desc : 모든 문자배열을 사용해서 비밀번호를 생성함
	 * @Method Name : getRandomPassword
	 * @return 모든문자로 구성되어 있는 비밀번호
	 */
	public static String getRandomPassword(){
		return getRandomPassword(DEFAULT_PASSWORD_LENGTH, allCharaters);
	}
	
	/**
	 * Desc : 모든 문자배열을 사용해서 지정된 길이만큼의 비밀번호를 생성함
	 * @Method Name : getRandomPassword
	 * @return 모든문자로 구성되어 있는 비밀번호
	 */
	public static String getRandomPassword(int passwordLengh){
		return getRandomPassword(passwordLengh, allCharaters);
	}

	/**
	 * Desc : 지정된 배열을 사용해서 비밀번호를 생성함.
	 * @Method Name : getRandomPassword
	 * @param charArray 비밀번호 생성시에 사용할 배열
	 * @return 생성된 비밀번호
	 */
	protected static String getRandomPassword(Character[] charArray){
		return getRandomPassword(DEFAULT_PASSWORD_LENGTH, charArray);
	}
	
	/**
	 * Desc : 지정된 길이만큼 지정된 배열을 사용해서 비밀번호를 생성함.
	 * @Method Name : getRandomPassword
	 * @param passwordLengh 비밀번호 생성 길이 passwordLengh
	 * @param charArray 비밀번호 생성시에 사용할 배열
	 * @return 생성된 비밀번호
	 */
	protected static String getRandomPassword(int passwordLengh, Character[] charArray){
		int charLength = charArray.length;
		Character[] keyPoll = getArrayRandomSort(charArray);
		
		StringBuilder strBuilder = new StringBuilder();
		Random random = new Random();
		
		for(int i = 0; i < passwordLengh; i++){
			strBuilder.append(keyPoll[random.nextInt(charLength)]);
		}
		
		return strBuilder.toString();
	}
	
	/**
	 * Desc : 배열을 순서를 랜덤하게 정렬해주는 메소드
	 * @Method Name : getArrayRandomSort
	 * @param charArray
	 * @return 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	protected static <T> T[] getArrayRandomSort(T[] charArray){
		List<T> cList = (List<T>)Arrays.asList(charArray);
		Collections.shuffle(cList);
		
		return (T[]) cList.toArray();
	}
}