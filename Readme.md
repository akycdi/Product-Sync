# Vendor Management System

## Overview

This project is designed to manage and visualize data related to products, categories, orders, and customers. It includes features for tracking revenue, growth, sales, and customer data, with a central home dashboard for an overview.


#### **Create Categories**

  ```json
  [
      {
          "name": "Electronics",
          "imageUrl": "http://example.com/electronics.png"
      },
      {
          "name": "Books",
          "imageUrl": "http://example.com/books.png"
      },
      {
          "name": "Clothing",
          "imageUrl": "http://example.com/clothing.png"
      }
  ]


{
    "name": "Laptop",
    "description": "A high-performance laptop",
    "price": 1200.00,
    "quantity": 50,
    "category": {
        "id": 1 
    },
    "url": "http://example.com/laptop.png"
}


{
    "name": "Novel",
    "description": "A gripping science fiction novel",
    "price": 15.99,
    "quantity": 200,
    "category": {
        "id": 2  
    },
    "url": "http://example.com/novel.png"
}


{
    "name": "T-shirt",
    "description": "A comfortable cotton T-shirt",
    "price": 19.99,
    "quantity": 100,
    "category": {
        "id": 3  
    },
    "url": "http://example.com/tshirt.png"
}
