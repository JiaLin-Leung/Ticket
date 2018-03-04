package com.TrictSystem.Beans;

import java.io.Serializable;
import java.util.List;

/**
 * Created by smile_raccoon on 2018/1/17.
 */

public class Ticket implements Serializable {

    private String message;
    private String next;
    private String response;
    private String error;
    private List<Ticket_Bean> data;

    @Override
    public String toString() {
        return "Ticket{" +
                "message='" + message + '\'' +
                ", next='" + next + '\'' +
                ", response='" + response + '\'' +
                ", error='" + error + '\'' +
                ", data=" + data +
                '}';
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

    public List<Ticket_Bean> getData() {
        return data;
    }

    public void setData(List<Ticket_Bean> data) {
        this.data = data;
    }

    public class Ticket_Bean implements Serializable{

        private String add_time;
        private String begin_time;
        private String domain;
        private String end_time;
        private String env_id;
        private String from_user_id;
        private String from_user_name;
        private String status_code;
        private String id;
        private String status;
        private String type;
        private String url;

        @Override
        public String toString() {
            return "Ticket_Bean{" +
                    "add_time='" + add_time + '\'' +
                    ", begin_time='" + begin_time + '\'' +
                    ", domain='" + domain + '\'' +
                    ", end_time='" + end_time + '\'' +
                    ", env_id='" + env_id + '\'' +
                    ", from_user_id='" + from_user_id + '\'' +
                    ", from_user_name='" + from_user_name + '\'' +
                    ", id='" + id + '\'' +
                    ", status='" + status + '\'' +
                    ", status_code='" + status_code + '\'' +
                    ", type='" + type + '\'' +
                    ", url='" + url + '\'' +
                    '}';
        }

        public String getAdd_time() {
            return add_time;
        }

        public void setAdd_time(String add_time) {
            this.add_time = add_time;
        }

        public String getBegin_time() {
            return begin_time;
        }

        public void setBegin_time(String begin_time) {
            this.begin_time = begin_time;
        }

        public String getDomain() {
            return domain;
        }

        public void setDomain(String domain) {
            this.domain = domain;
        }

        public String getEnd_time() {
            return end_time;
        }

        public void setEnd_time(String end_time) {
            this.end_time = end_time;
        }

        public String getEnv_id() {
            return env_id;
        }

        public void setEnv_id(String env_id) {
            this.env_id = env_id;
        }

        public String getFrom_user_id() {
            return from_user_id;
        }
        public String getFrom_user_name() {
            return from_user_name;
        }

        public void setFrom_user_id(String from_user_id) {
            this.from_user_id = from_user_id;
        }
        public void setFrom_user_name(String from_user_name) {
            this.from_user_name = from_user_name;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getStatus_code() {
            return status_code;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus_code(String status_code) {
            this.status_code = status_code;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
