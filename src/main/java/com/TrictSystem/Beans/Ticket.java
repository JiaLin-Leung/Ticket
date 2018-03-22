package com.TrictSystem.Beans;

import java.io.Serializable;
import java.util.List;

/**
 * Created by smile_raccoon on 2018/1/17.
 */

public class Ticket implements Serializable {

    /**
     * 数据库返回信息
     */
    private String message;
    /**
     * 是否有下一页
     */
    private String next;
    /**
     * 响应值
     */
    private String response;
    /**
     * 错误响应信息
     */
    private String error;
    /**
     * LIST形式数据返回
     */
    private List<Ticket_Bean> data;

    @Override
    /**
     * tostring方法
     */
    public String toString() {
        return "Ticket{" +
                "message='" + message + '\'' +
                ", next='" + next + '\'' +
                ", response='" + response + '\'' +
                ", error='" + error + '\'' +
                ", data=" + data +
                '}';
    }

    /**
     * 获得返回信息
     * @return string类型
     */
    public String getMessage() {
        return message;
    }

    /**
     * 设置返回信息
     * @param message 将数据库返回信息设置到javabean
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * 获得下一页标记
     * @return  字符串1 or 0 or other
     */
    public String getNext() {
        return next;
    }

    /**
     * 设置下一页标记
     * @param next
     */
    public void setNext(String next) {
        this.next = next;
    }

    /**
     * 获得返回状态值
     * @return 200 or 500 or other
     */
    public String getResponse() {
        return response;
    }

    /**
     * 设置返回状态值
     * @param response
     */
    public void setResponse(String response) {
        this.response = response;
    }


    /**
     * 获得错误信息
     * @return
     */
    public String getError() {
        return error;
    }

    /**
     * 设置错误信息
     * @param error
     */
    public void setError(String error) {
        this.error = error;
    }

    /**
     * 获得从服务器获得的lIST类型数据
     * @return Ticket_Bean类型的LIST数据
     */
    public List<Ticket_Bean> getData() {
        return data;
    }

    /**
     * 设置数据
     * @param data
     */
    public void setData(List<Ticket_Bean> data) {
        this.data = data;
    }

    public class Ticket_Bean implements Serializable{

        /**
         * 添加时间
         */
        private String add_time;
        /**
         * 任务开始时间
         */
        private String begin_time;
        /**
         * 域名
         */
        private String domain;
        /**
         * 任务结束时间
         */
        private String end_time;
        private String env_id;
        /**
         * 指向人ID
         */
        private String from_user_id;
        /**
         * 指向人用户名
         */
        private String from_user_name;
        /**
         * 状态值
         */
        private String status_code;
        /**
         * 任务ID
         */
        private String id;
        /**
         * 任务状态
         */
        private String status;
        /**
         * 任务类型
         */
        private String type;
        /**
         * URL
         */
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
