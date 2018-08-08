package com.tgjs.dql.mymvpdemo.entity;

import java.io.File;

/**
 * Created by Administrator on 2017/9/9.
 */

public class UdCreditResultDto {


    /**
     * url_photoget :
     * flag_sex : 男
     * risk_tag : {"living_attack":"0"}
     * ret_msg : 交易成功
     * id_name : 王
     * be_idcard : 0.8865
     * id_no :
     * date_birthday :
     * url_frontcard :
     * addr_card :
     * branch_issued :
     * state_id : 汉
     * url_backcard :
     * ret_code : 000000
     * result_auth : T
     * start_card : 2010.11.23-2020.11.23
     * url_photoliving :
     * */

    //身份证头像
    private String url_photoget;
    //性别
    private String flag_sex;
    //风控参数
    private RiskTagBean risk_tag;
    //风控提示
    private String ret_msg;
    //姓名
    private String id_name;
    //相似度
    private String be_idcard;
    //身份证号
    private String id_no;
    //生日
    private String date_birthday;
    //身份证正面
    private String url_frontcard;
    //地址
    private String addr_card;
    //颁发部门
    private String branch_issued;
    //名族
    private String state_id;
    //身份证背面
    private String url_backcard;
    private String ret_code;
    //认证结果  T通过
    private String result_auth;
    //身份证颁发-到期时间
    private String start_card;
    //实人照片
    private String url_photoliving;
    private File img_fore;
    private File img_back;
    private File img_living;

    public File getImg_fore() {
        return img_fore;
    }

    public void setImg_fore(File img_fore) {
        this.img_fore = img_fore;
    }

    public File getImg_back() {
        return img_back;
    }

    public void setImg_back(File img_back) {
        this.img_back = img_back;
    }

    public File getImg_living() {
        return img_living;
    }

    public void setImg_living(File img_living) {
        this.img_living = img_living;
    }

    public String getTxl() {
        return txl;
    }

    public void setTxl(String txl) {
        this.txl = txl;
    }

    private String txl;

    public String getUrl_photoget() {
        return url_photoget;
    }

    public void setUrl_photoget(String url_photoget) {
        this.url_photoget = url_photoget;
    }

    public String getFlag_sex() {
        return flag_sex;
    }

    public void setFlag_sex(String flag_sex) {
        this.flag_sex = flag_sex;
    }

    public RiskTagBean getRisk_tag() {
        return risk_tag;
    }

    public void setRisk_tag(RiskTagBean risk_tag) {
        this.risk_tag = risk_tag;
    }

    public String getRet_msg() {
        return ret_msg;
    }

    public void setRet_msg(String ret_msg) {
        this.ret_msg = ret_msg;
    }

    public String getId_name() {
        return id_name;
    }

    public void setId_name(String id_name) {
        this.id_name = id_name;
    }

    public String getBe_idcard() {
        return be_idcard;
    }

    public void setBe_idcard(String be_idcard) {
        this.be_idcard = be_idcard;
    }

    public String getId_no() {
        return id_no;
    }

    public void setId_no(String id_no) {
        this.id_no = id_no;
    }

    public String getDate_birthday() {
        return date_birthday;
    }

    public void setDate_birthday(String date_birthday) {
        this.date_birthday = date_birthday;
    }

    public String getUrl_frontcard() {
        return url_frontcard;
    }

    public void setUrl_frontcard(String url_frontcard) {
        this.url_frontcard = url_frontcard;
    }

    public String getAddr_card() {
        return addr_card;
    }

    public void setAddr_card(String addr_card) {
        this.addr_card = addr_card;
    }

    public String getBranch_issued() {
        return branch_issued;
    }

    public void setBranch_issued(String branch_issued) {
        this.branch_issued = branch_issued;
    }

    public String getState_id() {
        return state_id;
    }

    public void setState_id(String state_id) {
        this.state_id = state_id;
    }

    public String getUrl_backcard() {
        return url_backcard;
    }

    public void setUrl_backcard(String url_backcard) {
        this.url_backcard = url_backcard;
    }

    public String getRet_code() {
        return ret_code;
    }

    public void setRet_code(String ret_code) {
        this.ret_code = ret_code;
    }

    public String getResult_auth() {
        return result_auth;
    }

    public void setResult_auth(String result_auth) {
        this.result_auth = result_auth;
    }

    public String getStart_card() {
        return start_card;
    }

    public void setStart_card(String start_card) {
        this.start_card = start_card;
    }

    public String getUrl_photoliving() {
        return url_photoliving;
    }

    public void setUrl_photoliving(String url_photoliving) {
        this.url_photoliving = url_photoliving;
    }

    public static class RiskTagBean {
        /**
         * living_attack : 0
         */

        private String living_attack;

        public String getLiving_attack() {
            return living_attack;
        }

        public void setLiving_attack(String living_attack) {
            this.living_attack = living_attack;
        }
    }
}
