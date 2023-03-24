package com.edgar.auth;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class AuthenticationResponse {

	private String token;
	
	private Long id;

    private String firstname;

    private String email;


}
