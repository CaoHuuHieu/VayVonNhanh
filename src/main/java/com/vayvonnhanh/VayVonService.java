package com.vayvonnhanh;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class VayVonService {
	
	@Autowired
	ServicePackRepository servicePackRepository;
	@Autowired
	ImageStorageService imageStorageService;
	public List<ServicePackEntity> getAllServicePack() {
		return servicePackRepository.findAll();
	}
	
	public ServicePackEntity addNewServicePack(ServicePackRequest service) {
		ServicePackEntity servicePackEntity = new ServicePackEntity();
		servicePackEntity.setFirthLoan(service.getFirstLoan());
		servicePackEntity.setDescription(service.getDiscription());
		servicePackEntity.setMaxAge(service.getMaxAge());
		servicePackEntity.setMaxLoan(service.getMaxLoan());
		servicePackEntity.setMinAge(service.getMinAge());
		servicePackEntity.setLink(service.getLink());
		if(!service.getImageFile().isEmpty()) {
			String fileName = imageStorageService.storeFile(service.getImageFile());
			servicePackEntity.setImageName(fileName);
		}else {
			servicePackEntity.setImageName(null);
		}
		return servicePackRepository.save(servicePackEntity);
	}
	public ServicePackEntity updateServicePack(int id, ServicePackRequest servicePack) {
		ServicePackEntity servicePackEntity =  servicePackRepository.findById(id).orElse(null);
		if(servicePackEntity != null) {
			servicePackEntity.setFirthLoan(servicePack.getFirstLoan());
			servicePackEntity.setDescription(servicePack.getDiscription());
			servicePackEntity.setMaxAge(servicePack.getMaxAge());
			servicePackEntity.setMaxLoan(servicePack.getMaxLoan());
			servicePackEntity.setMinAge(servicePack.getMinAge());
			servicePackEntity.setLink(servicePack.getLink());
			if(!servicePack.getImageFile().isEmpty()) {
				String fileName = imageStorageService.storeFile(servicePack.getImageFile());
				servicePackEntity.setImageName(fileName);
			}
		}
		return servicePackRepository.save(servicePackEntity);
	}
	
	public void deleteServicePack(int id) {
		servicePackRepository.deleteById(id);
	}

	public ServicePackRequest getService(int id) {
		ServicePackEntity servicePackEntity =  servicePackRepository.findById(id).orElse(null);
		if(servicePackEntity != null) {
			ServicePackRequest servicePackRequest = new ServicePackRequest();
			servicePackRequest.setId(servicePackEntity.getId());
			servicePackRequest.setFirstLoan(servicePackEntity.getFirstLoan());
			servicePackRequest.setDiscription(servicePackEntity.getDescription());
			servicePackRequest.setMaxAge(servicePackEntity.getMaxAge());
			servicePackRequest.setMaxLoan(servicePackEntity.getMaxLoan());
			servicePackRequest.setMinAge(servicePackEntity.getMinAge());
			servicePackRequest.setLink(servicePackEntity.getLink());
			servicePackRequest.setImageName(servicePackEntity.getImageName());
			return servicePackRequest;
		}else
			return null;
		
	}
}
