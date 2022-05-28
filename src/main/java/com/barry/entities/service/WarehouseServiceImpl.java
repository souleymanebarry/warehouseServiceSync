package com.barry.entities.service;

import com.barry.entities.Warehouse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WarehouseServiceImpl implements WarehouseService {
    @Override
    public List<Warehouse> fetchAllStore() {
        return null;
    }

    @Override
    public Warehouse getWarehouseByCode(String code) {
        return null;
    }

    @Override
    public Warehouse createWarehouse(Warehouse warehouse) {
        return null;
    }

    @Override
    public void deleteWarehouseByCode(String code) {

    }
}
