package sy.model;

public class RoleResource {
    private String id;

    private String roleid;

    private String resourceid;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getRoleid() {
        return roleid;
    }

    public void setRoleid(String roleid) {
        this.roleid = roleid == null ? null : roleid.trim();
    }

    public String getResourceid() {
        return resourceid;
    }

    public void setResourceid(String resourceid) {
        this.resourceid = resourceid == null ? null : resourceid.trim();
    }
}