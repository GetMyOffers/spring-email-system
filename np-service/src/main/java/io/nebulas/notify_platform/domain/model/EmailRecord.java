package io.nebulas.notify_platform.domain.model;

import java.io.Serializable;
import java.util.Date;

/**
 * notify_platform.email_record  
 *
 * @author lisanaaa
 * @date 2018-6-21
 *
 */
public class EmailRecord implements Serializable {
    /**  */
    private Long id;

    /**  */
    private String receiver;

    /**  */
    private String sender;

    /**  */
    private String subject;

    /**  */
    private String content;

    /**  */
    private Date createdAt;

    /**  */
    private Integer isSuccess;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver == null ? null : receiver.trim();
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender == null ? null : sender.trim();
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject == null ? null : subject.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getIsSuccess() {
        return isSuccess;
    }

    public void setIsSuccess(Integer isSuccess) {
        this.isSuccess = isSuccess;
    }
}