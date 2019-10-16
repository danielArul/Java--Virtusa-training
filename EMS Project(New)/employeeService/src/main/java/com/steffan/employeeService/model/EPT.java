package com.steffan.employeeService.model;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class EPT {

    @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer eptid;
    int eid;
    int pid;
    int tid;

    public EPT() {
    }

    public EPT(Integer eptid, int eid, int pid, int tid) {
        this.eptid = eptid;
        this.eid = eid;
        this.pid = pid;
        this.tid = tid;
    }

    public Integer getEptid() {
        return eptid;
    }

    public void setEptid(Integer eptid) {
        this.eptid = eptid;
    }

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    @Override
    public String toString() {
        return "EPT{" +
                "eptid=" + eptid +
                ", eid=" + eid +
                ", pid=" + pid +
                ", tid=" + tid +
                '}';
    }
}
