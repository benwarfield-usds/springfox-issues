package com.example.springfoxissues;

import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import springfox.documentation.annotations.ApiIgnore;

@RestController
public class ImplicitParamController {

	@ApiImplicitParams({
		@ApiImplicitParam(name="implicitTypeParameter", paramType="query"),
		@ApiImplicitParam(name="explicitTypeParameter", paramType="query", dataTypeClass=String.class),
		// this causes a NullPointerException
		// @ApiImplicitParam(name="homelessParameter", dataTypeClass=String.class),
	})
	@GetMapping("/demo/implicit")
	public void querySomething(@ApiIgnore @RequestParam MultiValueMap<String, String> queryFilters) {}

}
