package com.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.vo.Product;

@Mapper
public interface ProductMapper {
	
	List<Product> getProductsByCategoryNo(int categoryNo);
	List<Product> getAllproduct();
	Product getProductByNo(int no);
	void insertProduct(Product product);
	void updateProduct(Product product);
	

}
