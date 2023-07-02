package com.vayvonnhanh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vayvonnhanh.entity.AppEntity;
import com.vayvonnhanh.entity.BankEntity;
import com.vayvonnhanh.repository.AppRepository;
import com.vayvonnhanh.repository.BankRepository;
import com.vayvonnhanh.request.AppDTO;
import com.vayvonnhanh.request.BankDTO;

@Service
public class VayVonService {
	@Autowired
	AppRepository appRepository;
	@Autowired
	BankRepository bankRepository;
	@Autowired
	ImageStorageService imageStorageService;
	public List<AppEntity> getApps() {
		return appRepository.findAll();
	}
	
	public AppEntity addNewApp(AppDTO app) {
		AppEntity servicePackEntity = new AppEntity();
		servicePackEntity.setMinLoan(app.getMinLoan());
		servicePackEntity.setName(app.getName());
		servicePackEntity.setMaxLoan(app.getMaxLoan());
		servicePackEntity.setLink(app.getLink());
		if(!app.getImageFile().isEmpty()) {
			String fileName = imageStorageService.storeFile(app.getImageFile());
			servicePackEntity.setImageName(fileName);
		}else {
			servicePackEntity.setImageName(null);
		}
		return appRepository.save(servicePackEntity);
	}
	public AppEntity updateApp(int id, AppDTO app) {
		AppEntity servicePackEntity =  appRepository.findById(id).orElse(null);
		if(servicePackEntity != null) {
			servicePackEntity.setMinLoan(app.getMinLoan());
			servicePackEntity.setName(app.getName());
			servicePackEntity.setMaxLoan(app.getMaxLoan());
			servicePackEntity.setLink(app.getLink());
			if(!app.getImageFile().isEmpty()) {
				String fileName = imageStorageService.storeFile(app.getImageFile());
				servicePackEntity.setImageName(fileName);
			}
		}
		return appRepository.save(servicePackEntity);
	}
	
	public void deleteApp(int id) {
		appRepository.deleteById(id);
	}

	public AppDTO getAppById(int id) {
		AppEntity servicePackEntity =  appRepository.findById(id).orElse(null);
		if(servicePackEntity != null) {
			AppDTO app = new AppDTO();
			app.setId(servicePackEntity.getId());
			app.setMinLoan(servicePackEntity.getMinLoan());
			app.setName(servicePackEntity.getName());
			app.setMaxLoan(servicePackEntity.getMaxLoan());
			app.setLink(servicePackEntity.getLink());
			app.setImageName(servicePackEntity.getImageName());
			return app;
		}else
			return null;
		
	}
	
	public List<BankEntity> getAllBank() {
		return bankRepository.findAll();
	}
	
	public BankEntity addNewBank(BankDTO bank) {
		BankEntity bankEntity = new BankEntity();
		bankEntity.setName(bank.getName());
		bankEntity.setLink(bank.getLink());
		bankEntity.setHeading(bank.getHeading());
		bankEntity.setDiscription(bank.getDiscription());
		if(!bank.getImageFile().isEmpty()) {
			String fileName = imageStorageService.storeFile(bank.getImageFile());
			bankEntity.setImageName(fileName);
		}else {
			bankEntity.setImageName(null);
		}
		return bankRepository.save(bankEntity);
	}
	public BankEntity updateBank(int id, BankDTO bank) {
		BankEntity bankEntity =  bankRepository.findById(id).orElse(null);
		if(bankEntity != null) {
			bankEntity.setName(bank.getName());
			bankEntity.setLink(bank.getLink());
			bankEntity.setHeading(bank.getHeading());
			bankEntity.setDiscription(bank.getDiscription());
			if(!bank.getImageFile().isEmpty()) {
				String fileName = imageStorageService.storeFile(bank.getImageFile());
				bankEntity.setImageName(fileName);
			}
		}
		return bankRepository.save(bankEntity);
	}
	
	public void deleteBank(int id) {
		bankRepository.deleteById(id);
	}

	public BankDTO getBankById(int id) {
		BankEntity bankEntity =  bankRepository.findById(id).orElse(null);
		if(bankEntity != null) {
			BankDTO bank = new BankDTO();
			bank.setId(bankEntity.getId());
			bank.setHeading(bankEntity.getHeading());
			bank.setName(bankEntity.getName());
			bank.setDiscription(bankEntity.getDiscription());
			bank.setLink(bankEntity.getLink());
			bank.setImageName(bankEntity.getImageName());
			return bank;
		}else
			return null;
	}
	
	
	
	
}
