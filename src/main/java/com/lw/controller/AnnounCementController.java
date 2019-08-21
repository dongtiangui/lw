package com.lw.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.github.pagehelper.PageInfo;
import com.lw.base.BaseTableResult;
import com.lw.model.AnnounCementModel;
import com.lw.services.AnnounCementServices;

@RestController
@RequestMapping(value="/announ")
public class AnnounCementController {
	
	private BaseTableResult<AnnounCementModel> baseTableResult;
	
	@ModelAttribute
	private void init() {
		baseTableResult = new BaseTableResult<AnnounCementModel>();
	}
	
	@Autowired
	private AnnounCementServices announCementServices;
	
	@RequestMapping(value="/list")
	public BaseTableResult<AnnounCementModel> pageList(Integer pageSize,Integer pageNum) {
		
		PageInfo<AnnounCementModel> models = announCementServices.findList(pageSize,pageNum);
		
		baseTableResult.setAaData(models.getList());
		
		baseTableResult.setRecordsTotal((int) models.getTotal());
		
		return baseTableResult;
	}
}
