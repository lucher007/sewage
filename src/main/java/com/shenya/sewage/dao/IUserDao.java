package com.shenya.sewage.dao;

import com.shenya.sewage.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserDao {

    /*
     * @param User
     * @return
     */
    public User findById(Integer id);

}
