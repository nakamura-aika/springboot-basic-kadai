package com.example.springkadaiform.form;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data // Lombokによるgetter・setterの自動生成
public class ContactForm {
    @NotBlank(message = "お名前を入力してください。")
    private String name;

    @NotBlank(message = "メールアドレスを入力してください。")
    @Email(message = "正しいメールアドレス形式を入力してください。")
    private String email;

    @NotBlank(message = "お問い合わせ内容を入力してください。")
    private String message;
}
