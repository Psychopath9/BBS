package com.bbs.service.lai;

import com.bbs.dao.lai.UserDao;
import com.bbs.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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




    public boolean registerUser(User user) {
        if(userDao.findByUserid(user.getUserid()).isEmpty()) {
            userDao.save(user);
            return true;
        }else {
            return false;
        }
    }

}
