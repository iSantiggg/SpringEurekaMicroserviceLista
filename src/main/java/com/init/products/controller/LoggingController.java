package com.init.products.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import com.init.products.model.Logging;
import com.init.products.model.TokenReqRes;
import com.init.products.service.LoggingService;
import com.init.products.util.JwtTokenUtil;


@RestController
@RequestMapping("/logging")
public class LoggingController {

	@Autowired
	private LoggingService loggingService;

	@GetMapping("/lista")
	public ResponseEntity<List<Logging>> lista() {
		List<Logging> person = new ArrayList<>();

		try {
			person = loggingService.listausuarios();
			if (person != null) {
				return new ResponseEntity<>(person, HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			System.out.println(e);
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
}
