package org.example.assignment02.service.impl;

import org.example.assignment02.dao.ItemDao;
import org.example.assignment02.dto.ItemStatus;
import org.example.assignment02.dto.impl.ItemDTO;
import org.example.assignment02.entity.impl.ItemEntity;
import org.example.assignment02.exception.DataPersistException;
import org.example.assignment02.service.ItemService;
import org.example.assignment02.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemDao itemDao;
    @Autowired
    private Mapping itemMapping;

    @Override
    public void saveItem(ItemDTO itemDTO) {
        ItemEntity saveItem=itemDao.save(itemMapping.toItemEntity(itemDTO));
        if (saveItem==null){
            throw new DataPersistException("Item not saved");
        }
    }

    @Override
    public List<ItemDTO> getAllItems() {
        return List.of();
    }

    @Override
    public ItemStatus getItem(String itemId) {
        return null;
    }

    @Override
    public void deleteItem(String itemId) {

    }

    @Override
    public void updateItem(String itemId, ItemDTO item) {

    }
}
