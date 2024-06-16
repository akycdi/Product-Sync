import React, { useState, useEffect } from "react";
import axios from "axios";
import "../Css/CreateProduct.css";
import { useNavigate } from "react-router-dom";

const CreateProduct = () => {
  const navigator = useNavigate();
  const [formData, setFormData] = useState({
    name: "",
    price: "",
    quantity: "",
    category: "",
    description: "",
  });
  const [categories, setCategories] = useState([]);
  const [successMessage, setSuccessMessage] = useState("");
  const [errorMessage, setErrorMessage] = useState("");

  useEffect(() => {
    fetchCategories();
  }, []);

  const fetchCategories = async () => {
    try {
      const response = await axios.get("http://localhost:8080/api/categories/");
      setCategories(response.data);
    } catch (error) {
      console.error("Error fetching categories:", error);
    }
  };

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData((prevData) => ({
      ...prevData,
      [name]: value,
    }));
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      let postData = { ...formData };
      if (postData.category === "") {
        delete postData.category;
      } else {
        postData.category = { id: parseInt(postData.category) };
      }

      const response = await axios.post(
        "http://localhost:8080/api/products/create",
        postData
      );
      setSuccessMessage(
        response.data.message || "Product created successfully"
      );
      setFormData({
        name: "",
        price: "",
        quantity: "",
        category: "",
        description: "",
      });
      setErrorMessage("");
    } catch (error) {
      setErrorMessage(
        error.response?.data?.error ||
          "An error occurred while creating the product"
      );
      setSuccessMessage("");
    }
  };

  return (
    <div className="create-product-container">
      <h1>Create Product</h1>
      {successMessage && <p className="success-message">{successMessage}</p>}
      {errorMessage && <p className="error-message">{errorMessage}</p>}
      <form onSubmit={handleSubmit}>
        <label htmlFor="name">Name:</label>
        <input
          type="text"
          id="name"
          name="name"
          value={formData.name}
          onChange={handleChange}
          required
        />
        <label htmlFor="price">Price:</label>
        <input
          type="number"
          id="price"
          name="price"
          value={formData.price}
          onChange={handleChange}
          required
        />
        <label htmlFor="quantity">Quantity:</label>
        <input
          type="number"
          id="quantity"
          name="quantity"
          value={formData.quantity}
          onChange={handleChange}
          required
        />
        <label htmlFor="category">Category:</label>
        <select
          id="category"
          name="category"
          value={formData.category}
          onChange={handleChange}
          required
        >
          <option value="">Select category</option>
          {categories.map((category) => (
            <option key={category.id} value={category.id}>
              {category.name}
            </option>
          ))}
        </select>
        <label htmlFor="description">Description:</label>
        <textarea
          id="description"
          name="description"
          value={formData.description}
          onChange={handleChange}
          required
        />
        <button
          type="submit"
          onClick={() => {
            navigator("/");
          }}
        >
          Create Product
        </button>
      </form>
    </div>
  );
};

export default CreateProduct;
