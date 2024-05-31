package com.communicators.welltalk.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.communicators.welltalk.Entity.InquiryEntity;
import com.communicators.welltalk.Repository.InquiryRepository;

import java.util.List;

@Service
public class InquiryService {

    @Autowired
    InquiryRepository inquiryRepository;

    @Autowired
    UserService userService;

    @Autowired
    EmailService emailService;

    public List<InquiryEntity> getAllInquiries() {
        return inquiryRepository.findByIsDeletedFalse();
    }

    public InquiryEntity getInquiryByInquiryId(int id) {
        return inquiryRepository.findByInquiryIdAndIsDeletedFalse(id).get();
    }

    public InquiryEntity registerInquiry(int userId, InquiryEntity inquiry) {
        inquiry.setSender(userService.getUserById(userId));
        return inquiryRepository.save(inquiry);
    }

    @SuppressWarnings("finally")
    public InquiryEntity updateInquiry(int id, InquiryEntity inquiry) {
        InquiryEntity inquiryToUpdate = new InquiryEntity();
        try {
            inquiryToUpdate = inquiryRepository.findByInquiryIdAndIsDeletedFalse(id).get();
            inquiryToUpdate.setSubject(inquiry.getSubject());
            inquiryToUpdate.setMessageInquiry(inquiry.getMessageInquiry());
        } catch (Exception e) {
            throw new IllegalArgumentException("Inquiry " + id + " does not exist.");
        } finally {
            return inquiryRepository.save(inquiryToUpdate);
        }
    }

    public InquiryEntity replyInquiry(int id, int counselorId, InquiryEntity inquiry) {
        InquiryEntity inquiryToUpdate = inquiryRepository.findByInquiryIdAndIsDeletedFalse(id).get();
        inquiryToUpdate.setCounselor(userService.getUserById(counselorId));
        inquiryToUpdate.setCounselorReply(inquiry.getCounselorReply());
        inquiryToUpdate.setStatus(true);

        InquiryEntity success = inquiryRepository.save(inquiryToUpdate);

        if (success != null) {
            String message = "You have a new reply from your counselor("
                    + success.getCounselor().getInstitutionalEmail() + "). Subject: " + inquiryToUpdate.getSubject()
                    + " Message: " + inquiryToUpdate.getCounselorReply();

            emailService.sendSimpleMessage(inquiryToUpdate.getSender().getInstitutionalEmail(), "Reply from Inquiry",
                    message);
        }

        return success;
    }

    public boolean deleteInquiry(int id) {
        InquiryEntity inquiry = inquiryRepository.findByInquiryIdAndIsDeletedFalse(id).get();
        if (inquiry != null) {
            inquiry.setIsDeleted(true);
            inquiryRepository.save(inquiry);
            return true;
        } else {
            System.out.println("Inquiry " + id + " does not exist.");
            return false;
        }
    }
}
