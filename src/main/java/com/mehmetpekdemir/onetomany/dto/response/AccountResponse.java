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
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ApiModel(value = "Account Response")
public class AccountResponse {

	@ApiModelProperty(value = "Account Number")
	private String accountNumber;

	@ApiModelProperty(value = "Full Name")
	private String fullName;

}
