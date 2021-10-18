package lk.insteller.ems.util;

public class DepartmentTM {

    private String depId;
    private String depName;

    public DepartmentTM(String depId, String depName) {
        this.depId = depId;
        this.depName = depName;
    }

    public DepartmentTM() {
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
        return "DepartmentTM{" +
                "depId='" + depId + '\'' +
                ", depName='" + depName + '\'' +
                '}';
    }
}
