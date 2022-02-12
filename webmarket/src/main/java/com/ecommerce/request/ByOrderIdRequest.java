package com.ecommerce.request;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author galip
 * 
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ByOrderIdRequest implements Serializable {
	private static final long serialVersionUID = 1L;

	private long idd;
}