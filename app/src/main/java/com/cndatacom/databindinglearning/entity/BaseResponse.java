package com.cndatacom.databindinglearning.entity;

/**
 * Created by Charlie on 2016/8/5.
 */
public class BaseResponse<T> {
    private Page<T> datas;
    private String message;
    private int state;

    public Page<T> getDatas() {
        return datas;
    }

    public void setDatas(Page<T> datas) {
        this.datas = datas;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
