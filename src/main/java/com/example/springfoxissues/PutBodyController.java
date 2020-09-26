package com.example.springfoxissues;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiParam;

@RestController
public class PutBodyController {

	private static final Logger LOG = LoggerFactory.getLogger(PutBodyController.class);

	@PutMapping("/demo/putbodies/maplist")
	public void acceptGenericMapList(
			@RequestBody List<Map<String, String>> plainMapList) {
		LOG.info("PUT request for a list of size {}", plainMapList.size());
	}

	@PutMapping("/demo/putbodies/shimlist")
	public void acceptMapSpecializationList(
			@RequestBody List<Shimmy> shimList) {
		LOG.info("PUT request for a list of size {}", shimList.size());
	}
	@PutMapping("/demo/putbodies/silly")
	public void acceptLocalInterfaceList(
			@ApiParam(collectionFormat="object") @RequestBody List<Silly> sillyList) {
		LOG.info("PUT request for a list of size {}", sillyList.size());
	}
	// produces a valid swagger entry but won't actually work
	@PutMapping("/demo/putbodies/plainlist")
	public void acceptObjectList(
			 @RequestBody List<?> genericList) {
		LOG.info("PUT request for a list of size {}", genericList.size());
	}

	// produces a valid swagger entry
	@PutMapping("/demo/putbodies/intlist")
	public void acceptIntegerList(
			 @RequestBody List<Integer> integerList) {
		LOG.info("PUT request for a list of size {}", integerList.size());
	}

	// produces a valid swagger entry
	@PutMapping("/demo/putbodies/intarray")
	public void acceptIntegerArray(
			 @RequestBody int[] intArray) {
		LOG.info("PUT request for a list of size {}", intArray.length);
	}

	@PutMapping("/demo/putbodies/annotatedshim")
	public void acceptAnnotatedShim(
			@ApiParam(collectionFormat="com.example.springfoxissues.ApiController.Silly", type="com.example.springfoxissues.ApiController.Silly") @RequestBody List<Shimmy> annotatedList) {
		LOG.info("PUT request for a list of size {}", annotatedList.size());
	}

	@PutMapping("/demo/putbodies/annotatedmap")
	public void acceptAnnotatedMap(
			@ApiParam(collectionFormat="object", type="object") @RequestBody List<Map<String,String>> annotatedMapList) {
		LOG.info("PUT request for a list of size {}", annotatedMapList.size());
	}

	@ApiModel(value="object", parent=Object.class)
	public class Shimmy extends HashMap<String, String> {
		private static final long serialVersionUID = 1L;
	}

	@ApiModel(reference="object")
	public interface Silly {
		public String getThing();
	}
}
