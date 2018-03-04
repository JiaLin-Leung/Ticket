package com.TrictSystem.Beans;

import java.io.Serializable;

/**
 * Created by smile_raccoon on 2018/1/13.
 */

public class User implements Serializable {

    private String message;
    private String next;
    private String response;
    private String error;
    private User_bean data;

    public class User_bean implements Serializable{
        private String username;
        private String user_id;
        private String mobile;
        private String token_expired;
        private String is_active;
        private String access_token;
        private String proj_ids;
        private String is_supper;
        private String role_id;
        private String nickname;
        private String email;
        private String password_hash;

        @Override
        public String toString() {
            return "User_bean{" +
                    "username='" + username + '\'' +
                    ", user_id='" + user_id + '\'' +
                    ", mobile='" + mobile + '\'' +
                    ", token_expired='" + token_expired + '\'' +
                    ", is_active='" + is_active + '\'' +
                    ", access_token='" + access_token + '\'' +
                    ", proj_ids='" + proj_ids + '\'' +
                    ", is_supper='" + is_supper + '\'' +
                    ", role_id='" + role_id + '\'' +
                    ", nickname='" + nickname + '\'' +
                    ", email='" + email + '\'' +
                    ", password_hash='" + password_hash + '\'' +
                    '}';
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getUser_id() {
            return user_id;
        }

        public void setUser_id(String user_id) {
            this.user_id = user_id;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getToken_expired() {
            return token_expired;
        }

        public void setToken_expired(String token_expired) {
            this.token_expired = token_expired;
        }

        public String getIs_active() {
            return is_active;
        }

        public void setIs_active(String is_active) {
            this.is_active = is_active;
        }

        public String getAccess_token() {
            return access_token;
        }

        public void setAccess_token(String access_token) {
            this.access_token = access_token;
        }

        public String getProj_ids() {
            return proj_ids;
        }

        public void setProj_ids(String proj_ids) {
            this.proj_ids = proj_ids;
        }

        public String getIs_supper() {
            return is_supper;
        }

        public void setIs_supper(String is_supper) {
            this.is_supper = is_supper;
        }

        public String getRole_id() {
            return role_id;
        }

        public void setRole_id(String role_id) {
            this.role_id = role_id;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPassword_hash() {
            return password_hash;
        }

        public void setPassword_hash(String password_hash) {
            this.password_hash = password_hash;
        }
    }

    public User_bean getUser_bean() {
        return data;
    }

    public void setUser_bean(User_bean user_bean) {
        this.data = user_bean;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    @Override
    public String toString() {
        return "User{" +
                "message='" + message + '\'' +
                ", next='" + next + '\'' +
                ", response='" + response + '\'' +
                ", error='" + error + '\'' +
                ", user_bean=" + data +
                '}';
    }
}
