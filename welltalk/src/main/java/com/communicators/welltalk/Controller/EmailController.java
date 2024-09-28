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
                "        margin: 0;\n" +
                "        padding: 0;\n" +
                "        font-family: Arial, sans-serif;\n" +
                "        background-color: #f4f4f4;\n" +
                "      }\n" +
                "    </style>\n" +
                "  </head>\n" +
                "  <body>\n" +
                "    <table align=\"center\" width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" style=\"background-color: #f4f4f4; padding: 20px;\">\n"
                +
                "      <tr>\n" +
                "        <td align=\"center\">\n" +
                "          <table width=\"600\" cellpadding=\"0\" cellspacing=\"0\" style=\"background-color: #ffffff; padding: 20px;\">\n"
                +
                "            <tr>\n" +
                "              <td align=\"center\" style=\"padding: 20px;\">\n" +
                "                <img src=\"cid:imageId1\" alt=\"Logo\" width=\"150\" style=\"display: block; margin: 0 auto;\" />\n"
                +
                "              </td>\n" +
                "            </tr>\n" +
                "            <tr>\n" +
                "              <td align=\"center\" style=\"padding: 20px;\">\n" +
                "                <img src=\"cid:imageId2\" alt=\"Email\" width=\"100\" height=\"100\" style=\"display: block; margin: 0 auto;\" />\n"
                +
                "              </td>\n" +
                "            </tr>\n" +
                "            <tr>\n" +
                "              <td align=\"center\">\n" +
                // " <p style=\"font-size: 15px; font-weight: bold; color: #8a252c; margin: 10px
                // 0;\">ACCOUNT IS VERIFIED</p>\n"
                // +
                "                <p style=\"font-size: 25px; font-weight: bold; color: #474647; margin: 10px 0;\">Your Account is Verified</p>\n"
                +
                "                <hr style=\"border: 1px solid #8a252c; width: 30%; margin: 10px auto;\" />\n" +
                "                <p style=\"font-size: 12px; color: #474647; line-height: 1.5; margin: 20px;\">\n" +
                "                  <span style=\"font-weight: bold; color: #8a252c;\">Congratulations!</span> Your WellTalk account has been successfully\n"
                +
                "                  verified. You’re all set to begin exploring and enjoying seamless appointment booking with integrated journals and logs.\n"
                +
                "                  Simply click the button below to log in and start using WellTalk.\n" +
                "                </p>\n" +
                "                <a href=\"https://localhost:3000/\" style=\"background-color: #8a252c; color: #ffffff; padding: 10px 20px; text-decoration: none; border-radius: 5px; display: inline-block;\">Go to WellTalk</a>\n"
                +
                "                <p style=\"font-size: 12px; color: #474647; margin-top: 10px;\">\n" +
                "                  If the button isn't clickable, please use the following link instead:\n" +
                "                  <a href=\"https://localhost:3000/\" style=\"color: #8a252c;\">https://localhost:3000/</a>\n"
                +
                "                </p>\n" +
                "              </td>\n" +
                "            </tr>\n" +
                "          </table>\n" +
                "        </td>\n" +
                "      </tr>\n" +
                "    </table>\n" +
                "  </body>\n" +
                "</html>";

        // Paths for the images you want to embed
        String image1Path = "C:/Users/User/Documents/GitHub/Welltalk-backend/welltalk/src/main/resources/static/images/logowords.png";
        String image2Path = "C:/Users/User/Documents/GitHub/Welltalk-backend/welltalk/src/main/resources/static/images/approve.png";

        try {
            // Send the email with the HTML content and images
            emailService.sendHtmlMessage(to, subject, htmlContent, image1Path, image2Path);
            return "Email sent successfully";
        } catch (Exception e) {
            e.printStackTrace();
            return "Failed to send email: " + e.getMessage();
        }
    }
}
