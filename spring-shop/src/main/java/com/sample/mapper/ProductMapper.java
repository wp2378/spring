package com.sample.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.sample.vo.Product;

@Mapper
public interface ProductMapper {

	void insertProdcut(Product prodcut);
	List<Product> getAllProduct();
	Product getProductByNo(int no);
	
}
