package com.example.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.BranchApplication;
import com.example.model.Branch;
import com.example.repository.BranchRepository;
@Service
public class BranchServiceImp implements BranchService{
	private static Logger logger=LogManager.getLogger(BranchServiceImp.class); 

	    @Autowired
	    private BranchRepository branchRepository;
		@Override
		public Branch addBranch(Branch branch) {
			logger.info("Add method in Service");
			System.out.println(branch);
			return branchRepository.save(branch);
		}

		@Override
		public List<Branch> getAllBranchs(){
			logger.info("Get All method in Service");

			return branchRepository.findAll();
		}

		@Override
		public Branch getBranchByBranchCode(int code) {
			//System.out.println(branchRepository.findById(code).get());
			logger.info("Get by BranchCode method in Service");

			return branchRepository.findById(code).get();
		}
		
		@Override
		public List<Branch> getBranchByDist(String dist) {
			//return branchRepository.findOne(dist);   //(dist).get();;
			//branchRepository.findBy
			logger.info("Get by District method in Service");
			return branchRepository.getBranchByDist(dist);
		}

		@Override
		public List<Branch> getBranchByState(String state) {
			// TODO Auto-generated method stub
			logger.info("Get by State method in Service");
			return branchRepository.getBranchByState(state);
		}

		@Override
		public List<Branch> getBranchByCountry(String country) {
			// TODO Auto-generated method stub
			logger.info("Get by Country method in Service");
			return branchRepository.getBranchByCountry(country);
		}	
		
		@Override
		public Branch updateBranchByBranchCode(Branch branch) {
		   	 Branch br= branchRepository.findById(branch.getBranchCode()).get();
			// br.setBranchCode(branch.getBranchCode());
			 br.setHospitalId(branch.getHospitalId());
	         br.setBranchName(branch.getBranchName());
	         br.setEmail(branch.getEmail());
	         br.setDist(branch.getDist());
	         br.setState(branch.getState());
			 br.setCountry(branch.getCountry());
			 logger.info("Update by BranchCode method in Service");
			 return branchRepository.save(br);

		}

		
		@Override
		public String deleteBranchByBranchCode(int code) {
			branchRepository.deleteById(code);
			logger.info("Delete method in Service");
			return "Deleted the Branch by Branch Code:"+code;
			//getAllBranchs();
			//branchRepository.findAll();
			
		}

		@Override
		public Branch getByemail(String email) {
			return	branchRepository.getByemail(email);
			 
		}

		//@Override
	//	public void deleteAllBranchs() {
		//	branchRepository.deleteAll();	
		//}
	
}
