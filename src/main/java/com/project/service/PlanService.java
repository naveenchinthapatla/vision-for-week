package com.project.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.project.model.Plan;
import com.project.repository.PlanRepository;
import com.project.utility.CurrentUser;

@Service
public class PlanService{
@Autowired
private PlanRepository planRepository;
@Autowired
private CurrentUser currentUser;

//Returning add Plans Page
public String getAddPage(Model model) {
	Plan plan = planRepository.findById(currentUser.getName()).get();
	model.addAttribute("sunday",plan.getSun());
	model.addAttribute("monday",plan.getMon());
	model.addAttribute("tuesday",plan.getTue());
	model.addAttribute("wednesday",plan.getWed());
	model.addAttribute("thursday",plan.getThu());
	model.addAttribute("friday",plan.getFri());
	model.addAttribute("saturday",plan.getSat());
	return "add";
}

//Adding plans to database
public String addPlans(String sun, String mon, String tue, String wed,
		String thu, String fri, String sat, Model model) {

	Plan plan = planRepository.findById(currentUser.getName()).get();
	plan.setSun(sun);
	plan.setMon(mon);
	plan.setTue(tue);
	plan.setWed(wed);
	plan.setThu(thu);
	plan.setFri(fri);
	plan.setSat(sat);
	planRepository.save(plan);
	model.addAttribute("status","Plans added/modified successfully.");
	return "features";
}

//Viewing Plans to the user
public String viewPlans(Model model) {
	Plan plan = planRepository.findById(currentUser.getName()).get();
	model.addAttribute("sunday",plan.getSun());
	model.addAttribute("monday",plan.getMon());
	model.addAttribute("tuesday",plan.getTue());
	model.addAttribute("wednesday",plan.getWed());
	model.addAttribute("thursday",plan.getThu());
	model.addAttribute("friday",plan.getFri());
	model.addAttribute("saturday",plan.getSat());
	model.addAttribute("status","Check your plans in the table below.");
	return "features";
}

//Removing all plans
public String deletePlans(Model model) {
	Plan plan = planRepository.findById(currentUser.getName()).get();
	plan.setSun("");
	plan.setMon("");
	plan.setTue("");
	plan.setWed("");
	plan.setThu("");
	plan.setFri("");
	plan.setSat("");
	planRepository.save(plan);
	model.addAttribute("status","All plans removed successfully.");
	return "features";
}

}
