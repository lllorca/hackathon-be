package com.juanlamb.hackathon.modules.purchase;

import com.juanlamb.hackathon.domain.Purchase;
import com.juanlamb.hackathon.modules.purchase.dto.PurchaseDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PurchaseConverter {

    private final ModelMapper modelMapper;

    public PurchaseDto convert(Purchase purchase) {
        return modelMapper.map(purchase, PurchaseDto.class);
    }

}
