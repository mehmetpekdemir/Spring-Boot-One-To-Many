package com.mehmetpekdemir.onetomany.dto.request;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.mehmetpekdemir.onetomany.common.validator.UniqueAccountNumber;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
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
@ApiModel(value = "Account Create Request")
public class AccountCreateRequest {

	@NotNull
	@NotEmpty
	@UniqueAccountNumber
	@ApiModelProperty(value = "Account Number", required = true)
	private String accountNumber;

	@NotNull
	@NotEmpty
	@ApiModelProperty(value = "User Name", required = true)
	private String userName;

}
