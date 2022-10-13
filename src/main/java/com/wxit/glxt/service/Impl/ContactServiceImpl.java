package com.wxit.glxt.service.Impl;

import com.wxit.glxt.mapper.ContactMapper;
import com.wxit.glxt.service.ContactService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class ContactServiceImpl implements ContactService {

    @Resource
    private ContactMapper contactMapper;

    @Override
    public List contTable() {
        return contactMapper.contTable();
    }
}
