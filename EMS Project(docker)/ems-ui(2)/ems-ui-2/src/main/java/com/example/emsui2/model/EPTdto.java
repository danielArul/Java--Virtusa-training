package com.example.emsui2.model;

import java.util.Arrays;

public class EPTdto {
    int eid;
    int pid;
    int[] tids;

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

    public int[] getTids() {
        return tids;
    }

    public void setTids(int[] tids) {
        this.tids = tids;
    }

    @Override
    public String toString() {
        return "EPTdto{" +
                "eid=" + eid +
                ", pid=" + pid +
                ", tids=" + Arrays.toString(tids) +
                '}';
    }
}
