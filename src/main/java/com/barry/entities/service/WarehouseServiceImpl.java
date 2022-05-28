package com.barry.entities.service;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.barry.entities.Warehouse;
import com.barry.entities.repositories.WarehouseRepository;
import com.barry.entities.service.exception.AppException;

@Service
public class WarehouseServiceImpl implements WarehouseService {

	@Autowired
	private WarehouseRepository warehouseRepository;

	// Si on a rien en BDD renvoyer une exception
	@Override
	public List<Warehouse> fetchAllStore() {
		List<Warehouse> warehouses = warehouseRepository.findAll();
		if (CollectionUtils.isEmpty(warehouses)) {
			throw new AppException("The warehouses must not be empty");
		}
		return warehouses;
	}

	@Override
	public Warehouse getWarehouseByCode(String code) {
		if (StringUtils.isEmpty(code))
			throw new AppException("Code is Empty");

		if (StringUtils.isBlank(code))
			throw new AppException("Code is blank");

		return warehouseRepository.findById(code).orElseThrow(() -> new AppException("Code not found"));
	}

	@Override
	public Warehouse createWarehouse(Warehouse warehouse) {
		return null;
	}

	@Override
	public void deleteWarehouseByCode(String code) {

	}

	// Méthode que reçoit 3 paramètres (2 integers et un symbole (+ ou -))
	// Retourner le résultat de cette opération
	// Vérifier les paramètres d'entrées
	// Faire l'opération si elle est possible et retourner le résultat

	public Integer calculate(Integer a, Integer b, String operation) {
		List<String> operationsList = Arrays.asList("+", "-");

		Integer resultat = 0;
		if (a == null || b == null) {
			throw new IllegalArgumentException("a or b must not be null");
		}
		if (!operationsList.contains(operation)) {
			throw new IllegalArgumentException("Symbole operation is not allowed");
		}

		resultat = switch (operation) {
			case "+" -> {
				yield a + b;
			}
			case "-" -> {
				yield a + b;
			}
			default -> {
				throw new IllegalArgumentException("Unexpected value: " + operation);
			}
			};

		return resultat;

	}

}
