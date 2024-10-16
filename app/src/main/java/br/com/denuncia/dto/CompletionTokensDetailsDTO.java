package br.com.denuncia.dto;

import java.io.Serializable;

public class CompletionTokensDetailsDTO implements Serializable {
    private static final long serialVersionUID = 4209767429718302803L;

    private int reasoning_tokens;

    public int getReasoning_tokens() {
        return reasoning_tokens;
    }

    public void setReasoning_tokens(int reasoning_tokens) {
        this.reasoning_tokens = reasoning_tokens;
    }

    @Override
    public String toString() {
        return "CompletionTokensDetailsDTO{" +
                "reasoning_tokens=" + reasoning_tokens +
                '}';
    }
}
