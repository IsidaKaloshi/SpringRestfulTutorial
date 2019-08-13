package com.SpringBasicRest.BasicRest;

import com.SpringBasicRest.BasicRest.User.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Component
public class UserDaoService {

    private static int UserCount =3;

private static List<User> users = new ArrayList<>();


static {

           users.add(new User(1,"Adam", new Date()));
           users.add(new User(2,"Eva", new Date()));
           users.add(new User(3,"Jack", new Date()));


             }

             // create methd for the following intofrmation {}
            public List<User> findAll(){
                return users;
            }
            public User save (User user) {
                if(user.getId()==null) {
                    user.setId(++UserCount);
                }
                users.add(user);
                return user;
            }
             public User findOne (int id) {
                for (User user: users){

                    if(user.getId()==id){
                        return user;
                    }
                }
                    return  null;
             }


             public User deleteByID (int id) {

                 Iterator<User> iterator= users.listIterator();
                    while (iterator.hasNext()){
                    User user = iterator.next();
                     if(user.getId()==id){
                         iterator.remove();
                        return user;
                    }
                }
                     return  null;
             }

}
