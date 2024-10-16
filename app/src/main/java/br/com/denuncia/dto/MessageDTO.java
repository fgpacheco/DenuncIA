package br.com.denuncia.dto;

import java.io.Serializable;

public class MessageDTO implements Serializable {
    private static final long serialVersionUID = -7889832670344783153L;

    private String role;
    private String content;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "MessageDTO{" +
                "role='" + role + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
