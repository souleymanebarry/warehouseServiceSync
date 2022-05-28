package com.barry.entities.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.barry.entities.Warehouse;
import com.barry.entities.repositories.WarehouseRepository;
import com.barry.entities.service.exception.AppException;

@ExtendWith(MockitoExtension.class)
class WarehouseServiceImplTest {

	@InjectMocks
	private WarehouseServiceImpl warehouseService;

	@Mock
	private WarehouseRepository warehouseRepository;

	@Test
	void test_fetchAllStore_shouldReturnAllWarehouses_whenExistingStore() {
		// given
		List<Warehouse> warehouses = Arrays.asList(new Warehouse("200", "PARIS", "1 AV DE YORK", "02", 87000, "01"),
				new Warehouse("202", "LA ROCHELLE", "RUE DUMONT CITY", "01", 17000, "017"));

		// when
		when(warehouseRepository.findAll()).thenReturn(warehouses);
		List<Warehouse> warehouseList = warehouseService.fetchAllStore();

		// then

		assertAll(() -> assertThat(warehouseList).isNotNull());
	}

	@Test
	void test_fetchAllStore_shouldReturnExceptions_whenExistingStore() {
		// given

		// when
		when(warehouseRepository.findAll()).thenReturn(Collections.emptyList());

		// then
		AppException thrown = assertThrows(AppException.class, () -> warehouseService.fetchAllStore());

		assertTrue(thrown.getMessage().equalsIgnoreCase("The warehouses must not be empty"));

	}

	@ParameterizedTest
	@ValueSource(strings = { "", " ", "\t" })
	@NullSource
	void test_getWarehouseByCode_whenWarehouseShouldNotAccept_Empty_blank_null(String code) {

		AppException thrown = assertThrows(AppException.class, () -> warehouseService.getWarehouseByCode(code));
		assertNotNull(thrown.getMessage());
		assertTrue(thrown.getMessage().contains("Code"));

	}

	@Test
	void test_calculate_ThrowException_When_One_Of_Value_Is_Null() {

		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> warehouseService.calculate(null, null, "-"));
		assertThat(thrown.getMessage()).isEqualTo("a or b must not be null");
	}
	
	@Test
	void test_calculate_ThrowException_When_SymboleOperation_is_not_allowed() {

		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> warehouseService.calculate(8, 2, "X"));
		
		assertThat(thrown.getMessage()).isEqualTo("Symbole operation is not allowed");
	}
	
	
	@Test
	void test_calculate_Return_resultat_For_Plus_Operation() {

		Integer resultat =  warehouseService.calculate(8, 2, "+");
		
		assertThat(resultat).isEqualTo(10);
	}
	
	@Test
	void test_calculate_Return_resultat_For_substract_Operation() {

		Integer resultat =  warehouseService.calculate(8, 2, "-");
		
		assertThat(resultat).isEqualTo(6);
	}

//    @ParameterizedTest(name = "{index} => code={0}, message={1}")
//    @NullSource
//    @CsvSource({
//        "\"\"", "\"Code is empty\"",
//        "\" \"", "\"Code is blank\""
//    })
//    void test_getWarehouseByCode_whenWarehouseShouldNotAccept_Empty_blank_nullOther(String code, String message) {
//    	
//    	AppException thrown = assertThrows(AppException.class, () -> warehouseService.getWarehouseByCode(code));
//    	  assertTrue(thrown.getMessage().equalsIgnoreCase(message));
//    	
//    }
}
