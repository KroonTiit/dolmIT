package com.dolmit.pakiautomaat;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PakiautomaatController {
	public List<Pakiautomaat> result;
	
	@Autowired 
	private PakiautomaatRepo pakiautomaatRepo;
	@Autowired 
	public  PakiautomaatController (PakiautomaatRepo pakiautomaatRepo){
		this.pakiautomaatRepo=pakiautomaatRepo;
	}
	@CrossOrigin(origins = "http://localhost:8080")
	@RequestMapping(value="pakiautomaat", method = RequestMethod.GET)
	public List<Pakiautomaat> getPakiautomaatList() {
		return pakiautomaatRepo.findAll();
	}
	@CrossOrigin(origins = "http://localhost:8080")
	@RequestMapping(value="pakiautomaat/search/{active}&{skoor}", method = RequestMethod.GET)
	public List<Pakiautomaat> searchBySkoorPakiautomaat(@PathVariable Boolean active,@PathVariable int skoor) {
		result=pakiautomaatRepo.findByActiveAndScore(active,skoor);
		return result;
	}
	@CrossOrigin(origins = "http://localhost:8080")
	@RequestMapping(value="pakiautomaat/returnSearchResult", method = RequestMethod.GET)
	public List<Pakiautomaat> returnSearchResult() {
		return result;
	}
	@CrossOrigin(origins = "http://localhost:8080")
	@RequestMapping(value="pakiautomaat/openOnBusinessHours", method = RequestMethod.GET)
	public List<Pakiautomaat> getOpenOnBusinessHours() {
		return pakiautomaatRepo.findOpenOnBusinsesHours();
	}
	@CrossOrigin(origins = "http://localhost:8080")
	@RequestMapping(value="pakiautomaat/open10h", method = RequestMethod.GET)
	public List<Pakiautomaat> getOpen10h() {
		return pakiautomaatRepo.findOpen10h();
	}
	
	@CrossOrigin(origins = "http://localhost:8080")
    @RequestMapping(value="pakiautomaat",method = RequestMethod.POST)
    public Pakiautomaat createPakiautomaat(@RequestBody Pakiautomaat pakiautomaat) {
    	return pakiautomaatRepo.save(pakiautomaat);
    }
	@CrossOrigin(origins = "http://localhost:8080")
    @RequestMapping(value="pakiautomaat/{masinaId}", method = RequestMethod.PATCH)
    public void updatePakiautomaat(@RequestBody Pakiautomaat pakiautomaat) {
		pakiautomaatRepo.save(pakiautomaat);
    }
	@CrossOrigin(origins = "http://localhost:8080")
    @RequestMapping (value="pakiautomaat/{masinaId}",method = RequestMethod.DELETE)
    public void deletePakiautomaat(@PathVariable String masinaId) {
		pakiautomaatRepo.delete(Long.decode(masinaId));
    }
}
