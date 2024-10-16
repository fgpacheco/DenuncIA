package br.com.denuncia.dto;

import java.io.Serializable;
import java.util.List;

public class ChatCompletionResponseDTO implements Serializable {
    private static final long serialVersionUID = 8634049749993269686L;

    public String id;
    public String object;
    public int created;
    public String model;
    public String system_fingerprint;
    public List<ChoiceDTO> choices;
    public UsageDTO usage;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public int getCreated() {
        return created;
    }

    public void setCreated(int created) {
        this.created = created;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getSystem_fingerprint() {
        return system_fingerprint;
    }

    public void setSystem_fingerprint(String system_fingerprint) {
        this.system_fingerprint = system_fingerprint;
    }

    public List<ChoiceDTO> getChoices() {
        return choices;
    }

    public void setChoices(List<ChoiceDTO> choices) {
        this.choices = choices;
    }

    public UsageDTO getUsage() {
        return usage;
    }

    public void setUsage(UsageDTO usage) {
        this.usage = usage;
    }

    @Override
    public String toString() {
        return "ChatCompletionResponseDTO{" +
                "id='" + id + '\'' +
                ", object='" + object + '\'' +
                ", created=" + created +
                ", model='" + model + '\'' +
                ", system_fingerprint='" + system_fingerprint + '\'' +
                ", choices=" + choices +
                ", usage=" + usage +
                '}';
    }
}
