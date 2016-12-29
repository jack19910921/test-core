package com.vip.test.service.impl;

import com.vip.test.service.EmailSenderService;
import com.vip.test.service.vo.EmailMessage;
import lombok.extern.java.Log;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;
import org.springframework.ui.velocity.VelocityEngineUtils;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import javax.mail.internet.MimeMessage;
import java.util.List;

/**
 * Created by jack on 16/12/4.
 */
@Log
@Service
public class EmailSenderServiceImpl implements EmailSenderService {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private VelocityEngine velocityEngine;

    @Override
    public void send(final EmailMessage emailMessage) {
        if (emailMessage != null) {
            Assert.hasText(emailMessage.getTemplatePath(), "templatePath is required");

            mailSender.send(new MimeMessagePreparator() {

                public void prepare(MimeMessage mimeMessage) throws Exception {
                    MimeMessageHelper message = new MimeMessageHelper(mimeMessage, emailMessage.getCharset());
                    message.setTo(emailMessage.getTo());
                    message.setFrom(emailMessage.getFrom());
                    message.setSubject(emailMessage.getSubject());
                    String text = VelocityEngineUtils.mergeTemplateIntoString(
                            velocityEngine, emailMessage.getTemplatePath(), emailMessage.getCharset(),
                            emailMessage.getParam());
                    message.setText(text, true);
                }
            });
        }
    }

    @Override
    public void send(List<EmailMessage> emailMessages) {
        if (!CollectionUtils.isEmpty(emailMessages)) {
            for (EmailMessage message : emailMessages) {
                send(message);
            }
        }
    }
}
