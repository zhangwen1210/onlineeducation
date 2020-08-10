package vip.zhangw.onlineeducation;

import io.jsonwebtoken.Claims;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import vip.zhangw.onlineeducation.domain.User;
import vip.zhangw.onlineeducation.util.JWTUtils;

@SpringBootTest
class OnlineeducationApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	public void testJwt() {
		User user = new User();
		user.setPhone("18877384565");
		user.setName("张文");
		user.setPwd("root");
		String token = JWTUtils.getJsonWebToken(user);
		System.out.println("====");
		System.out.println(token);
		System.out.println("====");
		try {
			Thread.sleep(5000);
		}catch (Exception e){
			e.printStackTrace();
		}
		Claims claims = JWTUtils.checkJWT(token);
		System.out.println(claims.get("name"));
	}

}
