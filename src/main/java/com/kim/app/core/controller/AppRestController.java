package com.kim.app.core.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.kim.app.core.delegate.TestDto;
import com.kim.app.core.domain.TestTable2;
import com.kim.app.core.service.AppService;

@RestController
// @RequestMapping(path = "/kim")
public class AppRestController {

	private static Logger logger = Logger.getLogger(AppRestController.class.getName());

	@Autowired
	private AppService appService;

	@RequestMapping(value = "/call/voice", method = RequestMethod.POST)
	public ResponseEntity<Object> processVoiceCall(@RequestBody TestDto testDto) {

		appService.processTestData(testDto);

		return new ResponseEntity<>(testDto, HttpStatus.OK);
	}

	// RequestMapping's default RequestMethod is 'GET'.
	@RequestMapping(value = "/test/syslog")
	public ResponseEntity<Object> get() {

		return new ResponseEntity<>("Updated successfully.", HttpStatus.OK);
	}

	@GetMapping("/tbl2/pagination")
	public Page<TestTable2> getTestTable2Pagination(Pageable pageable) {

		TestDto testDto = new TestDto();
		testDto.setPageable(pageable);

		return appService.readTestTable2Page(testDto);
	}

	@GetMapping("/tbl2/all")
	public @ResponseBody Iterable<TestTable2> getAllTestTable2() {

		return appService.readAllTestTable2();
	}

	@PostMapping("/tbl2/single")
	public @ResponseBody Optional<TestTable2> readSingleTestTable2(@Valid @RequestBody TestDto testDto) {

		return appService.readOneTestTable2(testDto);
	}

	@GetMapping("/test")
	public ResponseEntity<Object> testMethod() {

		HttpHeaders httpHeaders = new HttpHeaders();

		// Workaround for CORS during development.
		// httpHeaders.set("Access-Control-Allow-Origin", "*");

		return ResponseEntity.ok().headers(httpHeaders).body("Hi");
	}

	@GetMapping("/test/angular/httpclient")
	public ResponseEntity<Object> testForAngularHttpClient() {

		TestDto testDto = new TestDto();
		testDto.setId(Long.valueOf(1000));

		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.set("Access-Control-Allow-Origin",
				"*"); /* Workaround for CORS during development. */

		return ResponseEntity.ok().headers(httpHeaders).body(appService.readOneTestTable2(testDto));
	}

	@PostMapping("/tbl2")
	public TestDto createTestTable2(@Valid @RequestBody TestDto testDto) {

		return appService.createTestTable2(testDto);
	}

	@PutMapping("/tbl2/{id}")
	public TestDto updateTestTable2(@PathVariable Long id, @Valid @RequestBody TestDto testDto) {

		testDto.setId(id);
		return appService.updateTestTable2(testDto);
	}

	@DeleteMapping("/tbl2/{id}")
	public ResponseEntity<Object> deleteTestTable2(@PathVariable Long id) {

		appService.deleteTestTable2(id);

		return new ResponseEntity<>("Deleted successfully.", HttpStatus.OK);
	}

	@DeleteMapping("/tbl2/all/{id}")
	public ResponseEntity<Object> deleteAllTestTable2(@PathVariable Long id) {

		if (id.equals(Long.valueOf(999999))) {

			appService.deleteAllTestTable2();

			return new ResponseEntity<>("Deleted successfully.", HttpStatus.OK);
		} else {

			return new ResponseEntity<>("Bad Request.", HttpStatus.BAD_REQUEST);
		}
	}

}
