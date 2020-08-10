package vip.zhangw.onlineeducation.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import vip.zhangw.onlineeducation.domain.User;

import java.util.Date;

/**
 * @program: onlineeducation->JWTUtils
 * @description: JWT工具类
 * @author: zhangwen
 * @create: 2020-08-10 21:12
 **/
public class JWTUtils {

    /**
     * 过期时间一周
     */
    private static final long EXPIRE = 60000 * 60 * 24 * 7;
    // private static final long EXPIRE = 1;

    /**
     * 加密秘钥
     */
    private static final String SECRET = "zhangw.vip1995";

    /**
     * 令牌前缀
     */
    private static final String TOKEN_PREFIX = "zhangw";

    /**
     * 颁布者信息
     */
    private static final String SUBJECT = "zhangw";


    /**
     * 根据用户信息生成令牌
     * @param user
     * @return
     */
    public static String getJsonWebToken(User user){
        String token = Jwts.builder().setSubject(SUBJECT)
                .claim("head_img",user.getHeadImg())
                .claim("id",user.getId())
                .claim("name",user.getName())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() +
                        EXPIRE))
                .signWith(SignatureAlgorithm.HS256,SECRET).compact();
        token = TOKEN_PREFIX + token;
        return token;
    }


    /**
     * 校验token的方法
     * @param token
     * @return
     */
    public static Claims checkJWT(String token){
        try{
            final Claims claims = Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token.replace(TOKEN_PREFIX,"")).getBody();
            return claims;
        }catch (Exception e){
            return null;
        }
    }

}
