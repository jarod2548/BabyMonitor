package org.babymonitor.Security;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class JWTFilter extends OncePerRequestFilter {
  private final JWTService jwtService;

  public JWTFilter(JWTService Util) {
    jwtService = Util;
  }

  @Override
  protected void doFilterInternal(
      HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
      throws ServletException, IOException {

    try{
      String token = extractJwtFromCookies(request);

      if (token != null ) {
        jwtService.validateToken(token);
        UserPrincipal user = jwtService.getClaims(token);

        UsernamePasswordAuthenticationToken auth =
                new UsernamePasswordAuthenticationToken(
                        user, null, List.of(new SimpleGrantedAuthority("ROLE_" + user.getRole())));

        auth.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        SecurityContextHolder.getContext().setAuthentication(auth);
      }

      filterChain.doFilter(request, response);
    }
    catch (ExpiredJwtException e) {

      SecurityContextHolder.clearContext();

      response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
      response.setContentType("application/json");

      response.getWriter().write("""
  {
    "error": "JWT expired"
  }
  """);

      response.getWriter().flush();
      return;
    }catch (JwtException e) {
      SecurityContextHolder.clearContext();

      response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
      response.setContentType("application/json");

      response.getWriter().write("""
    {
      "error": "Invalid JWT"
    }
    """);
      return;
    }
  }

  private String extractJwtFromCookies(HttpServletRequest request) {
    if (request.getCookies() == null) return null;

    for (Cookie cookie : request.getCookies()) {
      if ("jwt".equals(cookie.getName())) {
        return cookie.getValue();
      }
    }
    return null;
  }
}
