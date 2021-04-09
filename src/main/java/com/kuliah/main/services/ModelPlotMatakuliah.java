package com.kuliah.main.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kuliah.main.entity.PlotMataKuliah;
import com.kuliah.main.repository.PlotMataKuliahRepository;

@Service
public class ModelPlotMatakuliah implements ModelPlotMataKuliahInterface {

	@Autowired
	PlotMataKuliahRepository plotMataKuliahRepository;
	
	@Override
	public List<PlotMataKuliah> getAllPlotMataKuliah() {
		// TODO Auto-generated method stub
		return (List<PlotMataKuliah>) this.plotMataKuliahRepository.findAll();
	}

	@Override
	public PlotMataKuliah getPlotMataKuliahByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PlotMataKuliah addPlotMataKuliah(PlotMataKuliah PlotMataKuliah) {
		// TODO Auto-generated method stub
		return this.plotMataKuliahRepository.save(PlotMataKuliah);
	}

	@Override
	public PlotMataKuliah getPlotMataKuliahById(String id) {
		// TODO Auto-generated method stub
		return (PlotMataKuliah)this.plotMataKuliahRepository.findById(Long.parseLong(id)).get();
	}

	@Override
	public void deletePlotMataKuliah(String id) {
		// TODO Auto-generated method stub
		this.plotMataKuliahRepository.deleteById(Long.parseLong(id));
	}

}
