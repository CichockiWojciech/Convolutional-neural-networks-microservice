package pl.secuirity;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.filter.GenericFilterBean;
import pl.messages.ClassificationTarget;
import pl.services.IpVisitorService;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;


public class IpFilter extends GenericFilterBean {

    private Random random = new Random();
    private ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private IpVisitorService ipVisitorService;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        boolean access = false;
        String address = request.getRemoteAddr();
        if(address != null){
            ipVisitorService.register(address);
            access = ipVisitorService.gainAccess(address);
        }
        if(!access) {
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            PrintWriter out = response.getWriter();
            var json = new ClassificationTarget(random.nextInt(2) == 0 ? "NO" : "YES");
            String jsonString = objectMapper.writeValueAsString(json);
            out.write(jsonString);
            out.flush();
            return;
        }
        filterChain.doFilter(request, response);
    }
}
