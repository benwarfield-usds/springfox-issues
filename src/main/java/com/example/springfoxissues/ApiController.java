package com.example.springfoxissues;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

	private static final Logger LOG = LoggerFactory.getLogger(ApiController.class);

	@PutMapping("/demo/listput")
	public void acceptInterfaceList(@RequestBody List<Map<String, String>> simpleObjectList) {
		LOG.info("PUT request for a list of size {}", simpleObjectList.size());
	}
}
