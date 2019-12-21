package com.bbs.service.lai;

import com.bbs.dao.lai.UserDao;
import com.bbs.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private UserDao userDao;

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public int verifyUser(Integer id, String password) {
        if (userDao.findByUseridAndUserpassword(id, password).isEmpty()) {
            return 0;
        }else {
            if (!userDao.findByUseridAndUseradmin(id,1).isEmpty()) {
                return 10;
            }
            return 1;
        }
    }

    public List<User> findByUserid(Integer id) {
        return userDao.findByUserid(id);
    }




    public boolean registerUser(User user) {
        if(userDao.findByUserid(user.getUserid()).isEmpty()) {
            userDao.save(user);
            return true;
        }else {
            return false;
        }
    }
    public int update(User user) {
        return  userDao.updateUserById(user.getUserphone(), user.getUseroccu(), user.getUserorg(), user.getUserid());
    }

}
