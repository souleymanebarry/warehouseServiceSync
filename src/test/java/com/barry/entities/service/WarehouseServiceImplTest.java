package com.barry.entities.service;


import com.barry.entities.Warehouse;
import com.barry.entities.repositories.WarehouseRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class WarehouseServiceImplTest {

    @InjectMocks
    private WarehouseServiceImpl warehouseService;

    @Mock
    private WarehouseRepository warehouseRepository;


    @Test
    void test_fetchAllStore_shouldReturnAllWarehouses_whenExistingStore() {
        //given
        List<Warehouse> warehouses = Arrays.asList(
                new Warehouse("200",
                        "PARIS", "1 AV DE YORK", "02", 87000, "01"),
                new Warehouse("202", "LA ROCHELLE", "RUE DUMONT CITY",
                        "01", 17000, "017")
        );

        //when
        when(warehouseRepository.findAll()).thenReturn(warehouses);
        List<Warehouse> warehouseList = warehouseService.fetchAllStore();

        //then

        assertAll(
                ()->assertThat(warehouseList).isNotNull()
        );
    }
}
