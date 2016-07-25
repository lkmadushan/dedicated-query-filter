package dao;

import entity.Role;

import java.util.List;

public class RoleDao extends Dao<Role> {

    public Role find(Integer id) {
        return super.find(Role.class, id);
    }

    public List<Role> all() {
        return this.all(Role.class);
    }
}
