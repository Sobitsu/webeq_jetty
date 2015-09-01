package com.sobit.webeq.services.users.rest;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
 
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
 
import com.sobit.webeq.services.dao.data.users.UsersDAO;
import com.sobit.webeq.entities.Users;
 
@RestController
@RequestMapping("/service")
public class UsersServiceJSON {
 
    private UsersDAO usersdao=new UsersDAO();
     
    @RequestMapping(value="/userall", method=RequestMethod.GET)
    public List<Users> users() {
        return usersdao.getUsers();
    }
     
     
    @RequestMapping(value="/users", method=RequestMethod.GET)
    public Users users(HttpServletRequest request) {
        if(request.getParameter("id")!=null)
        {
        return usersdao.getUsers(Integer.parseInt(request.getParameter("id")));
        }
        return null;
    }
}