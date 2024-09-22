package com.arq.back.servicoextra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicoExtraServices {

    @Autowired
    ServicoExtraRepository servicoExtraRepository;
}
