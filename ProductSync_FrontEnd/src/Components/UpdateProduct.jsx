import React, { useState, useEffect } from "react";
import { useNavigate, useParams } from "react-router-dom";
import axios from "axios";
import "../CSS/UpdateItem.css";

const UpdateProduct = () => {
    const navigator = useNavigate();
    const { id } = useParams();
    const [productData, setProductData] = useState({
        name: "",
        price: "",
        quantity: "",
        category: "",
        description: "",
    });
    const [categories, setCategories] = useState([]);

    useEffect(() => {
        fetchCategories();
        fetchProductData();
    }, []);

    const fetchCategories = async () => {
        try {
            const response = await axios.get("http://localhost:8080/api/categories/");
            setCategories(response.data);
        } catch (error) {
            console.error("Error fetching categories:", error);
        }
    };

    const fetchProductData = async () => {
        try {
            const response = await axios.get(`http://localhost:8080/api/products/${id}`);
            setProductData(response.data);
        } catch (error) {
            console.error("Error fetching product data:", error);
        }
    };

    const handleChange = (e) => {
        const { name, value } = e.target;
        setProductData((prevData) => ({
            ...prevData,
            [name]: value,
        }));
    };

    const handleUpdate = async (e) => {
        e.preventDefault();
        try {
            const updatedData = {
                name: productData.name,
                description: productData.description,
                price: parseFloat(productData.price),
                quantity: parseInt(productData.quantity),
                category: {
                    id: parseInt(productData.category),
                },
            };
            const response = await axios.put(`http://localhost:8080/api/products/update/${id}`, updatedData);
            //console.log(response.data);
            navigator("/");
        } catch (error) {
            console.error("Error updating product:", error);
        }
    };

    return (
        <div className="update-product-container">
            <h1>Update Product</h1>
            <form onSubmit={handleUpdate}>
                <label htmlFor="name">Name:</label>
                <input type="text" id="name" name="name" value={productData.name} onChange={handleChange} />
                <label htmlFor="price">Price:</label>
                <input type="number" id="price" name="price" value={productData.price} onChange={handleChange} />
                <label htmlFor="quantity">Quantity:</label>
                <input type="number" id="quantity" name="quantity" value={productData.quantity} onChange={handleChange} required />
                <label htmlFor="category">Category:</label>
                <select id="category" name="category" value={productData.category} onChange={handleChange} required>
                    <option value="">Select category</option>
                    {categories.map((category) => (
                        <option key={category.id} value={category.id}>
                            {category.name}
                        </option>
                    ))}
                </select>
                <label htmlFor="description">Description:</label>
                <textarea id="description" name="description" value={productData.description} onChange={handleChange} required />
                <button type="submit">Update Product</button>
            </form>
        </div>
    );
};

export default UpdateProduct;
