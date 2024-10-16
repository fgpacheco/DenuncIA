package br.com.denuncia.dto;

import java.io.Serial;
import java.io.Serializable;

public class ChoiceDTO implements Serializable {
    private static final long serialVersionUID = -7749934610613615906L;
    private int index;
    private MessageDTO message;
    private Object logprobs;
    private String finish_reason;

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public MessageDTO getMessage() {
        return message;
    }

    public void setMessage(MessageDTO message) {
        this.message = message;
    }

    public Object getLogprobs() {
        return logprobs;
    }

    public void setLogprobs(Object logprobs) {
        this.logprobs = logprobs;
    }

    public String getFinish_reason() {
        return finish_reason;
    }

    public void setFinish_reason(String finish_reason) {
        this.finish_reason = finish_reason;
    }

    @Override
    public String toString() {
        return "ChoiceDTO{" +
                "index=" + index +
                ", message=" + message +
                ", logprobs=" + logprobs +
                ", finish_reason='" + finish_reason + '\'' +
                '}';
    }
}
