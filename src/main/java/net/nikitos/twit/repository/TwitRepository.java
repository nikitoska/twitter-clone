package net.nikitos.twit.repository;

import net.nikitos.twit.entity.Twit;
import net.nikitos.twit.entity.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface TwitRepository extends JpaRepository<Twit,Integer> {

    List<Twit> findByUser(User user, Pageable pageable );
}
