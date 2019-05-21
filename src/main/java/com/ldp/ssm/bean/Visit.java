package com.ldp.ssm.bean;

import java.util.Date;

public class Visit {
    private Integer id;

    private Date visitTime;

    private String visitAddr;

    private String visitDetail;

    private Date visitNexttime;

    private Integer visitAdminId;

    private Integer visitEmployeeId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getVisitTime() {
        return visitTime;
    }

    public void setVisitTime(Date visitTime) {
        this.visitTime = visitTime;
    }

    public String getVisitAddr() {
        return visitAddr;
    }

    public void setVisitAddr(String visitAddr) {
        this.visitAddr = visitAddr == null ? null : visitAddr.trim();
    }

    public String getVisitDetail() {
        return visitDetail;
    }

    public void setVisitDetail(String visitDetail) {
        this.visitDetail = visitDetail == null ? null : visitDetail.trim();
    }

    public Date getVisitNexttime() {
        return visitNexttime;
    }

    public void setVisitNexttime(Date visitNexttime) {
        this.visitNexttime = visitNexttime;
    }

    public Integer getVisitAdminId() {
        return visitAdminId;
    }

    public void setVisitAdminId(Integer visitAdminId) {
        this.visitAdminId = visitAdminId;
    }

    public Integer getVisitEmployeeId() {
        return visitEmployeeId;
    }

    public void setVisitEmployeeId(Integer visitEmployeeId) {
        this.visitEmployeeId = visitEmployeeId;
    }
}