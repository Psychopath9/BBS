package com.bbs.dao.lai;


import com.bbs.entity.User;
import io.swagger.models.auth.In;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {
    List<User> findByUserid(Integer id);
    List<User> findByUseridAndUserpassword(Integer id, String password);
    List<User> findByUseridAndUseradmin(Integer id, Integer isAdmin);
}
