package com.citicompass.repository;

import com.citicompass.model.CallStackItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CallStackItemRepository extends JpaRepository<CallStackItem, String> {
}
