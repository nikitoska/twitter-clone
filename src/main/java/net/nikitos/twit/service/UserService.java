package net.nikitos.twit.service;

import net.nikitos.twit.entity.Role;
import net.nikitos.twit.entity.Twit;
import net.nikitos.twit.entity.User;
import net.nikitos.twit.repository.RoleRepository;
import net.nikitos.twit.repository.TwitRepository;
import net.nikitos.twit.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TwitRepository twitRepository;

    @Autowired
    private RoleRepository roleRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }


    public User findOne(int id) {
        return userRepository.findOne(id);
    }

    public void save(User user) {
        user.setEnabled(true);
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        List<Role> roles = new ArrayList<>();
        roles.add(roleRepository.findByName("ROLE_USER"));
        user.setRoles(roles);
        userRepository.save(user);
    }

    public User findWithTwit(int id){
        User user = findOne(id);
        List<Twit> twits = twitRepository.findByUser(user, new PageRequest(0,10, Sort.Direction.DESC,"date"));
        user.setTwits(twits);
        return user;

    }

    public User findWithTwit(String name) {
        User user = userRepository.findByName(name);
        return findWithTwit(user.getId());
    }

    public User findOne(String username) {
        return userRepository.findByName(username);
    }

    public void saveFollower(User parent, User follower) {
        List<User> followers = parent.getFollowers();
        followers.add(follower);
        follower.setParent(parent);
        parent.setFollowers(followers);
        userRepository.save(parent);

    }

    public void deleteFollower(User parent, User follower) {
        List<User> followers = parent.getFollowers();
       String followerName= follower.getName();
        for (User user : followers){
            if (user.getName().equals(followerName)){
               followers.remove(user);
                break;

            }
        }

        parent.setFollowers(followers);
       userRepository.save(parent);
    }
}
