//package utez.edu.mx.U3_04_JNHB.Controller;
//
//import lombok.Data;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import utez.edu.mx.U3_04_JNHB.Security.JwtUtil;
//import utez.edu.mx.U3_04_JNHB.Security.UserDetailsServiceImpl;
//
//@RestController
//@RequestMapping("/api/auth")
//@RequiredArgsConstructor
//public class AuthController {
//
//    private final AuthenticationManager authenticationManager;
//    private final UserDetailsServiceImpl userDetailsService;
//    private final JwtUtil jwtUtil;
//
//    @PostMapping("/login")
//    public ResponseEntity<String> login(@RequestBody AuthRequest auth) throws Exception {
//        UsernamePasswordAuthenticationToken authentication =
//                new UsernamePasswordAuthenticationToken(auth.getUsername(), auth.getPassword());
//        authenticationManager.authenticate(authentication);
//        UserDetails user = userDetailsService.loadUserByUsername(auth.getUsername());
//        return ResponseEntity.ok(jwtUtil.generateToken(user));
//    }
//}
//
//@Data
//class AuthRequest {
//    private String username;
//    private String password;
//}
