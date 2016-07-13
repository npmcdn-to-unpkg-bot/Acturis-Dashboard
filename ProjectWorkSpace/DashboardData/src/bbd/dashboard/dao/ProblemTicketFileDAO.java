package bbd.dashboard.dao;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import bbd.dashboard.DashboardUtils;
import bbd.dashboard.Log;
import bbd.dashboard.Result;
import bbd.dashboard.dto.ProblemTicketDTO;

public class ProblemTicketFileDAO implements ProblemTicketDAO {
	
	private static ProblemTicketFileDAO instance;
	
	public static ProblemTicketFileDAO getInstance() {
		if(instance == null)
			instance = new ProblemTicketFileDAO();
		
		return instance;
	}
	
	private ProblemTicketFileDAO(){}

	@Override
	public Result<List<ProblemTicketDTO>> getProblemTickets() {
		Log.info("Start");
		
		File problemsFolder = new File("../Problems");
		Log.info("tmp=" + problemsFolder.getAbsoluteFile());
		
		
		
		Log.info("End");
		List<ProblemTicketDTO> list = new ArrayList<ProblemTicketDTO>();
		Result<List<ProblemTicketDTO>> result = new Result<List<ProblemTicketDTO>>(list);
		return result;
	}

	@Override
	public Result<String> addProblemTicket(ProblemTicketDTO problem) {
		Log.infoEnabled = true;
		Log.info("Start");
		
		String filename = "../Problems/" + problem.getCode() + ".json";
		
		File problemsFolder = new File(filename);
		Log.info("tmp=" + problemsFolder.getAbsoluteFile());
		if(!problemsFolder.getParentFile().exists())
			problemsFolder.getParentFile().mkdirs();
		
		DashboardUtils.writeJsonFile(filename, problem, ProblemTicketDTO.class);
		
		
		Log.info("End");
		Log.infoEnabled = false;
		Result<String> result = new Result<String>("Succes");
		return result;
	}

	
	
}