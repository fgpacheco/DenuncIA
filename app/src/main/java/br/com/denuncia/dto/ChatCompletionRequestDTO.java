package br.com.denuncia.dto;

import java.io.Serializable;
import java.util.List;

public class ChatCompletionRequestDTO implements Serializable {

    private static final long serialVersionUID = 1103712262295992644L;

    private String model;
    private List<MessageDTO> messages;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public List<MessageDTO> getMessages() {
        return messages;
    }

    public void setMessages(List<MessageDTO> messages) {
        this.messages = messages;
    }

    @Override
    public String toString() {
        return "ChatCompletionRequestDTO{" +
                "model='" + model + '\'' +
                ", messages=" + messages +
                '}';
    }
}
