package com.java.pagination;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentService service;

	@GetMapping
	private List<Student> getRecords() {
		List<Student> allProducts = service.findAllRecord();
		return allProducts;
	}

	@GetMapping("/pagination/{offset}/{pageSize}")
	private Page<Student> getProductsWithPagination(@PathVariable int offset, @PathVariable int pageSize) {
		Page<Student> findRecordsWithPagination = service.findRecordsWithPagination(offset, pageSize);
		return findRecordsWithPagination;
	}

	@GetMapping("/paginationAndSort/{offset}/{pageSize}/{field}")
	private Page<Student> getRecordWithPaginationAndSort(@PathVariable int offset, @PathVariable int pageSize,
			@PathVariable String field) {
		Page<Student> recordsWithPagination = service.findRecordsWithPaginationAndSorting(offset, pageSize, field);
		return recordsWithPagination;
	}
}
