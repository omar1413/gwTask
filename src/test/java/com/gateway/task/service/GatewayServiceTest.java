package com.gateway.task.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.hamcrest.CoreMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.gateway.task.entity.Gateway;
import com.gateway.task.exception.CustomException;
import com.gateway.task.model.FlatGateway;
import com.gateway.task.repository.GatewayRepository;

@ExtendWith(MockitoExtension.class)
public class GatewayServiceTest {
	
	@Mock
	private GatewayRepository gatewayRepository;
	
	@InjectMocks
	private GateWayService service;
	
	
	

	@Test
	void getGatewayDetailtest() {
		Gateway expectedGateway = new Gateway();
		expectedGateway.setId(5l);
		FlatGateway expectedFlatGateway = new FlatGateway(expectedGateway);
		Optional<Gateway> op = Optional.of(expectedGateway);
		when(gatewayRepository.findById(5l)).thenReturn(op);
		FlatGateway actual = service.getGatewayDetail(5l);
		assertThat(actual.getId()).isEqualTo(expectedFlatGateway.getId());
		
	}
	
	@Test
	void getGatewayDetailNotFoundTest() {
		when(gatewayRepository.findById(4l)).thenReturn(Optional.empty());
		
		
		Assertions.assertThrows(CustomException.class, ()->{
			service.getGatewayDetail(4l);
		});
		
	}
}
