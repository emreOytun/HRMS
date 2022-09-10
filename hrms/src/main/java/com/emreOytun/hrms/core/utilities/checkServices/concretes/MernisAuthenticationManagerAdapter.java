package com.emreOytun.hrms.core.utilities.checkServices.concretes;

import java.rmi.RemoteException;  

import org.springframework.stereotype.Service;

import com.emreOytun.hrms.core.utilities.checkServices.abstracts.CandidateAuthenticationService;
import com.emreOytun.hrms.entities.concretes.users.Candidate;

import tr.gov.nvi.tckimlik.WS.KPSPublicSoap;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

@Service
public class MernisAuthenticationManagerAdapter implements CandidateAuthenticationService {

	@Override
	public boolean authenticate(Candidate candidate) {
		KPSPublicSoap client = new KPSPublicSoapProxy();
		
		try {
			client.TCKimlikNoDogrula(Long.parseLong(candidate.getIdentityNumber()), candidate.getFirstName().toUpperCase(), candidate.getLastName().toUpperCase(), candidate.getBirthYear());
		} catch (NumberFormatException e) {
			e.printStackTrace();
			return false;
		} catch (RemoteException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
}
