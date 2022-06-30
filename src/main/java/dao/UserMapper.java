package dao;

import domain.User;

import java.io.IOException;
import java.util.List;

public interface UserMapper {
    public List<User> findAll() throws IOException;
    public void insert(User user);
    public void delete(int id);
}
