package com.kuliah.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.kuliah.main.entity.PlotMataKuliah;
import com.kuliah.main.services.ModelDosen;
import com.kuliah.main.services.ModelMahasiswa;
import com.kuliah.main.services.ModelMataKuliah;
import com.kuliah.main.services.ModelPlotMatakuliah;

@Controller
public class PlotMataKuliahPage {

	@Autowired
	ModelPlotMatakuliah modelPlotMataKuliah;
	
	@Autowired
	ModelMahasiswa modelMahasiswa;
	
	@Autowired
	ModelDosen modelDosen;
	
	@Autowired
	ModelMataKuliah modelMataKuliah;
	
	@GetMapping("/plotmatakuliah/view")
	public String viewIndexPlotMatkul(Model model) {
		model.addAttribute("listplotmatakuliah",modelPlotMataKuliah.getAllPlotMataKuliah());
		model.addAttribute("active",6);
		return "view_plotmatakuliah";
	}
	
	@GetMapping("/plotmatakuliah/add")
	public String viewAddPlotMatkul(Model model) {
		model.addAttribute("plotmatakuliah",new PlotMataKuliah());
		model.addAttribute("listMahasiswa", modelMahasiswa.getAllMahasiswa());
		model.addAttribute("listDosen", modelDosen.getAllDosen());
		model.addAttribute("listMataKuliah", modelMataKuliah.getAllMataKuliah());
		return "add_plotmatakuliah";
	}
	
	@PostMapping("/plotmatakuliah/view")
	  public String addPlotMatkul(@ModelAttribute PlotMataKuliah PlotMataKuliah, Model model) {
		
		this.modelPlotMataKuliah.addPlotMataKuliah(PlotMataKuliah);
		model.addAttribute("listPlotMatakuliah",modelPlotMataKuliah.getAllPlotMataKuliah());
	
		return "redirect:/plotmatakuliah/view";
	}
	
}
