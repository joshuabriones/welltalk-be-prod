package com.communicators.welltalk.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.communicators.welltalk.Service.EmailService;

@RestController
public class EmailController {

    @Autowired
    private EmailService emailService;

    @GetMapping("/sendEmail")
    private String sendEmail() {
        String to = "kheisaselma0227@gmail.com";
        String subject = "Test Email";
        String htmlContent = "<!DOCTYPE html>\n" +
                "<html>\n" +
                "  <head>\n" +
                "    <title>Verified</title>\n" +
                "    <style>\n" +
                "      body {\n" +
                "        margin: auto;\n" +
                "        padding: 0;\n" +
                "        display: flex;\n" +
                "        flex-direction: column;\n" +
                "        justify-content: center;\n" +
                "        align-items: center;\n" +
                "      }\n" +
                "      .image-container {\n" +
                "        display: flex;\n" +
                "        justify-content: center;\n" +
                "        align-items: center;\n" +
                "        padding-top: 30px;\n" +
                "        padding-bottom: 30px;\n" +
                "      }\n" +
                "      h1 {\n" +
                "        text-align: center;\n" +
                "        background-color: #8a252c;\n" +
                "        color: white;\n" +
                "      }\n" +
                "      .small-heading {\n" +
                "        text-align: center;\n" +
                "        font-size: 15px;\n" +
                "        font-weight: 900;\n" +
                "        letter-spacing: 1px;\n" +
                "        color: #8a252c;\n" +
                "      }\n" +
                "      .title {\n" +
                "        text-align: center;\n" +
                "        font-size: 25px;\n" +
                "        font-weight: 900;\n" +
                "        letter-spacing: 1px;\n" +
                "        color: #474647;\n" +
                "        margin-bottom: 0;\n" +
                "        margin-top: 10px;\n" +
                "      }\n" +
                "      hr {\n" +
                "        width: 30%;\n" +
                "        margin-top: 10px;\n" +
                "        margin-bottom: 5px;\n" +
                "        border: 1px solid #8a252c;\n" +
                "      }\n" +
                "      .content {\n" +
                "        text-align: center;\n" +
                "        font-size: 12px;\n" +
                "        font-weight: 500;\n" +
                "        letter-spacing: 1px;\n" +
                "        color: #474647;\n" +
                "        margin-left: 30px;\n" +
                "        margin-right: 30px;\n" +
                "      }\n" +
                "      span {\n" +
                "        font-weight: 900;\n" +
                "        color: #8a252c;\n" +
                "      }\n" +
                "      .button {\n" +
                "        display: inline-block;\n" +
                "        padding: 10px 20px;\n" +
                "        font-size: 16px;\n" +
                "        color: white;\n" +
                "        background-color: #8a252c;\n" +
                "        border: none;\n" +
                "        border-radius: 5px;\n" +
                "        text-align: center;\n" +
                "        text-decoration: none;\n" +
                "        text-align: center;\n" +
                "        text-decoration: none;\n" +
                "        margin: auto;\n" +
                "        margin-top: 10px;\n" +
                "        margin-bottom: 10px;\n" +
                "      }\n" +
                "      .footer {\n" +
                "        background-color: #474647;\n" +
                "        height: 100px;\n" +
                "        margin: 10px 20px 0 20px;\n" +
                "        padding: 10px;\n" +
                "      }\n" +
                "      .logo {\n" +
                "        width: 20%;\n" +
                "      }\n" +
                "      .header {\n" +
                "        display: flex;\n" +
                "        justify-content: center; /* Horizontally centers the image */\n" +
                "        align-items: center;\n" +
                "      }\n" +
                "    </style>\n" +
                "  </head>\n" +
                "\n" +
                "  <body>\n" +
                "    <div class=\"header\">\n" +
                "      <img src=\"logowords.png\" class=\"logo\" />\n" +
                "    </div>\n" +
                "    <div class=\"image-container\">\n" +
                "      <img src=\"approve.png\" alt=\"Email\" style=\"width: 100px; height: 100px\" />\n" +
                "    </div>\n" +
                "    <p class=\"small-heading\">ACCOUNT IS VERIFIED</p>\n" +
                "    <p class=\"title\">Your Account is Verified</p>\n" +
                "    <hr />\n" +
                "    <p class=\"content\">\n" +
                "      <span>Congratulations!</span> Your WellTalk account has been successfully\n" +
                "      verified. <br /><br />\n" +
                "\n" +
                "      You’re all set to begin exploring and enjoying seamless appointment\n" +
                "      booking with integrated journals and logs. Simply click the button below\n" +
                "      to log in and start using WellTalk.\n" +
                "    </p>\n" +
                "\n" +
                "    <a class=\"button\" href=\"https://localhost:3000/\">Go to WellTalk</a>\n" +
                "\n" +
                "    <p class=\"content\">\n" +
                "      If the button isn't clickable, please use the following link instead:\n" +
                "      <a href=\"https://localhost:3000/\">https://localhost:3000/</a>\n" +
                "    </p>\n" +
                "\n" +
                "    <!-- <div class=\"footer\">\n" +
                "      <div class=\"header\">\n" +
                "        <img src=\"welltalk.png\" class=\"logo\" />\n" +
                "        <img src=\"welltalk-text.jpg\" class=\"logo-text\" />\n" +
                "      </div>\n" +
                "    </div> -->\n" +
                "  </body>\n" +
                "</html>";

        try {
            emailService.sendHtmlMessage(to, subject, htmlContent);
            return "Email sent successfully";
        } catch (Exception e) {
            e.printStackTrace();
            return "Failed to send email: " + e.getMessage();
        }
    }
}
