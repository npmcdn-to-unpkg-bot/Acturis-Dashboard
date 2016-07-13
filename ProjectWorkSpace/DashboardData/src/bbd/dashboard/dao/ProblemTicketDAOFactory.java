package bbd.dashboard.dao;

public class ProblemTicketDAOFactory {
	
	private static ProblemTicketDAOFactory instance;
	
	private ProblemTicketDAOFactory(){};
	
	public static ProblemTicketDAOFactory getInstance() {
		if(instance == null)
			instance = new ProblemTicketDAOFactory();
		
		return instance;
	}
	
	public ProblemTicketDAO getDAO(DAOType type) {
		if(type == DAOType.DB)
			return ProblemTicketDBDAO.getInstance(); 
		
		return ProblemTicketFileDAO.getInstance();
	}
}
