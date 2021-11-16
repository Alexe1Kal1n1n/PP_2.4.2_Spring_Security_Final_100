package spring.mvc.hibernate.service;

import spring.mvc.hibernate.model.Role;
import spring.mvc.hibernate.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;

@Component
public class UserDataLoader {

    RoleService roleService;
    UserService userService;

    @Autowired
    public UserDataLoader(RoleService roleService, UserService userService) {
        this.roleService = roleService;
        this.userService = userService;
    }

    @PostConstruct
    public void loadDataUser() {
        Role role1 = new Role("ROLE_ADMIN");
        Role role2 = new Role("ROLE_USER");
        roleService.add(role1);
        roleService.add(role2);
//        User user1 = new User( "alex", "$2a$10$GGRd0oT3kI6DJFzZB3HTW./zOCTnAPg12.vBItGIS8akLG1GrvgeO",
//                "Alex", "Kalinin","alex@mail.ru");
//        User user2 = new User( "kim", "$2a$10$GfEUbTFPYnwF.ARzKqDkh.4ybziR3c.pwr8fnfrnr8BX8UtFnYaqS",
//                "Kim", "ChenIn","kim5@chen.com");
//        User user3 = new User( "zaur", "$2a$10$T9t.0r7MY//aEhB8/Nuv.eQmhnn0io1VgaWw7u8YDsjLFdbMf87Ia",
//                "Zaur", "Tregulov","tregulov@ya.ru");

        User user1 = new User( "alex", "alex",
                "Alex", "Kalinin","alex@mail.ru");
        User user2 = new User( "kim", "kim",
                "Kim", "ChenIn","kim5@chen.com");
        User user3 = new User( "zaur", "zaur",
                "Zaur", "Tregulov","tregulov@ya.ru");

        Set<Role> roles1 = new HashSet<>();
        roles1.add(role1);
        roles1.add(role2);
        user1.setRoles(roles1);
        userService.saveUser(user1);

        Set<Role> roles2 = new HashSet<>();
        roles2.add(role2);
        user2.setRoles(roles2);
        userService.saveUser(user2);

        Set<Role> roles3 = new HashSet<>();
        roles3.add(role1);
        user3.setRoles(roles3);
        userService.saveUser(user3);
    }
}