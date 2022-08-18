package ru.chnr.vn.tinkbotclientservice.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.chnr.vn.tinkbotclientservice.domain.User;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByUserName(String userName);
}
