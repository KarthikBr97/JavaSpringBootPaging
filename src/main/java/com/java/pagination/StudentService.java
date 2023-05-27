package com.java.pagination;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

public class StudentService {

	@Autowired
	private StudentRepository repository;

	public List<Student> findAllRecord() {
		return repository.findAll();
	}

	public Page<Student> findRecordsWithPagination(int offset, int pageSize) {

		return repository.findAll(PageRequest.of(offset, pageSize));
	}

	public Page<Student> findRecordsWithPaginationAndSorting(int offset, int pageSize, String field) {

		return repository.findAll(PageRequest.of(offset, pageSize).withSort(Sort.by(field)));

	}
}
