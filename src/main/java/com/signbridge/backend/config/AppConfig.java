package com.signbridge.backend.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class AppConfig {
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

//    "Encrypt" vs "Hash" — yeh same nahi hai
    //
    //Encryption (jaise AES) — reversible hai. Tumhare paas ek "key" hoti hai jisse tum encrypted data ko decrypt karke wapas original nikal sakte ho. (Example: WhatsApp messages encrypted hote hain, par receiver unhe decrypt karke padh leta hai)
    //Hashing (BCrypt) — irreversible hai. Koi key nahi hai jisse tum wapas original nikal sako. Ek one-way scrambling hai, decrypt karne ka koi raasta hi nahi hai — chahe tumhare paas server ka full access ho, source code ho, sab ho.
}
