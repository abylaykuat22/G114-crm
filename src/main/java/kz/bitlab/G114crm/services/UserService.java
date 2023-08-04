package kz.bitlab.G114crm.services;

import java.util.Set;
import kz.bitlab.G114crm.models.Role;
import kz.bitlab.G114crm.models.User;
import kz.bitlab.G114crm.repositories.RoleRepository;
import kz.bitlab.G114crm.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

  @Autowired
  private UserRepository userRepository;
  @Autowired
  private RoleService roleService;

  public List<User> getUsers() {
    return userRepository.findAll();
  }

  public void addRoleToUser(Long userId, Long roleId) {
    User user = userRepository.findById(userId).orElse(null);
    Role role = roleService.getRoleById(roleId);
    if (user == null || role == null) {
      return;
    }
    Set<Role> roles = user.getRoles();
    roles.add(role);
    user.setRoles(roles);
    userRepository.save(user);
  }

  public void deleteRoleFromUser(Long userId, Long roleId) {
    User user = userRepository.findById(userId).orElse(null);
    Role role = roleService.getRoleById(roleId);
    if (user == null || role == null) {
      return;
    }
    Set<Role> roles = user.getRoles();
    roles.remove(role);
    user.setRoles(roles);
    userRepository.save(user);
  }
}
