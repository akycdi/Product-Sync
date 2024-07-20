package com.productSync;

import com.productSync.Controller.ProductController;
import com.productSync.Model.Product;
import com.productSync.Service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

public class ProductControllerTest {

    @Mock
    private ProductService productService;

    @InjectMocks
    private ProductController productController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllProducts() {
        List<Product> productList = new ArrayList<>();
        productList.add(new Product());

        when(productService.getAllProducts()).thenReturn(productList);

        ResponseEntity<List<Product>> responseEntity = productController.getAllProducts();

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(productList, responseEntity.getBody());
    }

    @Test
    public void testGetProductById() {
        Product product = new Product();
        product.setId(1L);

        when(productService.getProductById(1L)).thenReturn(Optional.of(product));

        ResponseEntity<?> responseEntity = productController.getProductById(1L);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(product, responseEntity.getBody());
    }

    @Test
    public void testGetProductById_NotFound() {
        when(productService.getProductById(1L)).thenReturn(Optional.empty());

        ResponseEntity<?> responseEntity = productController.getProductById(1L);

        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
    }

    @Test
    public void testCreateProduct() {
        Product product = new Product();
        when(productService.createProduct(any(Product.class))).thenReturn(product);

        ResponseEntity<?> responseEntity = productController.createProduct(product);

        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals(product, responseEntity.getBody());
    }

    @Test
    public void testUpdateProduct() {
        Product product = new Product();
        product.setId(1L);

        when(productService.updateProduct(anyLong(), any(Product.class))).thenReturn(product);

        ResponseEntity<?> responseEntity = productController.updateProduct(1L, product);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(product, responseEntity.getBody());
    }

    @Test
    public void testDeleteProduct() {
        doNothing().when(productService).deleteProduct(1L);

        ResponseEntity<?> responseEntity = productController.deleteProduct(1L);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals("Deleted Product", responseEntity.getBody());
    }

    @Test
    public void testSearchProductsByName() {
        List<Product> productList = new ArrayList<>();
        productList.add(new Product());

        when(productService.searchProductsByName(anyString())).thenReturn(productList);

        ResponseEntity<?> responseEntity = productController.searchProductsByName("test");

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(productList, responseEntity.getBody());
    }

    @Test
    public void testSellProduct() {
        doNothing().when(productService).sellProduct(anyLong(), anyLong());

        ResponseEntity<?> responseEntity = productController.sellProduct(1L, 1L);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals("Product sold successfully", responseEntity.getBody());
    }

    @Test
    public void testCalculateDaysInDatabase() {
        long days = 10L;

        when(productService.calculateDaysInDatabase(anyLong())).thenReturn(days);

        ResponseEntity<?> responseEntity = productController.calculateDaysInDatabase(1L);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(days, responseEntity.getBody());
    }
}
