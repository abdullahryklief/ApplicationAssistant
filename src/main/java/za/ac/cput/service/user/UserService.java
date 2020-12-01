package za.ac.cput.service.user;

import za.ac.cput.entity.user.User;
import za.ac.cput.service.IService;

import java.util.Set;

public interface UserService extends IService<User, String> {
    Set<User> getAll();

}
