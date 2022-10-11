package com.maveric.userservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.maveric.userservice.dto.UserDto;
import com.maveric.userservice.enumeration.Gender;
import com.maveric.userservice.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public
class UserServiceApplicationTests {

	public static final String APIV1 ="/api/v1/users";

	@Test
	void contextLoads() {
		assertTrue(true);
	}
	public static UserDto getUserDto()
	{
		return  UserDto.builder()
				.firstName("manisha")
				.lastName("shinde")
				.middleName("kishan")
				.phoneNumber("9788146455")
				.email("manisha@gmail.com")
				.address("pune")
				.dateOfBirth(LocalDateTime.parse("2001-08-30"))
				.gender(Gender.FEMALE)
				.build();
	}
	public static User getUser()
	{
		return  User.builder()
				.firstName("manisha")
				.lastName("shinde")
				.middleName("kishan")
				.phoneNumber("9788146455")
				.email("manisha@gmail.com")
				.address("pune")
				.dateOfBirth(LocalDateTime.parse("2001-08-30"))
				.gender(Gender.FEMALE)
				.build();
	}
	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
