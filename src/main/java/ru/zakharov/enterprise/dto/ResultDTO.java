package ru.zakharov.enterprise.dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ResultDTO {

    private Boolean success = true;

    private String message = "";

    public ResultDTO(Boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public ResultDTO() {

    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
