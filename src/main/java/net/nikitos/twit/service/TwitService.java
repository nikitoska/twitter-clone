package net.nikitos.twit.service;

import net.nikitos.twit.entity.Twit;
import net.nikitos.twit.entity.User;
import net.nikitos.twit.repository.TwitRepository;
import net.nikitos.twit.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TwitService {

    @Autowired
    private TwitRepository twitRepository;

    @Autowired
    private UserRepository userRepository;

    public void save(Twit twit, String name) {
        User user = userRepository.findByName(name);
        twit.setUser(user);
        twitRepository.save(twit);

    }

    public void delete(int id) {
        twitRepository.delete(id);

    }

    public List<Twit> findAll() {
       return twitRepository.findAll(new PageRequest(0,10, Sort.Direction.DESC,"date")).getContent();
    }
}
