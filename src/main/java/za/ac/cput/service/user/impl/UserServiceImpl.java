package za.ac.cput.service.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.entity.user.User;
import za.ac.cput.repository.user.UserRepository;
import za.ac.cput.service.user.UserService;
//import za.ac.cput.util.SendHTMLEmail;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;


    @Override
    public Set<User> getAll()
    {
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }

    @Override
    public User create(User user)
    {
        return this.repository.save(user);
    }

    @Override
    public User read(String userId)
    {
        return this.repository.findById(userId).orElseGet(null);
    }

    @Override
    public User update(User user)
    {
        if(this.repository.existsById(user.getUserId())){
            return this.repository.save(user);
        }
        return null;
    }

    @Override
    public boolean delete(String userId)
    {
        this.repository.deleteById(userId);
        if(this.repository.existsById(userId)) return false;
        else return true;
    }
}
