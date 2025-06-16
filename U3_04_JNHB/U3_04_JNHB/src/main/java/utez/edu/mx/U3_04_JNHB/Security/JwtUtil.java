//package utez.edu.mx.U3_04_JNHB.Security;
//
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//import io.jsonwebtoken.security.Keys;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.stereotype.Component;
//
//import java.util.Date;
//
//@Component
//public class JwtUtil {
//
//    private final String SECRET_KEY = "SECRET_KEY_CAMBIALA";
//
//    private final long EXPIRATION = 86400000;
//
//    public String extractUsername(String jwt) {
//        return Jwts.parserBuilder().setSigningKey(Keys.hmacShaKeyFor(SECRET_KEY.getBytes())).build()
//                .parseClaimsJws(jwt).getBody().getSubject();
//    }
//
//    public String generateToken(UserDetails userDetails) {
//        Date now = new Date();
//        Date expiration = new Date(now.getTime() + EXPIRATION);
//        return Jwts.builder()
//                .setSubject(userDetails.getUsername())
//                .setIssuedAt(now)
//                .setExpiration(expiration)
//                .signWith(Keys.hmacShaKeyFor(SECRET_KEY.getBytes()), SignatureAlgorithm.HS256)
//                .compact();
//    }
//
//    public boolean isValid(String jwt, UserDetails userDetails) {
//        return extractUsername(jwt).equals(userDetails.getUsername()) &&
//                !isExpired(jwt);
//    }
//
//    private boolean isExpired(String jwt) {
//        Date expiration = Jwts.parserBuilder().setSigningKey(Keys.hmacShaKeyFor(SECRET_KEY.getBytes())).build()
//                .parseClaimsJws(jwt).getBody().getExpiration();
//
//        return expiration.before(new Date());
//    }
//}
//
