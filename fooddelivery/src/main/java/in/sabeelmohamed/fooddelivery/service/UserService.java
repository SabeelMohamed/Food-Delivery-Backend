package in.sabeelmohamed.fooddelivery.service;

import in.sabeelmohamed.fooddelivery.io.UserRequest;
import in.sabeelmohamed.fooddelivery.io.UserResponse;

import java.util.List;

public interface UserService {

    UserResponse createUser(UserRequest request);

    String getUserRole(String email);

    List<UserResponse> readUsers();

    void deleteUser(String id);
}
