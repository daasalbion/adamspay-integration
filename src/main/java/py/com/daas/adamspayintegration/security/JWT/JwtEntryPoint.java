package py.com.daas.adamspayintegration.security.JWT;

import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Created By Zhu Lin on 1/1/2019.
 */
@Component
public class JwtEntryPoint implements AuthenticationEntryPoint {


    private static final Logger logger = LoggerFactory.getLogger(JwtEntryPoint.class);

    // called if authentication failed
    @Override
    public void commence(HttpServletRequest request,
                         HttpServletResponse response,
                         AuthenticationException e)
            throws IOException {

        logger.error("Unauthorized error. Message - {}", e.getMessage());
        response.setStatus(HttpStatus.UNAUTHORIZED.value());
    }
}
