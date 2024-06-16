import React, { useState } from 'react';
import axios from 'axios';
import '../CSS/ProductSearch'; 

const ProductSearch = () => {
    const [searchTerm, setSearchTerm] = useState('');
    const [searchResults, setSearchResults] = useState([]);
    const [error, setError] = useState('');

    const handleSearch = async () => {
        try {
            const response = await axios.get(`http://localhost:8080/api/products/search/${searchTerm}`);
            setSearchResults(response.data);
            setError('');
        } catch (error) {
            console.error('Error searching products:', error);
            setSearchResults([]);
            setError('Error fetching products. Please try again later.');
        }
    };

    return (
        <div className="product-search-container">
            <h1>Product Search</h1>
            <div className="search-bar">
                <input
                    type="text"
                    value={searchTerm}
                    onChange={(e) => setSearchTerm(e.target.value)}
                    placeholder="Search by name..."
                />
                <button onClick={handleSearch}>Search</button>
            </div>
            {error && <p className="error-message">{error}</p>}
            <ul className="search-results">
                {searchResults.map((product) => (
                    <li key={product.id} className="search-item">
                        {product.name} - {product.price}
                    </li>
                ))}
            </ul>
        </div>
    );
};

export default ProductSearch;
