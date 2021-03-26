package com.ibm.Bts.service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.Bts.entity.Bug;
import com.ibm.Bts.repo.BugRepository;

@Service
public class BugService {
	Logger logger = Logger.getLogger(BugService.class.getName());

	@Autowired
	BugRepository bugRepository;

	public String createBug(Bug bug) {
		Bug savedBug = bugRepository.save(bug);
		logger.log(Level.WARNING, "Order created with " + savedBug.getId());
		return savedBug.getId();
	}

	public Optional<Bug> getBug(String bugId) {
		logger.log(Level.WARNING, "Searched for bug " + bugId);
		return bugRepository.findById(bugId);
	}

	public List<Bug> getBugs() {
		logger.log(Level.WARNING, "retuened all bugs ");
		return bugRepository.findAll();

	}

	public void updateBug(@Valid Bug bug) {
		logger.log(Level.WARNING, "updated bug with ID : " + bug.getId());
		bugRepository.save(bug);
	}

	public void deleteOrder(String bugId) {
		logger.log(Level.WARNING, "Deleted bug with ID : " + bugId);
		bugRepository.deleteById(bugId);

	}

}
