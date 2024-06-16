import React, { useState } from 'react';
import axios from 'axios';
import '../Css/SearchComponent.css';

const SearchComponent = () => {
    const [searchTerm, setSearchTerm] = useState('');
    const [searchResults, setSearchResults] = useState([]);

    const handleSearch = async () => {
        try {
            const response = await axios.get(`http://localhost:8080/api/products/search/${searchTerm}`);
            setSearchResults(response.data);
        } catch (error) {
            console.error('Error searching products:', error);
        }
    };

    return (
        <div className="search-container">
            <h1>Product Search</h1>
            <input
                type="text"
                value={searchTerm}
                onChange={(e) => setSearchTerm(e.target.value)}
                placeholder="Search by name..."
            />
            <button onClick={handleSearch}>Search</button>
            <ul className="search-results">
                {searchResults.map((product) => (
                    <li key={product.id}>
                        {product.name} - ${product.price}
                    </li>
                ))}
            </ul>
        </div>
    );
};

export default SearchComponent;
