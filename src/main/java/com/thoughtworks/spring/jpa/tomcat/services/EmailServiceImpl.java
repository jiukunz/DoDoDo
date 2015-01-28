package com.thoughtworks.spring.jpa.tomcat.services;

import com.thoughtworks.spring.jpa.tomcat.entities.User;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;
import org.springframework.ui.velocity.VelocityEngineUtils;

import javax.mail.internet.MimeMessage;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by dwwang on 1/28/15.
 */
@Service
public class EmailServiceImpl implements EmailService{
    private static final String FROM = "admin@dododo.com";
    private static final String REGISTRATION_CONFIRMATION_VM = "registration-confirmation.vm";
    @Autowired
    private JavaMailSender mailSender;
    @Autowired
    private VelocityEngine velocityEngine;
    @Override
    public void sendConfirmEmail(final User user) {
        MimeMessagePreparator preparator = new MimeMessagePreparator() {
            public void prepare(MimeMessage mimeMessage) throws Exception {
                MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
                message.setTo(user.getEmail());
                message.setFrom(FROM);
                message.setSubject("Confirm Your Registration");
                Map model = new HashMap();
                model.put("userName", user.getFirstName()+user.getLastName());
                model.put("code", user.getId());
                String text = VelocityEngineUtils.mergeTemplateIntoString(
                    velocityEngine, REGISTRATION_CONFIRMATION_VM, "UTF-8", model);
                message.setText(text, true);
            }
        };
        this.mailSender.send(preparator);
    }

    @Override
    public void sendRecoveryEmail(User user) {

    }
}
