package ru.zakharov.enterprise.controller;


import lombok.Getter;
import lombok.Setter;
import ru.zakharov.enterprise.constants.FieldConsts;
import ru.zakharov.enterprise.dao.UserDAO;
import ru.zakharov.enterprise.entity.User;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

@ManagedBean
@ViewScoped
public class UserLoginController {

    @Inject
    private UserDAO userDAO;

    @Getter
    @Setter
    private User user;

    private HttpSession session;

    public void init(HttpSession session) {
        this.session = session;
        user = new User();
    }

    public String login() {
        if (user.getLogin().equals("admin") &&
                user.getPasswd().equals("31337")) {
            session.setAttribute(FieldConsts.AUTH_OK, "true");
            return "admin";
        }
        return "error";
    }

}
