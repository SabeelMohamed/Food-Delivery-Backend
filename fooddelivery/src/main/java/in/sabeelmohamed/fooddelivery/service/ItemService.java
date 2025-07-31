package in.sabeelmohamed.fooddelivery.service;

import in.sabeelmohamed.fooddelivery.io.ItemRequest;
import in.sabeelmohamed.fooddelivery.io.ItemResponse;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ItemService {

    ItemResponse add(ItemRequest request, MultipartFile file) throws IOException;

    List<ItemResponse> fetchItems();

    void deleteItem(String itemId);
}
