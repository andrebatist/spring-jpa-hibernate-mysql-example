package com.techprimers.jpa.springjpahibernateexample.resource;

import com.techprimers.jpa.springjpahibernateexample.model.Users;
import com.techprimers.jpa.springjpahibernateexample.model.UsersContact;
import com.techprimers.jpa.springjpahibernateexample.model.UsersLog;
import com.techprimers.jpa.springjpahibernateexample.repository.UsersContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/rest/userscontact")
@RestController
public class UsersContactResource {
    @Autowired
    private UsersContactRepository usersContactRepository;

    @GetMapping(value = "/all")
    public List<UsersContact> getUsersContact() {
        return usersContactRepository.findAll();
    }

    @GetMapping(value = "/update/{name}")
    public List<UsersContact> update(@PathVariable final String name) {

        UsersContact usersContact = new UsersContact();
        usersContact.setPhoneNo(11111);

        Users users = new Users();
        users.setTeamName("Development")
                    .setSalary(10000)
                    .setName(name);

        usersContact.setUsers(users);

        UsersLog usersLog = new UsersLog();
        usersLog.setLog("HI Youtube");

        UsersLog usersLog2 = new UsersLog();
        usersLog2.setLog("HI Viewers");

      //  users.setUsersLogs(Arrays.asList(usersLog, usersLog2));
        usersContactRepository.save(usersContact);
        return usersContactRepository.findAll();
    }
}
