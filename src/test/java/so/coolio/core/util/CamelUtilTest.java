package so.coolio.core.util;

import static org.junit.Assert.*;

import org.junit.Test;

public class CamelUtilTest {
	private String camelVar = "user_name";
	private String underScoreVar = "UserName";

	@Test
	public void 카멜규칙_변수_테스트() {
		String result = CamelUtil.convert2CamelCase(camelVar);
		assertEquals("userName", result);
	}

	@Test
	public void 언더스코어규칙_변수_테스트() {
		String result = CamelUtil.convert2UnderScore(underScoreVar);
		assertEquals("USER_NAME", result);
	}

}
