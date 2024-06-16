import React, { useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';
import axios from 'axios';
import '../Css/SearchResults.css';

const SearchResults = () => {
    const { searchTerm } = useParams();
    const [searchResults, setSearchResults] = useState([]);
    const [error, setError] = useState(null);

    useEffect(() => {
        const fetchSearchResults = async () => {
            try {
                const response = await axios.get(`http://localhost:8080/api/products/search/${searchTerm}`);
                setSearchResults(response.data);
            } catch (error) {
                setError(error.response?.data?.error || 'An error occurred');
            }
        };

        fetchSearchResults();
    }, [searchTerm]);

    return (
        <div className="search-results-container">
            <h1>Search Results for "{searchTerm}"</h1>
            {error ? (
                <p className="error-message">Error: {error}</p>
            ) : (
                <ul className="search-results-list">
                    {searchResults.map((product) => (
                        <li key={product.id} className="search-result-item">
                            <span className="product-name">{product.name}</span>
                            <span className="product-price">${product.price}</span>
                        </li>
                    ))}
                </ul>
            )}
        </div>
    );
};

export default SearchResults;
