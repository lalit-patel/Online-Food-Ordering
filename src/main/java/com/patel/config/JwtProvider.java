package com.patel.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Service
public class JwtProvider {

    private static SecretKey key = Keys.hmacShaKeyFor(JwtConstant.SCECRET_KEY.getBytes());

    public String generateToken(Authentication auth) {
        Collection<? extends GrantedAuthority> authorities = auth.getAuthorities();
        String role = populateAuthrities(authorities);

        String jwt = Jwts.builder().setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime()+86400000))
                .claim("email",auth.getName())
                .claim("authorities",role)
                .signWith(key)
                .compact();

        return jwt;
    }

    public static String getEmailFromJwtToken(String jwt) {
        jwt = jwt.substring(7).trim();

        Claims claims = Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJwt(jwt).getBody();

        String email = String.valueOf(claims.get("email"));

        return email;
    }

    private String populateAuthrities(Collection<? extends GrantedAuthority> authorities) {
        Set<String> auth = new HashSet<>();
        for (GrantedAuthority authority:authorities) {
            auth.add(authority.getAuthority());
        }
        return String.join(",",auth);
    }

}
