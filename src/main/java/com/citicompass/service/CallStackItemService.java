package com.citicompass.service;

import com.citicompass.model.CallStackItem;
import com.citicompass.repository.CallStackItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CallStackItemService {

    @Autowired
    private CallStackItemRepository callStackItemRepository;

    public List<CallStackItem> getAllCallStackItems() {
        return callStackItemRepository.findAll();
    }

    public Optional<CallStackItem> getCallStackItemById(String id) {
        return callStackItemRepository.findById(id);
    }

    public CallStackItem saveCallStackItem(CallStackItem callStackItem) {
        return callStackItemRepository.save(callStackItem);
    }

    public void deleteCallStackItem(String id) {
        callStackItemRepository.deleteById(id);
    }
}
