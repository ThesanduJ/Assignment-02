package org.example.assignment02.service;

import org.example.assignment02.dto.ItemStatus;
import org.example.assignment02.dto.impl.ItemDTO;

import java.util.List;

public interface ItemService {
    void saveItem(ItemDTO item);
    List<ItemDTO> getAllItems();
    ItemStatus getItem(String itemId);
    void deleteItem(String itemId);
    void updateItem(String itemId, ItemDTO item);
}
