package commun;




public abstract class LoanApplicationFactory {
	
	public Object getLoanApplication(Object communLoanApplication, String type){

		if("standard".equals(type)){
			standard.LoanApplication standardLoanApplication = (standard.LoanApplication) communLoanApplication;
		}else if ("document".equals(type)){
			ducument.LoanApplication documentLoanApplication = (ducument.LoanApplication) communLoanApplication;
		}
		
		
		return null;
	}

}
