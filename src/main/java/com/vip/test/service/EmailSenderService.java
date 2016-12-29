package com.vip.test.service;

import com.vip.test.service.vo.EmailMessage;

import java.util.List;

/**
 * Created by jack on 16/12/4.
 */
public interface EmailSenderService {
    void send(EmailMessage emailMessage);

    void send(List<EmailMessage> emailMessages);
}
