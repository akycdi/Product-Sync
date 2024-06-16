import React, { useState, useEffect } from 'react';
import axios from 'axios';
import '../Css/ProductList.css'; 

const ProductList = () => {
    const [products, setProducts] = useState([]);
    const [error, setError] = useState(null);

    useEffect(() => {
        fetchProducts();
    }, []);

    const fetchProducts = async () => {
        try {
            const response = await axios.get('http://localhost:8080/api/products/');
            setProducts(response.data);
        } catch (error) {
            setError(error.response?.data?.error || 'An error occurred');
        }
    };

    return (
        <div className="product-list-container">
            <h1>Product List</h1>
            {error ? (
                <p className="error-message">Error: {error}</p>
            ) : (
                <ul className="product-list">
                    {products.map((product) => (
                        <li key={product.id} className="product-item">
                            <span className="product-id">{product.id}</span>
                            <span className="product-name">{product.name}</span>
                            <span className="product-quantity">{product.quantity}</span>
                            <span className="product-price">${product.price}</span>
                        </li>
                    ))}
                </ul>
            )}
        </div>
    );
};

export default ProductList;
