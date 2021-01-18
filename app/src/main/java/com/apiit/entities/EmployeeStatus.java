package com.apiit.entities;

public class EmployeeStatus {
    private Integer id;
    private boolean activeStatus;

    public EmployeeStatus() {
    }

//    @Override
//   public String toString() {
//        return "EmployeeStatus{" +
//                "id=" + id +
//                ", employee=" + employee +
//                ", activeStatus=" + activeStatus +
//                '}';
//    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

//    public Employee getEmployee() {
//        return employee;
//    }
//
//    public void setEmployee(Employee employee) {
//        this.employee = employee;
//    }

    public boolean isActiveStatus() {
        return activeStatus;
    }

    public void setActiveStatus(boolean activeStatus) {
        this.activeStatus = activeStatus;
    }
}
