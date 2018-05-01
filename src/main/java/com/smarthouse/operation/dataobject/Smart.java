package com.smarthouse.operation.dataobject;

import java.util.Date;

/**
 * @Auther: davidddl
 * @Date: 2018/5/2 01:22
 * @Description:
 */
public class Smart {

    private Integer id;
    private String type;
    private String command;
    private Date operateTime;
    private String operator;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public Date getOperateTime() {
        return operateTime;
    }

    public void setOperateTime(Date operateTime) {
        this.operateTime = operateTime;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    @Override
    public String toString() {
        return "Smart{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", command='" + command + '\'' +
                ", operateTime=" + operateTime +
                ", operator='" + operator + '\'' +
                '}';
    }
}
