package br.com.denuncia.dto;

import java.io.Serializable;

public class UsageDTO implements Serializable {

    private static final long serialVersionUID = 2429789964043536214L;

    private int prompt_tokens;
    private int completion_tokens;
    private int total_tokens;
    private CompletionTokensDetailsDTO completion_tokens_details;

    public int getPrompt_tokens() {
        return prompt_tokens;
    }

    public void setPrompt_tokens(int prompt_tokens) {
        this.prompt_tokens = prompt_tokens;
    }

    public int getCompletion_tokens() {
        return completion_tokens;
    }

    public void setCompletion_tokens(int completion_tokens) {
        this.completion_tokens = completion_tokens;
    }

    public int getTotal_tokens() {
        return total_tokens;
    }

    public void setTotal_tokens(int total_tokens) {
        this.total_tokens = total_tokens;
    }

    public CompletionTokensDetailsDTO getCompletion_tokens_details() {
        return completion_tokens_details;
    }

    public void setCompletion_tokens_details(CompletionTokensDetailsDTO completion_tokens_details) {
        this.completion_tokens_details = completion_tokens_details;
    }

    @Override
    public String toString() {
        return "UsageDTO{" +
                "prompt_tokens=" + prompt_tokens +
                ", completion_tokens=" + completion_tokens +
                ", total_tokens=" + total_tokens +
                ", completion_tokens_details=" + completion_tokens_details +
                '}';
    }
}
