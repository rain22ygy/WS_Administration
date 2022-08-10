package com.wushang.bean;

public class userInformation {
//            `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '人员编号',
//            `regname` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '人员名称',
//            `phone` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '电话号码',
//            `sex` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '性别',
//            `age` int(10) NULL DEFAULT NULL COMMENT '年龄',
//            `wsid` int(20) NULL DEFAULT NULL COMMENT '武商ID',
//            `upload` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '照片',
//            `regtime` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '注册时间',
//            `department` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '部门名称',
//            `password` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
//            `address` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '地点',
//            `deptId` int(50) NULL DEFAULT NULL COMMENT '部门ID',
//            `status` int(1) UNSIGNED ZEROFILL NOT NULL DEFAULT 1 COMMENT '是否已删除',
//    PRIMARY KEY (`id`) USING BTREE
    private int id;
    private String regname;
    private String phone;
    private String sex;
    private int age;
    private int wsid;
    private String upload;
    private String regtime;
    private String department;
    private String password;
    private String address;
    private int deptId;

    public userInformation() {
    }

    @Override
    public String toString() {
        return "userInformation{" +
                "id=" + id +
                ", regname='" + regname + '\'' +
                ", phone='" + phone + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", wsid=" + wsid +
                ", upload='" + upload + '\'' +
                ", regtime='" + regtime + '\'' +
                ", department='" + department + '\'' +
                ", password='" + password + '\'' +
                ", address='" + address + '\'' +
                ", deptId=" + deptId +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRegname() {
        return regname;
    }

    public void setRegname(String regname) {
        this.regname = regname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getWsid() {
        return wsid;
    }

    public void setWsid(int wsid) {
        this.wsid = wsid;
    }

    public String getUpload() {
        return upload;
    }

    public void setUpload(String upload) {
        this.upload = upload;
    }

    public String getRegtime() {
        return regtime;
    }

    public void setRegtime(String regtime) {
        this.regtime = regtime;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    public userInformation(int id, String regname, String phone, String sex, int age, int wsid, String upload, String regtime, String department, String password, String address, int deptId) {
        this.id = id;
        this.regname = regname;
        this.phone = phone;
        this.sex = sex;
        this.age = age;
        this.wsid = wsid;
        this.upload = upload;
        this.regtime = regtime;
        this.department = department;
        this.password = password;
        this.address = address;
        this.deptId = deptId;
    }
}
