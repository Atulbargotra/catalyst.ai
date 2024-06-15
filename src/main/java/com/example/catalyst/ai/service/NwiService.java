package com.example.catalyst.ai.service;

import com.example.catalyst.ai.dto.NwiResponse;
import com.example.catalyst.ai.model.NWI;
import com.example.catalyst.ai.repository.NwiRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class NwiService {
    private final NwiRepository repository;
    public NwiResponse getNwi(Long id) {
        Optional<NWI> byId = repository.findById(id);
        if(byId.isPresent()){
            NWI nwi = byId.get();
            return new NwiResponse(nwi.getName());
        }
        return new NwiResponse("");
    }

    public Long saveNwi(String name) {
        NWI nwi = new NWI();
        nwi.setName(name);
        NWI save = repository.save(nwi);
        return save.getId();
    }
}
