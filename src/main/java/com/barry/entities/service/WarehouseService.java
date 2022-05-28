package com.barry.entities.service;

import com.barry.entities.Warehouse;

import java.util.List;

public interface WarehouseService {

    List<Warehouse> fetchAllStore();

    Warehouse getWarehouseByCode(String code);

    Warehouse createWarehouse(Warehouse warehouse);

    void deleteWarehouseByCode(String code);
}
