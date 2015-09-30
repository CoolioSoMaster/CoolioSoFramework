/*
 * ------------------------------------------------------------------------------
 * @Project       : CoolioSo FrameWork
 * @Source        : CamelUtil.java
 * @Author        : YOUNGMIN
 * @Version       : v1.0
 * Copyright(c) 2015 CoolioSo All rights reserved
 *------------------------------------------------------------------------------
 *                  변         경         사         항                       
 *------------------------------------------------------------------------------
 *    DATE     AUTHOR                      DESCRIPTION                        
 * ----------  ------  --------------------------------------------------------- 
 * 2015. 6. 8.   YOUNGMIN    신규생성                                     
 *------------------------------------------------------------------------------
 */ 
package so.coolio.core.util;

/**
 * <pre>
 * 카멜법칙에 의한 프로퍼티명 변경
 * so.coolio.core.util
 * _CamelUtil.java
 * </pre>
 *
 * @author YOUNGMIN
 * @version 1.0
 * <li>(2015. 6. 8.) YOUNGMIN 최초 작성</li>
 */
public class CamelUtil {

    /**
     * <pre>
     * underscore ('_') 가 포함되어 있는 문자열을 Camel Case ( 낙타등
     * 표기법 - 단어의 변경시에 대문자로 시작하는 형태. 시작은 소문자) 로 변환해주는
     * utility 메서드 ('_' 가 나타나지 않고 첫문자가 대문자인 경우도 변환 처리
     * 함.)
     * </pre>
     *
     * @Method Name : _convert2CamelCase
     * @param underScore
     *        - '_' 가 포함된 변수명
     * @return Camel 표기법 변수명
     */
    public static String convert2CamelCase(String underScore) {

        // '_' 가 나타나지 않으면 이미 camel case 로 가정함.
        // 단 첫째문자가 대문자이면 camel case 변환 (전체를 소문자로) 처리가
        // 필요하다고 가정함. --> 아래 로직을 수행하면 바뀜
        if (underScore.indexOf('_') < 0 && Character.isLowerCase(underScore.charAt(0))) {
            return underScore;
        }
        StringBuilder result = new StringBuilder();
        boolean nextUpper = false;
        int len = underScore.length();

        for (int i = 0; i < len; i++) {
            char currentChar = underScore.charAt(i);
            if (currentChar == '_') {
                nextUpper = true;
            } else {
                if (nextUpper) {
                    result.append(Character.toUpperCase(currentChar));
                    nextUpper = false;
                } else {
                    result.append(Character.toLowerCase(currentChar));
                }
            }
        }
        return result.toString();
    }
    
    /**
     * <pre>
     * 카멜형식의 문자열을 '_' 문자로 구분지어서 반환되며 반환된 문자는 대문자로 표시
     * </pre>
     *
     * @Method Name : _convert2UnderScore
     * @param camelCase
     * @return
     */
    public static String convert2UnderScore(String camelCase){
    	StringBuilder result = new StringBuilder();
    	int len = camelCase.length();
    	
        for(int i = 0; i < len; i++){
            char currentChar = camelCase.charAt(i);
            if(i > 0 && Character.isUpperCase(currentChar)){
                result.append('_');
                result.append(Character.toUpperCase(currentChar));
            } else {
                result.append(Character.toUpperCase(currentChar));
            }
        }

        return result.toString();
    }
}