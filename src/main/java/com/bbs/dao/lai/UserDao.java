package com.bbs.dao.lai;


import com.bbs.entity.User;
import io.swagger.models.auth.In;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {
    List<User> findByUserid(Integer id);
    List<User> findByUseridAndUserpassword(Integer id, String password);
    List<User> findByUseridAndUseradmin(Integer id, Integer isAdmin);
    @Transactional
    @Modifying
    @Query(value = "update user set user_phone = ?1, user_occu = ?2, user_org = ?3 where user_id = ?4",nativeQuery = true)
    int updateUserById(String phone, String occ, String org, Integer id);
}
