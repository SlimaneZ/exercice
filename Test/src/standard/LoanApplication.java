package standard;



public class LoanApplication{
	
	private String name;
	
	private LoanProposal loanProposal;

	public LoanProposal getLoanProposal() {
		return loanProposal;
	}

	public void setLoanProposal(LoanProposal loanProposal) {
		this.loanProposal = loanProposal;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
