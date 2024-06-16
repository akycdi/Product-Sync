import React, { useState, useEffect } from 'react';
import { useNavigate } from 'react-router-dom';
import axios from 'axios';
import '../CSS/ProductList.css'; 

const ProductList = () => {
    const [products, setProducts] = useState([]);
    const [error, setError] = useState(null);
    const navigate = useNavigate();

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

    const handleProductClick = (id) => {
        navigate(`/product/${id}`);
    };

    return (
        <div className="product-list-container">
            <h1>Product List</h1>
            {error ? (
                <p className="error-message">Error: {error}</p>
            ) : (
                <ul className="product-list">
                    {products.map((product) => (
                        <li key={product.id} className="product-item" onClick={() => handleProductClick(product.id)}>
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
