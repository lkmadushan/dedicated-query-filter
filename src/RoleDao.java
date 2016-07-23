public class RoleDao extends Dao<Role> {

    public Role find(Integer id) {
        return super.find(Role.class, id);
    }
}
