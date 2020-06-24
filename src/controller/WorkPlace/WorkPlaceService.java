package controller.WorkPlace;

import controller.*;
import java.util.ArrayList;

import model.*;
import model.WorkPlaceDAO;

public class WorkPlaceService {
	private static WorkPlaceService service = new WorkPlaceService();
	public WorkPlaceDAO dao = WorkPlaceDAO.getInstance();

	private WorkPlaceService() {

	}

	public static WorkPlaceService getInstance() {
		return service;
	}

	//사업장 관리
	public void workplaceCreate(WorkPlaceDTO workplaceDto) {
		dao.workplaceCreate(workplaceDto);
	}

	public void workplaceUpdate(String name, String newname) {
		dao.workplaceUpdate(name, newname);
	}

	public void workplaceDelete(String name) {
		dao.workplaceDelete(name);
	}

	public WorkPlaceDTO workplaceRead(String name) {
		WorkPlaceDTO workplace = dao.workplaceRead(name);
		return workplace;
	}

	public ArrayList<WorkPlaceDTO> workplaceList() {
		ArrayList<WorkPlaceDTO> list = dao.workplaceList();
		return list;
	}

	//사업장 속성 관리

	public void workplaceInfoCreate(WorkPlaceDTO workplaceDto) throws ClassNotFoundException {
		dao.workplaceInfoCreate(workplaceDto);
	}

	public void workplaceInfoUpdate(WorkPlaceDTO workplace) {
		dao.workplaceInfoUpdate(workplace);
	}

	public void workplaceInfoDelete(String name) {
		dao.workplaceInfoDelete(name);
	}

	public void workplaceInfoRead(String name) {
		dao.workplaceInfoRead(name);
	}

	public ArrayList<WorkPlaceDTO> workplaceInfoList() {
		ArrayList<WorkPlaceDTO> list = dao.workplaceInfoList();
		return list;
	}
}
