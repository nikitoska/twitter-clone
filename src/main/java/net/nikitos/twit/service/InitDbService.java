package net.nikitos.twit.service;

import net.nikitos.twit.entity.Role;
import net.nikitos.twit.entity.Twit;
import net.nikitos.twit.entity.User;
import net.nikitos.twit.repository.RoleRepository;
import net.nikitos.twit.repository.TwitRepository;
import net.nikitos.twit.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Transactional
@Service
public class InitDbService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TwitRepository twitRepository;
    @Autowired
    private RoleRepository roleRepository;

    @PostConstruct
    public void init(){
        Role role = new Role();
        role.setName("ROLE_ADMIN");
        roleRepository.save(role);

        Role role_user = new Role();
        role_user.setName("ROLE_USER");
        roleRepository.save(role_user);

        List<Role> roles = new ArrayList<>();
        roles.add(role);
        roles.add(role_user);
        User user = new User();
        user.setName("admin");
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode("admin"));
        user.setEnabled(true);
        user.setEmail("admin@gmail.com");
        user.setRoles(roles);



        User user2 = new User();
        user2.setName("Nikita");
        user2.setEmail("aleks@gmail.com");
        user2.setParent(user);

        User user3 = new User();
        user3.setName("Nika");

        User user4 = new User();
        user4.setName("User4");

        List<User> followers = new ArrayList<>();
        followers.add(user2);

        user.setFollowers(followers);

        userRepository.save(user);
        userRepository.save(user2);
        userRepository.save(user3);
        userRepository.save(user4);

        Twit twit1 = new Twit();
        twit1.setDate(new Date());
        twit1.setDescription("my first twit");
        twit1.setUser(user);

        Twit twit2 = new Twit();
        twit2.setDate(new Date());
        twit2.setDescription("my second twit");
        twit2.setUser(user);

        Twit twit3 = new Twit();
        twit3.setDate(new Date());
        twit3.setDescription("my third twit");
        twit3.setUser(user2);

        Twit twit4 = new Twit();
        twit4.setDate(new Date());
        twit4.setDescription("Nika tweet");
        twit4.setUser(user3);

        Twit twit5 = new Twit();
        twit5.setDate(new Date());
        twit5.setDescription("User4 tweet");
        twit5.setUser(user4);

        twitRepository.save(twit4);
        twitRepository.save(twit5);
        twitRepository.save(twit3);
        twitRepository.save(twit1);
        twitRepository.save(twit2);






    }
}
