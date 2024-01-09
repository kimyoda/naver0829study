package myshop.service;

import myshop.data.MyShopDto;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import myshop.mapper.MyShopMapper;

import java.util.List;

@Service
@AllArgsConstructor
public class MyShopService {
    private MyShopMapper shopMapper;

    public int getTotalCount()
    {
        return shopMapper.getTotalCount();
    }

    public void insertShop(MyShopDto dto) {
        shopMapper.insertShop(dto);
    }

    public List<MyShopDto> getSangpumList() {
        return shopMapper.getSangpumList();
    }

    public MyShopDto getData(int num) {
        return shopMapper.getData(num);

    }
    public void deleteShop(int num) {
        shopMapper.deleteShop(num);
    }

}
