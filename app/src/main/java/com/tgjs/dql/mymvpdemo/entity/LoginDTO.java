package com.tgjs.dql.mymvpdemo.entity;

/**
 * Created by Administrator on 2017/9/9.
 */

public class LoginDTO {


    /**
     * msg : 登录成功
     * code : 1000
     * data : {"phone":"15869125947","authen_status":"1","user_id":"4","real_name":"王祯豪","card_id":"330903199301030218","age":"24","token":"8f8f2226c0338efa93ef8381ad886ad6"}
     */

    private String msg;
    private String code;
    private DataBean data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * phone : 15869125947
         * authen_status : 1
         * user_id : 4
         * real_name : 王祯豪
         * card_id : 330903199301030218
         * age : 24
         * token : 8f8f2226c0338efa93ef8381ad886ad6
         */

        private String phone;
        private String authen_status;
        private String user_id;
        private String real_name;
        private String card_id;
        private String age;
        private String token;
        private String bank_no;
        private String add_time;

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getAuthen_status() {
            return authen_status;
        }

        public void setAuthen_status(String authen_status) {
            this.authen_status = authen_status;
        }

        public String getUser_id() {
            return user_id;
        }

        public void setUser_id(String user_id) {
            this.user_id = user_id;
        }

        public String getReal_name() {
            return real_name;
        }

        public void setReal_name(String real_name) {
            this.real_name = real_name;
        }

        public String getCard_id() {
            return card_id;
        }

        public void setCard_id(String card_id) {
            this.card_id = card_id;
        }

        public String getAge() {
            return age;
        }

        public void setAge(String age) {
            this.age = age;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public String getAdd_time() {
            return add_time;
        }

        public void setAdd_time(String add_time) {
            this.add_time = add_time;
        }
        public String getBank_no() {
            return bank_no;
        }

        public void setBank_no(String bank_no) {
            this.bank_no = bank_no;
        }

    }
}
