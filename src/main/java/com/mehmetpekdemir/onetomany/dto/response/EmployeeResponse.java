package com.mehmetpekdemir.onetomany.dto.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel(value = "Employee Response")
public class EmployeeResponse {

	@ApiModelProperty(value = "First Name")
	private String firstName;

	@ApiModelProperty(value = "Last Name")
	private String lastName;

}
