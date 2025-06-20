package utez.edu.mx.U3_04_JNHB.Controller;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import utez.edu.mx.U3_04_JNHB.Model.Usuario;
import utez.edu.mx.U3_04_JNHB.Security.JwtUtil;
import utez.edu.mx.U3_04_JNHB.Security.UserDetailsServiceImpl;
import utez.edu.mx.U3_04_JNHB.Service.UsuarioService;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final UserDetailsServiceImpl userDetailsService;
    private final JwtUtil jwtUtil;
    private final UsuarioService usuarioService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody AuthRequest auth) {
        UsernamePasswordAuthenticationToken authentication =
                new UsernamePasswordAuthenticationToken(auth.getUsername(), auth.getPassword());
        authenticationManager.authenticate(authentication);
        UserDetails user = userDetailsService.loadUserByUsername(auth.getUsername());
        return ResponseEntity.ok(jwtUtil.generateToken(user));
    }

    @PostMapping("/register")
    public ResponseEntity<Usuario> register(@RequestBody RegisterRequest usuario) {
        Usuario nuevoUsuario = new Usuario();
        nuevoUsuario.setUsername(usuario.getUsername());
        nuevoUsuario.setPassword(usuario.getPassword());
        nuevoUsuario.setRole(usuario.getRole().toUpperCase());
        Usuario registrado = usuarioService.guardar(nuevoUsuario);
        return ResponseEntity.ok(registrado);
    }
}

@Data
class AuthRequest {
    private String username;
    private String password;
}