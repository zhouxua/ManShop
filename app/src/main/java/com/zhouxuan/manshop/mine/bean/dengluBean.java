package com.zhouxuan.manshop.mine.bean;

/**
 * 周旋
 * 2017/11/13  18:34
 */

public class dengluBean {

    /**
     * msg : 登录成功
     * code : 0
     * data : {"age":null,"appkey":null,"appsecret":null,"createtime":"2017-11-13T15:30:37","email":null,"gender":0,"icon":null,"mobile":"15726649477","money":0,"nickname":null,"password":"123456","token":"7D7681906D11EB7DA06B04362688EB74","uid":983,"username":"15726649477"}
     */

    private String msg;
    private String code;

    public dengluBean(String msg, String code) {
        this.msg = msg;
        this.code = code;
    }

    public dengluBean() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "dengluBean{" +
                "msg='" + msg + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
