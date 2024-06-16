import React, { useState, useEffect } from 'react';
import { useParams, useNavigate } from 'react-router-dom';
import axios from 'axios';
import '../CSS/ProductDetail.css';

const ProductDetail = () => {
    const { id } = useParams();
    const [product, setProduct] = useState(null);
    const [error, setError] = useState(null);
    const navigate = useNavigate();

    useEffect(() => {
        fetchProductDetails();
    }, [id]);

    const fetchProductDetails = async () => {
        try {
            const response = await axios.get(`http://localhost:8080/api/products/${id}`);
            setProduct(response.data);
        } catch (error) {
            setError(error.response?.data?.error || 'An error occurred');
        }
    };

    const handleUpdate = () => {
        navigate(`/product/update/${id}`);
    };

    const handleDelete = async () => {
        try {
            await axios.delete(`http://localhost:8080/api/products/delete/${id}`);
            navigate('/');
        } catch (error) {
            setError(error.response?.data?.error || 'An error occurred while deleting the product');
        }
    };

    if (error) {
        return <div className="product-detail-container"><p className="error-message">Error: {error}</p></div>;
    }

    if (!product) {
        return <div className="product-detail-container"><p>Loading...</p></div>;
    }

    return (
        <div className="product-detail-container">
            <h1 className="product-detail-title">{product.name}</h1>
            <p className="product-detail-description">{product.description}</p>
            <div className="product-detail-info">
                <span className="product-detail-label">Price:</span>
                <span className="product-detail-price">${product.price}</span>
            </div>
            <div className="product-detail-info">
                <span className="product-detail-label">Quantity:</span>
                <span className="product-detail-quantity">{product.quantity}</span>
            </div>
            <div className="product-detail-info">
                <span className="product-detail-label">Category:</span>
                <span className="product-detail-category">{product.category?.name || 'N/A'}</span>
            </div>
            <div className="button-container">
                <button className="action-button update-button" onClick={handleUpdate}>Update</button>
                <button className="action-button delete-button" onClick={handleDelete}>Delete</button>
                <button className="action-button back-button" onClick={() => navigate(-1)}>Back</button>
            </div>
        </div>
    );
};

export default ProductDetail;
