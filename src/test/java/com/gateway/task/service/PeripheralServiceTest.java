package com.gateway.task.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.hamcrest.CoreMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.gateway.task.entity.Gateway;
import com.gateway.task.entity.Peripheral;
import com.gateway.task.exception.CustomException;
import com.gateway.task.model.FlatGateway;
import com.gateway.task.repository.GatewayRepository;
import com.gateway.task.repository.PeripheralRepository;

@ExtendWith(MockitoExtension.class)
public class PeripheralServiceTest {

	@Mock
	private GatewayRepository gatewayRepository;

	@Mock
	private PeripheralRepository peripheralRepository;

	@InjectMocks
	private PeripheralService service;

	@Test
	void devicesNotGreaterThan10() {
		Gateway gw = new Gateway();
		gw.setPeripherals(new ArrayList<>());
		Peripheral p = new Peripheral();
		when(gatewayRepository.findById(5l)).thenReturn(Optional.of(gw));
		when(peripheralRepository.save(p)).thenAnswer(I -> {
			gw.getPeripherals().add(p);
			return p;
		});
		
		Assertions.assertDoesNotThrow(()->{
			service.add(5L, p);
			service.add(5L, p);
			service.add(5L, p);
			service.add(5L, p);
			service.add(5L, p);
			service.add(5L, p);
			service.add(5L, p);
			service.add(5L, p);
			service.add(5L, p);
			service.add(5L, p);
		
		});
		Assertions.assertThrows(CustomException.class, ()->{
			service.add(5L, p);
			
		});
	

	}

}
