package kz.bitlab.G114crm.services;

import kz.bitlab.G114crm.models.ApplicationRequest;
import kz.bitlab.G114crm.repositories.ApplicationRequestRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class ApplicationRequestService {
    @Autowired
    private ApplicationRequestRepo applicationRequestRepo;

    public List<ApplicationRequest> getAppReqs() {
        List<ApplicationRequest> appReqList = applicationRequestRepo.findAll();
        return appReqList.stream()
//                .filter(appReq -> appReq.isHandled())
                .sorted(Comparator.comparing(ApplicationRequest::getUserName))
                .toList();
    }

    public ApplicationRequest getAppReqById(Long id) {
        return applicationRequestRepo.findById(id).orElse(null);
    }
}
