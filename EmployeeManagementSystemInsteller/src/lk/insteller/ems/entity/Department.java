package lk.insteller.ems.entity;

// According To Java BeanSpec:
public class Department implements SuperEntity {

    private String depId;
    private String depName;

    public Department(String depId, String depName) {
        this.depId = depId;
        this.depName = depName;
    }

    public Department() {
    }

    public String getDepId() {
        return depId;
    }

    public void setDepId(String depId) {
        this.depId = depId;
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }

    @Override
    public String toString() {
        return "Department{" +
                "depId='" + depId + '\'' +
                ", depName='" + depName + '\'' +
                '}';
    }
}
